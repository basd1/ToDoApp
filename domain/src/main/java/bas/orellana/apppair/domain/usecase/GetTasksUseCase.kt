package bas.orellana.apppair.domain.usecase
import bas.orellana.apppair.domain.model.Task
import bas.orellana.apppair.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
class GetTasksUseCase(private val repository: TaskRepository) {
    operator fun invoke(): Flow<List<Task>> = repository.getAllTasks()
}