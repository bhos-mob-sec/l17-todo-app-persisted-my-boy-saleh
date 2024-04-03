package az.edu.bhos.l14todoapp.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// todo complete the entity class
@Entity(tableName = "todos")
data class TodoLocalDto(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "completed") val completed: Boolean,
    @ColumnInfo(name = "weekday") val weekday: String
)