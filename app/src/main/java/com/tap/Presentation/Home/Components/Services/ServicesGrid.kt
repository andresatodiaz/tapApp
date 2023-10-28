package com.tap.Presentation.Home.Components.Services

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.tap.Data.Entities.Service

@Composable
fun ServicesGrid(
    section:String,
    servicesList: List<Service>
){
    Text(section, fontWeight = FontWeight.Black)
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(servicesList){service->
            ServiceCard(service = service)
        }
    }
}