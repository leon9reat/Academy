package com.medialink.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.data.source.local.entity.CourseEntity
import com.medialink.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    // fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
//    fun getCourses(): List<CourseEntity> = academyRepository.getAllCourses()
    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}