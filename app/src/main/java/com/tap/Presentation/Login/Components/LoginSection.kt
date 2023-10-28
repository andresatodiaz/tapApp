package com.tap.Presentation.Login.Components

import android.widget.Spinner
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tap.Presentation.Notification.Notification
import com.tap.R
import com.tap.ui.theme.mainBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(10)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginSection(
    typeUser:MutableState<String>,
    goToMain: ()->Unit,
    auth: ()->Unit
) {
    val context= LocalContext.current
    val scope = rememberCoroutineScope()
    val user = remember{mutableStateOf("")}
    val pass = remember{mutableStateOf("")}
    val showPass = remember{ mutableStateOf(false) }
    val register = remember{ mutableStateOf(false) }
    val loadingCompletion = remember{ mutableStateOf(0f) }

    LaunchedEffect(key1 = register.value ){
        if(register.value==true){
            delay(2000)
            register.value=false
            Notification(context = context ).showBasicNotification("Tap","Se ha registrado su usuario")
        }
    }

    if(register.value){
        Dialog(onDismissRequest = { /*TODO*/ }) {
            Column(
                modifier=Modifier.background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp)
            ) {
                Spacer(Modifier.padding(10.dp))
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    progress = loadingCompletion.value
                )
                Spacer(Modifier.padding(10.dp))
                Text("Gracias por ingresar sus datos", fontWeight = FontWeight.Bold,modifier=Modifier.padding(bottom=20.dp))
                Text("Registrando usuario..", fontWeight = FontWeight.Normal)
            }
        }
    }

    BackHandler {
        typeUser.value=""
    }
    Column(
        modifier= Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido ${typeUser.value}", fontWeight = FontWeight.Bold,color= mainBlue,modifier=Modifier.padding(bottom=20.dp))
        OutlinedTextField(value = user.value , onValueChange = {user.value=it},
            modifier=Modifier.padding(bottom = 10.dp),
            shape= CircleShape,
            label = {
                Text("Usuario")
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = mainBlue,
                containerColor = Color.Transparent
            )
        )
        OutlinedTextField(value = pass.value , onValueChange = {pass.value=it},
            modifier=Modifier.padding(bottom = 20.dp),
            shape= CircleShape,
            label = {
                Text("Contraseña")
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = mainBlue,
                containerColor = Color.Transparent
            ),
            trailingIcon = {
                Image(painter = painterResource(id = if(showPass.value) R.drawable.showpass else R.drawable.hidepass), contentDescription = "showpass",modifier=Modifier.clickable {
                    showPass.value=!showPass.value
                })
            },
            visualTransformation = if (showPass.value) VisualTransformation.None else PasswordVisualTransformation()
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = mainBlue
            ),
            modifier= Modifier.fillMaxWidth(0.6f),
            onClick = {
                auth()
                //goToMain()
            }) {
            Text("Iniciar Sesión",modifier= Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier= Modifier.fillMaxWidth(0.6f),
            onClick = {
                register.value=true
                scope.launch {
                    loadProgress { progress ->
                        loadingCompletion.value = progress
                    }
                }

            }) {
            Text(text= buildAnnotatedString {
                append("No tiene cuenta? ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Registrate")
                } },
                modifier= Modifier.padding(10.dp),color= mainBlue)
        }
    }
}