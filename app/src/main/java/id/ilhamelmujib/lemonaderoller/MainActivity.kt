package id.ilhamelmujib.lemonaderoller

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ilhamelmujib.lemonaderoller.ui.theme.LemonadeRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeRollerTheme {
                LemonadeRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeRollerApp() {
    ButtonAndImageRoll(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ButtonAndImageRoll(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val text = when (result) {
        1 -> R.string.tap_1
        2 -> R.string.tap_2
        3 -> R.string.tap_3
        else -> R.string.tap_4
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Cyan)
            .padding(paddingValues = PaddingValues(20.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
            onClick = {
                if (result == 4){
                    result = 1
                }else {
                    result++
                }
            }) {
            Image(painter = painterResource(id = imageResource), contentDescription = "1")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = text))
    }
}
