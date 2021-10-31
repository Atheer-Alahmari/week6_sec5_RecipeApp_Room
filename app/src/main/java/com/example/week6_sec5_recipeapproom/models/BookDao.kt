package com.example.week6_sec5_recipeapproom.models

import androidx.room.*

@Dao
interface BookDao {
    @Query("SELECT * FROM Books /* ORDER BY Note DESC*/")
    fun getAllBooks():List<Book>

    @Insert
    fun insertBook(input: Book)
    @Delete
    fun deleteBook(id: Book)

    @Update
    fun updateBook(id: Book)
}