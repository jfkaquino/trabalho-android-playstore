package com.trabalho.playstore

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.rounded.GetApp
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trabalho.playstore.dao.AppDatabase
import com.trabalho.playstore.dao.Avaliacao

@Preview
@Composable
fun TelaInstalar(navController: NavHostController = rememberNavController()) {
    var avaliacoes by remember { mutableStateOf<List<Avaliacao>>(emptyList()) }

    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)
    val avaliacoesDao = db.avaliacoesDao()

    LaunchedEffect(Unit) {
        avaliacoes = avaliacoesDao.getAll()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BarraSuperior(navController) },
        bottomBar = { BarraInferior(navController) },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp)
            ) {
                Row {
                    Surface(
                        modifier = Modifier
                            .size(80.dp),
                        color = Color.Blue,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.telefone_icone),
                            contentDescription = "Play Pass Banner",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Column {
                        Text(
                            "Telefone",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            "Google LLC",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Blue
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "4,5",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.labelSmall
                            )
                            Icon(
                                modifier = Modifier
                                    .size(15.dp),
                                imageVector = Icons.Outlined.Star,
                                contentDescription = "Avaliação",
                                tint = Color.Blue
                            )
                        }

                        Text(
                            "40 mi\navaliações",
                            textAlign = TextAlign.Center,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier
                            .height(26.dp),
                        thickness = 1.dp,
                        color = Color.Gray,
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.GetApp,
                            contentDescription = ""
                        )
                        Text(
                            "12 MB",
                            textAlign = TextAlign.Center,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier
                            .height(26.dp),
                        thickness = 1.dp,
                        color = Color.Gray,
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Mais de 1 bi",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            "Downloads",
                            textAlign = TextAlign.Center,
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.Black
                    ),
                    onClick = {},
                ) {
                    Text(
                        "Instalar",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    CapturaDeTela(R.drawable.tel_um, "Tela1")
                    CapturaDeTela(R.drawable.tel_seis,"Tela6")
                    CapturaDeTela(R.drawable.tel_sete,"Tela7")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Sobre este app",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.LightGray),
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                            contentDescription = ""
                        )
                    }
                }
                Text(
                    "Ligações confiáveis com proteção contra spam, identificador de chamadas e outros",
                    modifier = Modifier
                        .padding(15.dp, 0.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(20.dp))
                FlowRow(
                    Modifier
                        .height(70.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Etiqueta("Ferramentas")
                    Etiqueta("Comunicação")
                    Etiqueta("Apps de chamadas")
                    Etiqueta("Android Auto")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                ) {
                    Text(
                        "Avaliação do app",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Dê sua opinião",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.DarkGray,
                    )
                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        var currentRating by remember { mutableIntStateOf(0) }
                        for (starIndex in 1..5) {
                            NotaEstrela(
                                starIndex = starIndex,
                                currentRating = currentRating,
                                onStarClicked = { clickedStarIndex ->
                                    currentRating = clickedStarIndex
                                }
                            )
                        }
                    }
                    var text by remember { mutableStateOf("") }
                    val context = LocalContext.current
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = {
                            Toast.makeText(context, "Obrigado pela resenha!\n$text", Toast.LENGTH_LONG).show()
                        }),
                        label = { Text("Escreva uma resenha") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(vertical = 8.dp)
                            .border(2.dp, Color.LightGray, RoundedCornerShape(5.dp)),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            focusedLabelColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            cursorColor = Color.DarkGray,
                        ),
                    )
                }



            }
        }
    }
}

@Preview
@Composable
fun ItemAvaliacao(nome: String = "teste", nota: Int = 3, comentario: String = "oi") {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 15.dp)
                    .size(40.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "",
                tint = Color.DarkGray
            )
            Text(nome)
            Spacer(modifier = Modifier.fillMaxWidth())
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(20.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(),
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "",
                )
            }
        }
        Row {
            for (i in 1..nota){
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "",
                    tint = Color.Blue
                )
            }
        }
        Row{
            Text(
                text = comentario,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CapturaDeTela(@DrawableRes imageResId: Int, nomeOferta: String) {
    Surface(
        modifier = Modifier
            .width(100.dp)
            .height(170.dp),
        color = Color.LightGray,
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

@Composable
private fun Etiqueta(texto: String) {
    Text(
        texto,
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(5.dp))
            .padding(8.dp, 5.dp),
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
private fun NotaEstrela(
    starIndex: Int,
    currentRating: Int,
    onStarClicked: (Int) -> Unit
) {
    val isFilled = starIndex <= currentRating

    IconButton(
        onClick = { onStarClicked(starIndex) }
    ) {
        Icon(
            modifier = Modifier.size(60.dp),
            imageVector = if (isFilled) Icons.Outlined.Star else Icons.Outlined.StarOutline,
            contentDescription = "Avaliação $starIndex",
            tint = if (isFilled) Color.Blue else Color.Gray
        )
    }
}