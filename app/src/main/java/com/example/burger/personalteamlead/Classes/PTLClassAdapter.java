package com.example.burger.personalteamlead.Classes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.burger.personalteamlead.R;

import java.util.List;

/**
 * Created by Burge on 04.11.2017.
 */

public class PTLClassAdapter extends RecyclerView.Adapter<PTLClassAdapter.UserListViewHolder> {

    List<PTLClass> classes;
    ClassListener listener;


    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView tvText1;


        UserListViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_gridview);
            tvText1 = itemView.findViewById(R.id.tvText1);

        }
    }

    public PTLClassAdapter(List<PTLClass> classes, ClassListener listener) {
        this.classes = classes;
        this.listener = listener;
    }

    public List<PTLClass> getPTLClass() {
        return classes;
    }

    @Override
    public PTLClassAdapter.UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellgrid, parent, false);
        UserListViewHolder pvh = new UserListViewHolder(v);
        return pvh;
    }

   @Override
    public void onBindViewHolder(UserListViewHolder holder, final int position) {
        holder.tvText1.setText(getPTLClass().get(position).getName());
        holder.linearLayout.setOnClickListener(view -> listener.getPTLClassToListner(getPTLClass().get(position)));

    }

    public void addClass(PTLClass ptlClass){
        getPTLClass().add(ptlClass);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return classes.size();
    }
    public  void clear(){
        getPTLClass().clear();
        notifyDataSetChanged();
    }
}