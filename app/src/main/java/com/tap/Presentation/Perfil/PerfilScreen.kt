package com.tap.Presentation.Perfil

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.tap.LoginActivity
import com.tap.R
import com.tap.ui.theme.mainBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilScreen(

) {
    val context= LocalContext.current

    val refreshing = remember{ mutableStateOf(true) }
    val swipeRefreshState  = rememberSwipeRefreshState(isRefreshing =refreshing.value)
    LaunchedEffect(key1 = true){
        delay(2000)
        refreshing.value=false
    }
    Scaffold(
        modifier=Modifier.fillMaxWidth(),
    ){
        SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {

        },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                fade = true,
                contentColor = mainBlue,
                scale = true,
                backgroundColor = Color.White,
                shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 100))
            )
        }
    ) {     Column (
                modifier=Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
    )       {
            Column(modifier=Modifier.fillMaxWidth(0.9f)){
                Image(painter = painterResource(id =R.drawable.perfilbanner ), contentDescription = "perfilbanner",modifier= Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(top = 20.dp)
                    .clip(
                        RoundedCornerShape(20.dp)
                    ), contentScale = ContentScale.Crop)
                Spacer(Modifier.padding(top=20.dp))
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
                            containerColor = mainBlue,
                            contentColor = Color.White
                        ),
                        onClick = {
                            context.startActivity(Intent(context, LoginActivity::class.java))
                        }) {
                        Text("Cerrar sesión",fontWeight = FontWeight.Bold, modifier=Modifier.padding(10.dp))
                    }
                }
            }
            }

        }

    }

}