import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(isOpenDialog: MutableState<Boolean>, isOpenWindow: MutableState<Boolean>) {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        showDialog(isOpenDialog = isOpenDialog, isOpenWindow = isOpenWindow)
        Box(modifier=Modifier.fillMaxSize().background(Color(0xFFE4E7ED)).padding(10.dp)){
            EducationLoginCompose()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun showDialog(isOpenDialog: MutableState<Boolean>, isOpenWindow: MutableState<Boolean>) {
    if (isOpenDialog.value) {
        AlertDialog(
            onDismissRequest = {
                isOpenDialog.value = false
            },
            title = {
                Text(text = "这是对话框标题")
            },
            text = {
                Text(
                    "这是一段描述对话框提示内容的文本， " +
                            "这个文本有点长，还有点俏皮！"
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        isOpenWindow.value = false
                    }
                ) {
                    Text("确认")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        isOpenDialog.value = false
                    }
                ) {
                    Text("取消")
                }
            }
        )
    }
}


fun main() = application {
    val isOPenWindow = remember { mutableStateOf(true) }
    val isOpenDialog = remember { mutableStateOf(false) }
    if (isOPenWindow.value) {
        Window(
            title = "Compose Desktop",
            //icon = painterResource(""),
            onCloseRequest = { isOpenDialog.value = true },
            state = WindowState(
                size = DpSize(1000.dp, 600.dp),
                position = WindowPosition(alignment = Alignment.Center)
            )
        ) {
            App(isOpenDialog = isOpenDialog, isOpenWindow = isOPenWindow)
        }
    }
}
