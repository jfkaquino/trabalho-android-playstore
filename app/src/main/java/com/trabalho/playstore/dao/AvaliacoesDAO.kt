package com.trabalho.playstore.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AvaliacoesDAO{

    @Insert
    suspend fun insert(avaliacao: Avaliacao)

    @Query("SELECT * FROM avaliacoes")
    suspend fun getAll() : List<Avaliacao>

    @Delete
    suspend fun delete(avaliacao: Avaliacao)

    @Update
    suspend fun update(avaliacao: Avaliacao)
}