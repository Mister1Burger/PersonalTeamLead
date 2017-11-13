package com.example.burger.personalteamlead.Methods;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.burger.personalteamlead.Classes.ClassListener;
import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Classes.PTLClassAdapter;
import com.example.burger.personalteamlead.R;

import java.util.List;

/**
 * Created by Burge on 04.11.2017.
 */

public class PTLMethodAdapter extends RecyclerView.Adapter<PTLMethodAdapter.UserListViewHolder> {

        List<PTLMethod> methods;
        MethodListener listener;


        public static class UserListViewHolder extends RecyclerView.ViewHolder {
            LinearLayout linearLayout;
            TextView tvText1;


            UserListViewHolder(View itemView) {
                super(itemView);
                linearLayout = itemView.findViewById(R.id.ll_gridview);
                tvText1 = itemView.findViewById(R.id.tvText1);

            }
        }

        public PTLMethodAdapter(List<PTLMethod> methods, MethodListener listener) {
            this.methods = methods;
            this.listener = listener;
        }

        public List<PTLMethod> getPTLMethod() {
            return methods;
        }

    @Override
    public PTLMethodAdapter.UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cellgrid, parent, false);
        UserListViewHolder pvh = new UserListViewHolder(v);
        return pvh;
    }

        @Override
        public void onBindViewHolder(PTLMethodAdapter.UserListViewHolder holder, final int position) {
            holder.tvText1.setText(getPTLMethod().get(position).getName());
            holder.linearLayout.setOnClickListener(view -> listener.getPTLMethodToListener(getPTLMethod().get(position)));

        }

        public void addMethod(PTLMethod ptlMethod){
            getPTLMethod().add(ptlMethod);
            notifyDataSetChanged();
        }


        @Override
        public int getItemCount() {
            return methods.size();
        }

    public  void clear(){
            getPTLMethod().clear();
            notifyDataSetChanged();
        }
    }

