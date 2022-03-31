import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun AccountLoginCompose(
    accountname:String,
    accountpwd:String,
    onNameValue:(String)->Unit,
    onPwdValue:(String)->Unit
){
    var pwdOff by remember { mutableStateOf(false) }
    Column(modifier= Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            singleLine = true,
            modifier=Modifier.fillMaxWidth(),
            value=accountname,
            onValueChange = {onNameValue(it)},
            placeholder = {
                Text("请输入用户名", style = MaterialTheme.typography.body1,
                color= Color(0xFF8A8F99)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                unfocusedBorderColor = Color(0xFFE4E7ED),
                focusedBorderColor = Color(0xFF1BD184)
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            singleLine = true,
            modifier=Modifier.fillMaxWidth(),
            value=accountpwd,
            onValueChange = {onPwdValue(it)},
            placeholder = {
                Text("请输入密码", style = MaterialTheme.typography.body1,
                    color= Color(0xFF8A8F99)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                unfocusedBorderColor = Color(0xFFE4E7ED),
                focusedBorderColor = Color(0xFF1BD184)
            ),

            visualTransformation = if(pwdOff) VisualTransformation.None else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    pwdOff=!pwdOff
                }){
                    Icon(painter = if(pwdOff) painterResource("eye_on.png")
                    else painterResource("eye_off.png"),
                    contentDescription = "",
                    tint = Color.Unspecified)
                }
            }
        )
    }
}