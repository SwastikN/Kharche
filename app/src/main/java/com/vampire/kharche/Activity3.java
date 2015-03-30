package com.vampire.kharche;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Activity3 extends ActionBarActivity{

    TinyDB tinydb;
    TextView balancecondition, status;
    Double TotalDeposit, TotalWithdraw, Balance;
    String stat1, stat2, stat3, stat4, stat5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        balancecondition = (TextView) findViewById(R.id.textView5);
        status = (TextView) findViewById(R.id.textView6);

        tinydb = new TinyDB(getApplicationContext());
        stat1 = "Excellent";
        stat2 = "Moderate";
        stat3 = "Average";
        stat4 = "Low";
        stat5 = "Critical";

        TotalDeposit = tinydb.getDouble("TotalDeposit");
        TotalWithdraw = tinydb.getDouble("TotalWithdraw");
        Balance = (TotalDeposit-TotalWithdraw);

        if(Balance < 0){
            status.setText(stat5);
        }
        else if(Balance >= 0 && Balance < (.25*TotalDeposit)){
            status.setText(stat4);
        }
        else if(Balance >= (.25*TotalDeposit) && Balance < (.5*TotalDeposit)){
            status.setText(stat3);
        }
        else if(Balance >= (.5*TotalDeposit) && Balance < (.75*TotalDeposit)){
            status.setText(stat2);
        }
        else{
            status.setText(stat1);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==android.R.id.home){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
