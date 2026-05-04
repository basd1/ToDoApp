package bas.orellana.apppair.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidad que representa una tarea en la base de datos local.
 * Mapea directamente a la tabla "tasks" en Room.
 */
@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)