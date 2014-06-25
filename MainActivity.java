package com.example.conect1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
	
	RequestQueue queue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		queue = Volley.newRequestQueue(this);
		final TextView textview1 = (TextView)findViewById(R.id.textview1);
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Data1 r = new Data1(Method.GET, "http://ougou80.web.fc2.com/inside/proxy.txt", new Listener<String>() {
					@Override
					public void onResponse(String response) {
						textview1.setText(response);
					}
				}, null);
				queue.add(r);
			}
		});
		
		

	}
	
	protected void onStart(){
		super.onStart();
		
		queue.start();
	}
	
	protected void onStop(){
		super.onStop();
		
		queue.stop();
	}

}
