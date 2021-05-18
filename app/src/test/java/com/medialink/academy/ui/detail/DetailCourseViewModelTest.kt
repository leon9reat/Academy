package com.medialink.academy.ui.detail

import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailCourseViewModelTest {

    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
    }


    @Test
    fun getCourse() {
        Mockito.`when`(academyRepository.getCourseWithModules(courseId)).thenReturn(dummyCourse)
        val courseEntity = viewModel.getCourse()
        Mockito.verify(academyRepository).getCourseWithModules(courseId)
        //viewModel.setSelectedCourse(dummyCourse.courseId)


        assertNotNull(courseEntity)

        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)
    }

    @Test
    fun getModules() {
        Mockito.`when`(academyRepository.getAllModulesByCourse(courseId))
            .thenReturn(DataDummy.generateDummyModules(courseId))
        val moduleEntities = viewModel.getModules()
        Mockito.verify(academyRepository).getAllModulesByCourse(courseId)

        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities.size.toLong())
    }
}