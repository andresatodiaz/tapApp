package com.tap

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tap.Presentation.Login.LoginScreen
import com.tap.ui.theme.TapTheme
import com.tap.ui.theme.mainBlue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sp = MainApplication.applicationContext().getSharedPreferences(
                        "preferences",
                        MODE_PRIVATE
                    )

                    if(sp.getString("LOGGED_ID","")!=""){
                        goToMain()
                    }

                    val uiController = rememberSystemUiController()
                    uiController.setStatusBarColor(Color.White, darkIcons = true)
                    uiController.setNavigationBarColor(mainBlue)

                    LoginScreen(){
                        goToMain()
                    }

                }
            }
        }
    }
    @OptIn(ExperimentalGetImage::class) private fun goToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}