package com.example.trojan.kotlin_formlogin

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(email == "admin@gmail.com" && password == "admin"){
                val progressDialog = ProgressDialog(this,
                    R.style.Theme_MaterialComponents_Light_Dialog)
                progressDialog.isIndeterminate = true
                progressDialog.setMessage("Loading...")
                progressDialog.show()

                val intent = Intent (this,Dashboard::class.java)
                startActivity(intent)
                finish()

            }else if(email == "admin@gmail.com" && password != "admin"){
                Toast.makeText(this,"Password is Invalid!",Toast.LENGTH_SHORT).show()
            }else if(email != "admin@gmail.com" && password == "admin"){
                Toast.makeText(this,"Email is Invalid!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
