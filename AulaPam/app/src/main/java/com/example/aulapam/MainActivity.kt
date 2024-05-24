package com.example.aulapam

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aulapam.ui.theme.AulaPamTheme
import com.example.aulapam.ui.theme.debugButtonColors
import com.example.aulapam.ui.theme.errorsButtonColors
import com.example.aulapam.ui.theme.infoButtonColors
import com.example.aulapam.ui.theme.warningButtonColors


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaPamTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@Composable
private fun App(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            Image(painter = painterResource(id = R.drawable.etec), contentDescription = "Foto Etec Zl", modifier = Modifier.width(100.dp))
            Text(text = "Atividade PAM II")
            RegisterName()
            ActionButton(text = "I", buttonColors = errorsButtonColors(), modifier =  Modifier.fillMaxWidth(0.5f)) {
                Log.e(TAG, "Nota I")
            }
            ActionButton(text = "R", buttonColors = warningButtonColors(), modifier =  Modifier.fillMaxWidth(0.5f)) {
                Log.i(TAG, "Nota R")
            }
            ActionButton(text = "B", buttonColors = debugButtonColors(), modifier =  Modifier.fillMaxWidth(0.5f)) {
                Log.d(TAG, "Nota B")
            }
            ActionButton(text = "MB", buttonColors = infoButtonColors(), modifier =  Modifier.fillMaxWidth(0.5f)) {
                Log.w(TAG, "Nota MB")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(onClick = block, shape = RoundedCornerShape(5.dp), colors = buttonColors, modifier = modifier) {
        Text(text = text)
    }
}

@Composable
fun RegisterName() {
    var nome by remember {
        mutableStateOf("")
    }
    Row(
        Modifier.fillMaxWidth(),
        Arrangement.Center) {
        TextField(value = nome, onValueChange = {novovalor -> nome = novovalor }, label = { Text("Digite o nome do aluno    ")} )
    }
}