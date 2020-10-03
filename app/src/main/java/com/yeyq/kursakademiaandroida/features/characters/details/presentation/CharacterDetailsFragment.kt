package com.yeyq.kursakademiaandroida.features.characters.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterPassed(it) }
    }

    private fun observeCharacter() {
        viewModel.character.observe(this) {
            showCharacterDetails(it)
        }
    }

    private fun showCharacterDetails(character: CharacterDisplayable) {
        nameTextView.text = character.name
        Glide.with(this)
            .load(character.image)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}