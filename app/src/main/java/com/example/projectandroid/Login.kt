package com.example.projectandroid


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.tampilan_login.*

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tampilan_login)

        auth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener {
            if(email.text.trim().toString().isNotEmpty() || password.text.trim().toString().isNotEmpty()) {
                Loginn(email.text.trim().toString(), password.text.trim().toString());

            }else{
                Toast.makeText(this,"Input Required", Toast.LENGTH_LONG).show();
            }
        }
    }

    fun Loginn(email: String, password: String) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful){
                    val intent = Intent(this, Rating::class.java);
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Eror !!"+task.exception, Toast.LENGTH_LONG).show()
                }

            }

    }
}