package com.example.myapplication8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView =  findViewById(R.id.listview);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       Api api = retrofit.create(Api.class);

        Call<List<Region >> call =api.getRegions();
        call.enqueue(new Callback<List<Region>>() {
            @Override
            public void onResponse(Call<List<Region>> call, Response<List<Region>> response) {
                List<Region> regions = response.body();
                String[] regionName = new String[regions.size()];

                for (int i = 0; i<regions.size();i++){
                    regionName[i] = regions.get(i).getRegion_name();
                }
                ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(

                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                regionName

                );
                listView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<List<Region>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,CitiesActivity.class);
                intent.putExtra("RegionName",listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });



    }





}
