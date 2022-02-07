package com.example.sakura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sakura.Network.MyInterface
import com.example.sakura.Network.MyRetrofit
import com.example.sakura.Network.login
import retrofit2.Call
import retrofit2.Response
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
                val hashMap:HashMap<String,String> = hashMapOf()
                hashMap.put("email",email.text.toString())
                hashMap.put("password",password.text.toString())
                val ret = MyRetrofit().getRetrofit()
                val inter=ret.create(MyInterface::class.java)
                val call=inter.getLogin(hashMap)
                    .enqueue(object : retrofit2.Callback<login> {
                        override fun onResponse(call: Call<login>, response: Response<login>) {
                            if(response.isSuccessful)
                            {
                                val intent= Intent(this@SignInScreen,MenuScreen::class.java)
                                startActivity(intent)
                                Toast.makeText(this@SignInScreen, response.code().toString(),Toast.LENGTH_SHORT).show()
                            }
                            else
                            {
                                Toast.makeText(this@SignInScreen,response.code().toString(),Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<login>, t: Throwable) {
                            Toast.makeText(this@SignInScreen,t.localizedMessage,Toast.LENGTH_SHORT).show()
                        }
                    })
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