package com.example.librarymanagement

class Data {
    private lateinit var name: String
    constructor()
    constructor(name: String) {
        this.name = name
    }
    public fun getName() : String {
        return name
    }


}