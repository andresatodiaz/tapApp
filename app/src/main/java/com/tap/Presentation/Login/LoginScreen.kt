package com.tap.Presentation.Login

import android.widget.Toast
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.tap.Presentation.Login.Components.LoginBanner
import com.tap.Presentation.Login.Components.LoginSection
import com.tap.Presentation.Login.Components.StartSection
import com.tap.Presentation.Notification.Notification
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue
import com.tap.ui.theme.tertiaryBlue

@Composable
fun LoginScreen(
    goToMain: ()-> Unit
){
    val typeUser = remember{mutableStateOf("")}

    val context = LocalContext.current
    val activity = LocalContext.current as FragmentActivity
    val executor  = ContextCompat.getMainExecutor(activity)

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Para generar el token digital")
        .setDescription("Ingrese su huelle digital o clave del dispositivo")
        .setAllowedAuthenticators(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
        .build()

    val biometricPrompt = BiometricPrompt(activity,executor,
        object : BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(
                        context,
                        "Error",
                        Toast.LENGTH_LONG
                    ).show()
                Notification(context = context ).showBasicNotification("Tap","Verifique su identidad mediante su correo.")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(
                    context,
                    "Correcto",
                    Toast.LENGTH_LONG
                ).show()
                goToMain()
                Notification(context = context ).showBasicNotification("Tap","Token digital guardado en el app")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(
                    context,
                    "Falló",
                    Toast.LENGTH_LONG
                ).show()
                Notification(context = context ).showBasicNotification("Tap","Verifique su identidad mediante su correo.")
            }
        })



    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        secondaryBlue
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LoginBanner()
        if(typeUser.value==""){
            StartSection(typeUser = typeUser)
        }else{
            LoginSection(typeUser = typeUser, goToMain=goToMain ){
                biometricPrompt.authenticate(promptInfo)
            }
        }
    }
}