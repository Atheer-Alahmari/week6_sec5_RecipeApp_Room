package com.example.week6_sec5_recipeapproom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6_sec5_recipeapproom.models.Book
import com.example.week6_sec5_recipeapproom.models.BookDataBase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_update_delete_user.*
import kotlin.random.Random

class Update_Delete_user : AppCompatActivity() {
    lateinit var myDBRoom: BookDataBase
    lateinit var list_b: List<Book>
    lateinit var list_RV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete_user)
        myDBRoom = BookDataBase.getInstance(this)
        list_RV = findViewById(R.id.recycler_View)// Recycler View
        list_b = listOf()

        updateList()


    }

    fun updateList() {
        list_b=myDBRoom.BookDao1().getAllBooks()

        list_RV.adapter = RV_Adapter(this,list_b)
        list_RV.layoutManager = LinearLayoutManager(this)

        list_RV.scrollToPosition(list_b.size - 1)

    }
}