package mac.mamigon.httprequests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity  implements  AsyncResponse{
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info=(TextView)findViewById( R.id.infoText);
        AsyncTaskMeh task = new AsyncTaskMeh();
        task.delegate=this;
        task.execute("");
    }

    @Override
    public void finishProcess(String param) {
        info.setText(param);
    }
}
