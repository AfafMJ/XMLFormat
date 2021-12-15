package com.afaf.xmlformat


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afaf.xmlformat.databinding.StudentRowBinding

class RVAdapter (private val students: ArrayList<Student>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: StudentRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(StudentRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = students[position]
        holder.binding.apply {
            tvStudentId.text = student.id.toString()
            tvStudentName.text = student.name
            tvStudentMark.text = student.mark.toString()
        }
    }

    override fun getItemCount() = students.size
}