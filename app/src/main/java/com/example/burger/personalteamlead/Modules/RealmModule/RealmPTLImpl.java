package com.example.burger.personalteamlead.Modules.RealmModule;

import android.content.Context;
import android.util.Log;


import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Projects.PTLProject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.exceptions.RealmMigrationNeededException;

public class RealmPTLImpl implements RealmPTL {

    public RealmPTLImpl() {
    }

    @Override
    public Realm init(Context context) {
        Realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name( "reminder.realm")
                .modules(new MyLibraryModule())
                .build();

        try {
            return Realm.getInstance(realmConfiguration);
        } catch (RealmMigrationNeededException e) {
            try {
                Log.e( "TAG", String.valueOf(e));
                Realm.deleteRealm(realmConfiguration);
                //Realm file has been deleted.
                return Realm.getInstance(realmConfiguration);
            } catch (Exception ex) {
                //No Realm file to remove.
                Log.e( "TAG", String.valueOf(ex));
            }
        }

        return null;
    }

    @Override
    public List<PTLClass> readPTLClasses(Context context, String parentName) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        try {
            assert realm != null;
            RealmResults<PTLClass> list = realm.where(PTLClass.class)
                    .equalTo("ParentName", parentName)
                    .findAll();
            Log.d( "TAG", String.valueOf(realmFile.length()));
            if (list == null)
                return new ArrayList<>();
            return list;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void savePTLClass(Context context, PTLClass ptlClass) {

        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(ptlClass);
            Log.d( "TAG", String.valueOf(realmFile.length()));
            realm.commitTransaction();
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public void removePTLClass(Context context, String parentName) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
           PTLClass ptlClass = realm.where(PTLClass.class)
                    .equalTo("ParentName", parentName).findFirst();
            if(ptlClass!=null) {
                realm.beginTransaction();
                ptlClass.deleteFromRealm();
                realm.commitTransaction();
            }
            Log.d( "TAG", String.valueOf(realmFile.length()));
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public void onDestroy(Context context) {
        Realm realm = init(context);
        assert realm != null;
        realm.close();
    }

    @Override
    public List<PTLMethod> readPTLMethods(Context context, String parentName) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        try {
            assert realm != null;
            RealmResults<PTLMethod> list = realm.where(PTLMethod.class)
                    .equalTo("ParentName", parentName)
                    .findAll();
            Log.d( "TAG", String.valueOf(realmFile.length()));
            if (list == null)
                return new ArrayList<>();
            return list;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void savePTLMethod(Context context, PTLMethod ptlMethods) {

        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(ptlMethods);
            Log.d( "TAG", String.valueOf(realmFile.length()));
            realm.commitTransaction();
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public void removePTLMethod(Context context, String parentName) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            PTLMethod ptlMethods = realm.where(PTLMethod.class)
                    .equalTo("ParentName", parentName).findFirst();
            if(ptlMethods!=null) {
                realm.beginTransaction();
                ptlMethods.deleteFromRealm();
                realm.commitTransaction();
            }
            Log.d( "TAG", String.valueOf(realmFile.length()));
        } catch (NullPointerException ignore) {
        }
    }

    @Override
    public List<PTLProject> readPTLProject(Context context) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        try {
            assert realm != null;
            RealmResults<PTLProject> list = realm.where(PTLProject.class).findAll();
            Log.d( "TAG", String.valueOf(realmFile.length()));
            if (list == null)
                return new ArrayList<>();
            return list;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void savePTLProject(Context context, PTLProject ptlProject) {

        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            realm.beginTransaction();
            realm.insert(ptlProject);
            Log.d( "TAG", String.valueOf(realmFile.length()));
            realm.commitTransaction();
        } catch (Exception e) {

        }
    }

    @Override
    public void removePTLProject(Context context, String name) {
        Realm realm = init(context);
        File realmFile = new File(context.getFilesDir(), "reminder.realm");
        assert realm != null;
        try {
            PTLProject ptlProject = realm.where(PTLProject.class)
                    .equalTo("ParentName", name).findFirst();
            if(ptlProject!=null) {
                realm.beginTransaction();
                ptlProject.deleteFromRealm();
                realm.commitTransaction();
            }
            Log.d( "TAG", String.valueOf(realmFile.length()));
        } catch (NullPointerException ignore) {
        }
    }
}
