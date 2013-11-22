package yoga1290.ostta;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DashBoardActivity extends Activity {

	final Activity thisActivity=this;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		
		((ImageView) findViewById(R.id.ImageView01)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0)
			{
				startActivity(new Intent(thisActivity, MapActivity.class)	);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dash_board, menu);
		return true;
	}

}
