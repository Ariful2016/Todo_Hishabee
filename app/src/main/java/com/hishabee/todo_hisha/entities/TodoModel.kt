package com.hishabee.todo_hisha.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName ="tbl_todo")
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    val name : String,
    @ColumnInfo(name="completed")
    var isCompleted : Boolean = false,



)
