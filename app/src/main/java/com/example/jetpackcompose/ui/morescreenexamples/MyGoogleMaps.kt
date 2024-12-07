package com.example.jetpackcompose.ui.morescreenexamples

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Preview
@Composable
fun MyGoogleMaps(modifier: Modifier = Modifier) {

    val markerPosition = LatLng(-33.4503, -70.6798)
    val properties by remember { mutableStateOf(MapProperties(mapType = MapType.SATELLITE)) }
    val uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = true)) }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = properties,
        uiSettings = uiSettings,
        cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(markerPosition, 16f)
        }
    ) {
        Marker(
            state = rememberMarkerState(position = markerPosition),
            title = "University of Santiago",
            snippet = "This is my university"
        )
    }
}
