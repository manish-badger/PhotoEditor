package ja.burhanrashid52.photoeditor

import android.view.View
import android.widget.ImageView

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
open class GraphicalBaseWithImageView(
    tag: String,
    protected val mPhotoEditorView: PhotoEditorView,
    protected val mMultiTouchListener: MultiTouchListener,
    protected val mViewState: PhotoEditorViewState,
    layoutId: Int,
) : LayoutGraphicalBase(
    context = mPhotoEditorView.context,
    tag = tag,
    viewType = ViewType.IMAGE,
    layoutId = layoutId
) {

    protected open lateinit var contentView: ImageView

    init {
        touchHandlersSetup()
        setupView(rootView)
    }

    private fun touchHandlersSetup() {
        rootView.setOnTouchListener(mMultiTouchListener)
    }

    private fun setupView(rootView: View) {
        contentView = rootView.findViewById(R.id.content)
    }
}