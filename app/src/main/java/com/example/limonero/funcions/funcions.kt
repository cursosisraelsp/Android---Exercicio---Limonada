package com.example.limonero.funcions

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonero.R


@Preview
@Composable
fun Exprimo(modifier: Modifier = Modifier){
    /*
    A variable result necesita o seguinte:
        - import androidx.compose.runtime.mutableStateOf
        - import androidx.compose.runtime.remember
        - import androidx.compose.runtime.setValue
    * */
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result){
        // As veces o IDE non da de maneira automática a clase R, deberemos situarnos para importala
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),

        )
        Button(onClick = {result = (1..4).random()},modifier = Modifier.background(color = Color.Red)) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "texto"
            )
        }

    }
}