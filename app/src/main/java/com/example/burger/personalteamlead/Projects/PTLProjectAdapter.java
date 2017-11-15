package com.example.burger.personalteamlead.Projects;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.burger.personalteamlead.R;

import java.util.List;

/**
 * Created by Burge on 07.11.2017.
 */

public class PTLProjectAdapter extends RecyclerView.Adapter<PTLProjectAdapter.UserListViewHolder> {

    List<PTLProject> projects;
    ProjectListener listener;


    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvText1;


        UserListViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_gridview);
            tvText1 = itemView.findViewById(R.id.tvText1);

        }
    }

    public PTLProjectAdapter(List<PTLProject> projects, ProjectListener listener) {
        this.projects = projects;
        this.listener = listener;
    }

    public List<PTLProject> getPTLProjects() {
        return projects;
    }

    @Override
    public PTLProjectAdapter.UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellgrid, parent, false);
        UserListViewHolder pvh = new UserListViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PTLProjectAdapter.UserListViewHolder holder, final int position) {
        holder.tvText1.setText(getPTLProjects().get(position).getName());
        holder.linearLayout.setOnClickListener(view -> listener.getPTLProjectToListener(getPTLProjects().get(position)));
    }


//    public void addMethod(PTLProject ptlProject){
//        getPTLProjects().add(ptlProject);
//        notifyDataSetChanged();
//    }


    @Override
    public int getItemCount() {
        return projects.size();
    }

//    public  void clear(){
//        getPTLProjects().clear();
//        notifyDataSetChanged();
//    }
}
