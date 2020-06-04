package sg.edu.rp.c346.id19036308.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement,etIndexElement;
    Button btnAdd,btnRemove, btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);


        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String coloursName = etElement.getText().toString();
                //alColours.add(coloursName);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, coloursName);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }

        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                etIndexElement.setText(null);
                Toast.makeText(MainActivity.this, "Colour deleted.", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String element1 = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos,element1);
                aaColour.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Colour updated.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
