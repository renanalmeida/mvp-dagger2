package org.github.kotlinissues.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import org.github.kotlinissues.AppApplication
import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule



@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBindingModule::class,  DataModule::class,NetworkModule::class])
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }

}