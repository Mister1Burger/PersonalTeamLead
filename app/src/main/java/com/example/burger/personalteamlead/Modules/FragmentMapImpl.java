package com.example.burger.personalteamlead.Modules;

import android.util.Log;

import com.example.burger.personalteamlead.Fragments.PreviousFragment;
import com.example.burger.personalteamlead.Fragments.FragmentsFlags;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 29.11.2017.
 */

public class FragmentMapImpl implements FragmentMap {
    private List<PreviousFragment> previousFragments = new ArrayList<>();

    @Override
    public void addFlag(FragmentsFlags flag, int id, String parentName){
        PreviousFragment previousFragment = new PreviousFragment();
        previousFragment.setFlag(flag);
        previousFragment.setId(id);
        previousFragment.setParentName(parentName);
        previousFragments.add(previousFragment);
    }

    @Override
    public PreviousFragment previousFragment(){
        PreviousFragment fragment = new PreviousFragment();
        FragmentsFlags flag;
        if(previousFragments.size() == 0){
            flag = FragmentsFlags.PROJECT;
        }else {
            flag = previousFragments.get(previousFragments.size()-1).getFlag();}
        switch (flag){
            case PROJECT:
                fragment.setFlag(FragmentsFlags.PROJECT);
                fragment.setId(0);
                fragment.setParentName(null);
                break;

            case CLASS:
                previousFragments.remove(previousFragments.size()-1);
                fragment.setFlag(FragmentsFlags.PROJECT);
                fragment.setId(0);
                fragment.setParentName(null);
                break;

            case METHOD:
                Log.d("TAG",String.valueOf("Было" + previousFragments.size()));
                previousFragments.remove(previousFragments.size()-1);
                Log.d("TAG",String.valueOf("Стало" + previousFragments.size()));
                fragment.setFlag(FragmentsFlags.CLASS);
                fragment.setId(previousFragments.get(previousFragments.size()-1).getId());
                fragment.setParentName(String.valueOf(previousFragments.get(previousFragments.size()-1).getParentName()));
                break;

            case ADD:
                if (previousFragments.size()>1){
                    previousFragments.remove(previousFragments.size()-1);
                    fragment.setFlag(previousFragments.get(previousFragments.size() - 1).getFlag());
                    fragment.setId(previousFragments.get(previousFragments.size()-1).getId());
                    fragment.setParentName(previousFragments.get(previousFragments.size()-1).getParentName());
                }else {
                    fragment.setFlag(FragmentsFlags.PROJECT);
                    fragment.setId(0);
                    fragment.setParentName(null);}
                break;
        }
        return fragment;

    }

    @Override
    public void clear(){
        previousFragments.clear();
    }

    @Override
    public int getFragmentsQuantity(){
        int a;
        return a = previousFragments.size();
    }
}
