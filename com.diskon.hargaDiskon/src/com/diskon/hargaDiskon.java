package com.diskon;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class hargaDiskon extends Activity {
	EditText harga, diskon;
	TextView hargabaru, hmt;
	Editable isiharga, isidiskon;
	Button reset;
	ImageButton htng;
	String sharga, sdiskon;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		hargabaru = (TextView) findViewById(R.id.hasil);
		harga = (EditText) findViewById(R.id.harga);
		diskon = (EditText) findViewById(R.id.diskon);
		hmt = (TextView) findViewById(R.id.hemat);
		reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(new reset());
		htng = (ImageButton) findViewById(R.id.imageButton1);
		htng.setOnClickListener(new itung());

	}

	private class itung implements OnClickListener {
		public void onClick(View v) {
			try {
				Double h = Double.parseDouble(harga.getText().toString());
				Double d = Double.parseDouble(diskon.getText().toString());
				Double nd = (d / 100) * h;
				double hsl = h - nd;
				Number irit = h - hsl;
				DecimalFormat df = new DecimalFormat("@@##");
				hargabaru.setText("Rp." + df.format(hsl) + ",00");
				hmt.setText("Wow!! Anda Hemat Rp." + df.format(irit) + " !!");
			} catch (Exception e) {
			}
			;
		}
	}

	public class reset implements OnClickListener {
		public void onClick(View v) {
			hargabaru.setText("");
			harga.setText("");
			diskon.setText("");
			hmt.setText("");
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, 0, 0, "Tutorial");
		menu.add(0, 1, 0, "Info");
		menu.add(0, 2, 0, "Keluar");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == 0) {
			new AlertDialog.Builder(this)
					.setTitle("Info Aplikasi")
					.setMessage(
							"1. Masukkan harga asli"
						 +"\n2. Masukkan besar diskon"
						 +"\n3. Klik gambar HITUNG DISKON!"
						 +"\n4. Klik tombol Reset untuk mengosongkan data")
					.setNeutralButton("Kembali",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface arg0,
										int arg1) { //
									// TODO Auto-generated method stub
								}
							}).show();
		}else if (item.getItemId() == 1) {
			new AlertDialog.Builder(this)
					.setTitle("Info Aplikasi")
					.setMessage(
							"Aplikasi DISKON! dibuat oleh OmAyib2011."
									+ "Kunjungi www.omayib.com.")
					.setNeutralButton("Kembali",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface arg0,
										int arg1) { //
									// TODO Auto-generated method stub

								}
							}).show();
		} else if (item.getItemId() == 2) {
			hargaDiskon.this.finish();
		}
		return true;
	}
}