package and.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbAdapter {
	public static final String KEY_ROWID="_id";
	public static final String KEY_ISBN="isbn";
	public static final String KEY_TITLE="title";
	public static final String KEY_PUBLISHER="publisher";
	private static final String TAG="dbAdapter";
	
	private static final String DATABASE_NAME="books";
	private static final String DATABASE_TABLE="titles";
	private static final int DATABASE_VERSION=1;
	
	private static final String DATABASE_CREATE=
		"create table titles (_id integer primary key autoincrement,"
		+"isbn text not null, title text not null,"
		+"publisher text not null);";
	
	private final Context context;
	private DatabaseHelper dbHelper;
	private SQLiteDatabase db;
	
	public dbAdapter(Context ctx){
		this.context=ctx;
		dbHelper=new DatabaseHelper(context);
		
	}
	private static class DatabaseHelper extends SQLiteOpenHelper{
		DatabaseHelper(Context context){
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(DATABASE_CREATE);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w(TAG, "Upgrading database from version "+oldVersion
					+"to"
					+newVersion+", which will destroy old data");
			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);
		}
	}
	// open database
	public dbAdapter open() throws SQLException
	{
		db=dbHelper.getWritableDatabase();
		return this;
	}
	//--- close db
	public void close(){
		dbHelper.close();
	}
	// insert title
	public long insertTitle(String isbn,String title,String publisher){
		ContentValues iniVal=new ContentValues();
		iniVal.put(KEY_ISBN, isbn);
		iniVal.put(KEY_TITLE, title);
		iniVal.put(KEY_PUBLISHER, publisher);
		return db.insert(DATABASE_TABLE, null, iniVal); 
		
	}
	// delete judul tertentu
	public boolean deleteTitle(long rowId){
		return db.delete(DATABASE_TABLE, KEY_ROWID+"="+rowId, null)>0;
		
	}
	///----- retrieve judul
	public Cursor getAllTitles(){
		return db.query(DATABASE_TABLE, new String[]{
				KEY_ROWID,
				KEY_ISBN,
				KEY_TITLE,
				KEY_PUBLISHER}, null, null, null, null, null);
	}
	// retrieve judul tertentu..
	public Cursor getTitle(long rowId) throws SQLException{
		Cursor mCursor=db.query(true, DATABASE_TABLE, new String[]{
				KEY_ROWID,
				KEY_ISBN,
				KEY_TITLE,
				KEY_PUBLISHER}, KEY_ROWID+"="+rowId, null, null, null, null, null);
		if(mCursor !=null){
			mCursor.moveToFirst();
			
		}
		return mCursor;
	
	}
	//update title
	public boolean updateTitle(long rowId,String isbn,String title,String publisher){
		ContentValues cv=new ContentValues();
		cv.put(KEY_ISBN, isbn);
		cv.put(KEY_TITLE, title);
		cv.put(KEY_PUBLISHER, publisher);
		return db.update(DATABASE_TABLE, cv, KEY_ROWID+"="+rowId, null)>0;
	}
	
}
