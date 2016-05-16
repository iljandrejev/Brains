package com.example.ilja.brains;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private UOW uow;
    private PersonsAdapter personsAdapter;
    private Calculator calculator;
    private static final String TAG  = "Brains";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        registerReceiver(receiver,new IntentFilter("com.example.Nobrains_Math_Request"));
        //setSupportActionBar(toolbar);

        uow = new UOW(getApplicationContext());

        // start with fresh database
       //uow.DropCreateDatabase();
       // uow.SeedData();


        displayListView();
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            if(extras != null){
                Log.d(TAG, "GEt intent. Intent not empty");
                String[] mathLine = extras.getStringArray("mathLine");



                calculator = new Calculator(mathLine);

                String result = calculator.getResult();
                uow.insertMathLine(mathLine,result);
                Log.d(TAG, "getResult " + result);
                Intent backIntent = new Intent();
                backIntent.setAction("com.example.Brains_Math_Response");
                backIntent.putExtra("mathResult",result);
                Log.d(TAG, "sendREsult" );
                sendBroadcast(backIntent);

             }
        }
    };


    private void displayListView() {
        personsAdapter = new PersonsAdapter(this, uow.personRepo.getCursorAll(), uow);

        ListView listView = (ListView) findViewById(R.id.personsListView);

        // Assign adapter to ListView
        // listview will iterate over adapter, and get filled subview for every row
        listView.setAdapter(personsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the id
                String dbid =
                        cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                Toast.makeText(getApplicationContext(),
                        dbid, Toast.LENGTH_SHORT).show();

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add_person) {
            return true;
        }
        if (id == R.id.action_add_contact) {
            return true;
        }
        if (id == R.id.action_add_contacttype) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
