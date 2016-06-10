package com.samarth261.dt4;

import android.view.animation.Interpolator;

/**
 * Created by Samarth on 10-06-2016.
 */

public class myanim implements Interpolator {

    public myanim()
    {

    }
    public float getInterpolation(float t)
    {
        double ans;
        //ans=Math.pow(4*t-4*Math.pow(t,2),1/3.0);
        ans=Math.pow(+8*t+32*Math.pow(t,3)-24*Math.pow(t,2)-16*Math.pow(t,4),1/3.0);
        return (float)ans;
    }
}
