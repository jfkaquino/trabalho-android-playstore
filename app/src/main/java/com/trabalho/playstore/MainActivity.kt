package com.trabalho.playstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.trabalho.playstore.ui.avaliacoes.TelaInstalar
import com.trabalho.playstore.ui.contas.TelaCadastro
import com.trabalho.playstore.ui.contas.TelaConta

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "TelaInicial") {
                composable("TelaInicial") { TelaInicial(navController) }
                composable("TelaInstalar") { TelaInstalar(navController) }
                composable("TelaConta") { TelaConta(navController) }
                composable("TelaPlayPass") { TelaPlayPass(navController) }
                composable("TelaCadastro") { TelaCadastro(navController = navController, id = null) }
                composable("TelaCadastro/{id}") { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                    TelaCadastro(navController = navController, id = id)
                }
            }
        }
    }
}