package com.example.evaluacioncuno

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Formulario(){
    Column(Modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .weight(1f)){
            var montopre by rememberSaveable  {
                mutableStateOf("")
            }
            var resultado by rememberSaveable {
                mutableStateOf("")
            }
            Column {
                Text(text = "Ejercicio 2",
                    modifier = Modifier.fillMaxWidth())
                espacio(tamanio = 10)
                OutlinedTextField(value = montopre,
                    onValueChange = {montopre=it},
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Ingrese número") },
                    maxLines = 1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                espacio(tamanio = 10)
                Button(onClick = {
                    resultado= prestamo(montopre.toDouble())
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "CALCULAR")
                }
                espacio(tamanio = 10)
                Text(text = resultado)
            }
        }
        espacio(tamanio = 10)
    Box(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)

            .weight(1f)){
        var numv by rememberSaveable  {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column {
            Text(text = "Elabore un algoritmo que solicite un número entero y muestre un mensaje " +
                    "indicando la vocal correspondiente, considerando que la vocal A = 1",
                modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)
            OutlinedTextField(value = numv,
                onValueChange = {numv=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese número") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            Button(onClick = {
                resultado= vocal(numv.toInt())
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacio(tamanio = 10)
            Text(text = resultado)
        }
    }
    espacio(tamanio = 10)
    Box(
        Modifier
            .fillMaxWidth()
            .weight(1f)
           ){
        var limite by rememberSaveable  {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }
        Column(Modifier.verticalScroll(rememberScrollState())) {
            Text(text = "Ingresar el límite de número y por cada número de la secuencia obtener " +
                    "su cubo y su cuarta.",
                modifier = Modifier.fillMaxWidth())
            espacio(tamanio = 10)
            OutlinedTextField(value = limite,
                onValueChange = {limite=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese limmite") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            espacio(tamanio = 10)
            Button(onClick = {
                resultado=calLimite(limite.toInt())
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            espacio(tamanio = 10)
            Text(text = resultado)
        }
    }


}
}

@Composable
fun espacio(tamanio:Int){
    Spacer(modifier = Modifier.height(tamanio.dp))
}

fun prestamo(montoPrestamo:Double):String{

    
    return ""
}

fun vocal(num:Int):String{
    val vocal = when(num) {
        1 -> "A"
        2 -> "E"
        3 -> "I"
        4 -> "O"
        5 -> "U"
        else -> "Vuelve a intentarlo"
    }
    return  "vocal $vocal = $num"
}

fun calLimite(limite: Int):String{
    var rpt=""
    for (num in 1..limite) {
        var cubo = num * num * num
        var cuarta = cubo * num
        rpt+="cubo del $num = $cubo, cuarta del $num = $cuarta \n"
    }
    return rpt
}