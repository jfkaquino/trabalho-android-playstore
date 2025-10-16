package com.trabalho.playstore.data.repository

import com.trabalho.playstore.data.local.Avaliacao
import com.trabalho.playstore.data.local.AvaliacoesDAO
import kotlinx.coroutines.flow.Flow

class AvaliacoesRepository(private val avaliacaoDao: AvaliacoesDAO) {

    suspend fun getAvaliacoes(): Flow<List<Avaliacao>> {
        return avaliacaoDao.getAll()
    }

    suspend fun insertAvaliacao(avaliacao: Avaliacao) {
        avaliacaoDao.insert(avaliacao)
    }

    suspend fun deleteAvaliacao(avaliacao: Avaliacao) {
        avaliacaoDao.delete(avaliacao)
    }

    suspend fun updateAvaliacao(avaliacao: Avaliacao) {
        avaliacaoDao.update(avaliacao)
    }
}