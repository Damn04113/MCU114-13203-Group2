package com.example.homework6

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.homework6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyPagerAdapter
    private lateinit var mediaPlayer: MediaPlayer

    private val viewModel: WorkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false

        // 監聽背景工作是否開始 → 播音樂
        viewModel.isWorking.observe(this) { working ->
            if (working) startMusic() else stopMusic()
        }

        // 完成後切到 ResultFragment
        viewModel.isFinished.observe(this) { finished ->
            if (finished) binding.viewPager.currentItem = 2
        }
    }

    fun goToProgressPage() {
        binding.viewPager.currentItem = 1
    }

    fun goToResultPage() {
        binding.viewPager.currentItem = 2
    }

    private fun startMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    private fun stopMusic() {
        if (::mediaPlayer.isInitialized && mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}
