package com.example.lab1

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.activity.ComponentActivity

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.ui.theme.Lab1Theme

class Task1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val inputH = findViewById<EditText>(R.id.inputH)
        val inputC = findViewById<EditText>(R.id.inputC)
        val inputS = findViewById<EditText>(R.id.inputS)
        val inputN = findViewById<EditText>(R.id.inputN)
        val inputO = findViewById<EditText>(R.id.inputO)
        val inputW = findViewById<EditText>(R.id.inputW)
        val inputA = findViewById<EditText>(R.id.inputA)

        val calculateButton = findViewById<Button>(R.id.calculateButton)

        val dryMassH = findViewById<TextView>(R.id.dryMassH)
        val dryMassC = findViewById<TextView>(R.id.dryMassC)
        val dryMassS = findViewById<TextView>(R.id.dryMassS)
        val dryMassN = findViewById<TextView>(R.id.dryMassN)
        val dryMassO = findViewById<TextView>(R.id.dryMassO)
        val dryMassA = findViewById<TextView>(R.id.dryMassA)

        val combustibleMassH = findViewById<TextView>(R.id.combustibleMassH)
        val combustibleMassC = findViewById<TextView>(R.id.combustibleMassC)
        val combustibleMassS = findViewById<TextView>(R.id.combustibleMassS)
        val combustibleMassN = findViewById<TextView>(R.id.combustibleMassN)
        val combustibleMassO = findViewById<TextView>(R.id.combustibleMassO)

        val resultWorkingText = findViewById<TextView>(R.id.resultWorkingText)
        val resultDryText = findViewById<TextView>(R.id.resultDryText)
        val resultCombustibleText = findViewById<TextView>(R.id.resultCombustibleText)

        calculateButton.setOnClickListener {
            try {
                val H = inputH.text.toString().toDouble()
                val C = inputC.text.toString().toDouble()
                val S = inputS.text.toString().toDouble()
                val N = inputN.text.toString().toDouble()
                val O = inputO.text.toString().toDouble()
                val W = inputW.text.toString().toDouble()
                val A = inputA.text.toString().toDouble()

                val dryCoefficient = 100 / (100 - W)
                val C_dry = C * dryCoefficient
                val H_dry = H * dryCoefficient
                val S_dry = S * dryCoefficient
                val N_dry = N * dryCoefficient
                val O_dry = O * dryCoefficient
                val A_dry = A * dryCoefficient

                dryMassH.text = "Водень (H): %.2f".format(H_dry)
                dryMassC.text = "Вуглець (C): %.2f".format(C_dry)
                dryMassS.text = "Сірка (S): %.2f".format(S_dry)
                dryMassN.text = "Азот (N): %.2f".format(N_dry)
                dryMassO.text = "Кисень (O): %.2f".format(O_dry)
                dryMassA.text = "Зола (A): %.2f".format(A_dry)

                val combustibleCoefficient = 100 / (100 - W - A)
                val C_combustible = C * combustibleCoefficient
                val H_combustible = H * combustibleCoefficient
                val S_combustible = S * combustibleCoefficient
                val N_combustible = N * combustibleCoefficient
                val O_combustible = O * combustibleCoefficient

                combustibleMassH.text = "Водень (H): %.2f".format(H_combustible)
                combustibleMassC.text = "Вуглець (C): %.2f".format(C_combustible)
                combustibleMassS.text = "Сірка (S): %.2f".format(S_combustible)
                combustibleMassN.text = "Азот (N): %.2f".format(N_combustible)
                combustibleMassO.text = "Кисень (O): %.2f".format(O_combustible)

                val LHV = 339*C + 1030*H - 108.8*(O-S) - 25*W
                val LHV_dry = ((LHV/1000+0.025*W)*(100/(100-W)))*1000
                val LHV_combustible = ((LHV/1000+0.025*W)*(100/(100-W-A)))*1000

                resultWorkingText.text = "Нижча робоча теплота згоряння: %.1f кДж/кг".format(LHV)
                resultDryText.text = "Нижча суха теплота згоряння: %.1f кДж/кг".format(LHV_dry)
                resultCombustibleText.text = "Нижча горюча теплота згоряння: %.1f кДж/кг".format(LHV_combustible)

            } catch (e: Exception) {
                Toast.makeText(this, "Будь ласка, введіть правильні числові значення!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1Theme {
        Greeting("Android")
    }
}