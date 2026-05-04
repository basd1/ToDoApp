package bas.orellana.apppair.presentation.ui
import bas.orellana.apppair.domain.model.Task
data class TaskListState(
    val tasks: List<Task> = emptyList(),
    val isLoading: Boolean = true,
    val showAddDialog: Boolean = false
)