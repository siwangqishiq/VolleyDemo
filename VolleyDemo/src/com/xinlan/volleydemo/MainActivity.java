package com.xinlan.volleydemo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public final class MainActivity extends Activity {
	private TextView text;

	public String url = "http://www.baidu.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);

		RequestQueue queue = Volley.newRequestQueue(this);
		StringRequest request = new StringRequest(Request.Method.GET, url,
				new Listener<String>() {
					@Override
					public void onResponse(String response) {
						text.setText("response-->" + response);
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						text.setText("error-->" + error.getMessage());
					}
				});

		queue.add(request);
	}
}// end class
