package and.db;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class dbActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		dbAdapter db = new dbAdapter(this);
		db.open();
		db.insertTitle("123321", "buku Mabuk", "ANDI");
		db.insertTitle("456654", "Bljr Android", "GAMA");

		Cursor c = db.getAllTitles();
		if (c.moveToFirst()) {
			do {
				DisplayTitle(c);
			} while (c.moveToNext());
		}
		db.close();
		// ---get a title---
		/*
		 * db.open(); Cursor c = db.getTitle(2); if (c.moveToFirst())
		 * DisplayTitle(c); else Toast.makeText(this, "No title found",
		 * Toast.LENGTH_LONG).show(); db.close(); //---delete a title---
		 * db.open(); if (db.deleteTitle(1)) Toast.makeText(this,
		 * "Delete successful.", Toast.LENGTH_LONG).show(); else
		 * Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
		 * db.close();
		 */

	}

	private void DisplayTitle(Cursor c) {
		// TODO Auto-generated method stub
		Toast.makeText(
				this,
				"id: " + c.getString(0) + "\n" + "isbn: " + c.getString(1)
						+ "\n" + "Publisher : " + c.getString(3),
				Toast.LENGTH_LONG).show();
	}
}