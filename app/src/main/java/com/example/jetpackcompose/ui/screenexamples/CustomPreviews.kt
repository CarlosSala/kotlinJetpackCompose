package com.example.jetpackcompose.ui.screenexamples

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.CustomComposeTheme

private val listMessages: List<MyMessage> = listOf(
    MyMessage(
        title = "Message 1",
        body = "Body 1aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh"
    ),
    MyMessage(
        title = "Message 2",
        body = "Body 2 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 3",
        body = "Body 3 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 4",
        body = "Body 4 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 5",
        body = "Body 5 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 6",
        body = "Body 6 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 7",
        body = "Body 7 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 8",
        body = "Body 8 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 9",
        body = "Body 9 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 10",
        body = "Body 10 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 11",
        body = "Body 11 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 12",
        body = "Body 12 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 13",
        body = "Body 13 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 14",
        body = "Body 14 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 15",
        body = "Body 15 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 16",
        body = "Body 16 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 17",
        body = "Body 17 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    ),
    MyMessage(
        title = "Message 18",
        body = "Body 18 aliquid erroribus veritus inciderint fringilla non agam nec dapibus porro maiorum melius affert liber diam urbanitas scelerisque conclusionemque posse utamur ocurreret vocibus patrioque platonem justo elaboraret no an malesuada possit veniam no populo mandamus sapientem mauris putent tractatos reprehendunt convenire auctor salutatus interdum adipiscing dolorum quidam nostrum reformidans maximus nibh "
    )
)

@Composable
fun MyComponent(message: MyMessage) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "my description",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyTexts(myMessage: MyMessage) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(start = 8.dp)
            .clickable {
                expanded = !expanded
            }
    ) {
        MyText(
            text = myMessage.title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = myMessage.body,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
            lines = if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun MyText(
    text: String,
    color: Color,
    style: TextStyle,
    lines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        color = color,
        style = style,
        maxLines = lines
    )
}

@Composable
fun MyMessages(listMessages: List<MyMessage>) {
    LazyColumn {
        items(listMessages) { message ->
            MyComponent(message = message)
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Preview(showSystemUi = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
fun PreviewComponent() {
    CustomComposeTheme {
        MyMessages(listMessages = listMessages)
    }
}