package com.medialink.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.ui.CourseEntity
import com.medialink.academy.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository): ViewModel() {
//    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()
}