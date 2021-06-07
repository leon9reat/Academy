package com.medialink.academy.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.data.source.local.entity.CourseWithModule
import com.medialink.academy.utils.DataDummy
import com.medialink.academy.vo.Resource
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

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Mock
    private lateinit var observer: Observer<Resource<CourseWithModule>>

    @Before
    fun setUp() {
        viewModel = DetailCourseViewModel(academyRepository)
        viewModel.setSelectedCourse(courseId)
    }


    @Test
    fun getCourseWithModule() {
        val dummyCourseWithModule = Resource.success(
            DataDummy.generateDummyCourseWithModules(dummyCourse, true)
        )
        val course = MutableLiveData<Resource<CourseWithModule>>()
        course.value = dummyCourseWithModule

        Mockito.`when`(academyRepository.getCourseWithModules(courseId)).thenReturn(course)

        viewModel.courseModule.observeForever(observer)
        Mockito.verify(observer).onChanged(dummyCourseWithModule)
    }


}