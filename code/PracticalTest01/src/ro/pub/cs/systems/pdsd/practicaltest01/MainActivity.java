package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static String nume = "Dincu";
	private static String email = "andrei.dincu@gmail.com";
	private static String phone = "0723161108";
	private static int whatClicked = -1;
	
	final private static int ANOTHER_ACTIVITY_REQUEST_CODE = 2015;

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (requestCode) {
		case ANOTHER_ACTIVITY_REQUEST_CODE:
			if (resultCode == Activity.RESULT_OK) {
				Bundle data = intent.getExtras();
				Toast.makeText(MainActivity.this, data.getString("code"), Toast.LENGTH_SHORT).show();
			}
			break;

		}
	}

	public class MyClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Button numeButton = (Button) findViewById(R.id.name);
			Button phoneButton = (Button) findViewById(R.id.phone);
			Button emailButton = (Button) findViewById(R.id.email);
			EditText editText = (EditText) findViewById(R.id.mesaj);
			Button nextActivityButton = (Button) findViewById(R.id.next_activity);
			// TODO Auto-generated method stub
			if (numeButton.getId() == v.getId()) {
				if (whatClicked == 1) {
					email = editText.getText().toString();
				}
				else if (whatClicked == 2) {
					phone = editText.getText().toString();
				}
				editText.setText(nume);
				whatClicked = 0;

			} else if (emailButton.getId() == v.getId()) {
				if (whatClicked == 0) {
					nume = editText.getText().toString();
				}
				else if (whatClicked == 2) {
					phone = editText.getText().toString();
				}
				editText.setText(email);
				whatClicked = 1;
			}
			
			else if (phoneButton.getId() == v.getId()) {
				if (whatClicked == 0) {
					nume = editText.getText().toString();
				}
				else if (whatClicked == 1) {
					email = editText.getText().toString();
				}
				editText.setText(phone);
				whatClicked = 2;
			}
			else if (nextActivityButton.getId() == v.getId()) {
				Intent intent = new Intent(
						"ro.pub.cs.systems.pdsd.practicaltest01.PracticalTest01SecondaryActivity");
				intent.putExtra("name",nume);
				intent.putExtra("phone",phone);
				intent.putExtra("email",email);
				intent.putExtra("whatClicked",whatClicked);
				startActivityForResult(intent, ANOTHER_ACTIVITY_REQUEST_CODE);
			}

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button numeButton = (Button) findViewById(R.id.name);
		Button prenumeButton = (Button) findViewById(R.id.phone);
		Button emailButton = (Button) findViewById(R.id.email);
		Button nextActivityButton = (Button) findViewById(R.id.next_activity);
		MyClickListener clkListener = new MyClickListener();
		numeButton.setOnClickListener(clkListener);
		prenumeButton.setOnClickListener(clkListener);
		emailButton.setOnClickListener(clkListener);
		nextActivityButton.setOnClickListener(clkListener);
		
		if (savedInstanceState != null) {
			whatClicked = savedInstanceState.getInt("name");
			nume = savedInstanceState.getString("name");
			email = savedInstanceState.getString("email");
			phone = savedInstanceState.getString("phone");
		}
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
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		whatClicked = savedInstanceState.getInt("name");
		nume = savedInstanceState.getString("name");
		email = savedInstanceState.getString("email");
		phone = savedInstanceState.getString("phone");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("whatClicked", whatClicked);
		outState.putString("name", nume);
		outState.putString("email",email);
		outState.putString("phone", phone);
	}
}
