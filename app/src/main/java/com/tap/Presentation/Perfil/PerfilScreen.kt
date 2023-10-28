package com.tap.Presentation.Perfil

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tap.LoginActivity
import com.tap.R
import com.tap.ui.theme.mainBlue

@Composable
fun PerfilScreen(

) {
    val context= LocalContext.current

    Column(modifier=Modifier.fillMaxWidth(0.9f)){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .size(80.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.user), contentDescription = "grid",tint= mainBlue,
                modifier = Modifier.size(80.dp))
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Elvis Presley",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
                    .padding(bottom = 16.dp)
            )
        }
        Text("Nombre:",color= mainBlue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Elvis Aron Presley",color= Color.Black, fontWeight = FontWeight.Normal, fontSize = 20.sp, modifier = Modifier.padding(bottom = 12.dp))

        Text("Documento de Identidad:",color= mainBlue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("DNI: 70972284",color= Color.Black, fontWeight = FontWeight.Normal, fontSize = 20.sp, modifier = Modifier.padding(bottom = 12.dp))

        Text("Número de contacto:",color= mainBlue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("965*****",color= Color.Black, fontWeight = FontWeight.Normal, fontSize = 20.sp, modifier = Modifier.padding(bottom = 12.dp))

        Text("Correo: ",color= mainBlue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("e******************.com",color= Color.Black, fontWeight = FontWeight.Normal, fontSize = 20.sp, modifier = Modifier.padding(bottom = 12.dp))

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)){
            Button(
                colors=ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                onClick = {
                    context.startActivity(Intent(context, LoginActivity::class.java))
                },
                modifier = Modifier.border(
                    width = 2.dp,
                    color = mainBlue,
                    shape = CircleShape
                )) {
                Text("Cerrar sesión",color= mainBlue, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    }
}