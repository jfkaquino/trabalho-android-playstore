package com.trabalho.playstore

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContasDAO{

    @Insert
    suspend fun insert(conta: Conta)

    @Query("SELECT * FROM contas")
    suspend fun getAll() : List<Conta>

    @Delete
    suspend fun delete(conta: Conta)

    @Update
    suspend fun update(conta: Conta)
}