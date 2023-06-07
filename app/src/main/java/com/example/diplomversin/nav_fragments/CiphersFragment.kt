package com.example.diplomversin.nav_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diplomversin.CipherData
import com.example.diplomversin.CiphersAdapter
import com.example.diplomversin.R
import com.example.diplomversin.second_fragments.EncryptActivity


class CiphersFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<CipherData>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ciphers, container, false)

        imageList = arrayOf(
            R.drawable.ic_baseline_book_24
        )

        titleList = arrayOf(
            "AES",
            "Kalina",
            "Triple DES",
            "Blowfish",
            "Camellia",
            "Cast-128",
            "Data Encryption Standard (DES)",
            "International Data Encryption Algorithm (IDEA)",
            "RC4",
            "Serpent",
            "Twofish"
        )

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getData()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the title of the fragment
        activity?.title = "Шифри"
    }

    private fun getData() {
        for (i in titleList.indices) {
            val dataClass = CipherData(imageList[0], titleList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = CiphersAdapter(dataList) { cipherData ->
            // Create a new Intent to start the new activity
            val intent = Intent(activity, EncryptActivity::class.java)
            // Put any data you want to pass to the new activity using Intent extras
            intent.putExtra("title", cipherData.dataTitle)
            intent.putExtra("image", cipherData.dataImage)
            // Start the new activity
            startActivity(intent)
        }
    }

}
