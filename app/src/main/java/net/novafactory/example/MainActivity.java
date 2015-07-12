package net.novafactory.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.novafactory.example.basic.UserFragment;
import net.novafactory.example.collection.ObservableCollectionFragment;
import net.novafactory.example.image.ImageFragment;
import net.novafactory.example.list.RecyclerViewDataBindingFragment;
import net.novafactory.example.list.RecyclerViewFragment;
import net.novafactory.example.observable.ObservableFieldsUserFragment;
import net.novafactory.example.observable.ObservableUserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new MainFragment());
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.activity_main_container, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }

    public void replaceFragmentWithStack(Fragment fragment, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.activity_main_container, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }

    public void onClickBasic(View view) {
        replaceFragmentWithStack(new UserFragment(), "Basic");
    }

    public void onClickObservable(View view) {
        replaceFragmentWithStack(new ObservableUserFragment(), "Observable");
    }

    public void onClickObservableFields(View view) {
        replaceFragmentWithStack(new ObservableFieldsUserFragment(), "ObservableFields");
    }

    public void onClickObservableCollection(View view) {
        replaceFragmentWithStack(new ObservableCollectionFragment(), "ObservableCollection");
    }

    public void onClickRecyclerView(View view) {
        replaceFragmentWithStack(new RecyclerViewFragment(), "RecyclerView");
    }

    public void onClickRecyclerViewDataBinding(View view) {
        replaceFragmentWithStack(new RecyclerViewDataBindingFragment(), "RecyclerViewDataBinding");
    }

    public void onClickImage(View view) {
        replaceFragmentWithStack(new ImageFragment(), "Image");
    }
}
