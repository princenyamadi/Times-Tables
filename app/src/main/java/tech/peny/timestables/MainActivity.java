package tech.peny.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView tableView;
    SeekBar seekBar;
    ArrayList<String> multi;
    public void generateTimesTables(int timesTableNumber){
        multi = new ArrayList<String>();
        for (int i = 1 ; i <= 100; i++ ){

            multi.add(Integer.toString(timesTableNumber * i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,multi);
        tableView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableView = (ListView) findViewById(R.id.tableView);


//        seekbar config
        seekBar  = (SeekBar) findViewById(R.id.seekBar);
        int startingPoint = 10;
        int maxPoint = 20;
        seekBar.setMax(maxPoint);
        seekBar.setProgress(startingPoint);
//        seekBar.getProgress();
        generateTimesTables(seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
            int timesTableNumber;

                Log.i("Seekbar", Integer.toString(progress));
                if(progress < min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }else{
                    timesTableNumber = seekBar.getProgress();
                    generateTimesTables(timesTableNumber);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        tableView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Item Selected",multi.get(position));
            }
        });


    }
}