package com.tap.Presentation.PagoExitoso

import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.tap.LoginActivity
import com.tap.R
import com.tap.ui.theme.mainBlue

@Composable
fun PagoExitoso(
    navController: NavController,
    destino:String
) {
    val context= LocalContext.current

    Column(modifier=Modifier.fillMaxWidth(0.9f)){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "¡Tap Exitoso!",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
                    .padding(bottom = 14.dp)
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            Text(
                text = "Elvis Presley",
                color = mainBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Domingo 29 Octubre 2023 - 13:26 P.M.",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
                    .padding(bottom = 16.dp)
            )
        }
        Text(
            text = "Detalle del movimiento",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 20.dp)
                .padding(bottom = 16.dp)
        )
        Row(
        ){
            Text(
                text = "Destino",
                color = mainBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = destino,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "7681378",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Row(
        ){
            Text(
                text = "Desde",
                color = mainBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Cuenta Sueldo",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "****4170",
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Row(
        ){
            Text(
                text = "Número de Operación",
                color = mainBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "00143171",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)){
            Button(
                colors=ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = mainBlue
                ),
                onClick = {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, null)

                    startActivity(context,shareIntent,null)
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .border(
                    width = 2.dp,
                    color = mainBlue,
                    shape = CircleShape
                )){
                Text("Compartir",fontSize = 20.sp,fontWeight = FontWeight.Bold, modifier=Modifier.padding(10.dp))
            }
        }
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)){
            Button(
                colors=ButtonDefaults.buttonColors(
                    containerColor = mainBlue,
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("vida")
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .border(
                        width = 2.dp,
                        color = mainBlue,
                        shape = CircleShape
                    )) {
                Text("Salir",fontSize = 20.sp,fontWeight = FontWeight.Bold, modifier=Modifier.padding(10.dp))
            }
        }
    }
}