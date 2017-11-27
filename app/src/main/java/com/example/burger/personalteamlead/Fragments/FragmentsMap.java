package com.example.burger.personalteamlead.Fragments;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by java on 22.11.2017.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FragmentsMap  {
  private List<FragmentsFlags> flags = new ArrayList<>();
  private List<Integer> ids = new ArrayList<>();
  private  List<String> parentNames = new ArrayList<>();


    public void addFlag(FragmentsFlags flag, int id, String parentName){
     flags.add(flag);
     ids.add(id);
     parentNames.add(parentName);
    }

    public PreviousFragment previousFragment(){
        PreviousFragment fragment = new PreviousFragment();
        FragmentsFlags flag;
        if(flags.size() == 0){
            flag = FragmentsFlags.PROJECT;
        }else {
        flag = flags.get(flags.size()-1);}
    switch (flag){
        case PROJECT:
            fragment.setFlag(FragmentsFlags.PROJECT);
            fragment.setId(0);
            fragment.setParentName(null);
            break;

        case CLASS:
            fragment.setFlag(FragmentsFlags.PROJECT);
            fragment.setId(0);
            fragment.setParentName(null);
            flags.remove(flags.size()-1);
            ids.remove(ids.size()-1);
            parentNames.remove(parentNames.size());

            break;

        case METHOD:
            fragment.setFlag(FragmentsFlags.CLASS);
            fragment.setId(ids.size()-1);
            fragment.setParentName(String.valueOf(parentNames.size()-1));
            Log.d("TAG", String.valueOf(parentNames.size()-1));
            flags.remove(flags.size());
            ids.remove(ids.size());
            parentNames.remove(parentNames.size());
            break;

        case ADD:
            if (flags.size()>1){
                flags.remove(flags.size()-1);
                ids.remove(ids.size()-1);
                parentNames.remove(parentNames.size()-1);
                previousFragment();
            }else {
                fragment.setFlag(FragmentsFlags.PROJECT);
                fragment.setId(0);
                fragment.setParentName(null);}
            break;
    }
    return fragment;

    }
}

