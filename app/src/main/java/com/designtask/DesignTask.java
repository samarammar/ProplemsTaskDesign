package com.designtask;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class DesignTask extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        Utils.overrideFont(this, "MONOSPACE", "fonts/font.otf");


        //font override
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/font.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

}
