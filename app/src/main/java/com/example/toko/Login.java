package com.example.toko;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button login;
    TextView un, pass;
    Preferences sharedPreferences;
    Context mContext;
    ProgressDialog loading;
    String nama, jabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);

        un = findViewById(R.id.t_user);
        pass = findViewById(R.id.t_pass);
        nama = "Andi Setiawan Budi";
        jabatan = "Pengelola";
        login = findViewById(R.id.b_login);
        sharedPreferences = new Preferences(this);
        mContext=this;

        if(sharedPreferences.getLogged()){
            startActivity(new Intent(getApplicationContext(), Nav.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                postRequest();
//                if (un.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
//                    saveData();
//                    startActivity(new Intent(getApplicationContext(), Nav.class));
//                    finish();
//                }else{
//                    Toast.makeText(mContext,"Username dan password salah !",Toast.LENGTH_SHORT).show();
//                }
            }
        });




    }


    private void postRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
        String url = "https://script.google.com/macros/s/AKfycbykQlZx4OHlA5j_xKaOMyqzhST6J8F03D7yxr0-ryYAbcWxG1M/exec";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //let's parse json data
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if(jsonObject.getBoolean("isSuccess")){
                        sharedPreferences.saveString(Preferences.NAMA, jsonObject.getJSONObject("user").getString("nama"));
                        sharedPreferences.saveString(Preferences.JABATAN, jsonObject.getJSONObject("user").getString("jabatan"));
                        sharedPreferences.saveBoolean(Preferences.LOGGED, true);
                        startActivity(new Intent(getApplicationContext(), Nav.class));
                        finish();

                    }else{
                        loading.dismiss();
                        Toast.makeText(mContext,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                    loading.dismiss();
                    Toast.makeText(mContext,"POST DATA : unable to Parse Json",Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(mContext,"Post Data : Response Failed",Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params=new HashMap<>();
                params.put("action","a_login");
                params.put("username",un.getText().toString());
                params.put("password",pass.getText().toString());

                return params;
            }

            @Override
            public Map<String,String> getHeaders()  {
                Map<String,String> params=new HashMap<>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };

        requestQueue.add(stringRequest);

    }

}


