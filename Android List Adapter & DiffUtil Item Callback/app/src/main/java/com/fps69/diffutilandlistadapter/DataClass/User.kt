package com.fps69.diffutilandlistadapter.DataClass

import java.util.UUID

data class User(val id : String = UUID.randomUUID().toString(),
                val userName:String?=null)
