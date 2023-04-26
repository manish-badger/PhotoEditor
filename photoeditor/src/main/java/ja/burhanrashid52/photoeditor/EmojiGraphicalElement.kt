package ja.burhanrashid52.photoeditor

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
class EmojiGraphicalElement(
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
    ViewType.EMOJI
) {
    public override lateinit var contentView: TextView

    init{
        setupView(rootView)
    }

    private fun setupView(rootView: View) {
        contentView?.run {
            textSize = 56f
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
    }
}