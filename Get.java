package com.example.yaboyzc.torntrack;

import android.content.Context;
import android.widget.TextView;
import android.app.*;

import org.json.JSONObject;

public class Get {

    // Initialize context
    private Context context;

    Get(Context context) {
        this.context = context;
    }

    public void getName(JSONObject response) {
        TextView name = ((Activity) context).findViewById(R.id.name);

        // Parse name
        try {
            String user = response.get("name").toString();
            name.setText(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseBars(JSONObject response) {
        TextView happy = ((Activity) context).findViewById(R.id.happy);
        TextView energy = ((Activity) context).findViewById(R.id.energy);
        TextView nerve = ((Activity) context).findViewById(R.id.nerve);

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
