package com.ahmadasrori.telkomindonesia_test.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.telkomindonesia_test.R
import com.ahmadasrori.telkomindonesia_test.adapter.FavAdapter
import com.ahmadasrori.telkomindonesia_test.databinding.ActivitySavedStoryBinding
import com.ahmadasrori.telkomindonesia_test.model.Story
import com.ahmadasrori.telkomindonesia_test.viewmodel.FavoriteViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SavedStoryActivity : AppCompatActivity() {
    private val binding: ActivitySavedStoryBinding by lazy {
        ActivitySavedStoryBinding.inflate(layoutInflater)
    }
    private val viewModelFav: FavoriteViewModel by viewModel()
    private val listUser = ArrayList<Story>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_story)
        setContentView(binding.root)
        initView()
        observe()
    }

    private fun initView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = "Liked Story"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private fun observe() {
        viewModelFav.getAllFav().observe(this, {
            binding.pgBar.visibility = View.VISIBLE
            listUser.clear()
            it.let {
                listUser.addAll(it)
                initList()
            }
        })
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun initList() {
        val adapter = FavAdapter(listUser) {
            val intent = Intent(this, DetailStoryActivity::class.java)
            intent.putExtra(DetailStoryActivity.STORY, listUser[it].stori_id)
            startActivity(intent)
        }
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.pgBar.visibility = View.GONE
    }
}