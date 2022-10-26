package com.marta.navigationdrawer;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMinuman;
    private ArrayList<Minuman> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        HomeFragment mHomeFragment = new HomeFragment();
        Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

        if (!(fragment instanceof HomeFragment)) {
            Log.d("MyFlexibleFragment","Fragment Name :" + HomeFragment.class.getSimpleName());
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, mHomeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }

//        rvMinuman = findViewById(R.id.rv_heroes);
//        rvMinuman.setHasFixedSize(true);
//
//        list.addAll(getListMinuman());
//        showRecyclerList();
    }

//    public ArrayList<Minuman> getListMinuman() {
//        String[] dataName = getResources().getStringArray(R.array.data_name);
//        String[] dataDescription = getResources().getStringArray(R.array.data_description);
//        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
//        ArrayList<Minuman> listMinuman = new ArrayList<>();
//        for (int i = 0; i < dataName.length; i++) {
//            Minuman Minuman = new Hero();
//            Minuman.setName(dataName[i]);
//            Minuman.setDescription(dataDescription[i]);
//            Minuman.setPhoto(dataPhoto.getResourceId(i, -1));
//            lisMinuman.add(Minuman);
//        }
//        return listMinuman;
//    }
//
//    private void showRecyclerList() {
//        rvMinuman.setLayoutManager(new LinearLayoutManager(this));
//        ListMinumanAdapter listMinumanAdapter = new ListMinumanAdapter(list);
//        rvMinuman.setAdapter(listMinumanAdapter);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        if (searchManager != null) {
            SearchView searchView = (SearchView)
                    (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo
                    (getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
               public boolean onQueryTextSubmit(String query) {
               Toast.makeText(MainActivity.this, query,
               Toast.LENGTH_SHORT).show();
               searchView.clearFocus();
               return true;
               }
               @Override
               public boolean onQueryTextChange(String newText) {
               return false;
               }
             });
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.shoppingbag) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container, new ShoppingFragment())
                    .addToBackStack(null)
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.menu2) {
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
            return true;
        } else {
            return true;
        }
    }
}
