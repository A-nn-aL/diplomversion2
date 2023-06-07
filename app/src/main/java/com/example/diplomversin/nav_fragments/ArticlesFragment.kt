package com.example.diplomversin.nav_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diplomversin.ArticleData
import com.example.diplomversin.R
import com.example.diplomversin.adapters.ArticlesAdapter
import com.example.diplomversin.second_fragments.ArticleActivity

class ArticlesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList1: ArrayList<ArticleData>
    private lateinit var titleList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_articles, container, false)

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

        recyclerView = view.findViewById(R.id.recyclerView_2)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        dataList1 = arrayListOf()
        getData()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set the title of the fragment
        activity?.title = "Статті"
    }

    private fun getData() {
        for (i in titleList.indices) {
            val dataClass = ArticleData(R.drawable.ic_baseline_book_24, titleList[i])
            dataList1.add(dataClass)
        }
        recyclerView.adapter = ArticlesAdapter(dataList1) { articleData ->
            // Create a new Intent to start the new activity
            val intent = Intent(activity, ArticleActivity::class.java)
            // Put any data you want to pass to the new activity using Intent extras
            intent.putExtra("title", articleData.dataTitle1)
            // Start the new activity
            startActivity(intent)
        }
    }
}