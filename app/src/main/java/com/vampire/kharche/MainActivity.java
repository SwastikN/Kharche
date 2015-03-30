package com.vampire.kharche;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Button ToDeposit, ToWithdraw;
    private Toolbar toolbar;
    TextView ShowDetails, balance;
    TinyDB tinydb;
    Double TotalDeposit, TotalWithdraw, Balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setLogo(R.drawable.ic_launcher);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        tinydb = new TinyDB(getApplicationContext());

        ToDeposit=(Button)findViewById(R.id.button9);
        ToWithdraw=(Button)findViewById(R.id.button10);
        ShowDetails=(TextView)findViewById(R.id.textView);
        balance = (TextView)findViewById(R.id.textView10);

        TotalDeposit = tinydb.getDouble("TotalDeposit");
        TotalWithdraw = tinydb.getDouble("TotalWithdraw");
        Balance = (TotalDeposit-TotalWithdraw);

        balance.setText(Balance.toString());

        ShowDetails.setOnClickListener(this);
    }

    //Toast for active categories
    public void FOOD(View view){
        Toast.makeText(this,"Food",Toast.LENGTH_SHORT).show();
    }
    public void HOME(View view){
        Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
    }
    public void TRAVEL(View view){
        Toast.makeText(this,"Travel",Toast.LENGTH_SHORT).show();
    }
    public void HEALTH(View view){
        Toast.makeText(this,"Health",Toast.LENGTH_SHORT).show();
    }
    public void COMMUNICATION(View view){Toast.makeText(this,"Communication",Toast.LENGTH_SHORT).show();}
    public void GIFT(View view){
        Toast.makeText(this,"Gifts",Toast.LENGTH_SHORT).show();
    }
    public void CLOTHING(View view){
        Toast.makeText(this,"Clothing",Toast.LENGTH_SHORT).show();
    }
    public void ENTERTAINMENT(View view){Toast.makeText(this,"Entertainment",Toast.LENGTH_SHORT).show();}


    //On clicking the plus sign
    public void ButtonToDeposit(View view){
        Intent intent =new Intent(this,Activity5.class);
        startActivity(intent);
    }

    //On clicking the minus sign
    public void ButtonToWithdraw(View view){
        Intent intent2=new Intent(this,Activity2.class);
        startActivity(intent2);
    }

//    On clicking the Details link
    @Override
    public void onClick(View v) {
        Intent intent3 = new Intent(this, Activity3.class);
        startActivity(intent3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            Intent i = new Intent(this, Activity7.class);
            startActivity(i);
        }

            return super.onOptionsItemSelected(item);
    }
}