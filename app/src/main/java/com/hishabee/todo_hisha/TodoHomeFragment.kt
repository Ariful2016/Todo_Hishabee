package com.hishabee.todo_hisha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hishabee.todo_hisha.adapters.TodoAdapter
import com.hishabee.todo_hisha.databinding.FragmentTodoHomeBinding
import com.hishabee.todo_hisha.entities.TodoModel
import com.hishabee.todo_hisha.viewModels.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoHomeFragment : Fragment() {

    lateinit var binding: FragmentTodoHomeBinding
    private val todoViewModel: TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTodoHomeBinding.inflate(layoutInflater)

        val adapter = TodoAdapter(::todoAction)
        binding.recycler.adapter = adapter
        todoViewModel.getTodos().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_todoHomeFragment_to_todoAddFragment)
        }

        return binding.root
    }
    private fun todoAction(todoModel: TodoModel, action: String){
        when (action){
            todo_edit-> todoViewModel.editTodo(todoModel)
        }
    }

}