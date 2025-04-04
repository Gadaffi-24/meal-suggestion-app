package com.example.mealsuggestion

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.annotations.TestOnly

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Function to suggest a meal based on the time of day entered
    fun onSuggestMeal(view: View) {
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)

        val timeOfDay = timeInput.text.toString().trim().toLowerCase()

        // Log user input for debugging purposes
        Log.d("MealSuggestionApp", "User entered: $timeOfDay")

        var suggestion: String

        if (timeOfDay == "morning") {
            suggestion = "Oatmeal with fruits (Healthy start)"
        } else if (timeOfDay == "mid-morning") {
            suggestion = "Granola bar (Quick snack)"
        } else if (timeOfDay == "afternoon") {
            suggestion = "Grilled chicken salad (Light, filling)"
        } else if (timeOfDay == "mid-afternoon") {
            suggestion = "Yogurt with honey (Refresh & Energize)"
        } else if (timeOfDay == "dinner") {
            suggestion = "Grilled salmon with roasted veggies (Nutrient-packed)"
        } else if (timeOfDay == "after dinner") {
            suggestion = "Dark chocolate and almonds (Light dessert)"
        } else {
            // Log error for invalid input
            Log.e("MealSuggestionApp", "Invalid input: $timeOfDay")
            // Show error if input is invalid
            Toast.makeText(this, "Invalid time entered. Please try again.", Toast.LENGTH_SHORT).show()
            return
        }

        mealSuggestion.text = "Meal Suggestion: $suggestion"
    }

    // Function to reset the input and suggestion
    fun onReset(view: View) {
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)

        timeInput.text.clear()
        mealSuggestion.text = "Meal Suggestion will appear here."
    }
}
