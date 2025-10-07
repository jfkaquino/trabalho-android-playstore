package com.trabalho.playstore

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

@Entity(
    tableName = "avaliacoes",
    foreignKeys = [
        ForeignKey(
        entity = Conta::class,
        parentColumns = ["id"],
        childColumns = ["contaId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Avaliacao(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val contaId: Int,
    val nome: String,
    val nota: Int,
    val comentario: String
)
