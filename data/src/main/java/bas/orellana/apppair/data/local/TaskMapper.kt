package bas.orellana.apppair.data.local
import bas.orellana.apppair.domain.model.Task
fun TaskEntity.toDomain(): Task = Task(
    id = id, title = title, isCompleted = isCompleted, createdAt = createdAt
)
fun Task.toEntity(): TaskEntity = TaskEntity(
    id = id, title = title, isCompleted = isCompleted, createdAt = createdAt
)