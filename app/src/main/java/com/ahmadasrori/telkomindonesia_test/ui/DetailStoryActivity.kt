package com.ahmadasrori.telkomindonesia_test.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.ahmadasrori.telkomindonesia_test.databinding.ActivityDetailStoryBinding
import com.ahmadasrori.telkomindonesia_test.model.Story
import com.ahmadasrori.telkomindonesia_test.viewmodel.FavoriteViewModel
import com.ahmadasrori.telkomindonesia_test.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailStoryActivity : AppCompatActivity() {
    private val binding: ActivityDetailStoryBinding by lazy {
        ActivityDetailStoryBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val viewModelFav: FavoriteViewModel by viewModel()
    private var fav: Story? = null
    private var storyId = ""
    private var isInsert = false

    companion object {
        const val STORY = "story"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initListener()
        observe()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        fav = Story()
        storyId = intent.getStringExtra(STORY).toString()
        binding.pgBar.visibility = View.VISIBLE
        viewModel.getDetailStory(storyId)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = "Detail Story #$storyId"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initListener() {
        binding.fabAdd.setOnClickListener {
            fav.let { fav ->
                fav?.stori_id = storyId
            }
            if (isInsert) {
                viewModelFav.insert(fav as Story)
            } else {
                viewModelFav.delete(storyId)
            }
        }
    }

    @SuppressLint("SetTextI18n", "SetJavaScriptEnabled")
    private fun observe(){
        viewModelFav.getFav(storyId).observe(this, {
            if (it!=null) {
                isInsert = false
                binding.fabAdd.setColorFilter(Color.RED)
            } else {
                isInsert = true
                binding.fabAdd.setColorFilter(Color.GRAY)
            }
        })
        viewModel.detailStory.observe(this, {
            it.let {
                binding.tvTitle.text = it.title
                binding.tvBy.text = "by : ${it.by}"
                binding.tvScore.text = "score : ${it.score}"
                binding.webView.settings.javaScriptEnabled = true

                binding.webView.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url.toString())
                        return true
                    }
                }
                binding.webView.loadUrl(it.url.toString())
                binding.pgBar.visibility = View.GONE
            }
        })
    }

}