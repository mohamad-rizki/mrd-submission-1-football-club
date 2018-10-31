package com.dafian.android.submissionfootballclub.di.module

import com.dafian.android.submissionfootballclub.data.DataManager
import com.dafian.android.submissionfootballclub.data.api.SportService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun providesDataManager(service: SportService): DataManager {
        return DataManager(service)
    }
}