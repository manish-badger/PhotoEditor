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
open class GraphicalBaseWithTextView(
    tag: String,
    protected val mPhotoEditorView: PhotoEditorView,
    protected val mMultiTouchListener: MultiTouchListener,
    protected val mViewState: PhotoEditorViewState,
    layoutId: Int,
    viewType: ViewType
) : LayoutGraphicalBase(
    context = mPhotoEditorView.context,
    tag = tag,
    viewType = viewType,
    layoutId = layoutId
) {

    protected open lateinit var contentView: TextView

    init {
        touchHandlersSetup()
        setupView(rootView)
    }

    private fun touchHandlersSetup() {
        rootView.setOnTouchListener(mMultiTouchListener)
    }

    private fun setupView(rootView: View) {
        contentView = rootView.findViewById(R.id.content)
        contentView?.run {
            gravity = Gravity.CENTER
        }
    }
}