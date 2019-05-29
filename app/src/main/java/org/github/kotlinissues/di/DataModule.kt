package org.github.kotlinissues.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.github.kotlinissues.data.DataRepository
import org.github.kotlinissues.data.IDataRepository
import org.github.kotlinissues.data.remote.GithubApi

@Module
@Suppress("unused")
object DataModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRepository(api: GithubApi): IDataRepository {
        return DataRepository(api)
    }
}