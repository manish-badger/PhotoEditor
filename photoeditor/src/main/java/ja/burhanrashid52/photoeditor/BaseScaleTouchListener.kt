package ja.burhanrashid52.photoeditor

import android.widget.ImageView

open abstract class BaseScaleTouchListener: BasePhotoEditorTouchListener {

    var mIsPinchScalable: Boolean = true

    protected val minimumScale = 0.5f
    protected val maximumScale = 10.0f

    constructor(mIsPinchScalable: Boolean) : super() {
        this.mIsPinchScalable = mIsPinchScalable
    }

    constructor(
        photoEditorView: PhotoEditorView,
        photoEditImageView: ImageView,
        onPhotoEditorListener: OnPhotoEditorListener?,
        viewState: PhotoEditorViewState,
        mIsPinchScalable: Boolean
    ) : super(photoEditorView, photoEditImageView, onPhotoEditorListener, viewState) {
        this.mIsPinchScalable = mIsPinchScalable
    }
}