package com.example.myapplication8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CitiesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        final ListView listView2 = findViewById(R.id.listview2);
        Intent intent = getIntent();
        final String selectedRegion = intent.getStringExtra("RegionName");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api = retrofit.create(Api.class);

        Call<List<Cities >> call = api.getCities();
        call.enqueue(new Callback<List<Cities>>() {
            @Override
            public void onResponse(Call<List<Cities>> call, Response<List<Cities>> response) {
                List<Cities> cities = response.body();
                String[] CitiesName = new String[cities.size()];
                Log.d("Sonuç", response.raw().toString());



                if(selectedRegion.equals( "Marmara")){
                    for (int i = 0; i<=3;i++){
                        CitiesName[i] = cities.get(i).getCity_name();


                    }
                }
                else if(selectedRegion.equals( "Aegean")){
                    for (int i = 4; i<=7;i++){
                        CitiesName[i] = cities.get(i).getCity_name();
                    }
                }
                else if(selectedRegion.equals( "Central Anatolia")){
                    for (int i = 7; i<=10;i++){
                        CitiesName[i] = cities.get(i).getCity_name();
                    }
                }
                else if(selectedRegion.equals( "Mediterranean")){
                    for (int i = 11; i<14;i++){
                        CitiesName[i] = cities.get(i).getCity_name();
                    }
                }
                else if(selectedRegion.equals("Black Sea")){
                    for (int i = 15; i<=19;i++){
                        CitiesName[i] = cities.get(i).getCity_name();
                    }
                }
                else if (selectedRegion.equals( "Southeastern Anatolia")){
                    for (int i = 20; i<=23;i++){
                        CitiesName[i] = cities.get(i).getCity_name();
                    }
                }
                else{
                    for (int i = 24; i<=27;i++){
                        CitiesName[i] = cities.get(i).getCity_name();
                    }
                }
                ArrayAdapter<String> mAdapter2 = new ArrayAdapter<String>(

                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        CitiesName

                );



                listView2.setAdapter(mAdapter2);


            }

            @Override
            public void onFailure(Call<List<Cities>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


    }






    }
