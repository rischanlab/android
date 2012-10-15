package com.android.database;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class DatabaseActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DBAdapter db = new DBAdapter(this);
      //---add 2 titles---
        //---add 2 titles---
        db.open();        
        Cursor c = db.getAllTitles();
        if (c.moveToFirst())
        {
            do {          
                DisplayTitle(c);
            } while (c.moveToNext());
        }
        db.close();
    }
    public void DisplayTitle(Cursor c)
    {
        Toast.makeText(this, 
                "id: " + c.getString(0) + "\n" +
                "ISBN: " + c.getString(1) + "\n" +
                "TITLE: " + c.getString(2) + "\n" +
                "PUBLISHER:  " + c.getString(3),
                Toast.LENGTH_LONG).show();        
    } 


}