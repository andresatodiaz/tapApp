package com.tap.Presentation.Login.Components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.tap.R
import com.tap.ui.theme.mainBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginSection(
    typeUser:MutableState<String>,
    goToMain: ()->Unit
) {
    val user = remember{mutableStateOf("")}
    val pass = remember{mutableStateOf("")}
    val showPass = remember{ mutableStateOf(false) }
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
                goToMain()
            }) {
            Text("Iniciar Sesión",modifier= Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier= Modifier.fillMaxWidth(0.6f),
            onClick = {
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