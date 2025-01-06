package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class Task2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        val inputC = findViewById<EditText>(R.id.inputC)
        val inputH = findViewById<EditText>(R.id.inputH)
        val inputO = findViewById<EditText>(R.id.inputO)
        val inputS = findViewById<EditText>(R.id.inputS)
        val inputAD = findViewById<EditText>(R.id.inputA)
        val inputWR = findViewById<EditText>(R.id.inputW)
        val inputV = findViewById<EditText>(R.id.inputV)
        val inputQiDaf = findViewById<EditText>(R.id.inputQi_daf)

        val calculateButton = findViewById<Button>(R.id.calculateButton)

        val workingMassC = findViewById<TextView>(R.id.workingMassC)
        val workingMassH = findViewById<TextView>(R.id.workingMassH)
        val workingMassO = findViewById<TextView>(R.id.workingMassO)
        val workingMassS = findViewById<TextView>(R.id.workingMassS)
        val workingMassA = findViewById<TextView>(R.id.workingMassA)
        val workingMassV = findViewById<TextView>(R.id.workingMassV)

        val resultWorkingText = findViewById<TextView>(R.id.resultWorkingText)

        calculateButton.setOnClickListener {
            try {
                val C = inputC.text.toString().toDouble()
                val H = inputH.text.toString().toDouble()
                val O = inputO.text.toString().toDouble()
                val S = inputS.text.toString().toDouble()
                val A_d = inputAD.text.toString().toDouble()
                val W_r = inputWR.text.toString().toDouble()
                val V = inputV.text.toString().toDouble()
                val Qi_Daf = inputQiDaf.text.toString().toDouble()

                val workingCoefficient = (100 - W_r - A_d)/100
                val workingCoefficientForAV = (100 - W_r)/100
                val C_working = C * workingCoefficient
                val H_working = H * workingCoefficient
                val O_working = O * workingCoefficient
                val S_working = S * workingCoefficient
                val A_working = A_d * workingCoefficientForAV
                val V_working = V * workingCoefficientForAV

                workingMassC.text = "Вуглець (C): %.2f відсотків".format(C_working)
                workingMassH.text = "Водень (H): %.2f відсотків".format(H_working)
                workingMassO.text = "Кисень (O): %.2f відсотків".format(O_working)
                workingMassS.text = "Сірка (S): %.2f відсотків".format(S_working)
                workingMassA.text = "Зола (A): %.2f відсотків".format(A_working)
                workingMassV.text = "Ванадій (V): %.2f мг/кг".format(V_working)

                val Qi_R = Qi_Daf * ((100-W_r-A_d)/100)-0.025*W_r

                resultWorkingText.text = "Нижча робоча теплота згоряння: %.3f МДж/кг".format(Qi_R)

            } catch (e: Exception) {
                Toast.makeText(this, "Будь ласка, введіть правильні числові значення!",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }
}