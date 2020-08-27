package com.yeyq.kursakademiaandroida.features.characters.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.base.BaseFragment
import com.yeyq.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
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