package com.example.democompose.ui.splash_screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.democompose.R
import com.example.democompose.ui.route.startComposeRouteName
import com.example.democompose.ui.start_screen.StartActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    lateinit var viewModel:SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm by viewModels<SplashViewModel>()
        viewModel = vm
        setContent { SplashCompose(viewModel = viewModel) }
        initEvent()
    }

    private fun initEvent() {
        viewModel.getGoStartScreenEvent().observe(this) {
            val intent = Intent(this@SplashActivity, StartActivity::class.java)
            startActivity(intent)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashCompose(
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state = viewModel.getGoStartScreenEvent().observeAsState()
    Scaffold {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(60.dp)
                .clickable {
                    viewModel.clickToMain()
                },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashComposePreview() {
    SplashCompose()
}
