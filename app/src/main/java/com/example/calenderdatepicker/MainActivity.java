package com.example.calenderdatepicker;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {



    Toolbar toolbar;
    Spinner spinner;
    TextView month_name,month_date;
    private ListView mListView;
    String item;
    MyRecyclerViewAdapter adapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        spinner = findViewById(R.id.spinner);

        //month_date=findViewById(R.id.month_date);


        month_name=findViewById(R.id.month_name);
        List<String> months= new ArrayList<>();
        months.add(0,"September");
        months.add("January");
        months.add("February ");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("Aug");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");



        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,months);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("ChooseCategory")){
                }else{
                    item =parent.getItemAtPosition(position).toString();
                    month_name.setText(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<String> dates = new ArrayList<>();
        dates.add("1");
        dates.add("2");
        dates.add("3");
        dates.add("4");
        dates.add("5");
        dates.add("6");
        dates.add("7");
        dates.add("8");
        dates.add("9");
        dates.add("10");
        dates.add("11");
        dates.add("12");
        dates.add("13");
        dates.add("14");
        dates.add("15");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapters = new MyRecyclerViewAdapter(this, dates);
        adapters.setClickListener((MyRecyclerViewAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapters);









//Setting list views
      /*  mListView = (ListView) findViewById(R.id.tv_list_of_days);
        List<String> dates= new ArrayList<>();
        dates.add("1");
        dates.add("2");
        dates.add("3");
        dates.add("4");
        dates.add("5");
        dates.add("6");
        dates.add("7");
        dates.add("8");
        dates.add("9");
        dates.add("10");
        dates.add("11");
        dates.add("12");
        dates.add("13");
        dates.add("14");
        dates.add("15");


        ArrayAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dates);
        mListView.setAdapter(listAdapter);
        month_date.setText(item);*/

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
            return true;
        } else if(id == R.id.setting) {
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
            return true;
        } else if(id == R.id.about) {
            Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapters.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }
}