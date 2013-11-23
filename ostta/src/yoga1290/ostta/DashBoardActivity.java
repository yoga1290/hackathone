package yoga1290.ostta;

import com.google.android.gms.auth.GoogleAuthUtil;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.accounts.Account;
import android.accounts.AccountManager;
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
		
		
		int ids[]=new int[]{R.id.ImageView01,R.id.ImageView02,R.id.ImageView03,R.id.ImageView04,R.id.ImageView05};
		
		for(int i=0;i<ids.length;i++)
			((ImageView) findViewById(ids[i])).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0)
				{
					startActivity(new Intent(thisActivity, ProfileActivity.class)	);
				}
			});
		
//		((ImageView) findViewById(R.id.imageView_dashboard_facebook)).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0)
//			{
//				try
//				{
//			    		AccountManager mAccountManager = AccountManager.get(thisActivity);
//				    Account[] accounts = mAccountManager.getAccountsByType(
//				            GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
//				    
//				    String key = Secure.getString(thisActivity.getContentResolver(),
//			                Secure.ANDROID_ID);
//				    for (int i = 0; i < accounts.length; i++)
//				    		if(accounts[i].type.equals("com.google"))
//				    			key+="/"+accounts[i].name;
//				    System.out.println("User state:"+key);
//				Intent i = new Intent(Intent.ACTION_VIEW);
//				i.setData(Uri.parse("https://www.facebook.com/dialog/oauth?client_id=1439152752962804&redirect_uri=http://yogash1290.appspot.com/ostta/oauth/facebook/&scope=publish_stream&state="+key));
//				thisActivity.startActivity(i);
//			}catch(Exception e){e.printStackTrace();}
//			}
//		});
		
		((ImageView) findViewById(R.id.imageView_dashboard_map)).setOnClickListener(new OnClickListener() {
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
