package com.afaf.xmlformat


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var studentsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        studentsRecyclerView = findViewById(R.id.tvStudents)
        studentsRecyclerView.adapter = RVAdapter(getStudents())
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getStudents(): ArrayList<Student>{
        var studentsList = arrayListOf<Student>()
        try {
            val parser = XMLParser()
            val inputStream = assets.open("studentsInfo.xml")
            studentsList = parser.parse(inputStream)
        } catch (e: Exception){ e.printStackTrace() }
        return studentsList
    }
}