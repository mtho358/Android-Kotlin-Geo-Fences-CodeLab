/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcats.androidkotlingeofencescodelab.util

import android.content.Context
import com.coolcats.androidkotlingeofencescodelab.R
import com.google.android.gms.location.GeofenceStatusCodes
import com.google.android.gms.maps.model.LatLng
import java.util.concurrent.TimeUnit

/**
 * Returns the error string for a geofencing error code.
 */
fun errorMessage(context: Context, errorCode: Int): String {
    val resources = context.resources
    return when (errorCode) {
        GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE -> resources.getString(
            R.string.geofence_not_available
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES -> resources.getString(
            R.string.geofence_too_many_geofences
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS -> resources.getString(
            R.string.geofence_too_many_pending_intents
        )
        else -> resources.getString(R.string.unknown_geofence_error)
    }
}

/**
 * Stores latitude and longitude information along with a hint to help user find the location.
 */
data class LandmarkDataObject(val id: String, val hint: Int, val name: Int, val latLong: LatLng)

internal object GeofencingConstants {

    /**
     * Used to set an expiration time for a geofence. After this amount of time, Location services
     * stops tracking the geofence. For this sample, geofences expire after one hour.
     */
    val GEOFENCE_EXPIRATION_IN_MILLISECONDS: Long = TimeUnit.HOURS.toMillis(1)

    val LANDMARK_DATA = arrayOf(
        LandmarkDataObject(
            "golden_gate_bridge",
            R.string.water_park_tower_hint,
            R.string.water_tower_location,
            LatLng(42.9012331, -90.4338112)),

        LandmarkDataObject(
            "cross_roads1",
            R.string.woodward_park_hint,
            R.string.woodward_park_location,
            LatLng(42.902040, -90.433177)),

        LandmarkDataObject(
            "memorial_park",
            R.string.memorial_park_hint,
            R.string.memorial_park_location,
            LatLng(42.901620, -90.436064)),

        LandmarkDataObject(
            "cross_roads2",
            R.string.w_jackson_s_clifton_hint,
            R.string.w_jackson_s_clifton_location,
            LatLng(42.898208, -90.436430)),

        LandmarkDataObject(
            "bell_park",
            R.string.bell_park_hint,
            R.string.bell_park_location,
            LatLng(42.897966, -90.29316)
        )
    )

    val NUM_LANDMARKS = LANDMARK_DATA.size
    const val GEOFENCE_RADIUS_IN_METERS = 100f
    const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"
}