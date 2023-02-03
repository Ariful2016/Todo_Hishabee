package com.hishabee.todo_hisha.di
import android.content.Context
import com.hishabee.todo_hisha.daos.TodoDao
import com.hishabee.todo_hisha.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao {
        return TodoDatabase.getDb(context).todoDao()
    }
}