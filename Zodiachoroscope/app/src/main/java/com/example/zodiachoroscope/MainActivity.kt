// MainActivity.kt
package com.example.zodiachoroscope

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val birthDateEditText = findViewById<EditText>(R.id.birthDateEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val zodiacSignTextView = findViewById<TextView>(R.id.zodiacSignTextView)
        val zodiacPersonalityTextView = findViewById<TextView>(R.id.zodiacPersonalityTextView)
        val zodiacImageView = findViewById<ImageView>(R.id.zodiacImageView)
        val backButton: Button = findViewById(R.id.btn_back)

        backButton.setOnClickListener {
            finish()
        }

        submitButton.setOnClickListener {
            val inputDate = birthDateEditText.text.toString()
            val zodiacSign = getZodiacSign(inputDate)
            val zodiacPersonality = getZodiacPersonality(zodiacSign)
            zodiacSignTextView.text = zodiacSign
            zodiacPersonalityTextView.text = zodiacPersonality

            val zodiacImageResId = when (zodiacSign) {
                "กุมภ์" -> R.drawable.zodiac_aquarius
                "มีน" -> R.drawable.zodiac_pisces
                "เมษ" -> R.drawable.zodiac_aries
                "พฤษภ" -> R.drawable.zodiac_taurus
                "เมถุน" -> R.drawable.zodiac_gemini
                "กรกฎ" -> R.drawable.zodiac_cancer
                "สิงห์" -> R.drawable.zodiac_leo
                "กันย์" -> R.drawable.zodiac_virgo
                "ตุลย์" -> R.drawable.zodiac_libra
                "พิจิก" -> R.drawable.zodiac_scorpio
                "ธนู" -> R.drawable.zodiac_sagittarius
                "มังกร" -> R.drawable.zodiac_capricorn
                else -> R.drawable.icon
            }
            zodiacImageView.setImageResource(zodiacImageResId)
        }
    }

    private fun getZodiacSign(dateString: String): String {
        val dateFormat = SimpleDateFormat("MMdd", Locale.getDefault())
        val date = dateFormat.parse(dateString) ?: return ""
        val calendar = Calendar.getInstance()
        calendar.time = date
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return when {
            (month == 12 && day >= 16 ) || (month == 1 && day <= 14) -> "ธนู"
            (month == 1 && day >= 15) || (month == 2 && day <= 12) -> "มังกร"
            (month == 2 && day >= 13) || (month == 3 && day <= 14) -> "กุมภ์"
            (month == 3 && day >= 15) || (month == 4 && day <= 12) -> "มีน"
            (month == 4 && day >= 13) || (month == 5 && day <= 14) -> "เมษ"
            (month == 5 && day >= 15) || (month == 6 && day <= 14) -> "พฤษภ"
            (month == 6 && day >= 15) || (month == 7 && day <= 14) -> "เมถุน"
            (month == 7 && day >= 15) || (month == 8 && day <= 15) -> "กรกฎ"
            (month == 8 && day >= 16) || (month == 9 && day <= 16) -> "สิงห์"
            (month == 9 && day >= 17) || (month == 10 && day <= 16) -> "กันย์"
            (month == 10 && day >= 17) || (month == 11 && day <= 15) -> "ตุลย์"
            (month == 11 && day >= 16) || (month == 12 && day <= 15) -> "พิจิก"
            else -> "ไม่พบราศี"
        }
    }
    private fun getZodiacPersonality(zodiacSign: String): String {
        return when (zodiacSign) {
            "กุมภ์" -> "คุณมีสมองเป็นผู้นำในการพัฒนาและคิดค้นสิ่งใหม่ คุณมีความคิดแปลกใหม่และชอบสนทนาทางปัญญา."
            "มีน" -> "คุณมีความสามารถในการรับและให้ความห่วงใย คุณรู้สึกต่อผู้อื่นอย่างไวเร็วและเชื่อถือได้."
            "เมษ" -> "คุณมีความกล้าหาญ ตั้งใจ และมีความเชื่อมั่นในตนเอง."
            "พฤษภ" -> "คุณเป็นคนที่เชื่อถือได้ อดทน และมีความรักในสิ่งที่ดีของชีวิต."
            "เมถุน" -> "คุณเป็นคนที่สามารถปรับตัวได้ง่าย อยากรู้อยากเห็น และชอบสื่อสารกับผู้อื่น."
            "กรกฎ" -> "คุณมีความเอื้อเฟื้อ มีความรู้สึกของใจที่แข็งแรง และมีความสามารถในการเข้าใจอารมณ์ของผู้อื่น."
            "สิงห์" -> "คุณมีความเชื่อมั่นในตนเอง ใจบุญ และชอบที่จะเป็นจุดศูนย์กลางในความสนใจ."
            "กันย์" -> "คุณเป็นคนที่มีวิจารณญาณ ตั้งใจ และมีความรับผิดชอบต่อตนเองและผู้อื่น."
            "ตุลย์" -> "คุณมีความสามารถในการแก้ไขข้อขัดแย้ง มีความสัมพันธ์ที่ดี และพยายามสร้างความสมดุลในความสัมพันธ์."
            "พิจิก" -> "คุณมีความอยากรู้สึกอย่างเข้มงวด ตั้งใจ และมีสมองเป็นแหลม."
            "ธนู" -> "คุณชอบการผจญภัย มีทฤษฎีและมีความสนใจในความรู้."
            "มังกร" -> "คุณมีความเสียสละ ใจกว้าง และมีความเชื่อมั่นในประเพณีและการเข้าใจของตนเอง."
            else -> "ไม่พบราศี"
        }
    }

}

