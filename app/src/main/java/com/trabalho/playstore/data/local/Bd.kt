package com.trabalho.playstore.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "com/trabalho/playstore/ui/contas")
data class Conta(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val email: String,
    val senha: String
)

@Entity(tableName = "com/trabalho/playstore/ui/avaliacoes")
data class Avaliacao(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nota: Int,
    val comentario: String
)
