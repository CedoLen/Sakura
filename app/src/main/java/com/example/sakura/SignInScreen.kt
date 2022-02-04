package com.example.sakura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern.compile

class SignInScreen : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password:EditText
    lateinit var pattern:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_screen)

        email = findViewById(R.id.editTextEmailAddress)
        password= findViewById(R.id.editTextPassword)
        pattern = "[a-z]{1,25}"+"\\@[a-z]{1,10}"+"\\.[a-z]{2,4}"
    }

    fun EmailValid(email:String):Boolean{ return compile(pattern).matcher(email).matches()}

    fun goToSignIn(view: View) {
        if(email.text.isNotEmpty() && password.text.isNotEmpty())
        {
            if(EmailValid(email.text.toString()))
            {
                val intent= Intent(this,MenuScreen::class.java)
                startActivity(intent)
            }
            else
            {
                var alertDialog = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Ошибка в поле \"Почта\".")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }
        }
        else
        {
            var alertDialog = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин и пароль.")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }
    }
}