package com.medialink.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.medialink.academy.ui.CourseEntity
import com.medialink.academy.utils.DataDummy

class AcademyViewModel: ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}