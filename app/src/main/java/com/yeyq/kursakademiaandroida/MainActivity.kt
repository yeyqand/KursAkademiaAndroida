package com.yeyq.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yeyq.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.yeyq.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val episodeFragment: EpisodeFragment by inject()
    private val characterFragment: CharacterFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.mainLayout, characterFragment).commit()
    }
}