package com.boomtown.ckesho.robobindingexample;

import android.app.Activity;
import android.os.Binder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.robobinding.binder.Binders;
import org.robobinding.binder.*;


import java.util.ArrayList;

public class Main extends Activity {

    ListView listView;

    ArrayList<CustomViewData> list= new ArrayList<CustomViewData>();

    CustomViewAdapter customViewAdapter;

    //dont need
    ArrayAdapter<String> arrayAdapterString;
    String myString[]= new String[5];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PresentationModel1 presentationModel1 = new PresentationModel1();
        //the difference between inflateAndBind vs inflateAndBindWithoutPreInitializingViews?
        //Note: inflateAndBind works
        View rootview = Binders.inflateAndBind(this, R.layout.index, presentationModel1);
        setContentView(rootview);
        //setContentView(R.layout.index);

        //What is custom view binding description
        //BinderFactoryBuilder bfbuilder= new BinderFactoryBuilder();


        list.add(new CustomViewData("Chris", "9999999999", "chris@chris.com"));
        list.add(new CustomViewData("James", "9999999999", "james@james.com"));
        list.add( new CustomViewData("Alex", "9999999999", "alex@alex.com"));
        list.add( new CustomViewData("SJ", "9999999999", "donotreply.com"));

        listView=(ListView)findViewById(R.id.listView);

        customViewAdapter= new CustomViewAdapter(getBaseContext(),R.layout.itemlayout,list);

        //dont need
        /*
        myString[0]="space0";
        myString[1]="space1";
        myString[2]="space2";
        myString[3]="space3";
        myString[4]="space4";
        arrayAdapterString= new ArrayAdapter<String>(getBaseContext(),R.layout.itemlayout,R.id.tvEmail, myString);
        listView.setAdapter(arrayAdapterString);
        */


        listView.setAdapter(customViewAdapter);



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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
