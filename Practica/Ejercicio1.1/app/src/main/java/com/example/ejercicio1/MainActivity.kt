package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio1.ui.theme.Ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyIcon(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyIcon(modifier:Modifier){
    Row(){
        Icon(
            imageVector = Icons.Filled.AccountCircle,
            contentDescription = "favorite",
            tint = Color.Red,
            modifier = modifier.size(48.dp)
        )

        Icon(
            imageVector = Icons.Outlined.AccountCircle,
            contentDescription = "favorite",
            tint = Color.Red,
            modifier = modifier.size(48.dp)
        )
        Icon(
            imageVector = Icons.TwoTone.AccountCircle,
            contentDescription = "favorite",
            tint = Color.Red,
            modifier = modifier.size(48.dp)
        )
    }
}