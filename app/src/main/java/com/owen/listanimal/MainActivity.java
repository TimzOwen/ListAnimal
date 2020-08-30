package com.owen.listanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // solution 1
        //First find the ID related to the list view in our xml
        final ListView listAnimal = findViewById(R.id.list_view_animals);

        //Step 2 Soln 2
        //use array adapter to display the layout on the emulator.
        final ArrayAdapter<CharSequence> animalsAdapater = ArrayAdapter.createFromResource(this,
                R.array.animals_array, android.R.layout.simple_list_item_1);

        //step 3 sonl 3
        //add the created views on your adapter
        listAnimal.setAdapter(animalsAdapater);

        //Step 4 soln 4
        // attach items click listener to each item clicked
        listAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Step 5 sol 5
                //attach each element clicked to the index and show a pop up message both in french and English
                String message = getString(R.string.message) + " " +  animalsAdapater.getItem(position);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

    }
}