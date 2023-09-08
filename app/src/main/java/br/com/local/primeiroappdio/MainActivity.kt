package br.com.local.primeiroappdio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewApresentacao = findViewById<TextView>(R.id.textViewApresentacao)


        val apresentacao = getString(R.string.apresentacao)


        val linkStartIndex = apresentacao.indexOf("[Github]")
        val linkEndIndex = linkStartIndex + "[Github]".length


        val spannableString = SpannableString(apresentacao)


        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {

                val uri = Uri.parse("https://github.com/fabynho")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }


        spannableString.setSpan(clickableSpan, linkStartIndex, linkEndIndex, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)


        textViewApresentacao.text = spannableString


        textViewApresentacao.movementMethod = LinkMovementMethod.getInstance()
    }
}