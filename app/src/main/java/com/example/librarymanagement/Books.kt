package com.example.librarymanagement

import java.sql.Date

class Books {
    private lateinit var bookname:String
    private val mTimestamp: Date? = null

    constructor()
    constructor(bookname: String) {
        this.bookname = bookname
    }

}