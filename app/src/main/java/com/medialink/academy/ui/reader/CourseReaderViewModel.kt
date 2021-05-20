package com.medialink.academy.ui.reader

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.medialink.academy.data.ContentEntity
import com.medialink.academy.data.ModuleEntity
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.utils.DataDummy

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    /*fun getModules(): ArrayList<ModuleEntity> =
        DataDummy.generateDummyModules(courseId) as ArrayList<ModuleEntity>*/
    //fun getModules(): ArrayList<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId) as ArrayList<ModuleEntity>
    fun getModules(): LiveData<List<ModuleEntity>> =
        academyRepository.getAllModulesByCourse(courseId)

    /*fun getSelectedModule(): ModuleEntity {
        /*lateinit var module: ModuleEntity
        val moduleEntities = getModules()
        for (moduleEntity in moduleEntities) {
            if (moduleEntity.moduleId == moduleId) {
                module = moduleEntity
                module.contentEntity = ContentEntity(
                    "<h3 class=\\\"fr-text-bordered\\\">" + module.title +
                            "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                            "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                            "culpa qui officia deserunt mollit anim id est laborum.</p>"
                )
                break
            }
        }

        return module*/
        return academyRepository.getContent(courseId, moduleId)
    }*/

    fun getSelectedModule(): LiveData<ModuleEntity> =
        academyRepository.getContent(courseId, moduleId)
}