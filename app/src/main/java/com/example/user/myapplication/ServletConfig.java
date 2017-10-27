package com.example.user.myapplication;

import com.example.Config_method;
import com.example.Config_variables;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by User on 27.10.2017.
 */

public class ServletConfig {

    String congif_url="https://servlet-config.appspot.com";

    public String getConfigVersion(){
        final String url = new Config_method(congif_url).getConfigVersion();
        final MyResponseListener listener=new MyResponseListener();
        new HttpClient().request(url,listener);
        return String.valueOf(listener.getResult().getCurrent_app_version());
    }


    public String getForseUpdate(){
        final String url = new Config_method(congif_url).getConfigVersion();
        final MyResponseListener listener=new MyResponseListener();
        new HttpClient().request(url,listener);
        return String.valueOf(listener.getResult().getForce_update());
    }


    private static class MyResponseListener implements HttpClient.ResponseListener {

        private Config_variables result;
        private Throwable mThrowable;

        @Override
        public void onResponse(final InputStream pInputStream) throws Exception {
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(pInputStream);
                result = new GsonBuilder()
                        .setLenient()
                        .create().fromJson(inputStreamReader, Config_variables.class);
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (final Exception ignored) {}
                }
            }
        }

        public Throwable getThrowable() {
            return mThrowable;
        }

        @Override
        public void onError(final Throwable pThrowable) {
            mThrowable = pThrowable;
        }

        public Config_variables getResult() {
            return result;
        }


    }

}
