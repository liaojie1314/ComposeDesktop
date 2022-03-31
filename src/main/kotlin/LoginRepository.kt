import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.Login
import model.LoginModel
import java.util.concurrent.TimeUnit

class LoginRepository(private val client: HttpClient= defaultHttpClient) {

    private suspend fun loginForAccount(accountname:String,accountpwd:String):LoginModel{
        return client.post{
            url(
                ""
            )
        }
    }

    suspend fun getAccount(accountname:String,accountpwd:String): Login<LoginModel>{
        return withContext(Dispatchers.IO){
            try {
                val content=loginForAccount(accountname,accountpwd)
                Login.Content(content)
            }catch (e:Exception){
                e.printStackTrace()
                Login.Error(e)
            }
        }
    }

    companion object {
        val defaultHttpClient = HttpClient(OkHttp){
            install(Logging){
                logger=object :Logger{
                    override fun log(message: String) {
                        println("logger--->OkHttp $message")
                    }
                }
                level=LogLevel.ALL
            }
            engine {
                config {
                    readTimeout(timeout = 1,TimeUnit.MINUTES)
                    writeTimeout(timeout = 1,TimeUnit.MINUTES)
                    connectTimeout(timeout = 1,TimeUnit.MINUTES)
                }
            }
            install(JsonFeature){
                serializer=KotlinxSerializer(
                    json = kotlinx.serialization.json.Json {
                        ignoreUnknownKeys=true
                        isLenient=true
                    }
                )
            }
        }
    }
}