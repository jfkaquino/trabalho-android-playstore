package com.trabalho.playstore

import android.view.Menu
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.ArrowDropDownCircle
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.LocalActivity
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.rounded.AccountCircle
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trabalho.playstore.dao.AppDatabase
import com.trabalho.playstore.dao.Conta

@Preview
@Composable
fun TelaConta(navController: NavHostController = rememberNavController()) {
    var contas by remember { mutableStateOf<List<Conta>>(emptyList()) }
    var listaContasVisivel by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)
    val contasDao = db.contasDao()

    LaunchedEffect(Unit) {
        contas = contasDao.getAll()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF0F5F9)
            ),
        topBar = { BarraSuperiorConta(navController) },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
        ) {
            Column {
                Card(
                    modifier = Modifier
                        .padding(20.dp, 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                ) {
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
                            onClick = { listaContasVisivel = !listaContasVisivel }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(25.dp)
                                    .rotate(if (listaContasVisivel) 180f else 0f),
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
                    if (listaContasVisivel) {
                    LazyColumn {
                        items(contas){
                            conta -> MenuItem(
                                texto = conta.nome,
                                icone = Icons.Outlined.AccountCircle
                            )
                        }
                        item {
                            MenuItem(
                                texto = "Adicionar outra conta",
                                icone = Icons.Outlined.PersonAdd,
                                onClick = {}
                            )
                        }
                        item {
                            MenuItem(
                                texto = "Gerenciar contas neste dispositivo",
                                icone = Icons.Outlined.ManageAccounts,
                                onClick = {}
                            )
                        }
                        item {
                            HorizontalDivider(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                color = Color(0xFFF0F5F9),
                                thickness = 2.dp
                            )
                        }
                    }
                        }
                    Column {
                        MenuItem(
                            texto = "Gerenciar apps e dispositivos",
                            icone = Icons.Outlined.Apps
                        )
                        MenuItem(
                            texto = "Notificações e ofertas",
                            icone = Icons.Outlined.Notifications
                        )
                        MenuItem(
                            texto = "Pagamentos e assinaturas",
                            icone = Icons.Outlined.CreditCard
                        )
                        MenuItem(
                            texto = "Play Protect",
                            icone = Icons.Outlined.Security
                        )
                        MenuItem(
                            texto = "Biblioteca",
                            icone = Icons.Outlined.Folder
                        )
                        MenuItem(
                            texto = "Play Pass",
                            icone = Icons.Outlined.LocalActivity,
                            onClick = { navController.navigate("TelaPlayPass") }
                        )
                        MenuItem(
                            texto = "Play Points",
                            icone = Icons.Outlined.Star
                        )
                        MenuItem(
                            texto = "Personalização no app Google Play",
                            icone = Icons.Outlined.Tune
                        )
                        MenuItem(
                            texto = "Configurações",
                            icone = Icons.Outlined.Settings
                        )
                        MenuItem(
                            texto = "Ajuda e feedback",
                            icone = Icons.AutoMirrored.Outlined.HelpOutline
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Política de privacidade",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        text = "•",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "Termos de serviço",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun MenuItem(texto: String, icone: ImageVector, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable {
                onClick()
            },
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
private fun BarraSuperiorConta(navController: NavHostController) {
    CenterAlignedTopAppBar(
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