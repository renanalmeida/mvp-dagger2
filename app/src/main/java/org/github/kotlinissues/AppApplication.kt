package org.github.kotlinissues

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.github.kotlinissues.data.DataRepository
import org.github.kotlinissues.di.DaggerAppComponent
import javax.inject.Inject

class AppApplication: DaggerApplication() {

//     @Inject
//     lateinit var dataRepository: DataRepository

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>{
        return   DaggerAppComponent.builder().application(this).build()
    }

}