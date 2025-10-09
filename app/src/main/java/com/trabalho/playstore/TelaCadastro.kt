package com.trabalho.playstore

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trabalho.playstore.dao.AppDatabase
import com.trabalho.playstore.dao.Conta
import com.trabalho.playstore.dao.ContasDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun TelaCadastro(navController: NavHostController = rememberNavController()){

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("")}
    var senha by remember { mutableStateOf("") }

    val contex = LocalContext.current
    val db = AppDatabase.getDatabase(contex)
    val contaDao = db.contasDao()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { BarraSuperiorCadastro() },
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Criar uma conta do Google",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Insira seus dados",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail ou telefone") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
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

                Spacer(modifier = Modifier.height(3.dp))

                TextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
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

                Spacer(modifier = Modifier.height(3.dp))

                TextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
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

                Spacer(modifier = Modifier.height(3.dp))

                Button(
                    onClick = {
                        if(nome.isNotBlank() && email.isNotBlank() && senha.isNotBlank()){
                            CoroutineScope(Dispatchers.IO).launch {
                                insertConta(nome, email, senha, contaDao)
                            }
                        }
                    }
                ) {
                    Text("Avançar")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BarraSuperiorCadastro() {
    CenterAlignedTopAppBar(
        modifier = Modifier.padding(5.dp),
        navigationIcon = {
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(30.dp)
            ) {
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

suspend fun insertConta(nome: String, email: String, senha: String, contaDao: ContasDAO){
    try{
        contaDao.insert(Conta(nome = nome, email = email, senha = senha))
    }catch(e: Exception){
        Log.e("Erro ao adicionar", "Msg: ${e.message}")
    }
}