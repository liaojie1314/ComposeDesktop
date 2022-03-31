package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginModel(

    @SerialName("code")
    val code:Int,
    @SerialName("message")
    val message:String,
    @SerialName("success")
    val success:Boolean
)