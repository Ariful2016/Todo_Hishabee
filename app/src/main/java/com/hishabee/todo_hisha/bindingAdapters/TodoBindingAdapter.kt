package com.hishabee.todo_hisha.bindingAdapters
import androidx.databinding.BindingAdapter
import com.hishabee.todo_hisha.R
import com.hishabee.todo_hisha.todo_complete
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("app:setCompleteIcon")
fun setCompleteIcon(iv: CircleImageView, isComplete: Boolean){
    val icon = when(isComplete){
        todo_complete -> R.drawable.correct
        else -> R.drawable.check_bg
    }

    iv.setImageResource(icon)
}

