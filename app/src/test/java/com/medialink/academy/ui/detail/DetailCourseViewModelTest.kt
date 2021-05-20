package com.medialink.academy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.medialink.academy.data.ModuleEntity
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.ui.CourseEntity
import com.medialink.academy.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
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
    private val dummyModules = DataDummy.generateDummyModules(courseId)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Mock
    private lateinit var courseObserver: Observer<CourseEntity>

    @Mock
    private lateinit var modulesObserver: Observer<List<ModuleEntity>>

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
    }


    @Test
    fun getCourse() {
        val course = MutableLiveData<CourseEntity>()
        course.value = dummyCourse

        Mockito.`when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)
        val courseEntity = viewModel.getCourse().value as CourseEntity
        Mockito.verify(academyRepository).getCourseWithModules(courseId)
        //viewModel.setSelectedCourse(dummyCourse.courseId)


        assertNotNull(courseEntity)

        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.title, courseEntity.title)

        viewModel.getCourse().observeForever(courseObserver)
        verify(courseObserver).onChanged(dummyCourse)
    }

    @Test
    fun getModules() {
        val module = MutableLiveData<List<ModuleEntity>>()
        module.value = dummyModules

        Mockito.`when`(academyRepository.getAllModulesByCourse(courseId))
            .thenReturn(module)
        val moduleEntities = viewModel.getModules().value
        Mockito.verify(academyRepository).getAllModulesByCourse(courseId)

        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities?.size)

        viewModel.getModules().observeForever(modulesObserver)
        verify(modulesObserver).onChanged(dummyModules)
    }
}