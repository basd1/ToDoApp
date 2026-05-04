package bas.orellana.apppair.presentation.ui

import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    var isDarkMode: Boolean = false
    
    fun toggleDarkMode() {
        isDarkMode = !isDarkMode
    }
}