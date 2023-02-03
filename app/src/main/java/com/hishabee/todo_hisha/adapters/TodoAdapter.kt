package com.hishabee.todo_hisha.adapters
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hishabee.todo_hisha.databinding.TodoItemBinding
import com.hishabee.todo_hisha.entities.TodoModel
import com.hishabee.todo_hisha.todo_edit


class TodoAdapter(val todoCallback:(TodoModel, String)-> Unit) : ListAdapter<TodoModel,TodoAdapter.TodoViewHolder>(TodoDiffCallBack()){
    private lateinit var binding: TodoItemBinding
    class TodoViewHolder(
        private val binding: TodoItemBinding,
        val todoCallback: (TodoModel, String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(todoModel: TodoModel){
            binding.todo = todoModel
            binding.isCompleted.setOnClickListener {
                todoCallback(todoModel, todo_edit)
                binding.text.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
                if (!todoModel.isCompleted){
                    binding.text.setPaintFlags(binding.text.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                }
            }
            if (todoModel.isCompleted){
                binding.text.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(binding,todoCallback)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todoModel = getItem(position)
        holder.bind(todoModel)
    }
}

class TodoDiffCallBack : DiffUtil.ItemCallback<TodoModel>(){
    override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
        return  oldItem == newItem
    }

}