package com.burhanrashid52.photoediting.util

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.exifinterface.media.ExifInterface
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.getExifOrientationDegrees
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImage
import java.io.FileInputStream
import java.security.MessageDigest


class MyRotationTransformation(private val orientation: Int): BitmapTransformation() {

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update("rotation correction transformation".toByte());
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        val exifOrientationDegrees = getExifOrientationDegrees(orientation)
        return TransformationUtils.rotateImageExif(pool, toTransform, exifOrientationDegrees)
    }
}