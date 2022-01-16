package com.example.basketquiz.User

data class User(
    var name: String ?= null,
    var lastName: String ?= null,
    var email: String ?= null,
    var age: String ?= null,
    var imageUrl: String ?= null,
    var easyScore: Int = 0,
    var mediumScore: Int = 0,
    var hardScore: Int = 0)
