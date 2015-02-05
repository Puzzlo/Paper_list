package com.puzzlo.paper_list;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String[] paper, glue;
    ArrayAdapter<String> lvAdapterPaper, lvAdapterGlue;
    ListView lvPaper, lvGlue;
    TextView stroka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        stroka = (TextView) findViewById(R.id.inputString);
        stroka.setText("formedeblement");

        // make adapter for paper
        paper = getResources().getStringArray(R.array.listOfPaper);
        lvAdapterPaper = new ArrayAdapter<String>(this, R.layout.item_of_paper, paper);
        lvPaper = (ListView) findViewById(R.id.listPaper);
        lvPaper.setAdapter(lvAdapterPaper);
        // make adapter for glue
        glue = getResources().getStringArray(R.array.listOfGlue);
        lvAdapterGlue = new ArrayAdapter<String>(this, R.layout.item_of_paper, glue);
        lvGlue = (ListView) findViewById(R.id.listGlue);
        lvGlue.setAdapter(lvAdapterGlue);





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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
