package com.medialink.academy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.medialink.academy.data.ModuleEntity
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.ui.CourseEntity
import com.medialink.academy.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    /*fun getCourse(): CourseEntity {
        /*lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourses()
        for (courseEntity in coursesEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course*/
        return academyRepository.getCourseWithModules(courseId)
    }*/
    fun getCourse(): LiveData<CourseEntity> = academyRepository.getCourseWithModules(courseId)

    // fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
    //fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)
    fun getModules(): LiveData<List<ModuleEntity>> = academyRepository.getAllModulesByCourse(courseId)
}