package com.girigb1995.kank.AdDict;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button bAddHindi;
	TextView tvAddHindi, tvTESTING;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialise();

		final AssetManager am = getAssets();

		bAddHindi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// To load text file
				InputStream input;
				try {
					input = am.open("filehindi.txt");

					int size = input.available();
					byte[] buffer = new byte[size];
					input.read(buffer);
					input.close();

					// byte buffer into a string
					String text = new String(buffer);

					for (String retval : text.split(" ")) {
						UserDictionary.Words.addWord( getApplicationContext() , retval, 250
								,null,null);
					}

					tvTESTING.setText(text);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

	private void initialise() {
		// TODO Auto-generated method stub
		bAddHindi = (Button) findViewById(R.id.bAddHindi);
		tvAddHindi = (TextView) findViewById(R.id.tvAddHindi);
		tvTESTING = (TextView) findViewById(R.id.tvTESTING);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
