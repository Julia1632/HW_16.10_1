package com.example;

/**
 * Created by User on 26.10.2017.
 */

public class Config_method {

        public static final String CONFIG = "getconfig?";
        public String mBasePath;

        public Config_method(final String pBasePath) {
            if (pBasePath.charAt(pBasePath.length() - 1) == '/') {
                mBasePath = pBasePath;
            } else {
                mBasePath = pBasePath + "/";
            }
        }


    public String getConfigVersion() {
             return mBasePath + CONFIG;
     }

}
