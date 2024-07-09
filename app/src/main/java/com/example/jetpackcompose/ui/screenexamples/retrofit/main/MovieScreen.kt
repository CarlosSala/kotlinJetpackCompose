package com.example.jetpackcompose.ui.screenexamples.retrofit.main

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.screenexamples.retrofit.domain.model.Movie
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MovieScreen() {

    val viewModel: MovieViewModel = viewModel()

    val locationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    val defaultRegion = "us"
    val context = LocalContext.current

    val isPermissionGranted by viewModel.isPermissionGranted.collectAsState()
    val progressVisible by viewModel.progressVisible.collectAsState()
    val popularMovies by viewModel.listPopularMovies.collectAsState()
    val showMessage by viewModel.showMessage.collectAsState(initial = "")

    LaunchedEffect(locationPermissionState.status) {
        if (locationPermissionState.status.isGranted) {
            viewModel.checkPermissionStatus(true)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isPermissionGranted) {
            Text("Permission granted GPS enabled")

            val fusedLocationClient =
                remember { LocationServices.getFusedLocationProviderClient(context) }

            LaunchedEffect(Unit) {
                // viewModel.requestPopularMovies(defaultRegion)
                requestMoviesWithLocation(defaultRegion, viewModel, context, fusedLocationClient)
            }

        } else {
            // Explain why this permission is important
            Text("this permission is required to access GPS")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    locationPermissionState.launchPermissionRequest()
                }
            ) {
                Text("Request Permission")
            }
        }

        if (progressVisible) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(popularMovies) { movie ->
                    MovieItem(movie) { selectedMovie ->
                        viewModel.onMovieClicked(selectedMovie)
                    }
                }
            }
        }

        if (showMessage.isNotEmpty()) {
            Text(
                text = showMessage,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                // style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onClick(movie)
            },
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = movie.title,
                // style = MaterialTheme.typography.h6
            )
            Text(
                text = movie.overview,
                // style = MaterialTheme.typography.body2
            )
        }
    }
}

private fun requestMoviesWithLocation(
    defaultRegion: String,
    viewModel: MovieViewModel,
    context: Context,
    fusedLocationClient: FusedLocationProviderClient
) {

    // request lastLocation to GPS
    fusedLocationClient.lastLocation.addOnCompleteListener {

        if (it.result != null) {

            viewModel.requestPopularMovies(getRegionFromLocation(defaultRegion, it.result, context))

        } else {
            viewModel.requestPopularMovies(defaultRegion)
        }
    }
}

private fun getRegionFromLocation(
    defaultRegion: String,
    location: Location,
    context: Context
): String {

    val geocoder = Geocoder(context)
    val result = geocoder.getFromLocation(location.latitude, location.longitude, 1)

    return result?.firstOrNull()?.countryCode ?: defaultRegion
}
