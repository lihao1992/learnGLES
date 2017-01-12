package com.lh.learngles;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LessonOneActivity extends AppCompatActivity {

    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mGLSurfaceView = new GLSurfaceView(this);

        // Check if the system supports OpenGL ES 2.0.
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo(); //to get the device config information
        final boolean supportsES2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsES2){

            mGLSurfaceView.setEGLContextClientVersion(2);

            mGLSurfaceView.setRenderer(new LessonOneRenderer());
        }
        else{

            // This is where you could create an OpenGL ES 1.x compatible
            // renderer if you wanted to support both ES 1 and ES 2.

            return;
        }

        //we set the content view to our GLSurfaceView, which tells Android that the activity’s contents should be filled by our OpenGL surface.
        setContentView(mGLSurfaceView);
    }

    @Override
    protected void onResume(){

        //The activity must call the GL surface view's onResume() on activity onResume().
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause(){
        // The activity must call the GL surface view's onPause() on activity onPause().
        super.onPause();
        mGLSurfaceView.onPause();
    }
}
