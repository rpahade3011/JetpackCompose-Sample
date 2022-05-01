package com.rudraksh.example.jetpacksample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // The setContent block defines the layout of the activity and it is used in place of
        // setContent(R.id.some_xml_file) that we use normally(without compose). This is an
        // extension function of Activity. Form here we can call all our @Composable functions.
        setContent {
            // Column is used to have the views one after the other vertically. In the Column,
            // we can pass some parameters such as modifier, verticalArrangement, horizontalAlignment, etc.

            // modifier is used to decorate or add behavior to UI elements. Here we are telling the
            // column to fill the maximum size of the screen
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SimpleText(getString(R.string.msg_simple_text))

                SimpleTextComponent("Example of Simple Button")
                SimpleButtonComponent(applicationContext)
                Divider(color = Color.Gray)
            }
        }
    }
}

// This is a Composable function. To write any Composable function, you need to use @Composable annotation
@Composable
fun SimpleText(displayText: String) {
    // Text composable is used to display some text
    Text(text = displayText)
}

@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}

@Composable
fun SimpleButtonComponent(applicationContext: Context) {
    // Button is a Composable that is used to make Button.
    // onClick will handle the click event of the button
    Button(
        onClick = {
            Toast.makeText(applicationContext, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Text("Click Me")
    }
}

// Android Studio provides an awesome feature of previewing your Compose UI elements while writing the code.
// To do so, you need to use @Preview annotation and then write a Composable function and call your UI element.
// The UI will be refreshed on every build or you can refresh manually from the UI preview tab.
@Preview
@Composable
fun SimpleTextPreview() {
    SimpleText("Hi I am learning Compose")
    SimpleTextComponent("Example of Simple Button")
}