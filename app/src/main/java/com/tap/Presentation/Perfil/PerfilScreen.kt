package com.tap.Presentation.Perfil

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tap.LoginActivity
import com.tap.ui.theme.mainBlue

@Composable
fun PerfilScreen(

) {
    val context= LocalContext.current

    Column(modifier=Modifier.fillMaxWidth(0.9f)){
        Card(
           colors=CardDefaults.cardColors(
               containerColor =  mainBlue
           ),
            modifier=Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier=Modifier.fillMaxWidth()
                    .padding(20.dp)
            ){
                Text("John Doe",color= Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Button(
                    colors=ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    onClick = {
                    context.startActivity(Intent(context, LoginActivity::class.java))
                }) {
                    Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Logout")
                }

            }


        }
    }
}