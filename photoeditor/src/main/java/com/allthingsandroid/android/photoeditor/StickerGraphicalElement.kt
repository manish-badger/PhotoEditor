package com.allthingsandroid.android.photoeditor

import android.widget.ImageView


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