package code.sandeep.waterbottole

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import code.sandeep.waterbottole.ui.WaterBottle
import code.sandeep.waterbottole.ui.theme.WaterBottoleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterBottoleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.LightGray
                ) {
                    val totalWaterAmount = remember {
                        2400
                    }
                    var usedWaterAmount by remember {
                        mutableStateOf(400)
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WaterBottle(
                            modifier = Modifier.width(300.dp),
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedWaterAmount
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount is Rs. $totalWaterAmount")
                        Button(onClick = {
                            if (usedWaterAmount < totalWaterAmount) usedWaterAmount += 200 else Toast.makeText(
                                applicationContext, "Bottle is Empty", Toast.LENGTH_LONG
                            ).show()
                        }) {
                            Text(text = "Drink")
                        }

                    }
                }
            }
        }
    }
}

