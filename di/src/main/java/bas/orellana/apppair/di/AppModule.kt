package bas.orellana.apppair.di

import androidx.room.Room
import bas.orellana.apppair.data.local.AppDatabase
import bas.orellana.apppair.data.local.TaskDao
import bas.orellana.apppair.data.repository.TaskRepositoryImpl
import bas.orellana.apppair.domain.repository.TaskRepository
import bas.orellana.apppair.domain.usecase.AddTaskUseCase
import bas.orellana.apppair.domain.usecase.DeleteTaskUseCase
import bas.orellana.apppair.domain.usecase.GetTasksUseCase
import bas.orellana.apppair.domain.usecase.ToggleTaskUseCase
import bas.orellana.apppair.presentation.ui.TaskListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, AppDatabase.DATABASE_NAME).build() }
    single<TaskDao> { get<AppDatabase>().taskDao() }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
    factory { GetTasksUseCase(get()) }
    factory { AddTaskUseCase(get()) }
    factory { DeleteTaskUseCase(get()) }
    factory { ToggleTaskUseCase(get()) }
    viewModel { TaskListViewModel(get(), get(), get(), get()) }
}