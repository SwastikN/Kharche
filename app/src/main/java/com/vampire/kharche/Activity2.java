package com.vampire.kharche;

import android.content.Context;
import android.content.Intent;
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


public class Activity2 extends ActionBarActivity {
    TinyDB tinydb;
    EditText withdrawAmount, withdrawNote;
    Button withdraw, chooseCategory;
    String wNote;
    Double wAmount, temp;
    Integer withdrawNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        withdrawAmount = (EditText) findViewById(R.id.editText2);
        withdrawNote = (EditText) findViewById(R.id.editText);
        withdraw = (Button) findViewById(R.id.button38);
        chooseCategory = (Button) findViewById(R.id.button22);

        tinydb = new TinyDB(getApplicationContext());

        withdrawNum = tinydb.getInt("withdrawNum");
    }

    public void newWithdraw(View v) {

        if (tinydb.getString("chosenCategory") != ""){
            wAmount = Double.valueOf(withdrawAmount.getText().toString()).doubleValue();
            wNote = withdrawNote.getText().toString();
            withdrawNum++;
            tinydb.putDouble(withdrawNum+"Withdraw",wAmount);
            temp = tinydb.getDouble("TotalWithdraw");
            temp += wAmount;
            tinydb.putDouble("TotalWithdraw", temp);
            tinydb.putString(withdrawNum+"WNote",wNote);
            tinydb.putString(withdrawNum+"Category", tinydb.getString("chosenCategory"));
            tinydb.putInt("withdrawNum", withdrawNum);
            tinydb.putString("chosenCategory","");
            Toast("Withdraw Successful");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please choose a category", Toast.LENGTH_SHORT).show();
        }

    }

    public void ButtonToList(View view){
        Intent intent=new Intent(this,Activity4.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
