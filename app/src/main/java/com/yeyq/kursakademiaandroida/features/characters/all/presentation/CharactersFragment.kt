package com.yeyq.kursakademiaandroida.features.characters.all.presentation

import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.BR
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.databinding.FragmentCharactersBinding
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharactersBinding>(
    BR.viewModel,
    R.layout.fragment_characters
),
    CharactersAdapter.OnCharactersListener {

    override val viewModel: CharactersViewModel by viewModel()
    private val adapter: CharactersAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews(binding: FragmentCharactersBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharactersBinding) {
        with(binding.recyclerView) {
            layoutManager = this@CharactersFragment.layoutManager
            adapter = this@CharactersFragment.adapter
        }
        adapter.listener = this
    }

    override fun onDestroyView() {
        binding?.recyclerView?.let {
            it.layoutManager = null
            it.adapter = null
        }
        with(recyclerView) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }

    override fun onClick(characterDisplayable: CharacterDisplayable) {
        viewModel.onCharacterClick(characterDisplayable)
    }
}