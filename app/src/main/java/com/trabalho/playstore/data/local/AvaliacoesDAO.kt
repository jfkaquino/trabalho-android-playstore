package com.trabalho.playstore.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AvaliacoesDAO{

    @Insert
    suspend fun insert(avaliacao: Avaliacao)

    @Query("SELECT * FROM avaliacoes")
    fun getAll() : Flow<List<Avaliacao>>

    @Delete
    suspend fun delete(avaliacao: Avaliacao)

    @Update
    suspend fun update(avaliacao: Avaliacao)
}