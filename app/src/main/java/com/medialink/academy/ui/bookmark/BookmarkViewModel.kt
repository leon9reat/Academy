package com.medialink.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.medialink.academy.ui.CourseEntity
import com.medialink.academy.utils.DataDummy

class BookmarkViewModel: ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}