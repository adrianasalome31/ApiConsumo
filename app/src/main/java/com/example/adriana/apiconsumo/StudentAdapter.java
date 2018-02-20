package com.example.adriana.apiconsumo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adriana on 02-18-18.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{
    private List<Student> student;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public  TextView age;
        public  TextView surname;


        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            surname = view.findViewById(R.id.surname);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public StudentAdapter (List<Student> student) {
        this.student = student;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        StudentAdapter.ViewHolder viewHolder = new StudentAdapter.ViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {

        final Student stud = student.get(position);
        holder.age.setText(stud.getAge()+"");
        holder.name.setText(stud.getName());
        holder.surname.setText(stud.getSurname());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return student.size();
    }
}
