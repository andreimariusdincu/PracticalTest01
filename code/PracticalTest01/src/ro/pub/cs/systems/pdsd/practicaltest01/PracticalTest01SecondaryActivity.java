package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

	
	public class SecondClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Button ok = (Button) findViewById(R.id.ok);
			Button cancel = (Button) findViewById(R.id.cancel);
			Intent intentToParent = new Intent();
			if (ok.getId() == v.getId()) {
				intentToParent.putExtra("code", "1");
				setResult(RESULT_OK, intentToParent);
				finish();
			}
			else if (cancel.getId() == v.getId()) {
				intentToParent.putExtra("code", "2");
				setResult(RESULT_OK, intentToParent);
				finish();
			}
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		TextView name = (TextView) findViewById(R.id.numeView);
		TextView phone = (TextView) findViewById(R.id.phoneView);
		TextView email = (TextView) findViewById(R.id.emailView);
		Intent intent = getIntent();
		name.setText(intent.getExtras().getString("name"));
		phone.setText(intent.getExtras().getString("phone"));
		email.setText(intent.getExtras().getString("email"));
		Button ok = (Button) findViewById(R.id.ok);
		Button cancel = (Button) findViewById(R.id.cancel);
		SecondClickListener scnListener = new SecondClickListener();
		ok.setOnClickListener(scnListener);
		cancel.setOnClickListener(scnListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
