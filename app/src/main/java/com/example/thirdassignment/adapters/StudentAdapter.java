package com.example.thirdassignment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassignment.R;
import com.example.thirdassignment.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList){
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_student_view,parent,false);
        StudentHolder studentHolder = new StudentHolder(view);
        return studentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentHolder holder, final int position) {
        final Student student = studentList.get(position);
        holder.txtFullname.setText(student.getFullname());
        holder.txtAge.setText(student.getAge());
        holder.txtGender.setText(student.getGender());
        holder.txtAddress.setText(student.getAddress());

        holder.imageViewTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyItemRemoved(position);
            }
        });

        if (student.getGender().equals("Male")){
            holder.imageView.setImageResource(R.drawable.male);
        }
        else if (student.getGender().equals("Female")){
            holder.imageView.setImageResource(R.drawable.female);
        }
        else if (student.getGender().equals("Others")){
            holder.imageView.setImageResource(R.drawable.male);
        }

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder{

        TextView txtFullname, txtAge, txtGender, txtAddress;
        ImageView imageView, imageViewTrash;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            txtFullname = itemView.findViewById(R.id.txtFullname);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtGender = itemView.findViewById(R.id.txtGender);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            imageView = itemView.findViewById(R.id.imageView);
            imageViewTrash = itemView.findViewById(R.id.imageViewTrash);
        }
    }
}
