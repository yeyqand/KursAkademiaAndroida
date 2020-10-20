package com.yeyq.kursakademiaandroida.features.characters.all.presentation

import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentCharactersBinding
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharactersBinding>(
    BR.viewModel,
    R.layout.fragment_characters
),
    CharactersAdapter.OnCharactersListener {

    override val viewModel: CharactersViewModel by viewModel()
    private val adapter: CharactersAdapter by inject()

    override fun initViews(binding: FragmentCharactersBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharactersBinding) {
        binding.recyclerView.adapter = adapter
        adapter.listener = this
    }

    override fun onClick(characterDisplayable: CharacterDisplayable) {
        viewModel.onCharacterClick(characterDisplayable)
    }
}