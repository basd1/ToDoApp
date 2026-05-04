package bas.orellana.apppair.data.repository
import bas.orellana.apppair.data.local.TaskDao
import bas.orellana.apppair.data.local.TaskEntity
import bas.orellana.apppair.domain.model.Task
import bas.orellana.apppair.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks().map { entities -> 
        entities.map { entity -> Task(entity.id, entity.title, entity.isCompleted, entity.createdAt) } 
    }
    override suspend fun addTask(task: Task) { taskDao.insertTask(TaskEntity(task.id, task.title, task.isCompleted, task.createdAt)) }
    override suspend fun updateTask(task: Task) { taskDao.updateTask(TaskEntity(task.id, task.title, task.isCompleted, task.createdAt)) }
    override suspend fun deleteTask(task: Task) { taskDao.deleteTask(TaskEntity(task.id, task.title, task.isCompleted, task.createdAt)) }
}