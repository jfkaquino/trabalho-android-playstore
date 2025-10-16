package com.trabalho.playstore.data.repository

import com.trabalho.playstore.data.local.Conta
import com.trabalho.playstore.data.local.ContasDAO
import kotlinx.coroutines.flow.Flow

class ContasRepository (private val contasDAO: ContasDAO){

    suspend fun getAll(): Flow<List<Conta>>{
        return contasDAO.getAll()
    }

    suspend fun insert(conta: Conta){
        contasDAO.insert(conta)
    }

    suspend fun update(conta: Conta){
        contasDAO.update(conta)
    }

    suspend fun delete(conta: Conta){
        contasDAO.delete(conta)
    }

}