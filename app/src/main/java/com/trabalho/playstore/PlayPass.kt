package com.trabalho.playstore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TelaPlayPass() {

    Scaffold(
        topBar = { barratopo() }
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
            ){

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

                Row{

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
                    Text("Assinatura anual de R$ 89,99/ano",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.SemiBold)
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text("Ofertas disponíveis",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge)

                Text("Aproveite ofertas dos principais jogos com o Play Pass",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.height(13.dp))

                Column {

                    Row(
                        modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                    ){
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                    }

                    Spacer(modifier = Modifier.height(13.dp))

                    Row(
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState())
                    ){
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                        Spacer(modifier = Modifier.width(10.dp))
                        Ofertas()
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                Text("Perguntas frequentes",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(13.dp))

                PerguntasFrequentes()
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
fun barratopo() {

    TopAppBar(
        title = { ("")
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
                onClick = { },
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

@Preview
@Composable
fun Ofertas() {

    Column {

        Card(
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .height(80.dp)
                .width(150.dp),
            border = BorderStroke(2.dp, Color.DarkGray)
        ) {

        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Texto")

        Spacer(modifier = Modifier.height(4.dp))

        Text("Nome")
    }
}

@Preview
@Composable
fun PerguntasFrequentes(){

    Box(
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
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
    }


}
