package bas.orellana.apppair.presentation.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object ThemeStateManager {
    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    fun toggle() {
        _isDarkMode.value = !_isDarkMode.value
    }
}