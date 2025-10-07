package com.trabalho.playstore.dao

import android.util.Log

private suspend fun getAvaliacao(avaliacaoDao: AvaliacoesDAO): List<Avaliacao> {
    return try{
        avaliacaoDao.getAll()
    }catch(e: Exception){
        Log.e("Erro ao buscar", "${e.message}")
        emptyList()
    }
}

private suspend fun insertAvaliacao(contaId: Int, nome: String, nota: Int, comentario: String, avaliacaoDao: AvaliacoesDAO){
    try{
        avaliacaoDao.insert(Avaliacao(contaId = contaId, nome = nome, nota = nota, comentario = comentario))
    }catch(e: Exception){
        Log.e("Erro ao adicionar", "Msg: ${e.message}")
    }
}

private suspend fun deleteAvaliacao(avaliacao: Avaliacao, avaliacaoDao: AvaliacoesDAO){
    try{
        avaliacaoDao.delete(avaliacao)
    }catch(e: Exception){
        Log.e("Erro ao excluir", "Msg: ${e.message}")
    }
}

private suspend fun updateAvaliacao(avaliacao: Avaliacao, avaliacaoDao: AvaliacoesDAO){
    try{
        avaliacaoDao.update(avaliacao)
    }catch(e: Exception){
        Log.e("Erro ao editar", "Msg: ${e.message}")
    }
}