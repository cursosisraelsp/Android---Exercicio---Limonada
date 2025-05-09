package com.example.limonero.funcions

import android.widget.Button
import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonero.R

fun seleccion(valor: Int):Int{
    val eleccion = when (valor){
        1 -> 2
        2 -> 3
        3 -> 4
        4 -> 5
        5 -> 6
        6 -> 7
        else -> 1
    }
    return eleccion
}
fun textos(valor: Int):Int{
    val textoSalida = when(valor){
        1 -> R.string.select_lemon
        2 -> R.string.tapping_lemon
        3 -> R.string.tapping_lemon
        4 -> R.string.tapping_lemon
        5 -> R.string.tapping_lemon
        6 -> R.string.drink_lemon
        7 -> R.string.glass_lemon
        else -> R.string.tree_lemon
    }
    return textoSalida
}
fun imaxes(result: Int):Int{
    val imaxen = when (result){
        // As veces o IDE non da de maneira automática a clase R, deberemos situarnos para importala
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_squeeze
        4 -> R.drawable.lemon_squeeze
        5 -> R.drawable.lemon_squeeze
        6 -> R.drawable.lemon_drink
        7 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    return imaxen
}

@Composable
fun OTitulo(titulo: String,modificador: Modifier):Unit{
    Box(){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxHeight(0.05f)
                .fillMaxWidth(1f)){

            Text(text = titulo ,fontSize = 25.sp)
        }
    }

}
@Preview (showBackground = true)
@Composable
fun Exprimo(modifier: Modifier = Modifier){
    /*
    A variable result necesita o seguinte:
        - import androidx.compose.runtime.mutableStateOf
        - import androidx.compose.runtime.remember
        - import androidx.compose.runtime.setValue
    * */
    var result by remember { mutableStateOf(1) }
    val imageResource = imaxes(result)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OTitulo(stringResource(R.string.app_name),Modifier.background(color = Color.Yellow).fillMaxWidth(1f))
        Column (
            modifier = modifier.fillMaxHeight(1f).fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            // Define un color HSL
            val hue = 30f // Tono (0-360)
            val saturation = 0.8f // Saturación (0-1)
            val lightness = 0.5f // Luminosidad (0-1)


            // Temos diferentes opcións en 'https://androindian.com/image-button-in-jetpack/'
            IconButton(
                onClick = {result = seleccion(result)},
                modifier = Modifier.size(350.dp).clip(RoundedCornerShape(36.dp)).background(color = Color.hsl(hue,saturation,lightness))
                 ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = result.toString(),

                    )
                    val frase = textos(result)
                    Text(text = stringResource(frase))
                }

            }


        }
    }

}