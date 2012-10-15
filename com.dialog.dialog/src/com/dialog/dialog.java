package com.dialog;

import android.app.Activity;
import android.app.AlertDialog;
//import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class dialog extends Activity {
	Button alertBtn,listBtn,radioBtn,customBtn;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        alertBtn=(Button)findViewById(R.id.alertBtn);
        alertBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				memanggil(1);
			}
		});
        listBtn=(Button)findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				memanggil(2);
			}
		});
        radioBtn=(Button)findViewById(R.id.radioBtn);
        radioBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				memanggil(3);
			}
		});
        customBtn=(Button)findViewById(R.id.customBtn);
        customBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				memanggil(4);
			}
		});
    }
    private void memanggil(int arg){
    	if(arg==1){
    		AlertDialog.Builder bd=new AlertDialog.Builder(this);
    		bd.setMessage("Anda yakin ingin keluar?")
    		.setCancelable(false)
    		.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					// TODO Auto-generated method stub
					dialog.this.finish();
				}
			})
			.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dg, int id) {
					// TODO Auto-generated method stub
					dg.cancel();
				}
			}).show();
    	}else if(arg==2){
    		final CharSequence[] items={"Merah","Kuning","Biru"};
    		AlertDialog.Builder bd=new AlertDialog.Builder(this);
    		bd.setTitle("Pilih warnamu");
    		bd.setItems(items, new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dg, int itm) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), items[itm], Toast.LENGTH_SHORT).show();
				}
			}).show();
    	}else if(arg==3){
    		final CharSequence[] items={"Es Teh","Es Jeruk","Jus Jeruk"};
    		AlertDialog.Builder bd=new AlertDialog.Builder(this);
    		bd.setTitle("Pilih Minuman");
    		bd.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {		
				public void onClick(DialogInterface dg, int itm) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), items[itm], Toast.LENGTH_SHORT).show();
				}
			}).show();
    	}else if(arg==4){
    		AlertDialog.Builder bd;
    		@SuppressWarnings("unused")
			AlertDialog alertd;
    		
    		Context mContext=getApplicationContext();
    		LayoutInflater  inflater=(LayoutInflater)mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
    		View layout=inflater.inflate(R.layout.cdialog,(ViewGroup)findViewById(R.id.layout_root));
    		
    		TextView txt=(TextView)layout.findViewById(R.id.text);
    		txt.setText("Ini adalah custom dialog");
    		ImageView img=(ImageView)layout.findViewById(R.id.image);
    		img.setImageResource(R.drawable.icon);
    		
    		bd=new AlertDialog.Builder(mContext);
    		bd.setView(layout);
    		alertd =bd.create();
    	}
    }
}