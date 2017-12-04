package com.example.burger.personalteamlead.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.burger.personalteamlead.Classes.PTLClassAdapter;
import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.MainActivity;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Methods.PTLMethodAdapter;
import com.example.burger.personalteamlead.R;
import com.example.burger.personalteamlead.R2;
import com.example.burger.personalteamlead.TMP.TmpData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MethodsFragment extends Fragment{
    @BindView(R2.id.add_button_method)
    Button add_button_method;
    @BindView(R2.id.path_in_method_tv)
    TextView pathTV;
    @BindView(R2.id.description_method_tv)
    TextView descriptionTV;
    @BindView(R2.id.methods_list)
    RecyclerView methods_list;
    MainActivityControllerImpl mAC;
    TmpData tmpData;
    List<PTLMethod> methods;
    PTLMethodAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.method_fragment, container,false);
        ButterKnife.bind(this,view);
        mAC = ((MainActivity)getActivity()).getMAC();
        return  view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        methods_list.setLayoutManager(llm);
        add_button_method.setOnClickListener(view1 -> ((MainActivity)getActivity()).getFragment(FragmentsFlags.ADD,2,tmpData.getParentName()));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {
        super.onStart();
        tmpData = mAC.getTmpData();
        pathTV.setText(tmpData.getParentName());
        descriptionTV.setText(tmpData.getDescription());
        mAC.getFragmentMap().addFlag(tmpData.getFlag(),tmpData.getId(),tmpData.getParentName());
        Log.d("TAG",String.valueOf(tmpData.getFlag() + " /" + String.valueOf(tmpData.getId()) + "/ " + String.valueOf(tmpData.getParentName())));
        Log.d("TAG", String.valueOf(mAC.getFragmentMap().getFragmentsQuantity()));
        methods = mAC.getRealmPTL().readPTLMethods(getContext(),tmpData.getParentName());
        adapter = new PTLMethodAdapter(methods, ptlMethod -> Log.d("TAG","Ты нажал на метод)"));
        methods_list.setAdapter(adapter);
    }

}
