package com.fachrizalmrsln.newsreadersimple.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.fachrizalmrsln.component.base.activity.BaseViewBindingActivity
import com.fachrizalmrsln.component.base.extensions.loadImageFromAssets
import com.fachrizalmrsln.component.base.extensions.makeStatusAndNavigationBarTransparent
import com.fachrizalmrsln.component.base.navigation.IAppNavigation
import com.fachrizalmrsln.newsreadersimple.R
import com.fachrizalmrsln.newsreadersimple.databinding.ActivitySplashScreenBinding
import org.koin.android.ext.android.inject

class SplashScreen : BaseViewBindingActivity<ActivitySplashScreenBinding>() {

    private val navigation by inject<IAppNavigation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.makeStatusAndNavigationBarTransparent()
        delayingSplashScreen()
    }

    override fun setupComponent() {
        binding.ivAppIconName.loadImageFromAssets(R.drawable.ic_detikcom)
    }

    override val bindingInflater: (LayoutInflater) -> ActivitySplashScreenBinding
        get() = ActivitySplashScreenBinding::inflate

    private fun delayingSplashScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToLoginScreen()
            finish()
        }, 3000)
    }

    private fun navigateToLoginScreen() {
        navigation.navigateToNewsList(this)
    }

}