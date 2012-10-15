package com.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class KotakDialog extends Activity 
 implements OnClickListener {
	Button pesanToast;
	Button keluar;
	Button tampilList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		pesanToast = (Button) findViewById(R.id.toastBtn);
		pesanToast.setOnClickListener(this);

		keluar = (Button) findViewById(R.id.exitBtn);
		keluar.setOnClickListener(this);

		tampilList = (Button) findViewById(R.id.listDialogBtn);
		tampilList.setOnClickListener(this);

	}

	public void onClick(View clicked) {
		switch (clicked.getId()) {
		case R.id.listDialogBtn:
			munculListDialog();
			break;
		case R.id.toastBtn:
			Toast.makeText(this, "Anda memilih Toast", 
			Toast.LENGTH_SHORT).show();
			break;
		case R.id.exitBtn:
			exit();
			break;
		}
	}

	private void munculListDialog() {
		// TODO Auto-generated method stub
		final CharSequence[] items = { 
				"Es Teh", 
				"Es Jeruk", 
				"Lemon Squash",
				"Soft Drink" };

		AlertDialog.Builder kk = new AlertDialog.Builder(this);
		kk.setTitle("Pilih Minuman");
		kk.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				Toast.makeText(getApplicationContext(), items[2],
						Toast.LENGTH_SHORT).show();
			}
		}).show();
	}

	private void exit() {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Apakah Anda Benar-Benar ingin keluar?")
		 .setCancelable(false)
		 .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				KotakDialog.this.finish();
				}
			})
		 .setNegativeButton("Tidak",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int arg1) {
						// TODO Auto-generated method stub
						dialog.cancel();
						}
					}).show();
	}
}
