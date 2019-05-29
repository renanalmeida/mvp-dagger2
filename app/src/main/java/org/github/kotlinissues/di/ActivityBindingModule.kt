package org.github.kotlinissues.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.github.kotlinissues.di.issues.IssuesModule
import org.github.kotlinissues.ui.issues.IssuesActivity

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [IssuesModule::class])
    internal abstract fun issueActivity(): IssuesActivity
}