package com.example.mycv


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycv.ui.theme.MyCvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCvTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyCvWithImage()
                }
            }
        }
    }
}

@Composable
fun MyCvWithText(){
    Column(Modifier.fillMaxWidth()){
        Row(Modifier.weight(1f)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val image = painterResource(R.drawable.face)
                Image(painter = image, contentDescription = null)

                Text(
                    text = stringResource(R.string.name),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(20.dp)

                )

                Text(
                    text = stringResource(R.string.job),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp)
                )

            }
        }
        Row(Modifier.weight(.5f)){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(Modifier.weight(.1f)) {
                    InfoIconCall(modifier = Modifier.weight(.5f))
                    InfoText(
                        title = stringResource(R.string.sdt),
                        modifier = Modifier.weight(1f)
                    )

                }

                Row(Modifier.weight(.1f)) {
                    InfoIconEmail(modifier = Modifier.weight(.5f))
                    InfoText(
                        title = stringResource(R.string.email),
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(Modifier.weight(.1f)) {
                    InfoIconMap(modifier = Modifier.weight(.5f))
                    InfoText(
                        title = stringResource(R.string.dc),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun InfoText(title: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun InfoIconCall(modifier: Modifier = Modifier){
    Icon(Icons.Rounded.Call, contentDescription = "Localized description")
}

@Composable
fun InfoIconEmail(modifier: Modifier = Modifier){
    Icon(Icons.Rounded.Email, contentDescription = "Localized description")
}

@Composable
fun InfoIconMap(modifier: Modifier = Modifier){
    Icon(Icons.Rounded.Place, contentDescription = "Localized description")
}

@Composable
fun MyCvWithImage(){
    val background = painterResource(R.drawable.background)

    Box{
        Image(
            painter = background,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        MyCvWithText()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCvTheme {
        MyCvWithImage()
    }
}