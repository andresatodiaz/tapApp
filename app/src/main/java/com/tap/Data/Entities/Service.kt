package com.tap.Data.Entities

data class Service(
    val nombre : String,
    val precio : Double,
    val estado: String?=null,
    val fecha: String?=null,
    val codigo: String?=null
)
