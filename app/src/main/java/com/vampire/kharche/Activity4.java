package com.vampire.kharche;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class Activity4 extends ActionBarActivity {

    ListView lv;
    ArrayAdapter<String> adapter;
    private String[] category = {"Food", "Home", "Travel", "Health", "Communication", "Gift", "Clothing", "Entertainment"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TinyDB tinyDB = new TinyDB(getApplicationContext());
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv = (ListView) findViewById(R.id.listCategory);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, category);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = category[position];
                Toast.makeText(getApplicationContext(), selectedCategory+" chosen", Toast.LENGTH_SHORT).show();
                tinyDB.putString("chosenCategory",selectedCategory);
                Intent intent = new Intent(Activity4.this, Activity2.class);
                startActivity(intent);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==android.R.id.home){
            Intent intent =new Intent(this,Activity2.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}