package com.yeyq.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.yeyq.kursakademiaandroida.core.base.BaseViewModel
import com.yeyq.kursakademiaandroida.core.exception.ErrorMapper
import com.yeyq.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character
import com.yeyq.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also(this::getCharacters)
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure(this::handleFailure)
        }
    }

}