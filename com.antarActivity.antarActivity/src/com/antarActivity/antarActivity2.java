package com.antarActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class antarActivity2 extends Activity {
	TextView hasil;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout2);

		Bundle bb = this.getIntent().getExtras();
		String param1 = bb.getString("nama");

		hasil = (TextView) findViewById(R.id.hasil);
		hasil.setText("Halo " + param1);

	}
}