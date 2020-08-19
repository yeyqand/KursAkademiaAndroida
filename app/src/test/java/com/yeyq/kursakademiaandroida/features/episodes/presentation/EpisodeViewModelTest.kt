package com.yeyq.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.yeyq.kursakademiaandroida.core.base.UiState
import com.yeyq.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.yeyq.kursakademiaandroida.features.episodes.domain.model.Episode
import com.yeyq.kursakademiaandroida.mock.mock
import com.yeyq.kursakademiaandroida.utils.ViewModelTest
import com.yeyq.kursakademiaandroida.utils.getOrAwaitValue
import com.yeyq.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeViewModelTest : ViewModelTest() {


    @Test
    fun `WHEN episode live date is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episode live date is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is succes WHEN episode live date is observed THEN set idle state AND set result in live data`() {
        //given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val viewModel = EpisodeViewModel(useCase)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.id shouldBe episode.id
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
            episodeDisplayable.url shouldBe episode.url
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live date is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}