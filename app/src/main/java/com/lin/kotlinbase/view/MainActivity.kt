package com.lin.kotlinbase.view

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lin.kotlinbase.R
import com.lin.kotlinbase.api.ELEMENT
import com.lin.kotlinbase.api.LOCATION
import com.lin.kotlinbase.model.Repository
import com.lin.kotlinbase.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val adapter = MainViewHolderAdapter()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showToast()
        initUI()
        initViewModel()
        Log.e("test", "123".append("456"))
    }

    private fun initUI() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.data.observe(this, Observer {
            loading.visibility = View.GONE
            adapter.setDataSource(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            loading.visibility = View.GONE
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        loading.visibility = View.VISIBLE
        viewModel.getWeatherData(
            getString(R.string.weather_api_authorization),
            Repository.SOURCETYPE.REMOTE, LOCATION.TAIPEI, ELEMENT.MinT
        )
    }

    private fun showToast() {
        val sharedPreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val showToast = sharedPreferences.getBoolean(getString(R.string.spf_key_show_toast), false)
        if (showToast) {
            Toast.makeText(this, getString(R.string.welcome), Toast.LENGTH_SHORT).show()
        } else {
            sharedPreferences.edit().putBoolean(getString(R.string.spf_key_show_toast), true)
                .apply()
        }
    }
}
