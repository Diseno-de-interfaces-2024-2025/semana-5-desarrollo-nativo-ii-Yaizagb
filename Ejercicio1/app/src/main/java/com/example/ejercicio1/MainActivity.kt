package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio1.ui.theme.Ejercicio1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1Theme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFFCDE7B0)
                            ),
                            title = { Text("Título") },
                            navigationIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "favorite",
                                    tint = Color.Gray
                                )
                            },
                            actions = {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "favorite",
                                    tint = Color.Gray
                                )
                            },
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color(0xFFCDE7B0)
                        )
                        {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            )
                            {
                                Icon(
                                    imageVector = Icons.Default.Home, // Icono predeterminado
                                    contentDescription = "Home",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clickable {
                                            navController.navigate("screen1")
                                        },
                                    tint = Color.Black // Color del ícono
                                )
                                Icon(
                                    imageVector = Icons.Default.Edit, // Icono predeterminado
                                    contentDescription = "Edit",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clickable {
                                            navController.navigate("screen2")
                                        },
                                    tint = Color.Black // Color del ícono
                                )
                                Icon(
                                    imageVector = Icons.Default.Favorite, // Icono predeterminado
                                    contentDescription = "Favourites",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clickable {
                                            navController.navigate("screen3")
                                        },
                                    tint = Color.Black // Color del ícono
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyNavControllerCustom(navController,
                        Modifier.padding(innerPadding))
                }
            }


        }
    }
    @Composable
    fun MyNavControllerCustom(navController: NavHostController, modifier: Modifier){

        NavHost(navController = navController, startDestination = "screen1",
            modifier = modifier){
            composable("screen1"){ Screen1() }
            composable("screen2"){ Screen2() }
            composable("screen3"){ Screen3() }
        }
    }

    @Composable
    fun Screen1(){
        Box(Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            MyLazyColumn(Modifier.padding())
        }
    }
    @Composable
    fun Screen2(){
        Box(Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text("Pantalla 2")
        }
    }
    @Composable
    fun Screen3(){
        Box(Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text("Pantalla 3")
        }
    }

}

@Composable
fun MyLazyColumn(modifier: Modifier){
    val itemList = listOf(
        Asignatura("Historia", R.drawable.history),
        Asignatura("Matematicas", R.drawable.math),
        Asignatura("Historia", R.drawable.history),
        Asignatura("Matematicas", R.drawable.math),
        Asignatura("Historia", R.drawable.history),
        Asignatura("Matematicas", R.drawable.math),
        Asignatura("Historia", R.drawable.history),
    )
    LazyColumn (modifier = modifier.padding(horizontal = 15.dp).fillMaxWidth()) {
        items(itemList) { asign ->
            Column(Modifier.fillMaxWidth()){
                Text(asign.asignatura,
                    Modifier.align(Alignment.CenterHorizontally))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ){
                    Image(
                        painter = painterResource(asign.imageId),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}
data class Asignatura(val asignatura: String, val imageId: Int)
