package com.example.sqlearn;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insert_btn)
    Button insertBtn;
    @BindView(R.id.delete_btn)
    Button deleteBtn;
    @BindView(R.id.update_btn)
    Button updateBtn;
    @BindView(R.id.query_btn)
    Button queryBtn;

    private SQLiteDatabase mSqLiteDatabase;
    private DBHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mDbHelper = new DBHelper(this);
        mSqLiteDatabase = mDbHelper.getWritableDatabase();
    }

    @OnClick({R.id.insert_btn, R.id.delete_btn, R.id.update_btn, R.id.query_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insert_btn:
                insertData();
                break;
            case R.id.delete_btn:
                deleteData();
                break;
            case R.id.update_btn:
                updateData();
                break;
            case R.id.query_btn:
                queryData();
                break;
        }
    }

    private void insertData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME,"崔娟娟");
        contentValues.put(DBHelper.AGE,17);
        mSqLiteDatabase.insert(DBHelper.TABLE_NAME,null,contentValues);
    }

    private void deleteData() {
        int count = mSqLiteDatabase.delete(DBHelper.TABLE_NAME,DBHelper.NAME+" = ?",new String[]{"崔娟娟"});
        Toast.makeText(this, "删除数量："+count, Toast.LENGTH_SHORT).show();
    }

    private void updateData() {

    }

    private void queryData() {

    }


}
