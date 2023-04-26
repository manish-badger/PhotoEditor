package ja.burhanrashid52.photoeditor

import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
class TextGraphicalElement(
    tag: String,
    mPhotoEditorView: PhotoEditorView,
    mMultiTouchListener: MultiTouchListener,
    mViewState: PhotoEditorViewState,
    layoutId: Int,
) : GraphicalBaseWithTextView(
    tag,
    mPhotoEditorView,
    mMultiTouchListener,
    mViewState,
    layoutId,
    ViewType.TEXT
) {
    public override lateinit var contentView: TextView
}