package ja.burhanrashid52.photoeditor

import android.Manifest
import android.graphics.Typeface
import android.view.View
import androidx.annotation.RequiresPermission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@RequiresPermission(allOf = [Manifest.permission.WRITE_EXTERNAL_STORAGE])
fun PhotoEditor.saveAsFile(
    imagePath: String,
    saveSettings: SaveSettings,
    onSaveListener: PhotoEditor.OnSaveListener
) {
    GlobalScope.launch(Dispatchers.Main) {
        when (val result = saveAsFile(imagePath, saveSettings)) {
            is SaveFileResult.Success -> onSaveListener.onSuccess(imagePath)
            is SaveFileResult.Failure -> onSaveListener.onFailure(result.exception)
        }
    }
}

@RequiresPermission(allOf = [Manifest.permission.WRITE_EXTERNAL_STORAGE])
fun PhotoEditor.saveAsFile(imagePath: String, onSaveListener: PhotoEditor.OnSaveListener) {
    saveAsFile(imagePath, SaveSettings.Builder().build(), onSaveListener)
}

fun PhotoEditor.saveAsBitmap(saveSettings: SaveSettings, onSaveBitmap: OnSaveBitmap) {
    GlobalScope.launch(Dispatchers.Main) {
        val bitmap = saveAsBitmap(saveSettings)
        onSaveBitmap.onBitmapReady(bitmap)
    }
}

fun PhotoEditor.saveAsBitmap(onSaveBitmap: OnSaveBitmap) {
    saveAsBitmap(SaveSettings.Builder().build(), onSaveBitmap)
}