package com.login.db;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginDB extends Activity implements OnClickListener {
	String namaHari = "";
	TextView date;
	Button loginBtn, signupBtn;
	EditText inUser, inPass;
	private String url = "http://10.0.2.2/android/loginKuliah.php";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		inUser = (EditText) findViewById(R.id.inputUser);

		inPass = (EditText) findViewById(R.id.inputPass);
		loginBtn = (Button) findViewById(R.id.btnLogin);
		loginBtn.setOnClickListener(this);

		date = (TextView) findViewById(R.id.date);
	final Calendar hari = Calendar.getInstance();
		int hr = hari.get(Calendar.DAY_OF_WEEK);
		switch (hr) {
		case 1:
			namaHari = "Senin";
			// date.setText(new StringBuilder().append(hr));
			date.setText(namaHari);
			break;
		case 2:
			namaHari = "Selasa";
			date.setText(namaHari);
			break;
		case 3:
			namaHari = "Rabu";
			date.setText(namaHari);
			break;
		case 4:
			namaHari = "Kamis";
			date.setText(namaHari);
			break;
		case 5:
			namaHari = "Jumat";
			date.setText(namaHari);
			break;
		case 6:
			namaHari = "Sabtu";
			date.setText(namaHari);
			break;
		case 7:
			namaHari = "Minggu";
			date.setText(namaHari);
			break;
		default:
			namaHari = "Sekarang hari";
			date.setText(namaHari);

		}

		
	}

	public void onClick(View btn) {
		// TODO Auto-generated method stub
		login();
		//pindahActivity();
	}

	private void login() {
		// TODO Auto-generated method stub
		// input username pake nim
		ArrayList<NameValuePair> kirimParameter = new ArrayList<NameValuePair>();
		kirimParameter.add(new BasicNameValuePair("nim", inUser.getText()
				.toString()));
		kirimParameter.add(new BasicNameValuePair("pass", inPass.getText()
				.toString()));
		kirimParameter.add(new BasicNameValuePair("hari",namaHari));
		// String valid="1";
		String respon = null;
		try {
			respon = ClientToServer.eksekusiHttpPost(url, kirimParameter);
			String res = respon.toString();
			res = res.trim();
			res = res.replaceAll("\\s+", "");
			Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
			if (res.equals("1")) {
				Toast.makeText(this, "Username dan password sama",
						Toast.LENGTH_SHORT).show();
				pindahActivity();
			} else {
				Toast.makeText(this, "Ups!!Username dan password salah",
						Toast.LENGTH_SHORT).show();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}

	}

	private void pindahActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, TampilJadwal.class);
		startActivity(i);
	}
}