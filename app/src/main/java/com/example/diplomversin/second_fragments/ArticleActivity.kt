package com.example.diplomversin.second_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diplomversin.R
import com.example.diplomversin.adapters.ArticleAdapter
import com.example.diplomversin.ciphers.AesCipher
import com.example.diplomversin.ciphers.TripleDesCipher
import com.example.diplomversin.dataClass.Article
import com.example.diplomversin.databinding.ActivityArticleBinding


class ArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleBinding
    private val articleList = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarImage.setOnClickListener {
            onBackPressed()
        }

        val articleName = intent.getStringExtra("title").toString()

        binding.toolbarText1.text = articleName


//        val newArticle = Article("New Article Title", "Lorem ipsum dolor sit amet...")
//        val text = "Lorem ipsum dolor sit amet..."
//        articleList.add(newArticle)

        binding.articleTitleTextView.text = articleName
        binding.articleContentTextView.text = createArticles(articleName)
    }

    private fun createArticles(name: String): CharSequence? {
        return when (name) {
            "AES" -> Html.fromHtml("<p>This is a <b>formatted</b> <i>article</i> with <u>HTML tags</u>.</p>")
            //"KalynaCipher" -> KalynaCipher.encrypt(message, key)
            "Triple DES" -> Html.fromHtml("<p>This is a <b>formatted</b> <i>article</i> with <u>HTML tags</u>.</p>")
            else -> "Invalid cipher"
        }
    }
}
