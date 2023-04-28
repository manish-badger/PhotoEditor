package com.allthingsandroid.android.photoeditor

import android.view.View
import android.widget.TextView


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
        contentView.run {
            textSize = 56f
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }
    }
}