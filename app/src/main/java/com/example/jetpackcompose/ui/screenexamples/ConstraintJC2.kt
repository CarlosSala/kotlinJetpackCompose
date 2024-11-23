package com.example.jetpackcompose.ui.screenexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Preview(showBackground = true)
@Composable
fun ConstraintJC2(modifier: Modifier = Modifier) {

    ConstraintLayout(Modifier.fillMaxSize()) {

        // elements references
        val (title, profileImage, username, bio, followButton, postsCount) = createRefs()
        val topGuide = createGuidelineFromTop(fraction = 0.05f)
        val barrierBottom = createBottomBarrier(profileImage, username)

        Text(
            text = "User Profile",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(topGuide)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        // Profile Image
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .constrainAs(profileImage) {
                    top.linkTo(title.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        // User name
        Text(
            text = "@user123",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.constrainAs(username) {
                top.linkTo(profileImage.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        // Biographic
        Text(
            text = "Mobile Development | I love the technology and Design",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(bio) {
                    // Creates a horizontal chain including the referenced layouts
                    top.linkTo(barrierBottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.preferredWrapContent
                }
        )
        // Follows Button
        Button(
            onClick = { /* Action */ },
            modifier = Modifier.constrainAs(followButton) {
                top.linkTo(bio.bottom, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        ) {
            Text(text = "Follow")
        }
        // Publish Counter, Follows, Followings
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .constrainAs(postsCount) {
                    top.linkTo(followButton.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            CounterItem("Publish", "120")
            CounterItem("Follows", "10K")
            CounterItem("Followings", "500")
        }
    }
}

@Composable
fun CounterItem(label: String, count: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, style = MaterialTheme.typography.bodySmall)
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
    }
}