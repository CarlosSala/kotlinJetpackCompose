import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DownloadViewModel : ViewModel() {

    private val _progress = MutableStateFlow(0) // Estado del progreso
    val progress: StateFlow<Int> = _progress

    private val _hasNotificationPermission = MutableStateFlow(false) // Estado del permiso
    val hasNotificationPermission: StateFlow<Boolean> = _hasNotificationPermission

    fun updateProgress(progress: Int) {
        viewModelScope.launch {
            _progress.value = progress
        }
    }

    fun updateNotificationPermission(granted: Boolean) {
        viewModelScope.launch {
            _hasNotificationPermission.value = granted
        }
    }
}
