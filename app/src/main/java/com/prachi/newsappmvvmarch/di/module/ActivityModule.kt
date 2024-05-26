package com.prachi.newsappmvvmarch.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.prachi.newsappmvvmarch.data.repository.TopHeadlineRepository
import com.prachi.newsappmvvmarch.di.ActivityContext
import com.prachi.newsappmvvmarch.ui.base.ViewModelProviderFactory
import com.prachi.newsappmvvmarch.ui.topheadline.TopHeadlineAdapter
import com.prachi.newsappmvvmarch.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val activity: AppCompatActivity){

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsListViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
}