package com.ahmadasrori.telkomindonesia_test.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.telkomindonesia_test.R
import com.ahmadasrori.telkomindonesia_test.adapter.StoryAdapter
import com.ahmadasrori.telkomindonesia_test.databinding.ActivityMainBinding
import com.ahmadasrori.telkomindonesia_test.util.RecyclerViewLineDecoration
import com.ahmadasrori.telkomindonesia_test.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val listStory = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        observe()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_fav -> {
                val intent = Intent(this@MainActivity, SavedStoryActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun initView() {
        title = "Top Story"
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding.pgBar.visibility = View.VISIBLE
        viewModel.getTopStory()
    }

    private fun observe(){
        viewModel.topStory.observe(this, {
            listStory.clear()
            it.let {
                listStory.addAll(it)
                initList()
            }
        })
    }

    private fun initList() {
        val adapter = StoryAdapter(listStory) {
            val intent = Intent(this@MainActivity, DetailStoryActivity::class.java)
            intent.putExtra(DetailStoryActivity.STORY, listStory[it])
            startActivity(intent)
        }
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
        binding.rvItem.addItemDecoration(RecyclerViewLineDecoration(this))
        binding.pgBar.visibility = View.GONE
    }

}