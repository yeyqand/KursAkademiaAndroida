package com.yeyq.kursakademiaandroida.features.characters.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.fragment_episodes.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_character),
    CharactersAdapter.OnCharactersListeners {

    override val viewModel: CharactersViewModel by viewModel()
    private val adapter: CharactersAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
        adapter.listeners = this
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onIdleState() {
        super.onIdleState()
        hideProgressBar()
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        showProgressBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerView.layoutManager = null
        recyclerView.adapter = null
    }

    override fun onClick(characterDisplayable: CharacterDisplayable) {
        viewModel.onCharacterClick(characterDisplayable)
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            showCharacters(it)
        }
    }

    private fun showCharacters(characters: List<CharacterDisplayable>) {
        adapter.setItems(characters)
    }
}