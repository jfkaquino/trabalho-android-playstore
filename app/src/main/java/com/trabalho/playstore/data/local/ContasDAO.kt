package com.trabalho.playstore.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContasDAO{

    @Insert
    suspend fun insert(conta: Conta)

    @Query("SELECT * FROM contas")
    suspend fun getAll() : Flow<List<Conta>>

    @Query("SELECT * FROM contas WHERE id = :id LIMIT 1")
    suspend fun getContaById(id: Int): Conta?

    @Delete
    suspend fun delete(conta: Conta)

    @Update
    suspend fun update(conta: Conta)
}