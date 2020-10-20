package com.yeyq.kursakademiaandroida.features.characters.details.presentation

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_character_details
    ) {

    override val viewModel: CharacterDetailsViewModel by viewModels()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterPassed(it) }
    }
}
