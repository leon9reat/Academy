package com.medialink.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.medialink.academy.R
import com.medialink.academy.databinding.ActivityDetailCourseBinding
import com.medialink.academy.databinding.ContentDetailCourseBinding
import com.medialink.academy.ui.CourseEntity
import com.medialink.academy.ui.reader.CourseReaderActivity
import com.medialink.academy.utils.DataDummy
import com.medialink.academy.viewmodel.ViewModelFactory

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

        val adapter = DetailCourseAdapter()
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory).get(DetailCourseViewModel::class.java)

        val extras = intent.extras
        if (extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId != null) {
                activityDetailCourseBinding.detailContent.progressBar.visibility = View.VISIBLE
                //activityDetailCourseBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedCourse(courseId)
                //val modules = DataDummy.generateDummyModules(courseId)
                //val modules = viewModel.getModules()
                viewModel.getModules().observe(this, { modules ->
                    activityDetailCourseBinding.detailContent.progressBar.visibility = View.GONE
                    //activityDetailCourseBinding.content.visibility = View.VISIBLE
                    adapter.setModules(modules)
                    adapter.notifyDataSetChanged()
                })

                //adapter.setModules(modules)
                //populateCourse(viewModel.getCourse())
                viewModel.getCourse().observe(this, { course -> populateCourse(course) })
                /*for (course in DataDummy.generateDummyCourses()) {
                    if (course.courseId == courseId) {
                        populateCourse(course)
                    }
                }*/
            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration =
                DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        with(detailContentBinding) {
            textTitle.text = courseEntity.title
            textDescription.text = courseEntity.description
            textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)
        }

        Glide.with(this)
            .load(courseEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }
}