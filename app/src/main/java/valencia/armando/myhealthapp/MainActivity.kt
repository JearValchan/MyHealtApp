package valencia.armando.myhealthapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.weight) as EditText
        val altura: EditText = findViewById(R.id.height) as EditText
        val calcular: Button = findViewById(R.id.calculate) as Button
        val imc: TextView = findViewById(R.id.imc) as TextView
        val rango:TextView = findViewById(R.id.range) as TextView

        calcular.setOnClickListener{
            var p:Float = peso.text.toString().toFloat()
            var a: Float = altura.text.toString().toFloat()
            var i:Float = p/(a*a)

            imc.setText(""+i+"")

            when(i){
                in 0f..18.5f -> {
                    rango.setText("Por debajo de tu peso")
                    rango.setBackgroundResource(R.color.greenish)
                }
                in 18.6f..24.9f ->{
                    rango.setText("Saludable")
                    rango.setBackgroundResource(R.color.green)
                }
                in 25f..29.9f ->{
                    rango.setText("Sobrepeso")
                    rango.setBackgroundResource(R.color.yellow)
                }
                in 30f..39.9f ->{
                    rango.setText("Obesidad")
                    rango.setBackgroundResource(R.color.orange)
                }
                else -> {
                    rango.setText("Obesidad morbida")
                    rango.setBackgroundResource(R.color.red)
                }
            }
        }


    }
}
