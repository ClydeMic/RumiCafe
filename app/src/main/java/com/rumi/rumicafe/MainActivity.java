package com.rumi.rumicafe;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "MY KEY FOR ORDER MESSAGE";
    public String url = "www.allrecipes.com/recipes/79/desserts/";
    public String location ="Maziwa, Nairobi ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  // Define ActionBar object
        ActionBar actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FFFF00"));
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Implement an explicit intent for opening the order activity
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
            }
        });
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

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
        //}


        //Create a switch item block to handle
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
                return true;

            case R.id.action_call:
                //Implement an implicit intent that calls your no.
                Uri myUri = Uri.parse("tel:0795948595");
               Intent myIntent = new Intent(Intent.ACTION_DIAL,myUri);
               startActivity(myIntent);
               return true;

            case R.id.action_aboutUs:
                Uri webUri = Uri.parse(url);
                Intent addIntent = new Intent(Intent.ACTION_VIEW,webUri);
                startActivity(addIntent);
                return true;

            case R.id.action_locate:
                Uri addressUri = Uri.parse("geo:0,0?q=" + location);
                Intent addressIntent = new Intent(Intent.ACTION_VIEW,addressUri);
                startActivity(addressIntent);
                return true;


            default:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //Displaying toasts
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showiceCreamMessage(View view) {
        //Define what will happen when the user clicks on the image view e.g Showing a Toast,Adding an item to a shopping cart.
       // displayToast(getString(R.string.icecream_order));
        mOrderMessage =getString(R.string.icecream_order);
        displayToast(mOrderMessage);
    }

    public void showdoughnutMessage(View view) {
       // displayToast(getString(R.string.doughnut_order));
        mOrderMessage =getString(R.string.doughnut_order);
        displayToast(mOrderMessage);
    }

    public void showfroyoMessage(View view) {
        //displayToast(getString(R.string.froyo_order));
        mOrderMessage =getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}
