package com.example.yaboyzc.torntrack;

import android.content.Context;
import android.widget.TextView;
import android.app.*;
import android.widget.Toast;

import org.json.JSONObject;


public class Get {

    // Initialize context
    private Context context;

    public Get(Context context) {
        this.context = context;
    }

    public void getName() {
        TextView name = ((Activity)context).findViewById(R.id.name);
        
        try {



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void parseResponse(JSONObject response) {
        TextView happy = ((Activity)context).findViewById(R.id.happy);
        TextView energy = ((Activity)context).findViewById(R.id.energy);
        TextView nerve = ((Activity)context).findViewById(R.id.nerve);

        // Parse array
        try {
            String hap = "Happy: " + response.getJSONObject("happy").getString("current");
            happy.setText(hap);

            String ene = "Energy: " + response.getJSONObject("energy").getString("current");
            energy.setText(ene);

            String ner = "Nerve: " + response.getJSONObject("nerve").getString("current");
            nerve.setText(ner);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
