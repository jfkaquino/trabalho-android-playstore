package com.trabalho.playstore

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Notifications
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class AppItem(val nome: String, val descricao: String, val avaliacao: String, val tamanho: String, val cor: Color, val imageResId: Int, val nomeOferta: String, val rotaNavegacao: String? = null)

@Composable
fun Inicial(navController: NavHostController) {

    val listaApps = listOf(
        AppItem(
            "Telefone",
            "Google LLC • Ferramentas • Comunicação",
            "4,6",
            "12 MB",
            Color.Blue,
            R.drawable.telefone_icone,
            "Telefone",
            rotaNavegacao = "TelaInstalar"
        ),
        AppItem(
            "SHEIN-COMPRAS Online",
            "Compras • Lojas",
            "4,1",
            "27 MB",
            Color.Black,
            R.drawable.shein,
            "Shein"
        ),
        AppItem(
            "PicPay: Conta, Cartão e Pix",
            "PicPay • Finanças • Carteiras digitais",
            "4,7",
            "156 MB",
            Color.Green,
            R.drawable.picpay,
            "Picpay"
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BarraTopo(navController) },
        bottomBar = { BarraInferior(navController) }

    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
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
                    border = BorderStroke(2.dp, Color.White)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.banner1),
                        contentDescription = "Play Pass Banner",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        "Patrocinados • ",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Sugestões para você",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )

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

                LazyColumn(
                    userScrollEnabled = true
                ) {
                    items(listaApps) { app ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val appTel =
                                if (app.rotaNavegacao != null) {
                                    Modifier.clickable {
                                        navController.navigate(app.rotaNavegacao)
                                    }
                                } else {
                                    Modifier
                                }

                            Aplicativo(
                                color = app.cor,
                                imageResId = app.imageResId,
                                nomeOferta = app.nomeOferta,
                                modifier = appTel
                            )
                            Spacer(modifier = Modifier.width(20.dp))

                            Column {
                                Text(app.nome)

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    app.descricao,
                                    style = MaterialTheme.typography.bodySmall
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Row {
                                    Text(app.avaliacao, style = MaterialTheme.typography.bodySmall)

                                    Spacer(modifier = Modifier.width(2.dp))

                                    Icon(
                                        imageVector = Icons.Rounded.Star,
                                        contentDescription = "Avaliação",
                                        modifier = Modifier.size(14.dp),
                                        tint = Color.Black
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    Text(app.tamanho)
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraTopo(navController: NavHostController) {

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

            IconButton(
                onClick = { navController.navigate("TelaConta") }
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    )
}

@Composable
fun Aplicativo(color: Color, @DrawableRes imageResId: Int, nomeOferta: String, modifier: Modifier = Modifier) {

    Column {

        Card(
            colors = CardDefaults.cardColors(containerColor = color),
            modifier = modifier
                .height(70.dp)
                .width(70.dp),
            shape = RoundedCornerShape(10.dp)
        ) {

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = nomeOferta,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun TopoNavegacao() {

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
                    .padding(horizontal = 16.dp)
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
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
