package com.example;

import com.google.gson.annotations.SerializedName;

public class Config_variables {

    @SerializedName("current_app_version")
    public String current_app_version;

    @SerializedName("force_update")
    public String force_update;

    public String getCurrent_app_version() {
        return current_app_version;
    }

    public void setCurrent_app_version(String current_app_version) {
        this.current_app_version = current_app_version;
    }

    public String getForce_update() {
        return force_update;
    }

    public void setForce_update(String force_update) {
        this.force_update = force_update;
    }
}
