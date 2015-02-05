package com.puzzlo.paper_list;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {


    private final String LOG = "Log Of Andrey";

    String[] paper, glue;
    ArrayAdapter<String> lvAdapterPaper, lvAdapterGlue;
    ListView lvPaper, lvGlue;
    TextView stroka; // string on the bottom
    JSONObject jsonStroka = new JSONObject(); // json puts into file on disk
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnOk;
    Float chislo; // number from keyboard

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        stroka = (TextView) findViewById(R.id.inputString);
        stroka.setText("");
        chislo = 0F;

        // make adapter for paper
        paper = getResources().getStringArray(R.array.listOfPaper);
        lvAdapterPaper = new ArrayAdapter<String>(this, R.layout.item_of_paper, paper);
        lvPaper = (ListView) findViewById(R.id.listPaper);
        lvPaper.setAdapter(lvAdapterPaper);
        lvPaper.setOnItemClickListener(this);
        // make adapter for glue
        glue = getResources().getStringArray(R.array.listOfGlue);
        lvAdapterGlue = new ArrayAdapter<String>(this, R.layout.item_of_paper, glue);
        lvGlue = (ListView) findViewById(R.id.listGlue);
        lvGlue.setAdapter(lvAdapterGlue);
        lvGlue.setOnItemClickListener(this);
        //make listeners for buttons 0...9 + ok
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btnOk = (Button) findViewById(R.id.buttonOk);




        registerListeners();





    }



    private void registerListeners() {

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+1;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+2;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+3;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+4;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+5;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+6;
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+7;
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+8;
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chislo = chislo*10+9;
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jsonStroka.has("shirina")) {
                    try {
                        jsonStroka.put("dlina", chislo);
                        Log.d(LOG, String.valueOf(jsonStroka));
                        chislo = 0F;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        jsonStroka.put("shirina", chislo);
                        Log.d(LOG, String.valueOf(jsonStroka));
                        chislo = 0F;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.listPaper:
               // Toast.makeText(MainActivity.this, "paper = "+ paper[position], Toast.LENGTH_SHORT).show();
                stroka.setText("");
                stroka.setText(paper[position]);
                try {
                    jsonStroka.put("paper", paper[position]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.listGlue:
                //Toast.makeText(MainActivity.this, "glue = "+ glue[position], Toast.LENGTH_SHORT).show();
                stroka.setText(stroka.getText() + "    " + glue[position]);
                try {
                    jsonStroka.put("glue", glue[position]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            default:
                Toast.makeText(MainActivity.this, "чота не то нажали, нажмите то (view  = "+ view+")", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
