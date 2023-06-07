package com.example.diplomversin.ciphers

import android.os.Build
import androidx.annotation.RequiresApi
import java.security.Key
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

class AesCipher {

    companion object {

        private const val ALGORITHM = "AES"
        private const val TRANSFORMATION = "AES/ECB/PKCS5Padding"


        @RequiresApi(Build.VERSION_CODES.O)
        fun encrypt(message: String, key: String, keySize: Int): String {
            val cipher = getCipher(Cipher.ENCRYPT_MODE, key, keySize)
            val encryptedBytes = cipher.doFinal(message.toByteArray(Charsets.UTF_8))
            return Base64.getEncoder().encodeToString(encryptedBytes)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun decrypt(message: String, key: String, keySize: Int): String? {
            val cipher = getCipher(Cipher.DECRYPT_MODE, key, keySize)
            val decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(message))
            return String(decryptedBytes, Charsets.UTF_8)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun getCipher(mode: Int, key: String, keySize: Int): Cipher {
            val secureRandom = SecureRandom.getInstanceStrong()
            val keyGenerator = KeyGenerator.getInstance(ALGORITHM)
            keyGenerator.init(keySize, secureRandom)
            val secretKey: Key = SecretKeySpec(key.toByteArray(Charsets.UTF_8), ALGORITHM)
            val cipher = Cipher.getInstance(TRANSFORMATION)
            cipher.init(mode, secretKey)
            return cipher
        }
    }
    // TODO: "Додаток також повинен містити компоненти для управління ключами. Управління ключами є критично важливим для безпеки інформації, оскільки воно визначає, хто має доступ до зашифрованих даних. Додаток повинен дозволяти генерувати та зберігати ключі, а також мати можливість відкликати або оновити ключі за необхідності.")
}
