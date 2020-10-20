package com.yeyq.kursakademiaandroida.features.characters.all.presentation

import androidx.fragment.app.viewModels
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentCharactersBinding
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharactersBinding>(
    BR.viewModel,
    R.layout.fragment_characters
),
    CharactersAdapter.OnCharactersListener {

    @Inject
    lateinit var adapter: CharactersAdapter

    override val viewModel: CharactersViewModel by viewModels()

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