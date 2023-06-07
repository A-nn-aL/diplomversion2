package com.example.diplomversin.ciphers

import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESedeKeySpec

class TripleDesCipher {
    companion object{
    fun encrypt(message: String, key: String, keyLength: Int): String {
        // Convert the key to bytes
        val keyBytes = key.toByteArray()

        // Create a DESedeKeySpec object from the key bytes
        val keySpec = DESedeKeySpec(keyBytes)

        // Create a SecretKey object from the key specification
        val keyFactory = SecretKeyFactory.getInstance("DESede")
        val secretKey: SecretKey = keyFactory.generateSecret(keySpec)

        // Create a Cipher object and initialize it with the key and mode
        val cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)

        // Convert the message to bytes
        val messageBytes = message.toByteArray()

        // Encrypt the message
        val resultBytes = cipher.doFinal(messageBytes)

        // Convert the result bytes to a string and return it
        return String(resultBytes)
    }

    fun decrypt(cipherText: String, key: String, keyLength: Int): String {
        // Convert the key to bytes
        val keyBytes = key.toByteArray()

        // Create a DESedeKeySpec object from the key bytes
        val keySpec = DESedeKeySpec(keyBytes)

        // Create a SecretKey object from the key specification
        val keyFactory = SecretKeyFactory.getInstance("DESede")
        val secretKey: SecretKey = keyFactory.generateSecret(keySpec)

        // Create a Cipher object and initialize it with the key and mode
        val cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKey)

        // Convert the ciphertext to bytes
        val cipherTextBytes = cipherText.toByteArray()

        // Decrypt the ciphertext
        val resultBytes = cipher.doFinal(cipherTextBytes)

        // Convert the result bytes to a string and return it
        return resultBytes.toString()
    }}

}

