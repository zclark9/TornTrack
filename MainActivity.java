package com.example.yaboyzc.torntrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.security.spec.ECField;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Torn Check";

    private static RequestQueue requestQueue;

    final ProgressBar progressBar = findViewById(R.id.progressBar2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main);

        final TextView happy = findViewById(R.id.happy);
        happy.setText("");
        final TextView energy = findViewById(R.id.energy);
        energy.setText("");
        final TextView nerve = findViewById(R.id.nerve);
        nerve.setText("");


        final Button button = findViewById(R.id.update);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "start API");
                callAPI();
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void callAPI () {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://api.torn.com/user/?selections=bars&key=JlDIvev6",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d(TAG, response.toString());
                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                            parseResponse(response);

                        }
                        }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.w(TAG, error.toString());

                        }
                    });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void parseResponse(JSONObject response) {
        TextView happy = findViewById(R.id.happy);
        TextView energy = findViewById(R.id.energy);
        TextView nerve = findViewById(R.id.nerve);

        // Parse array
        try {
            JSONArray hapArr = response.getJSONArray("happy");
            JSONArray engArr = response.getJSONArray("energy");
            JSONArray nerArr = response.getJSONArray("nerve");

            happy.setText(hapArr.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
