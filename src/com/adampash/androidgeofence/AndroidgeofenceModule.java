/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.adampash.androidgeofence;

import java.util.HashMap;

import android.content.Intent;
import android.app.PendingIntent;
import com.google.android.gms.location.Geofence;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.KrollFunction;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

@Kroll.module(name="Androidgeofence", id="com.adampash.androidgeofence")
public class AndroidgeofenceModule extends KrollModule
{

  // Standard Debugging variables
  private static final String TAG = "AndroidgeofenceModule";

  private KrollFunction callback = null;

  // You can define constants with @Kroll.constant, for example:
  // @Kroll.constant public static final String EXTERNAL_NAME = value;

  public AndroidgeofenceModule()
  {
    super();
  }

  @Kroll.onAppCreate
  public static void onAppCreate(TiApplication app)
  {
    Log.d(TAG, "inside onAppCreate");
    // put module init code that needs to run when the application is created
  }

  private void initializeLocationManager()
  {
    if (callback != null) {
      HashMap event = new HashMap();
      event.put("type", "initialize location manager");
      callback.call(getKrollObject(), event);
    }
  }


  public void createGeofences(double lat, double lon, float radius) {
    new Geofence.Builder()
      .setRequestId("1234")
      .setCircularRegion(
          lat, lon, radius)
      .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER + Geofence.GEOFENCE_TRANSITION_EXIT)
      .setExpirationDuration(Geofence.NEVER_EXPIRE)
      .build();
  }


  // Methods
  @Kroll.method
  public String example()
  {
    Log.d(TAG, "example called");
    return "hello world";
  }

  @Kroll.method
  public void startGeoFencing(HashMap<String, String>[] regions, KrollFunction _callback)
  {
    Log.d(TAG, "example called");
    HashMap event = new HashMap();
    event.put("type", "initialized");

    initializeLocationManager();

    createGeofences(Double.parseDouble(regions[0].get("latitude")), 
        Double.parseDouble(regions[0].get("longitude")),
        Float.parseFloat(regions[0].get("radius"))
    );
    callback = (KrollFunction)_callback;

    callback.call(getKrollObject(), event);
  }

  // Properties
  @Kroll.getProperty
  public String getExampleProp()
  {
    Log.d(TAG, "get example property");
    return "hello world";
  }


  @Kroll.setProperty
  public void setExampleProp(String value) {
    Log.d(TAG, "set example property: " + value);
  }

}

