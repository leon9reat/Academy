package com.medialink.academy.ui.bookmark

import com.medialink.academy.ui.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
