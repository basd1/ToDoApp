package bas.orellana.apppair.domain.usecase
import bas.orellana.apppair.domain.model.Task
import bas.orellana.apppair.domain.repository.TaskRepository
class AddTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(title: String) {
        if (title.isNotBlank()) {
            repository.addTask(Task(title = title.trim()))
        }
    }
}