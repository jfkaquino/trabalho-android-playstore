package com.trabalho.playstore.dao

import android.util.Log

private suspend fun getConta(contaDao: ContasDAO): List<Conta> {
    return try{
        contaDao.getAll()
    }catch(e: Exception){
        Log.e("Erro ao buscar", "${e.message}")
        emptyList()
    }
}

private suspend fun insertConta(nome: String, email: String, senha: String, contaDao: ContasDAO){
    try{
        contaDao.insert(Conta(nome = nome, email = email, senha = senha))
    }catch(e: Exception){
        Log.e("Erro ao adicionar", "Msg: ${e.message}")
    }
}

private suspend fun deleteConta(conta: Conta, contaDao: ContasDAO){
    try{
        contaDao.delete(conta)
    }catch(e: Exception){
        Log.e("Erro ao excluir", "Msg: ${e.message}")
    }
}

private suspend fun updateConta(conta: Conta, contaDao: ContasDAO){
    try{
        contaDao.update(conta)
    }catch(e: Exception){
        Log.e("Erro ao editar", "Msg: ${e.message}")
    }
}