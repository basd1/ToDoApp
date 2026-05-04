package bas.orellana.apppair.presentation.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bas.orellana.apppair.domain.model.Task
import bas.orellana.apppair.domain.usecase.AddTaskUseCase
import bas.orellana.apppair.domain.usecase.DeleteTaskUseCase
import bas.orellana.apppair.domain.usecase.GetTasksUseCase
import bas.orellana.apppair.domain.usecase.ToggleTaskUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
class TaskListViewModel(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val toggleTaskUseCase: ToggleTaskUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(TaskListState())
    val state: StateFlow<TaskListState> = _state
    init { loadTasks() }
    private fun loadTasks() {
        viewModelScope.launch {
            getTasksUseCase().collect { tasks ->
                _state.update { it.copy(tasks = tasks, isLoading = false) }
            }
        }
    }
    fun onAddTaskClick() { _state.update { it.copy(showAddDialog = true) } }
    fun onDismissAddDialog() { _state.update { it.copy(showAddDialog = false) } }
    fun onAddTask(title: String) {
        viewModelScope.launch {
            addTaskUseCase(title)
            _state.update { it.copy(showAddDialog = false) }
        }
    }
    fun onToggleTask(task: Task) { viewModelScope.launch { toggleTaskUseCase(task) } }
    fun onDeleteTask(task: Task) { viewModelScope.launch { deleteTaskUseCase(task) } }
}