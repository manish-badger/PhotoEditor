package com.allthingsandroid.android.photoeditor

import android.content.Context
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import androidx.test.core.app.ApplicationProvider
import com.allthingsandroid.android.photoeditor.Graphic
import com.allthingsandroid.android.photoeditor.GraphicManagerOriginal
import com.allthingsandroid.android.photoeditor.PhotoEditorViewStateOriginal
import com.allthingsandroid.android.photoeditor.ViewType
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test


@RunWith(RobolectricTestRunner::class)
class GraphicManagerTest {

    private var mContext = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun testGraphicMangerAddViews() {
        val id = R.layout.view_photo_editor_text
        val childId = R.id.frmBorder
        val photoEditorView = PhotoEditorViewOriginal(mContext)
        val graphicManager = GraphicManagerOriginal(photoEditorView, PhotoEditorViewStateOriginal())
        val graphic: Graphic = object : Graphic(
            context = mContext,
            layoutId = id,
            viewType = ViewType.TEXT,
            graphicManager = graphicManager
        ) {

        }
        graphicManager.addView(graphic)

        // NOTE(lucianocheng): Expect 4 views: Image, Filter, Brush,
        //                     and the Graphic we just added.
        assertEquals(4, photoEditorView.childCount.toLong())
        assertNotNull(photoEditorView.findViewById(childId))
    }
}