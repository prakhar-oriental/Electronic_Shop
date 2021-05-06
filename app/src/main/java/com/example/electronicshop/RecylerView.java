package com.example.electronicshop;



import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class RecylerView extends AppCompatActivity {
    RecyclerView rcv;
    MyProductAdapter myProductAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        rcv = findViewById(R.id.rcv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);
       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        //   rcv.setLayoutManager(linearLayoutManager);
         myProductAdapter = new MyProductAdapter(dataqueue(),getApplicationContext());
        rcv.setAdapter(myProductAdapter);

    }
    public ArrayList<Model> dataqueue()
    {
        ArrayList<Model> myholder = new ArrayList<>();

        Model obj1 = new Model();
        obj1.setProductheader("Whirlphool Refridgerator");
        obj1.setProductimage(R.drawable.fridge);
        obj1.setPrice(6000);
        obj1.setProductdescription("It is very cool Refridgerator with 5 star rating ");
        obj1.setWarrenty("It has 5 year warrenty");
        obj1.setReplacementpolicy("It has 2 weeks Replacement policy");
        myholder.add(obj1);

        Model obj2 = new Model();
        obj2.setProductheader("Nikon camera");
        obj2.setProductimage(R.drawable.camera);
        obj2.setPrice(3000);
        obj2.setProductdescription("It is  nikon camera with 500 mega pixel ");
        obj2.setWarrenty("It has 3 year warrenty");
        obj2.setReplacementpolicy("It has 1 weeks Replacement policy");
        myholder.add(obj2);

        Model obj3 = new Model();
        obj3.setProductheader("Apple IPhone");
        obj3.setProductimage(R.drawable.phone);
        obj3.setPrice(1000);
        obj3.setProductdescription("It is Iphone 12 with 15 GB ram 32 mega pixel camera ");
        obj3.setWarrenty("It has 1 year warrenty");
        obj3.setReplacementpolicy("It has 1 weeks Replacement policy");
        myholder.add(obj3);

        Model obj4 = new Model();
        obj4.setProductheader("QLED TV");
        obj4.setProductimage(R.drawable.tv);
        obj4.setPrice(4000);
        obj4.setProductdescription("It is Qled new model with fascinating picture Quality ");
        obj4.setWarrenty("It has 10 year warrenty");
        obj4.setReplacementpolicy("It has 1 month Replacement policy");
        myholder.add(obj4);

        return myholder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        MenuItem item = menu.findItem(R.id.searchmenu);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myProductAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}