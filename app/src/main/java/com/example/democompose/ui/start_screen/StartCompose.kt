package com.example.democompose.ui.start_screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.democompose.R
import com.example.democompose.ui.theme.AppColor
import com.example.democompose.ui.theme.StyleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: StartViewModel by viewModels()
        setContent { StartCompose(viewModel = viewModel) }
        initEvent(viewModel)
    }

    private fun initEvent(viewModel: StartViewModel) {
        viewModel.navigateToHomeEvent.observe(this){
            onBackPressed()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartCompose(
    viewModel: StartViewModel?,
) {
    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 24.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_app_banner),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp),
                    contentScale = ContentScale.FillWidth,
                )
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "Xin chào", style = StyleUtils.style23W700)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Tham gia ngay cùng Việt Phụ Đạo",
                    style = StyleUtils.style14W400.copy(
                        color = AppColor.Black.copy(alpha = 0.45f)
                    ),
                )
                Spacer(modifier = Modifier.height(24.dp))
                PrimaryButton(text = "Đăng ký", onClick = {
                    viewModel?.clickSubScribe()
                })
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(), onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = AppColor.PrimaryColor,
            contentColor = AppColor.White,
        )
    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun preViewStartCompose() {
    StartCompose(viewModel = null)
}