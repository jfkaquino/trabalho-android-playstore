package com.trabalho.playstore

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TelaPlayPass(navController: NavHostController) {

    Scaffold(
        topBar = { barratopo(navController) }
    ) { innerPadding ->

        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Image(
                    painter = painterResource(id = R.drawable.playpass_banner),
                    contentDescription = "Minha imagem",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Participe do Google Play Pass",
                    style = MaterialTheme.typography.titleLarge,

                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Row {

                    Text("Por apenas")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("R$ 9,90/mês", fontWeight = FontWeight.SemiBold)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Acesse mais de mil apps e jogos, sem anúncios nem compras no app. E ainda receba ofertas nos melhores games.",
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.Black
                    )
                ) {
                    Text(
                        "Comece já"
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Text("Economize 24% com uma", style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "Assinatura anual de R$ 89,99/ano",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    "Ofertas disponíveis",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    "Aproveite ofertas dos principais jogos com o Play Pass",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(13.dp))

                Column {

                    Row(
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Ofertas(
                            R.drawable.cod_banner,
                            "Call of Duty",
                            "50% de desconto em uma compra no app",
                            "Call of Duty: Mobile - T 8"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.candy_banner,
                            "Candy Crush",
                            "Ganhe um Pacotinho Delicado",
                            "Candy Crush Saga"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.ball_banner,
                            "8 Ball Pool",
                            "50% de desconto em uma compra no app",
                            "8 Ball Pool"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.asphalt_banner,
                            "Asphalt 9: Legends",
                            "50% de desconto em uma compra no app",
                            "Asphalt Legends - Corrida"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.freefire_banner,
                            "Free Fire",
                            "50% de desconto em uma compra no app",
                            "Free Fire"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.eafc_banner,
                            "EA SPORTS FC Mobile",
                            "50% de desconto em uma compra no app",
                            "EA SPORTS FC Mobile"
                        )
                    }

                    Spacer(modifier = Modifier.height(13.dp))

                    Row(
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Ofertas(
                            R.drawable.angry_banner,
                            "Angry Birds",
                            "50% de desconto em uma compra no app",
                            "Angry Birds 2"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.monopoly_banner,
                            "Monopoly",
                            "50% de desconto em uma compra no app",
                            "Monopoly GO!"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.roblox_banner,
                            "Roblox",
                            "80% de desconto em uma compra no app",
                            "Roblox"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.disney_banner,
                            "Disney",
                            "50% de desconto em uma compra no app",
                            "O Reino Mágico da Disney"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.lords_banner,
                            "Lords Mobile",
                            "Ganhe um pacote Brilhando Juntos",
                            "Lords Mobile: Guerra de Reinos"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas(
                            R.drawable.guy_banner,
                            "Stumble Guys",
                            "50% de desconto em uma compra no app",
                            "Stumble Guys"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    "Perguntas frequentes",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(13.dp))

                PerguntasFrequentes()

                Spacer(modifier = Modifier.height(30.dp))

                rodape()
            }

        }
    }

}

@Composable
fun MinhaImagemLocal() {
    Image(
        painter = painterResource(id = R.drawable.icon),
        contentDescription = "Minha imagem",
        modifier = Modifier.size(150.dp),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barratopo(navController: NavHostController) {

    TopAppBar(
        title = {
            ("")
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "Minha imagem",
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 12.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Google Play Pass",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigateUp()
                },
                modifier = Modifier
                    .size(30.dp)
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )

}

@Composable
fun Ofertas(@DrawableRes imageResId: Int, nomeOferta: String, texto: String, texto2: String) {

    Column(
        modifier = Modifier.width(150.dp)
    ) {

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .height(80.dp)
                .width(150.dp),
            border = BorderStroke(2.dp, Color.DarkGray)
        ) {

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = nomeOferta,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(texto)

        Spacer(modifier = Modifier.height(4.dp))

        Text(texto2)
    }
}

@Preview
@Composable
fun PerguntasFrequentes() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text("Como o Play Pass funciona?")

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("O que tem no catálogo do Play Pass?")

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("O que são as ofertas do Play Pass?")

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("O que acontece com os jogos e apps que já tenho?")

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Como o Compartilhamento em família funciona no Play Pass?")

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun rodape() {

    Column {

        Image(
            painter = painterResource(id = R.drawable.icon_final),
            contentDescription = "Banner Play Pass Final",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            "Diversão para todos",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            "O administrador da família pode compartilhar o acesso aos jogos e apps do Google Play Pass com até cinco membros. As ofertas mensais no jogo só serão disponíveis para administradores da família",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            "Saiba mais",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold
        )

    }
}

