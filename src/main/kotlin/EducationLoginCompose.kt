import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
@Preview
fun EducationLoginCompose() {
    var selectIndex by remember { mutableStateOf(0) }
    val tabTitle = listOf("账号登录", "手机号登录")
    var accountname by remember { mutableStateOf("") }
    var accountpwd by remember { mutableStateOf("") }
    var accountphone by remember { mutableStateOf("") }
    var accountcode by remember { mutableStateOf("") }
    var rememberpwd by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        backgroundColor = Color.White
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxHeight().weight(0.55f)) {
                Image(
                    painterResource("education.png"),
                    contentDescription = "", contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight().weight(0.45f).padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TabRow(
                    selectedTabIndex = selectIndex,
                    backgroundColor = Color.White,
                    contentColor = Color(0xFF1BD184),
                    divider = {
                        TabRowDefaults.Divider(
                            color = Color(0xFFE4E7ED),
                            thickness = 2.dp
                        )
                    }
                ) {
                    tabTitle.forEachIndexed { index, title ->
                        Tab(
                            selected = selectIndex == index,
                            onClick = {
                                selectIndex = index
                            },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectIndex == index)
                                        Color(0xFF2E3033) else Color(0xFF8A8F99),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        )
                    }
                }
                Box(modifier = Modifier.fillMaxWidth()) {
                    if (selectIndex == 0) {
                        AccountLoginCompose(
                            accountname,
                            accountpwd,
                            onNameValue = { accountname = it },
                            onPwdValue = { accountpwd = it }
                        )
                    } else {
                        PhoneLoginCompose(
                            accountphone,
                            accountcode,
                            onPhoneValue = { accountphone = it },
                            onCodeValue = { accountcode = it }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().clickable {
                        rememberpwd = !rememberpwd
                    }, horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberpwd,
                        onCheckedChange = { rememberpwd = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF1BD184),
                            uncheckedColor = Color(0xFFE4E7ED)
                        )
                    )
                    Text("记住密码", color = Color(0xFF8A8F99), fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF1BD184),
                        contentColor = Color.White,
                        disabledBackgroundColor = Color(0xFF1BD184).copy(alpha = 0.6f)
                    )
                ) {
                    Text("确定", style = MaterialTheme.typography.h6)
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Divider(modifier = Modifier.fillMaxWidth().weight(1f))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "第三方账号登录", style = MaterialTheme.typography.body1,
                        color = Color(0xFF8A8F99)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Divider(modifier = Modifier.fillMaxWidth().weight(1f))
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource("qq.png"),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier=Modifier.size(50.dp)
                    )
                    Spacer(modifier=Modifier.width(30.dp))
                    Image(
                        painterResource("wx.png"),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier=Modifier.size(50.dp)
                    )
                    Spacer(modifier=Modifier.width(30.dp))
                    Image(
                        painterResource("email.png"),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier=Modifier.size(50.dp)
                    )
                }
            }
        }
    }
}