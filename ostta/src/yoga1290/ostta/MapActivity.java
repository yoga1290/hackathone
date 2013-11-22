package yoga1290.ostta;


import java.util.Currency;

import com.google.android.gms.internal.t;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.view.View.OnClickListener;

import com.google.android.gms.maps.SupportMapFragment;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;

public class MapActivity extends Activity implements OnMarkerClickListener, LocationListener
{

	private LocationManager locationManager;
	private GoogleMap mMap;
	private final Activity currentActivity=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		mMap = //((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map))
                //.getMap();
		((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();
		mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		mMap.setOnMarkerClickListener(this);
		mMap.setMyLocationEnabled(true);
		
		// Acquire a reference to the system Location Manager
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		try{
			  if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
			  {
					  showSettingsAlert();
//					  locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 100, this);//locationListener);
			  }
			  else
				  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 600, 100, this);
		  }catch(Exception e)
		  {
			  showSettingsAlert();
			    
		  }
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	
	public void showSettingsAlert()
	{
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
      
        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");
  
        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
  
        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);
  
        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });
  
        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which)
            {
            		dialog.cancel();
            }
        });
  
        // Showing Alert Message
        alertDialog.show();
    }



	@Override
	public boolean onMarkerClick(Marker arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void onLocationChanged(final Location location)
	{
		currentActivity.runOnUiThread(new Runnable() {
			
			@Override
			public void run()
			{
				mMap.moveCamera(	
						CameraUpdateFactory.zoomTo(19)
					);
				mMap.animateCamera(
						CameraUpdateFactory.newLatLng(
								new LatLng(	location.getLatitude() , location.getLongitude())
						)
					);
			}
		});
	}



	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

}


class Connect
{
	
}