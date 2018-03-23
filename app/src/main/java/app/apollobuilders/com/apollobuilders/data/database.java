package app.apollobuilders.com.apollobuilders.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Varun on 5/8/2016.
 */
public class database extends SQLiteOpenHelper{

    public database(Context context){

        super(context,"User",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table_name="UserDetails";

        String command="Create Table "+table_name+"(FirstName text,LastName text,Email text,Phone text,Password text,Address text)";
        db.execSQL(command);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InputDetails(javabeans j)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("FirstName",j.getFirstName());
        values.put("LastName",j.getLastName());
        values.put("Email",j.getEmail());
        values.put("Phone",j.getPhone());
        values.put("Password",j.getPassword());
        values.put("Address",j.getAddress());

        db.insert("UserDetails",null,values);

    }

    public javabeans getData()
    {
        javabeans jb=new javabeans();
        SQLiteDatabase db=this.getReadableDatabase();
        String command2="Select * from UserDetails";
        Cursor c=db.rawQuery(command2,null);

        if (c.moveToFirst())
        {
            jb.setFirstName(c.getString(0));
            jb.setLastName(c.getString(1));
            jb.setEmail(c.getString(2));
            jb.setPhone(c.getString(3));
            jb.setPassword(c.getString(4));
            jb.setAddress(c.getString(5));



        }

        return jb;
    }
}
