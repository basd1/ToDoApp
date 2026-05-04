package bas.orellana.apppair.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Base de datos de Room para la aplicacion.
 * Contiene unicamente la entidad Task.
 */
@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        const val DATABASE_NAME = "todo_database"
    }
}