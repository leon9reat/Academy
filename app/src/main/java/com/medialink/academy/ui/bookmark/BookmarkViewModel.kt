package com.medialink.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.data.source.local.entity.CourseEntity

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    //    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
//    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()
    fun getBookmarks(): LiveData<PagedList<CourseEntity>> = academyRepository.getBookmarkedCourses()

    fun setBookmark(courseEntity: CourseEntity) {
        val newState = !courseEntity.bookmarked
        academyRepository.setCourseBookmark(courseEntity, newState)
    }
}