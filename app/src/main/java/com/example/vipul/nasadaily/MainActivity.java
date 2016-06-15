package com.example.vipul.nasadaily;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String url = "http://www.nasa.gov/api/1/query/ubernodes.json?unType%5B%5D=image&routes%5B%5D=1446&page=0&pageSize=24";
    private RecyclerView recyclerView;
    private static ArrayList<ImageOfTheDayResponse> responseList;
    private CaptionedImagesAdapter adapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading Image of the Day....");

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start
        recyclerView = (RecyclerView) this.findViewById(R.id.recycle);
        responseList = new ArrayList<>();
        new GsonTask().execute();
        //RefreshFeed();
    }

    public class GsonTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL u = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) u.openConnection();
                GsonBuilder gBuilder = new GsonBuilder();
                Gson gson = gBuilder.create();

                if(conn.getResponseCode()!=200){
                    throw new IOException(conn.getResponseMessage());
                }

                InputStream stream = conn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line="";
                while ((line = reader.readLine())!=null){
                    buffer.append(line);
                }
                JSONObject j = new JSONObject(buffer.toString());
                Response responseObj = gson.fromJson(j.toString(), Response.class);
                conn.disconnect();
                reader.close();

                HttpURLConnection connection = null;
                BufferedReader r = null;
                for(int i = 0; i< responseObj.getUbernodes().size(); i++) {
                    //Log.v("Nasa Daily", responseObj.getUbernodes().get(i).getNid());
                    String x = "http://www.nasa.gov/api/1/record/node/" + responseObj.getUbernodes().get(i).getNid() + ".json";
                    URL url = new URL(x);
                    connection = (HttpURLConnection) url.openConnection();
                    if(connection.getResponseCode()!=200){
                        throw new IOException(connection.getResponseMessage());
                    }

                    InputStream s = connection.getInputStream();
                    r = new BufferedReader(new InputStreamReader(s));
                    StringBuffer b = new StringBuffer();

                    String l="";
                    while ((l = r.readLine())!=null){
                        b.append(l);
                    }
                    JSONObject jsonObject = new JSONObject(b.toString());
                    responseList.add(gson.fromJson(jsonObject.toString(),ImageOfTheDayResponse.class));
                }
                if(connection!=null)
                    connection.disconnect();
                if(r!=null)
                    r.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            String[] captions = new String[responseList.size()];
            for(int i=0;i<captions.length;i++){
                captions[i] = responseList.get(i).getUbernode().getTitle();
            }
            String[] nasaImages = new String[responseList.size()];
            for(int i=0;i<nasaImages.length;i++){
                Log.v("Image nasa",responseList.get(i).getImages().get(0).getFilename());
                nasaImages[i] = "https://www.nasa.gov/sites/default/files/thumbnails/image/"+responseList.get(i).getImages().get(0).getFilename();
            }
            adapter = new CaptionedImagesAdapter(getApplicationContext(),captions,nasaImages);
            recyclerView.setAdapter(adapter);
            LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(manager);

            adapter.setListener(new CaptionedImagesAdapter.Listener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(getApplicationContext(),ImageDetailActivity.class);
                    intent.putExtra(ImageDetailActivity.IMAGE_NID,responseList.get(position).getUbernode().getNid());
                    startActivity(intent);
                }
            });
        }
    }


    public static ImageOfTheDayResponse getUbernodeAtNid(String nid){
        ImageOfTheDayResponse u = null;
        for(int i=0;i<responseList.size();i++){
            if(responseList.get(i).getUbernode().getNid().equals(nid)){
                u = responseList.get(i);
                break;
            }
        }
        return u;
    }

}
