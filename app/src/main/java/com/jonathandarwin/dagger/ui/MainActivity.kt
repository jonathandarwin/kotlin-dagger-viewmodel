package com.jonathandarwin.dagger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jonathandarwin.dagger.App
import com.jonathandarwin.dagger.R
import com.jonathandarwin.dagger.databinding.ActivityMainBinding
import com.jonathandarwin.dagger.di.component.DaggerApplicationComponent
import com.jonathandarwin.dagger.di.module.NetworkModule
import com.jonathandarwin.dagger.factory.ViewModelFactory
import com.jonathandarwin.dagger.usecase.MainUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // @Inject is for let the dagger knows that this field will be injected
//    @Inject lateinit var mainUseCase : MainUseCase

    @Inject lateinit var factory : ViewModelFactory

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjection()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        viewModel.getUser().observe(this, Observer {
            if(it == null) {
                tv_result.text = "Error. Please try again"
            }
            else{
                tv_result.text = it.toString()
            }
        })

//        mainUseCase.getUser()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//            Log.d("masuksiniga", "subscribe $it")
//            tv_result.text = it.toString()
//        }, {
//            Log.d("masuksiniga", "subscribe ${it.message}")
//            tv_result.text = it.message
//        })
    }

    private fun initInjection() {
        (applicationContext as App).applicationComponent.inject(this)
    }
}
