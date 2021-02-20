package in.games.webview_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash_activity extends AppCompatActivity {
public  int limit=3000;
Context context;
    ConnectivityManager conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash_activity);
        context=Splash_activity.this;
        new Handler ().postDelayed(new Runnable(){
            @Override
            public void run() {
//                Intent intent=new Intent ( Splash_activity.this,MainActivity.class );
//                Splash_activity.this.startActivity (intent);
//                Splash_activity.this.finish ();

                conn = (ConnectivityManager)getSystemService (context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=conn.getActiveNetworkInfo ();
//         if(networkInfo = !null &&  networkInfo.isConnectedOrConnecting ())

                if( networkInfo != null && networkInfo.isConnectedOrConnecting ()){
                   // Toast.makeText (context, "connect", Toast.LENGTH_SHORT).show ( );
                    Intent intent=new Intent ( Splash_activity.this,MainActivity.class );
                    startActivity (intent);
                    finish ();
                }
                else {
                     // Toast.makeText (context, "not", Toast.LENGTH_SHORT).show ( );
                    Intent intent = new Intent ( Splash_activity.this,NointernetConnection.class );
                    startActivity (intent);
                    finish ();

                }

            }


        }, limit);

}

}