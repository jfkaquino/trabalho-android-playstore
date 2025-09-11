package com.trabalho.playstore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDownCircle
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TelaConta() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF0F5F9)
            ),
        topBar = { BarraSuperior() },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            Card(
                modifier = Modifier
                    .padding(20.dp, 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(55.dp),
                            tint = Color.Blue,
                            imageVector = Icons.Rounded.AccountCircle,
                            contentDescription = "",
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            Text(
                                text = "Fulano da Silva",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "fulanodasilva@gmail.com",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.DarkGray
                            )
                        }
                        Spacer(modifier = Modifier.weight(1F))
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                imageVector = Icons.Outlined.ArrowDropDownCircle,
                                contentDescription = "",
                                tint = Color.DarkGray
                            )
                        }
                    }
                    IconButton(
                        modifier = Modifier
                            .padding(start = 70.dp)
                            .border(BorderStroke(1.dp, Color.DarkGray), RoundedCornerShape(5.dp))
                            .width(220.dp)
                            .height(32.dp),
                        onClick = {}
                    )
                    {
                        Text(
                            text = "Gerenciar sua Conta do Google",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(),
                        color = Color(0xFFF0F5F9),
                        thickness = 2.dp
                    )
                    Column {
                        MenuItem(
                            texto = "Gerenciar apps e dispositivos",
                            icone = Icons.Rounded.Apps
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItem(texto: String, icone: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .size(20.dp),
            imageVector = icone,
            contentDescription = "",
            tint = Color.DarkGray
        )
        Text(
            text = texto,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BarraSuperior() {
    CenterAlignedTopAppBar(
        modifier = Modifier.padding(5.dp),
        navigationIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(30.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "",
                )
            }
        },
        title = {
            Image(
                modifier = Modifier
                    .size(80.dp),
                painter = painterResource(
                    id = R.drawable.google_logo
                ),
                contentDescription = "Logo do Google",
                contentScale = ContentScale.Fit
            )
        },
    )
}