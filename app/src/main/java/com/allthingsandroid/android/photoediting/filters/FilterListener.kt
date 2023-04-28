package com.allthingsandroid.android.photoediting.filters

import com.allthingsandroid.android.photoeditor.PhotoFilter

interface FilterListener {
    fun onFilterSelected(photoFilter: PhotoFilter)
}