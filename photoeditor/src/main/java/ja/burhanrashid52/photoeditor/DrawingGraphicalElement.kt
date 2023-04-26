package ja.burhanrashid52.photoeditor

import android.widget.ImageView

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
class DrawingGraphicalElement(
    tag: String,
    mPhotoEditorView: PhotoEditorView,
    mViewState: PhotoEditorViewState,
) : GraphicalBaseWithDrawingView(
    tag,
    mPhotoEditorView,
    mViewState,
) {
    public override var contentView: DrawingView? = null
    set(value) {
        field = value
        super.contentView = value
    }
}