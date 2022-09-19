package com.example.approvalmatrix;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {
    private Context context;

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ApprovalMatrix.db";

    // Matrix table name
    private static final String TABLE_NAME = "matrix";

    // Matrix Table Columns names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_FEATURE = "feature";
    private static final String COLUMN_MIN_APPROVAL = "min_approval";
    private static final String COLUMN_MAX_APPROVAL = "max_approval";
    private static final String COLUMN_TOTAL_APPROVAL = "number_of_approval";


    SQLiteDatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_FEATURE + " TEXT,"
                + COLUMN_MIN_APPROVAL + " LONG,"
                + COLUMN_MAX_APPROVAL + " LONG,"
                + COLUMN_TOTAL_APPROVAL + " LONG" + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Adding new matrix
    void addMatrix(Matrix matrix) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, matrix.getName());
        values.put(COLUMN_FEATURE, matrix.getFeature());
        values.put(COLUMN_MIN_APPROVAL, matrix.getMinApproval());
        values.put(COLUMN_MAX_APPROVAL, matrix.getMaxApproval());
        values.put(COLUMN_TOTAL_APPROVAL, matrix.getNumOfApproval());

        // Inserting Row
        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }
}
