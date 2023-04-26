package ja.burhanrashid52.photoeditor

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView

internal class ClickGesturesTouchListener: BasePhotoEditorTouchListener {

    private var mActivePointerId = MultiTouchListener.INVALID_POINTER_ID

    internal lateinit var graphicalBase: GraphicalBase

    constructor() : super()
    constructor(
        photoEditorView: PhotoEditorView,
        photoEditImageView: ImageView,
        onPhotoEditorListener: OnPhotoEditorListener?,
        viewState: PhotoEditorViewState
    ) : super(photoEditorView, photoEditImageView, onPhotoEditorListener, viewState)

    override fun onTouch(view: View, event: MotionEvent): Boolean {
        val action = event.action
        when (action and event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                mActivePointerId = event.getPointerId(0)
                view.bringToFront()
                viewState.currentSelectedView = graphicalBase
            }
            MotionEvent.ACTION_MOVE ->{

            }
            MotionEvent.ACTION_CANCEL -> mActivePointerId = MultiTouchListener.INVALID_POINTER_ID
            MotionEvent.ACTION_UP -> {
                mActivePointerId = MultiTouchListener.INVALID_POINTER_ID
            }
            MotionEvent.ACTION_POINTER_UP -> {
                val pointerIndexPointerUp =
                    action and MotionEvent.ACTION_POINTER_INDEX_MASK shr MotionEvent.ACTION_POINTER_INDEX_SHIFT
                val pointerId = event.getPointerId(pointerIndexPointerUp)
                if (pointerId == mActivePointerId) {
                    val newPointerIndex = if (pointerIndexPointerUp == 0) 1 else 0
                    mActivePointerId = event.getPointerId(newPointerIndex)
                }
            }
        }
        return true
    }
}