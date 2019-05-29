package org.github.kotlinissues

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.github.kotlinissues.di.DaggerAppComponent

class AppApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>{
        return   DaggerAppComponent.builder().application(this).build()
    }

}