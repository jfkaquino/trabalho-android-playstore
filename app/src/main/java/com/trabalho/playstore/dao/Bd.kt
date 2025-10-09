package com.trabalho.playstore.dao

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "contas")
data class Conta(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val email: String,
    val senha: String
)

@Entity(tableName = "avaliacoes")
data class Avaliacao(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nota: Int,
    val comentario: String
)
