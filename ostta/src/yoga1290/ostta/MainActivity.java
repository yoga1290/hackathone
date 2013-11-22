package yoga1290.ostta;

import yoga1290.ostta.MapActivity;

import com.google.android.gms.auth.GoogleAuthUtil;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.*;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private Activity thisActivity=this;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					startActivity(new Intent(thisActivity, DashBoardActivity.class)	);
					thisActivity.finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
//		((Button) findViewById(R.id.button_main)).setOnClickListener(new OnClickListener()
//		{
//			@Override
//			public void onClick(View arg0)
//			{
//				
//				startActivity(new Intent(thisActivity, MapActivity.class)	);
//			}
//		});
		
		
//		((Button) findViewById(R.id.button_main)).setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v)
//			{
//			    try
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
//				    
//					Intent i = new Intent(Intent.ACTION_VIEW);
//					i.setData(Uri.parse("https://www.facebook.com/dialog/oauth?client_id=326905200782417&redirect_uri=http://yogash1290.appspot.com/bey2ollak/oauth/facebook/&scope=publish_stream,email&state="+key));
//					thisActivity.startActivity(i);
//				}catch(Exception e){e.printStackTrace();}
//			}
//		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
