package com.christophercoleman.generate;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    static final int DEFAULT_SIZE = 1000;

    private randomNumber random = new randomNumber(DEFAULT_SIZE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button change = (Button) findViewById(R.id.generateNumber);
        change.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.generateNumber:
                    EditText inputTxt = (EditText) findViewById(R.id.randomLimit);
                    String limit;
                    if(!(TextUtils.isEmpty(inputTxt.getText().toString())))
                        limit = inputTxt.getText().toString();
                    else
                        limit = "1000";
                    int limitNumber = Integer.parseInt(limit);
                    if(random.checkInput(limitNumber))
                        random.setMaxNumberLimit(limitNumber);
                    else
                        random.setMaxNumberLimit(DEFAULT_SIZE);
                    break;
            }
            random.setRandomNumber();
            final TextView textViewToChange = (TextView) findViewById(R.id.textViewNumber);
            int number = random.getRandomNumber();
            String finalNumber = Integer.toString(number);
            textViewToChange.setText(finalNumber);
        }
    };


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
