package com.hishabee.todo_hisha.daos
import androidx.lifecycle.LiveData
import androidx.room.*
import com.hishabee.todo_hisha.entities.TodoModel


@Dao
interface TodoDao {

    @Insert
    suspend fun addTodo(todoModel: TodoModel)

    @Update
    suspend fun updateTodo(todoModel: TodoModel)

    @Query("Select * from tbl_todo order by id desc")
    fun getAllTodo(): LiveData<List<TodoModel>>
}