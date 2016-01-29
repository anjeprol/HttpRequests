package mac.mamigon.httprequests;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mito6 on 1/26/2016.
 */
public class AsyncTaskMeh extends AsyncTask<String,Void,String> {
    public AsyncResponse delegate = null;
    @Override
    protected String doInBackground(String... params) {
            String response = "";
            HttpURLConnection urlConnection=null;
            try{
                URL url = new URL("http://itunes.apple.com/search?term=rock");
                urlConnection = (HttpURLConnection) url.openConnection();
                //InputStream in = urlConnection.getInputStream();
                //readStream(in);
                InputStream isw =  new BufferedInputStream(urlConnection.getInputStream());

               // int data = isw.read();
                Log.e("XXX",  "started request");
//                while (data != -1) {
//                    char current = (char) data;
//                    data = isw.read();
//                    response=response+ current;
//                }
                response=readStream(isw);
                Log.e("XXX", response + "");

            }catch(Exception ex){
                Log.e("XXX", "error");
            }finally {
                urlConnection.disconnect();
            }
        return response;
    }
    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
    protected void onPostExecute(String res){
        delegate.finishProcess(res);
    }
}
