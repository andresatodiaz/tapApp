package com.tap.Presentation.Sobres

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tap.Presentation.Financiera.Components.Operaciones
import com.tap.Presentation.Sobres.Components.SobreCard
import com.tap.ui.theme.mainBlue
import com.tap.ui.theme.mainOrange
import com.tap.ui.theme.secondaryBlue
import com.tap.ui.theme.tertiaryBlue

@Composable
fun SobreScreen(

) {
    val sobres = listOf("Comida", "Ocio", "Educación")
    val sobresColores= listOf<Color>(Color(0xff00695c),Color(0xffd81b60),Color(0xff6d4c41))
    val selected = remember{mutableStateOf(sobres[0])}
    LazyColumn(
        modifier=Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom=100.dp)
    ){
        item{

            Column(
                modifier=Modifier.fillMaxWidth(0.9f)
            ) {
                LazyRow(
                    modifier=Modifier.fillMaxWidth()
                ){
                    items(sobres.size){
                        SobreCard(sobre = sobres[it], color = sobresColores[it], selected= selected)
                    }
                    item{
                        Button(
                            colors=ButtonDefaults.buttonColors(
                                containerColor = mainBlue,
                                contentColor = Color.White
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(50.dp),
                            contentPadding = PaddingValues(0.dp),
                            onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Add" )
                        }
                    }
                }
            }
        }
        item{
            Column(modifier= Modifier
                .fillMaxWidth(0.9f)
                .background(tertiaryBlue, RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp))
                .padding(20.dp)
            ) {

                Row(
                    modifier= Modifier
                        .fillMaxWidth(0.9f)
                        .padding(30.dp)
                ){
                    Box(modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .background(mainBlue)
                        .height(20.dp)){
                        Text("")
                    }
                    Box(modifier= Modifier
                        .fillMaxWidth(0.8f)
                        .background(mainOrange)
                        .height(20.dp)){
                        Text("")
                    }
                }
                Column (modifier=Modifier.fillMaxWidth(0.9f)){
                    Row (modifier=Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Text("Consumo S/. 1300")
                        Text("Límite S/. 1444.44")
                    }
                }
                Text("Has consumido 90% de este sobre", modifier=Modifier.padding(top=20.dp,bottom=20.dp), fontWeight = FontWeight.Bold)
            }
        }
        item{
            Text("Operaciones selectas", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=10.dp,bottom=10.dp))
        }
        items(10){
            Column(modifier=Modifier.fillMaxWidth(0.9f)){
                Operaciones()
            }
            Spacer(Modifier.padding(bottom=20.dp))
        }

    }

}