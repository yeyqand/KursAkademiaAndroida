package com.yeyq.kursakademiaandroida.features.characters.all.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.yeyq.kursakademiaandroida.core.base.BaseViewModel
import com.yeyq.kursakademiaandroida.core.exception.ErrorMapper
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.yeyq.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.yeyq.kursakademiaandroida.features.characters.domain.model.Character
import com.yeyq.kursakademiaandroida.features.characters.navigation.CharacterNavigator

class CharactersViewModel @ViewModelInject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val characterNavigator: CharacterNavigator,
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

    fun onCharacterClick(character: CharacterDisplayable) {
        characterNavigator.openCharacterDetailsScreen(character)
    }

}