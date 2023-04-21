package ja.burhanrashid52.photoeditor

import android.view.View.OnTouchListener
import android.widget.ImageView

open abstract class BasePhotoEditorTouchListener(): OnTouchListener {

    lateinit var photoEditorView: PhotoEditorView
        internal set
    lateinit var photoEditImageView: ImageView
        internal set
    var mOnPhotoEditorListener: OnPhotoEditorListener? = null
        internal set
    lateinit var viewState: PhotoEditorViewState
        internal set

    var isRotateEnabled = true
    var isTranslateEnabled = true
    var isScaleEnabled = true

    constructor(
        photoEditorView: PhotoEditorView,
        photoEditImageView: ImageView,
        onPhotoEditorListener: OnPhotoEditorListener?,
        viewState: PhotoEditorViewState
    ) : this() {
        this.photoEditorView = photoEditorView
        this.photoEditImageView = photoEditImageView
        this.mOnPhotoEditorListener = onPhotoEditorListener
        this.viewState = viewState
    }


}