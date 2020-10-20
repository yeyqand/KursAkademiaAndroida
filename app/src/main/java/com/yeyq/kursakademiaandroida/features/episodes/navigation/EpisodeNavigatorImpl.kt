package com.yeyq.kursakademiaandroida.features.episodes.navigation

import com.yeyq.kursakademiaandroida.R
import com.yeyq.kursakademiaandroida.core.navigation.FragmentNavigator
import com.yeyq.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.yeyq.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment.Companion.EPISODE_DETAILS_KEY
import javax.inject.Inject

class EpisodeNavigatorImpl @Inject constructor(private val fragmentNavigator: FragmentNavigator) :
    EpisodeNavigator {
    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_fragment,
            EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}