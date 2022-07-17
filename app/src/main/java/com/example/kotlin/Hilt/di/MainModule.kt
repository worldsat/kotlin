package com.example.kotlin.Hilt.di

import android.content.Context
import com.example.kotlin.Hilt.NAMED_USERNAME
import com.example.kotlin.Hilt.NAMED_USERNAME2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    @Named(NAMED_USERNAME)
    fun provideUsername(): String = "mohsen jamali"

    @Provides
    @Singleton
    @Named(NAMED_USERNAME2)
    fun provideUsername2(@ApplicationContext context: Context): String{
    return  "mohsen jamali33"
    }
}