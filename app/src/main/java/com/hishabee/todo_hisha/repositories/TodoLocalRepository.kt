package com.hishabee.todo_hisha.repositories
import androidx.lifecycle.LiveData
import com.hishabee.todo_hisha.daos.TodoDao
import com.hishabee.todo_hisha.entities.TodoModel
import javax.inject.Inject

class TodoLocalRepository @Inject constructor (val dao: TodoDao){

    suspend fun addTodo(todoModel: TodoModel){
        dao.addTodo(todoModel)
    }
    suspend fun updateTodo(todoModel: TodoModel){
        dao.updateTodo(todoModel)
    }

    fun getAllTodo() : LiveData<List<TodoModel>> = dao.getAllTodo()
}