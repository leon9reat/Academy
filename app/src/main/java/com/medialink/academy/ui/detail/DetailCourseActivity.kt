package com.medialink.academy.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.medialink.academy.R
import com.medialink.academy.databinding.ActivityDetailCourseBinding
import com.medialink.academy.databinding.ContentDetailCourseBinding

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent
        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}