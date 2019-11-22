package com.example.softwaricaapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwaricaapp.Model.Students;
import com.example.softwaricaapp.R;

import java.util.List;

import static com.example.softwaricaapp.ui.Students.StudentFragment.stList;

public class myadapter extends RecyclerView.Adapter<myadapter.MyHolder> {
    Context context;
    List<Students> stlist;


    public myadapter(Context context, List<Students> stList){
        this.context = context;
        this.stlist = stList;
    }


    @NonNull
    @Override
    public myadapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.viewstudents,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.MyHolder holder,final int position) {
        final Students stu = stList.get(position);

        holder.profile.setImageResource(stu.getImg());
        holder.nametxt.setText(stu.getName());
        holder.agetxt.setText(stu.getAge());
        holder.addresstxt.setText(stu.getAddress());
        holder.gendertxt.setText(stu.getGender());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stList.remove(stu);

                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return stlist.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView profile, delete;
        TextView nametxt, agetxt, gendertxt, addresstxt;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profileimg);
            nametxt = itemView.findViewById(R.id.nameview);
            agetxt = itemView.findViewById(R.id.ageview);
            addresstxt = itemView.findViewById(R.id.addressview);
            gendertxt = itemView.findViewById(R.id.genderview);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
