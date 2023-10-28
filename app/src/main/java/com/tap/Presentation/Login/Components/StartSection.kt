package com.tap.Presentation.Login.Components

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tap.R
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.secondaryBlue
import com.tap.ui.theme.tertiaryBlue

@Composable
fun StartSection(
    typeUser: MutableState<String>
) {
    Column(
        modifier= Modifier.fillMaxWidth(0.9f)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Text("Con respaldo del",color= mainBlue, fontSize = 16.sp)
            Spacer(Modifier.padding(start=10.dp))
            Image(painter = painterResource(id = R.drawable.bcp_logo), contentDescription = "bcpLogo",modifier= Modifier.size(100.dp))
        }
        Box(
            modifier= Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(tertiaryBlue),
            contentAlignment = Alignment.Center

        ){
            Text(text= buildAnnotatedString {
                append("Paga, contrata y gestiona tus servicios con un ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("tap")
                } },
                modifier= Modifier.padding(20.dp)
            )
        }
        Column(
            modifier= Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = mainBlue
                ),
                modifier= Modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = 20.dp),
                onClick = {
                    typeUser.value="usuario"
                }) {
                Text("Empezar",modifier= Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription ="next" , tint=Color.White)
            }
            /*Spacer(modifier = Modifier.padding(10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = mainBlue
                ),
                modifier= Modifier.fillMaxWidth(0.6f),
                onClick = {
                    typeUser.value="empresa"
                }) {
                Text("Empresa",modifier= Modifier.padding(10.dp), fontWeight = FontWeight.Bold)
            }*/
        }


    }
}