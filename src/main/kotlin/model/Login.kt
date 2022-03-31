package model

sealed class Login<out T> {
    object Loading:Login<Nothing>()
    data class Content<T>(val data:T):Login<T>()
    data class Error(val error:Throwable):Login<Nothing>()
}