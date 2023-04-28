package com.allthingsandroid.android.photoeditor

import android.view.View
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.allthingsandroid.android.photoeditor.R
import java.util.*

abstract class GraphicalElementBuilder<T: GraphicalElementBuilder<T>>{
    protected var touchHandlers: MutableList<BasePhotoEditorTouchListener> = arrayListOf()
    protected var defaultTouchBehavior: Boolean = true

    protected var tag: String? = null

    @LayoutRes
    protected var layoutId: Int = 0

    fun touchHandlers(touchHandlers: List<BasePhotoEditorTouchListener>): T{
        if(touchHandlers.isNotEmpty()){
            defaultTouchBehavior = false
            this.touchHandlers.addAll(touchHandlers)
        }
        return this as T
    }

    fun layoutId(@LayoutRes layoutId: Int): T{
        this.layoutId = layoutId
        return this as T
    }

    fun tag(tag: String): T{
        if(tag.isBlank()){
            throw IllegalStateException("Tag cannot be empty/blank.")
        }
        this.tag = tag
        return this as T
    }
}

class StickerGraphicalElementBuilder: GraphicalElementBuilder<StickerGraphicalElementBuilder>() {

    init{
        layoutId = R.layout.plain_iv_based_sticker
    }

    internal fun build(mPhotoEditorView: PhotoEditorView,
                       mViewState: PhotoEditorViewState,
                       mOnPhotoEditorListener: OnPhotoEditorListener?,
                       deleteView: View?,
                       sourceImageView: ImageView
    ): StickerGraphicalElement {
        val multiTouchListener = MultiTouchListener(
            deleteView,
            mPhotoEditorView,
            sourceImageView,
            mIsPinchScalable = true,
            mOnPhotoEditorListener,
            mViewState,
            defaultTouchBehavior,
            touchHandlers
        )
        val instance = StickerGraphicalElement(
            if(this.tag == null) {
                UUID.randomUUID().toString()} else {this.tag!!},
            mPhotoEditorView,
            multiTouchListener,
            mViewState,
            layoutId)
        multiTouchListener.addTouchHandler(ClickGesturesTouchListener().apply {
            graphicalBase = instance
        })
        return instance
    }
}

class TextGraphicalElementBuilder: GraphicalElementBuilder<TextGraphicalElementBuilder>() {

    init{
        layoutId = R.layout.plain_tv_based_text_graphical_element
    }

    internal fun build(mPhotoEditorView: PhotoEditorView,
                       mViewState: PhotoEditorViewState,
                       mOnPhotoEditorListener: OnPhotoEditorListener?,
                       deleteView: View?,
                       sourceImageView: ImageView,
    ): TextGraphicalElement {
        val multiTouchListener = MultiTouchListener(
            deleteView,
            mPhotoEditorView,
            sourceImageView,
            mIsPinchScalable = true,
            mOnPhotoEditorListener,
            mViewState,
            defaultTouchBehavior,
            touchHandlers
        )
        val instance = TextGraphicalElement(
            if(this.tag == null) {
                UUID.randomUUID().toString()} else {this.tag!!},
            mPhotoEditorView,
            multiTouchListener,
            mViewState,
            layoutId)
        multiTouchListener.addTouchHandler(ClickGesturesTouchListener().apply {
            graphicalBase = instance
        })
        return instance
    }
}

class EmojiGraphicalElementBuilder: GraphicalElementBuilder<EmojiGraphicalElementBuilder>() {

    init{
        layoutId = R.layout.plain_tv_based_text_graphical_element
    }

    internal fun build(mPhotoEditorView: PhotoEditorView,
                       mViewState: PhotoEditorViewState,
                       mOnPhotoEditorListener: OnPhotoEditorListener?,
                       deleteView: View?,
                       sourceImageView: ImageView,
    ): EmojiGraphicalElement {
        val multiTouchListener = MultiTouchListener(
            deleteView,
            mPhotoEditorView,
            sourceImageView,
            mIsPinchScalable = true,
            mOnPhotoEditorListener,
            mViewState,
            defaultTouchBehavior,
            touchHandlers
        )
        val instance = EmojiGraphicalElement(
            if(this.tag == null) {
                UUID.randomUUID().toString()} else {this.tag!!},
            mPhotoEditorView,
            multiTouchListener,
            mViewState,
            layoutId)
        multiTouchListener.addTouchHandler(ClickGesturesTouchListener().apply {
            graphicalBase = instance
        })
        return instance
    }
}