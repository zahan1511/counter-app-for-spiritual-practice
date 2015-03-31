package com.example.tasbih;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Hotornot  {

	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="persons_name";
	public static final String KEY_VALUE="Persons_value";
	
	private static final String DATABASE_NAME ="hotornotdb";
	private static final String DATABASE_TABLE ="peopletable";
	private static final int DATABASE_VERSION = 1 ;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION );
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
			KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " +
			KEY_VALUE + " INTEGER);"
			);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
		
		
		
	}
	
	public Hotornot(Context c)
	{
		ourContext=c;
	}
	public Hotornot open() throws SQLException{
		ourHelper= new DbHelper(ourContext, null, null, 0);
		ourDatabase=ourHelper.getWritableDatabase();
		return this;
	}
	public void close()
	{
		ourHelper.close();
	}
	public long createEntry(String name, int value) {
		// TODO Auto-generated method stub
		
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_VALUE, value);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
	}
	
	public List<String> getvalue() {
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_VALUE};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result="";
	    List<String> results1 = new ArrayList<String>();
	    int iRow=c.getColumnIndex(KEY_ROWID);
		int iName=c.getColumnIndex(KEY_NAME);
		int iValue=c.getColumnIndex(KEY_VALUE);

	    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	        results1.add( " "+c.getString(iName)+ "\n \n "+ " "+ c.getString(iValue) + "  times");
	    }
	    return results1;
	}

	public void delete(String del) throws SQLException {
		// TODO Auto-generated method stub
		long l = 0;
        String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_VALUE};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result="";
	   
	    int iRow=c.getColumnIndex(KEY_ROWID);
		int iName=c.getColumnIndex(KEY_NAME);
		int iValue=c.getColumnIndex(KEY_VALUE);

	    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	        result=" "+c.getString(iName)+ "\n \n "+ " "+ c.getString(iValue) + "  times";
	        if(result.equals(del))
	        {
	           l=Long.parseLong(c.getString(iRow));
	           break;
	        }
                
	    }
	    
	    ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + l,null );
		
			
	}
	public String getname(String del) {
		// TODO Auto-generated method stub
		
		long l = 0;
        String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_VALUE};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result="";
		String name="";
	   
	    int iRow=c.getColumnIndex(KEY_ROWID);
		int iName=c.getColumnIndex(KEY_NAME);
		int iValue=c.getColumnIndex(KEY_VALUE);

	    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	        result=" "+c.getString(iName)+ "\n \n "+ " "+ c.getString(iValue) + "  times";
	        if(result.equals(del))
	        {
	           name=c.getString(iName);
	           break;
	        }
                
	    }
		
		return name;
	}
	public int gettotal(String del) {
		// TODO Auto-generated method stub
		int go = 0;
        String[] columns=new String[]{KEY_ROWID,KEY_NAME,KEY_VALUE};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result="";
	   
	    int iRow=c.getColumnIndex(KEY_ROWID);
		int iName=c.getColumnIndex(KEY_NAME);
		int iValue=c.getColumnIndex(KEY_VALUE);

	    for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
	        result=" "+c.getString(iName)+ "\n \n "+ " "+ c.getString(iValue) + "  times";
	        if(result.equals(del))
	        {
	           go=Integer.parseInt(c.getString(iValue));
	           break;
	        }
                
	    }

		return go;
	}			

}
