package com.hishabee.todo_hisha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hishabee.todo_hisha.databinding.FragmentTodoAddBinding
import com.hishabee.todo_hisha.entities.TodoModel
import com.hishabee.todo_hisha.viewModels.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoAddFragment : Fragment() {
   lateinit var binding: FragmentTodoAddBinding
    private val todoViewModel: TodoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTodoAddBinding.inflate(inflater)

        binding.submitBtn.setOnClickListener {
            val todo_txt = binding.editTxt.text.toString()
            if (todo_txt.equals("")){
                binding.editTxt.setError("Field can't be empty!")
            }

            val todo = TodoModel(name = todo_txt)
            todoViewModel.insertTodo(todo)

            findNavController().navigate(R.id.action_todoAddFragment_to_todoHomeFragment)

        }

        return binding.root
    }


}