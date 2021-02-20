package in.games.webview_activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NointernetConnection extends AppCompatActivity {
Button checkbtn;
ConnectivityManager  conn;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_nointernet_connection);
        checkbtn=findViewById (R.id.checkbtn);
        context=NointernetConnection.this;
        checkbtn.setOnClickListener (new View.OnClickListener ( ) {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                conn = (ConnectivityManager)getSystemService (context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo=conn.getActiveNetworkInfo ();

                if( networkInfo != null && networkInfo.isConnectedOrConnecting ()){
                  //  Toast.makeText (context, "Internet connected", Toast.LENGTH_SHORT).show ( );
                    Intent intent = new Intent ( NointernetConnection.this,Splash_activity.class );
                    startActivity (intent);
                    finish ();
                }else{
                    Toast.makeText (context, "Please check internet connection ", Toast.LENGTH_SHORT).show ( );
                }
            }
        });
    }
}