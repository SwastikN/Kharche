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
import android.widget.Toast;


public class Activity5 extends ActionBarActivity{

    TinyDB tinydb;
    EditText depositAmount, depositNote;
    String dNote;
    Double dAmount, temp;
    Button deposit;
    Integer depositNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tinydb = new TinyDB(getApplicationContext());

        depositNum = tinydb.getInt("depositNum");

        depositAmount = (EditText) findViewById(R.id.editText3);
        depositNote = (EditText) findViewById(R.id.editText4);
        deposit = (Button) findViewById(R.id.button39);
    }


    public void newDeposit(View v){
        dAmount = Double.valueOf(depositAmount.getText().toString()).doubleValue();
        dNote = depositNote.getText().toString();
        depositNum++;
        tinydb.putDouble(depositNum+"Deposit",dAmount);
        temp = tinydb.getDouble("TotalDeposit");
        temp += dAmount;
        tinydb.putDouble("TotalDeposit", temp);
        tinydb.putString(depositNum+"DNote",dNote);
        tinydb.putInt("depositNum",depositNum);
        Toast("Deposit Successful");
        Intent intent = new Intent(Activity5.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id==android.R.id.home){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
