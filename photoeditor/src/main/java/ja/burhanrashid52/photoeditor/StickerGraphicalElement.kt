package ja.burhanrashid52.photoeditor

import android.widget.ImageView

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
class StickerGraphicalElement(
    tag: String,
    mPhotoEditorView: PhotoEditorView,
    mMultiTouchListener: MultiTouchListener,
    mViewState: PhotoEditorViewState,
    layoutId: Int,
) : GraphicalBaseWithImageView(
    tag,
    mPhotoEditorView,
    mMultiTouchListener,
    mViewState,
    layoutId
) {
    public override lateinit var contentView: ImageView
}