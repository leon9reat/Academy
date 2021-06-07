package com.medialink.academy.ui.bookmark

import com.medialink.academy.data.source.local.entity.CourseEntity


interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
