import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PhoneLoginCompose(
    accountphone: String,
    accountcode: String,
    onPhoneValue: (String) -> Unit,
    onCodeValue: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            value = accountphone,
            onValueChange = { onPhoneValue(it) },
            placeholder = {
                Text(
                    "请输入手机号", style = MaterialTheme.typography.body1,
                    color = Color(0xFF8A8F99)
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
            modifier = Modifier.fillMaxWidth(),
            value = accountcode,
            onValueChange = { onCodeValue(it) },
            placeholder = {
                Text(
                    "请输入密码", style = MaterialTheme.typography.body1,
                    color = Color(0xFF8A8F99)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                unfocusedBorderColor = Color(0xFFE4E7ED),
                focusedBorderColor = Color(0xFF1BD184)
            ),
            trailingIcon = {
                IconButton(onClick = {}) {
                    Text(
                        "获取验证码", color = Color(0xFF1BD184),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        )
    }
}