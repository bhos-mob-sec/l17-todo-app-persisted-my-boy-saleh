package az.edu.bhos.l14todoapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import az.edu.bhos.l14todoapp.data.dto.TodoLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos ORDER BY CASE WHEN weekday = 'Monday' THEN 1 WHEN weekday = 'Tuesday' THEN 2 WHEN weekday = 'Wednesday' THEN 3 WHEN weekday = 'Thursday' THEN 4 WHEN weekday = 'Friday' THEN 5 WHEN weekday = 'Saturday' THEN 6 WHEN weekday = 'Sunday' THEN 7 END")
    fun getTodosOrderedByWeekday(): Flow<List<TodoLocalDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<TodoLocalDto>)
}