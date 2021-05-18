package com.medialink.academy.ui.bookmark

import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Mock
    private lateinit var academyRepository: AcademyRepository

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(academyRepository)
    }

    @Test
    fun getBookmarks() {
        Mockito.`when`(academyRepository.getBookmarkedCourses()).thenReturn(DataDummy.generateDummyCourses())
        val courseEntities = viewModel.getBookmarks()
        Mockito.verify(academyRepository).getBookmarkedCourses()

        assertNotNull(courseEntities)
        assertEquals(5, courseEntities.size)
    }
}