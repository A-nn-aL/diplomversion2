package com.example.diplomversin.second_fragments


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.diplomversin.MainActivity
import com.example.diplomversin.R
import com.example.diplomversin.ciphers.AesCipher
import com.example.diplomversin.ciphers.TripleDesCipher
import com.example.diplomversin.databinding.ActivityEncryptBinding

import com.example.diplomversin.nav_fragments.CiphersFragment

class EncryptActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEncryptBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEncryptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val cipherName = intent.getStringExtra("title").toString()
        binding.toolbarText.text = title

        // Set up the back button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val bitSize = 128

        binding.key.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                var key = binding.key.text.toString()

                val userKeySizeBits = (key.toByteArray(Charsets.UTF_8)).size * 8
                binding.countBytes.text = userKeySizeBits.toString()

            }
        })

        binding.btnEncrypt.setOnClickListener {
            val key = binding.key.text.toString()
            val message = binding.messageEdit.text.toString()

  //           Call the cipher function with message and key
            //todo:check amount of bits
             val result = chooseCipherEncrypt(cipherName, message, key, bitSize)
             binding.result.text = result
        }

        binding.btnDecrypt.setOnClickListener {
            val key = binding.key.text.toString()
            val message = binding.messageEdit.text.toString()

//             Call the cipher function with message and key
             val result = title?.let { it1 -> chooseCipherdecrypt(it1, message, key, bitSize) }
             binding.result.text = result
        }

        binding.toolbarImage.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun chooseCipherdecrypt(cipherName: String, message: String, key: String, bitSize: Int): String? {
        return when (cipherName) {
            "AES" -> AesCipher.decrypt(message, key, bitSize)
            //"KalynaCipher" -> KalynaCipher.encrypt(message, key)
            "Triple DES" -> TripleDesCipher.decrypt(message, key, bitSize)
            else -> "Invalid cipher"
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun chooseCipherEncrypt(cipherName: String, message: String, key: String, bitSize:Int): String {

        return when (cipherName) {
            "AES" -> AesCipher.encrypt(message, key, bitSize)
            //"KalynaCipher" -> KalynaCipher.encrypt(message, key)
            "TripleDES" -> TripleDesCipher.encrypt(message, key, bitSize)
            else -> "Invalid cipher"
        }
    }
}
