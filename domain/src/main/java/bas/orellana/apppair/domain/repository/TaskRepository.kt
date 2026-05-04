package bas.orellana.apppair.domain.repository
import bas.orellana.apppair.domain.model.Task
import kotlinx.coroutines.flow.Flow
interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
}