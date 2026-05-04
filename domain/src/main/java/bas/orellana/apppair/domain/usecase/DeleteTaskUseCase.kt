package bas.orellana.apppair.domain.usecase
import bas.orellana.apppair.domain.model.Task
import bas.orellana.apppair.domain.repository.TaskRepository
class DeleteTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.deleteTask(task)
    }
}