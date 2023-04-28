package com.allthingsandroid.android.photoeditor

import android.widget.TextView


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