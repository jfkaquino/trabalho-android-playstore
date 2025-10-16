package com.trabalho.playstore.ui.contas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.trabalho.playstore.data.local.Avaliacao
import com.trabalho.playstore.data.local.Conta
import com.trabalho.playstore.data.repository.ContasRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ContasUIState(
    val ListadeContas: List<Conta> = emptyList(),
    val nome: String = "",
    val email: String = "",
    val senha: String = "",
    val contaEmEdicao: Conta? = null
) {
    val textoBotao: String
        get() = if (contaEmEdicao == null) "Cadastrar" else "Salvar"
}

class ContasViewMode(private val repository: ContasRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ContasUIState())

    val uiState: StateFlow<ContasUIState> = _uiState.asStateFlow()

    init {

        viewModelScope.launch {
            repository.getAll().collect{
                    contas ->
                _uiState.update {
                        currentState ->
                    currentState.copy( ListadeContas = contas )
                }
            }
        }

    }

    fun onNameChange(novoNome: String) {
        _uiState.update { it.copy(nome = novoNome) }
    }

    fun onEmailChange(novoEmail: String) {
        _uiState.update { it.copy(email = novoEmail) }
    }

    fun onSenhaChange(novaSenha: String) {
        _uiState.update { it.copy(senha = novaSenha) }
    }

    fun onDelete(conta: Conta) {
        viewModelScope.launch {
            repository.delete(conta)
        }
    }

    fun onSalvar() {

        val state = _uiState.value

        if (state.nome.isBlank() && state.email.isBlank() && state.senha.isBlank()) return

        val contaParaSalvar = state.contaEmEdicao?.copy(
            nome = state.nome,
            email = state.email,
            senha = state.senha
        ) ?: Conta(
            nome = state.nome,
            email = state.email,
            senha = state.senha
        )

        viewModelScope.launch {

            if (state.contaEmEdicao == null) {
                repository.insert(contaParaSalvar)
            } else {
                repository.update(contaParaSalvar)
            }
        }

        limparCampos()
    }

    private fun limparCampos(){
        _uiState.update {
            it.copy(
                nome = "",
                email = "",
                senha = "",
                contaEmEdicao = null
            )
        }
    }
}

class ContasViewModelFactory(private val repository: ContasRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContasViewMode::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContasViewMode(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



