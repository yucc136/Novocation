/*
 * Copyright 2011 Novoda Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.novoda.locationexample;

import com.novoda.location.core.LocationFinder;
import com.novoda.location.core.LocationSettings;

import android.app.Application;

public class LocationApplication extends Application {

    private static LocationFinder locator;

    @Override
    public void onCreate() {
        super.onCreate();

        LocationSettings settings = new LocationSettings(Constants.PACKAGE_NAME,
                Constants.LOCATION_UPDATE_ACTION);
        settings.setUpdatesInterval(2 * 60 * 1000);
        settings.setUpdatesDistance(50);
        locator = LocationFinder.getInstance();
        locator.connect(getApplicationContext(), settings);
    }

    public final LocationFinder getLocator() {
        return locator;
    }

}
