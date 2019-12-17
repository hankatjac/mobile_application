package ca.hank.forclass1;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import ca.hank.forclass1.HttpURLConnectionPostProcessorInterface;

public class AsynchronousHttpURLConnector extends AsyncTask<Void, Integer, String> {

    private String urlString;
    private HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface;
    private TextView textViewProgress;


    public AsynchronousHttpURLConnector(String urlString, HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface, TextView textViewProgress) {
        this.urlString = urlString;
        this.httpURLConnectionPostProcessorInterface = httpURLConnectionPostProcessorInterface;
        this.textViewProgress = textViewProgress;
    }

    public AsynchronousHttpURLConnector(String urlString, HttpURLConnectionPostProcessorInterface httpURLConnectionPostProcessorInterface) {
        this.urlString = urlString;
        this.httpURLConnectionPostProcessorInterface = httpURLConnectionPostProcessorInterface;
    }


    protected  String doInBackground(Void... params){
        String urlConnectionResultString = "";
        HttpURLConnection httpURLConnection = null;
        try{
            System.out.println("----------------------------> " + urlString);
            httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();

            InputStream urlConnectionInputStream = httpURLConnection.getInputStream();
            System.out.println("---------------------------- urlConnectionInputStream" + urlConnectionInputStream);

            urlConnectionResultString = inputStreamToString(urlConnectionInputStream);


        }catch (Exception exception){
            httpURLConnectionPostProcessorInterface.failureHandler(exception);

        }


        return urlConnectionResultString;

    }


    private String inputStreamToString(InputStream inputStream){
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        String oneLine = null;
        int counter = 0;
        try{
            while ((oneLine = bufferedReader.readLine())!=null){
                stringBuilder.append(oneLine);
                publishProgress(counter++);
            }

        } catch (Exception e){
            httpURLConnectionPostProcessorInterface.failureHandler(e);
        }
        System.out.println("------------------ Result String: " + stringBuilder.toString());
        return stringBuilder.toString();

    }


    @Override
    protected void onPostExecute(String urlConnectionResultString){
        super.onPostExecute(urlConnectionResultString);
        System.out.println("------------------------- onPostExecute: " + urlConnectionResultString);
        httpURLConnectionPostProcessorInterface.successHandler(urlConnectionResultString);
    }

    @Override
    protected  void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);

        textViewProgress.setText("number of lines in loaded web pages " + String.valueOf(values[0]));
        textViewProgress.setTextSize(16);
        System.out.println("------------------- number of lines in loaded web pages" +  String.valueOf(values[0]));
    }
}


