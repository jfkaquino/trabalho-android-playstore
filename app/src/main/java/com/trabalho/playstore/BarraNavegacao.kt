package com.trabalho.playstore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.SportsEsports
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(navController: NavController) {
    TopAppBar(
        modifier = Modifier.padding(5.dp),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier
                    .size(30.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = "",
                )
            }
        },
        title = { Text("") },
        actions = {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(30.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "",
                )
            }
        }
    )
}

@Composable
fun BarraInferior(navController: NavController) {
    BottomAppBar {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BarraInferiorBotao("Jogos", Icons.Outlined.SportsEsports)
            BarraInferiorBotao(
                "Apps",
                Icons.Outlined.GridView,
                { navController.navigate("TelaInicial") })
            BarraInferiorBotao("Pesquisa", Icons.Outlined.Search)
            BarraInferiorBotao("Livros", Icons.Outlined.Book)
        }
    }
}

@Composable
private fun BarraInferiorBotao(
    Texto: String,
    Icone: ImageVector,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {
                onClick()
            },
            modifier = Modifier
                .size(30.dp)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                imageVector = Icone,
                contentDescription = "",
            )
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = Texto,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
        )
    }
}