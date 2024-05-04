package com.example.icetask1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the button using the id we set on the user interface
        val clickMeButton = findViewById<Button>(R.id.button)
        // get the text view and edit text
        val welcomeTextView =
            findViewById<TextView>(R.id.textView)
        val nameEditText = findViewById<EditText>(R.id.editTextText)
        // add code to the button that happens when it is clicked
        clickMeButton?.setOnClickListener {
            welcomeTextView.text = "Welcome, ${nameEditText.text}!"
        }

        // get the switch that turns on the Zulu greeting
        val zuluSwitch = findViewById<Switch>(R.id.switch1)
        // add code to the button that happens when it is clicked
        clickMeButton?.setOnClickListener {

            var greeting: String

            if (zuluSwitch.isChecked) {
                greeting = "Sawubona, ${nameEditText.text}!"
            } else {
                greeting = "Greetings, ${nameEditText.text}!"
            }
            welcomeTextView.text = greeting
        }

        var greeting: String
        if (zuluSwitch.isChecked) {
            greeting = "Sawubona, ${nameEditText.text}!"
        } else {
            // easter egg for Sam
            if (nameEditText.text.toString() == "Sam") {
                greeting = "Yo, ${nameEditText.text}!"
            } else {
                greeting = "Greetings, ${nameEditText.text}!"
            }
        }
        welcomeTextView.text = greeting

        var zulu: Boolean = zuluSwitch.isChecked
        if (zulu) {
            greeting = "Sawubona, ${nameEditText.text}!"
        } else {

        }
        if (nameEditText.text.toString() == "Sam" ||
            nameEditText.text.toString() == "Samantha") {
            greeting = "Yo, ${nameEditText.text}!"
        } else {
            greeting = "Greetings, ${nameEditText.text}!"
        }

       // set up the spinner options
        val languageSpinner = findViewById<Spinner>(R.id.languageSpinner)
        languageSpinner.adapter = ArrayAdapter<Languages>(this,
            android.R.layout.simple_list_item_1, Languages.values())

        clickMeButton?.setOnClickListener {
            var greeting: String = ""
            var name = nameEditText.text.toString()
            var language = languageSpinner.selectedItem as Languages
            when (language) {
                Languages.ZULU -> greeting = "Sawubona, $name"
                else -> greeting = "Greetings, $name"
            }
            welcomeTextView.text = greeting
        }

    }

}



enum class Languages {
    ENGLISH,
    NDEBELE,
    PEDI,
    SOTHO,
    SWATI,
    TSONGA,
    TSWANA,
    VENDA,
    XHOSA,
    ZULU,
    AFRIKAANS
}





