package bas.orellana.apppair.domain.usecase
import bas.orellana.apppair.domain.model.Task
import bas.orellana.apppair.domain.repository.TaskRepository
class ToggleTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.updateTask(task.copy(isCompleted = !task.isCompleted))
    }
}