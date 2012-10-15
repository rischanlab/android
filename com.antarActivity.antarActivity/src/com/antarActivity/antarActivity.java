package com.antarActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class antarActivity extends Activity {
	Button kirim;
	EditText data;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		data = (EditText) findViewById(R.id.data);
		kirim = (Button) findViewById(R.id.kirimBtn);
		kirim.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				aksi();
			}
		});
	}
	private void aksi(){
		String nama=data.getText().toString();
		String txtnama=String.valueOf(nama);
		
		Bundle bundle=new Bundle();
		bundle.putString("nama", txtnama);
		
		Intent newIntent=new Intent(antarActivity.this,antarActivity2.class);
		newIntent.putExtras(bundle);
		startActivityForResult(newIntent,0);
	}
}