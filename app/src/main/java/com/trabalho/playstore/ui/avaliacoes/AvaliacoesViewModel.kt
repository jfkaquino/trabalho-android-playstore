package com.trabalho.playstore.ui.avaliacoes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.trabalho.playstore.data.local.Avaliacao
import com.trabalho.playstore.data.repository.AvaliacoesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AvaliacoesUiState(
    val listaAvaliacoes: List<Avaliacao> = emptyList(),
    val nota: Int = 0,
    val comentario: String = "",
    val avaliacaoEmEdicao: Avaliacao? = null
){
    val textoBotao: String
        get() = if (avaliacaoEmEdicao == null) "Postar" else "Postar edições"
}

class AvaliacoesViewModel(private val repository: AvaliacoesRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(AvaliacoesUiState())
    val uiState: StateFlow<AvaliacoesUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAvaliacoes().collect{
                    avaliacoes ->
                _uiState.update {
                        currentState ->
                    currentState.copy( listaAvaliacoes = avaliacoes)
                }
            }
        }
    }

    fun onNotaChange(novaNota: Int){
        _uiState.update { it.copy(nota = novaNota) }
    }

    fun onComentarioChange(novoComentario: String){
        _uiState.update { it.copy(comentario = novoComentario) }
    }

    fun onEditar(avaliacao: Avaliacao){
        _uiState.update {
            it.copy(
                avaliacaoEmEdicao = avaliacao,
                nota = avaliacao.nota,
                comentario = avaliacao.comentario
            )
        }
    }

    fun onDeletar(avaliacao: Avaliacao){
        viewModelScope.launch {
            repository.deleteAvaliacao(avaliacao)
        }
    }

    fun onSalvar(){
        val state = _uiState.value

        if ((state.nota < 1 || state.nota > 5) || state.comentario.isBlank()) return

        val avaliacaoParaSalvar = state.avaliacaoEmEdicao?.
        copy(
            // Editando
            nota = state.nota,
            comentario = state.comentario
        ) ?: Avaliacao(
            // Criando
            nota = state.nota,
            comentario = state.comentario
        )

        viewModelScope.launch {
            if(state.avaliacaoEmEdicao == null)
            {
                // Adicionar
                repository.insertAvaliacao(avaliacaoParaSalvar)
            } else {
                // Atualizar
                repository.updateAvaliacao(avaliacaoParaSalvar)
            }
        }

        limparCampos()
    }

    private fun limparCampos(){
        _uiState.update {
            it.copy(
                nota = 0,
                comentario = "",
                avaliacaoEmEdicao = null
            )
        }
    }
}

class AvaliacoesViewModelFactory(private val repository: AvaliacoesRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AvaliacoesViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return AvaliacoesViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}