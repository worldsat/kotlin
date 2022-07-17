package com.example.kotlin.Hilt.roomInHilt.di

import android.content.Context
import androidx.room.Room
import com.example.kotlin.Hilt.NOTE_DATABASE
import com.example.kotlin.Hilt.roomInHilt.db.NoteDatabase
import com.example.kotlin.Hilt.roomInHilt.db.NoteModel
import com.example.kotlin.RoomDatabase.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context)=  Room.databaseBuilder(context, NoteDatabase::class.java, NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db:NoteDatabase)=db.noteDao()

    @Provides
    @Singleton
    fun provideEntity()=NoteModel()
}