package com.hishabee.todo_hisha.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hishabee.todo_hisha.entities.TodoModel
import com.hishabee.todo_hisha.repositories.TodoLocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(val repository: TodoLocalRepository) : ViewModel() {


    fun insertTodo(todoModel: TodoModel){
        viewModelScope.launch {
            repository.addTodo(todoModel)
        }
    }
    fun editTodo(todoModel: TodoModel){
        todoModel.isCompleted = !todoModel.isCompleted
        viewModelScope.launch {
            repository.updateTodo(todoModel)
        }
    }


    fun getTodos() : LiveData<List<TodoModel>> = repository.getAllTodo()
}