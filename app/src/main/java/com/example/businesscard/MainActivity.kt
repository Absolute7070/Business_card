package com.example.businesscard

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFC0D8F8))
    ) {
        Spacer(modifier = Modifier.weight(1f))
        UpperBox(
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            interested = stringResource(R.string.interested),
            Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.weight(1f))
        LowerBox(
                phonenumber = stringResource(R.string.phonenumber),
                email = stringResource(R.string.email),
                socialMediaHandle = stringResource(R.string.socialmediahandle),
                modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun UpperBox(
    name: String,
    title: String,
    interested: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.earth_eu_nightsky)
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                //.width(800.dp)
                //.height(250.dp)
                .padding(top = 20.dp, bottom = 20.dp)
                .fillMaxWidth(1f)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            text = interested,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LowerBox(
    phonenumber: String,
    email: String,
    socialMediaHandle: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp)
            )
            Text(
                text = phonenumber
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
                //.padding(12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp)
            )
            Text(
                text = email
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp)
            )
            Text(
                text = socialMediaHandle,
                textAlign = TextAlign.Center
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}