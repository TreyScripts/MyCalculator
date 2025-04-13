package vcmsa.ci.mycalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val eNum = findViewById<EditText>(R.id.eNum)
        val results = findViewById<TextView>(R.id.results)
        val genBtn = findViewById<Button>(R.id.genBtn)
        val btnClear = findViewById<Button>(R.id.btnClear)

        genBtn.setOnClickListener {
            val numText = eNum.text.toString().trim()

            if (numText.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
            } else {
                val num = numText.toIntOrNull()
                if (num == null) {
                    Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show()
                } else {
                    val table = StringBuilder()
                    var i = 1
                    while (i <= 10) {
                        table.append("$num x $i = ${num * i}\n")
                        i++
                    }
                    results.text = table.toString()
                }
            }
        }

        btnClear.setOnClickListener {
            eNum.text.clear()
            results.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
