package com.trabalho.playstore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Inicial(navController: NavHostController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BarraTopo() },
        bottomBar = { BarraInferior() }

    ) { innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ){
            Column {

                Spacer(modifier = Modifier.height(5.dp))

                TopoNavegacao()

                Spacer(modifier = Modifier.height(15.dp))

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    thickness = 2.dp,
                    color = MaterialTheme.colorScheme.outline
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    colors = CardDefaults.cardColors(Color.Cyan),
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    border = BorderStroke(2.dp, Color.Black)

                ) {  }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text("Patrocinados • ", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                    Text("Sugestões para você", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.width(74.dp))

                    IconButton(
                        onClick = {
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Mais opções",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clickable {

                            navController.navigate("TelaInstalar")
                        },
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Aplicativo(Color.Blue, icon = Icons.Rounded.Phone)
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text("Telefone")

                        Spacer(modifier = Modifier.height(5.dp))

                        Text("Google LLC • Ferramentas • Comunicação", style = MaterialTheme.typography.bodySmall)

                        Spacer(modifier = Modifier.height(5.dp))

                        Row {
                            Text("4,6", style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.width(2.dp))

                            Icon(
                                imageVector = Icons.Rounded.Star,
                                contentDescription = "",
                                modifier = Modifier.size(14.dp),
                                tint = Color.Black
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text("12 MB")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Aplicativo(Color.Black, icon = Icons.Rounded.ShoppingCart)

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text("SHEIN-COMPRAS Online")

                        Spacer(modifier = Modifier.height(5.dp))

                        Text("Compras • Lojas", style = MaterialTheme.typography.bodySmall)

                        Spacer(modifier = Modifier.height(5.dp))

                        Row {
                            Text("4,1", style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.width(2.dp))

                            Icon(
                                imageVector = Icons.Rounded.Star,
                                contentDescription = "",
                                modifier = Modifier.size(14.dp),
                                tint = Color.Black
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text("27 MB")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Aplicativo(Color.Green, icon = Icons.Rounded.AttachMoney)

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text("PicPay: Conta, Cartão e Pix")

                        Spacer(modifier = Modifier.height(5.dp))

                        Text("PicPay • Finanças • Carteiras digitais", style = MaterialTheme.typography.bodySmall)

                        Spacer(modifier = Modifier.height(5.dp))

                        Row {
                            Text("4,7", style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.width(2.dp))

                            Icon(
                                imageVector = Icons.Rounded.Star,
                                contentDescription = "",
                                modifier = Modifier.size(14.dp),
                                tint = Color.Black
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text("156 MB")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraTopo(){

    TopAppBar(
        modifier = Modifier.padding(5.dp),
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.logo_playstore),
                contentDescription = "Logo Play Store",
                modifier = Modifier
                    .height(30.dp)
                    .padding(start = 7.dp),
                contentScale = ContentScale.Fit
            )
        },
        title = { Text("") },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )

            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }
    )
}

@Composable
fun Aplicativo(color: Color, icon: ImageVector){

    Column {

        Card(
            colors = CardDefaults.cardColors(containerColor = color),
            modifier = Modifier
                .height(70.dp)
                .width(70.dp),
            border = BorderStroke(2.dp, Color.Black)
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Ícone do aplicativo",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

        }
    }


}

@Composable
fun TopoNavegacao(){

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Para você",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "Em alta",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "Outros dispositivos",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "Crianças",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "Categorias",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}