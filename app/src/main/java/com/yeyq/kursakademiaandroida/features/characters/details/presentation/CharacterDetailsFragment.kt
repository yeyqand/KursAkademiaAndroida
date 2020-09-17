package com.yeyq.kursakademiaandroida.features.characters.details.presentation

import android.os.Bundle
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
    private var characterDisplayable: CharacterDisplayable? = null

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            characterDisplayable = it.getParcelable(CHARACTER_DETAILS_KEY)
        }
    }

    override fun initViews() {
        super.initViews()
        showCharacterDetails()
    }

    private fun showCharacterDetails() {
        characterDisplayable?.let {
            nameTextView.text = it.name
            Glide.with(this)
                .load(it.image)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
        }
    }
}