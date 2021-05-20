package com.medialink.academy.data

import com.medialink.academy.data.source.AcademyDataSource
import com.medialink.academy.data.source.remote.RemoteDataSource
import com.medialink.academy.ui.CourseEntity

class FakeAcademyRepository(private val remoteDataSource: RemoteDataSource) :
    AcademyDataSource {



    override fun getAllCourses(): List<CourseEntity> {
        val courseResponses = remoteDataSource.getAllCourses()
        val courseList = ArrayList<CourseEntity>()

//        for (response in courseResponses) {
//            val course = CourseEntity(
//                response.id,
//                response.title,
//                response.description,
//                response.date,
//                false,
//                response.imagePath
//            )
//            courseList.add(course)
//        }

        return courseList
    }

    override fun getBookmarkedCourses(): List<CourseEntity> {
        val courseResponses = remoteDataSource.getAllCourses()
        val bookmarkList = ArrayList<CourseEntity>()

//        for (response in courseResponses) {
//            val bookmark = CourseEntity(
//                response.id,
//                response.title,
//                response.description,
//                response.date,
//                true,
//                response.imagePath
//            )
//            bookmarkList.add(bookmark)
//        }

        return bookmarkList
    }

    override fun getCourseWithModules(courseId: String): CourseEntity {
        val courseResponses = remoteDataSource.getAllCourses()
        lateinit var course: CourseEntity
//        for (response in courseResponses) {
//            if (response.id == courseId) {
//                course = CourseEntity(
//                    response.id,
//                    response.title,
//                    response.description,
//                    response.date,
//                    false,
//                    response.imagePath
//                )
//                break
//            }
//        }

        return course
    }

    override fun getAllModulesByCourse(courseId: String): List<ModuleEntity> {
        val moduleResponses = remoteDataSource.getModules(courseId)
        val moduleList = ArrayList<ModuleEntity>()

//        for (response in moduleResponses) {
//            val module = ModuleEntity(
//                response.moduleId,
//                response.courseId,
//                response.title,
//                response.position,
//                false
//            )
//
//            moduleList.add(module)
//        }

        return moduleList
    }

    override fun getContent(courseId: String, moduleId: String): ModuleEntity {
        val moduleResponses = remoteDataSource.getModules(courseId)
        lateinit var module: ModuleEntity

//        for (response in moduleResponses) {
//            if (response.moduleId == moduleId) {
//                module = ModuleEntity(
//                    response.moduleId,
//                    response.courseId,
//                    response.title,
//                    response.position,
//                    false
//                )
//                module.contentEntity = ContentEntity(remoteDataSource.getContent(moduleId).content)
//                break
//            }
//        }

        return module
    }
}