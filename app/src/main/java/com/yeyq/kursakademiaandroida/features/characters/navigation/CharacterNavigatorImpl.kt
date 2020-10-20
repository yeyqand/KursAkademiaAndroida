package com.yeyq.kursakademiaandroida.features.characters.navigation

import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.navigation.FragmentNavigator
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.yeyq.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment
import javax.inject.Inject

class CharacterNavigatorImpl @Inject constructor(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {
    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_characters_screen_to_character_details_fragment,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}