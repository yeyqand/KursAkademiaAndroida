package com.yeyq.kursakademiaandroida.features.characters.navigation

import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.navigation.FragmentNavigator
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.yeyq.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterNavigatorImplTest {


    @Test
    fun `WHEN openCharacterDetailsScreen is called THEN invoke navigateTo method of FragmentNavigator with appropriate action and character model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        //when
        characterNavigator.openCharacterDetailsScreen(character)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_characters_screen_to_character_details_fragment,
                capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)

        //when
        characterNavigator.goBack()

        //then
        verify {
            fragmentNavigator.goBack()
        }
    }

}