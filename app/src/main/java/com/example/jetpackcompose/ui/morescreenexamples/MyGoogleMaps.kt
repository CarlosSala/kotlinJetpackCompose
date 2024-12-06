package com.example.jetpackcompose.ui.morescreenexamples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Preview
@Composable
fun MyGoogleMaps(modifier: Modifier = Modifier) {

    GoogleMap(modifier = Modifier.fillMaxSize(),

        cameraPositionState = rememberCameraPositionState {
            position =
                CameraPosition.fromLatLngZoom(LatLng(37.7749, -122.4194), 12f) // San Francisco
        }
    )
}