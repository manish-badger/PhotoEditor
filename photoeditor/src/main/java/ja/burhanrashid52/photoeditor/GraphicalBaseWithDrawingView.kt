package ja.burhanrashid52.photoeditor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.annotation.LayoutRes
import ja.burhanrashid52.photoeditor.MultiTouchListener.OnGestureControl

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
abstract class GraphicalBaseWithDrawingView(
    tag: String,
    protected val mPhotoEditorView: PhotoEditorView,
    protected val mViewState: PhotoEditorViewState,
) : GraphicalBase(
    context = mPhotoEditorView.context,
    tag = tag,
    viewType = ViewType.BRUSH_DRAWING,
) {
    protected open var contentView: DrawingView? = null
        set(value) {
            field = value
            if(value != null){
                rootView = value
            }
        }
}