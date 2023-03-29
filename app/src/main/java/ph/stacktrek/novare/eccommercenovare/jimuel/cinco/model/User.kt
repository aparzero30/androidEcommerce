package ph.stacktrek.novare.eccommercenovare.jimuel.cinco.model

import java.time.LocalDateTime

open class User(val username:String,  val password:String){


    lateinit var userID: String
        private set
    lateinit var accountCreated: LocalDateTime
        private set
    lateinit var lastLogin: LocalDateTime
        private set
    lateinit var email: String
        private set
    lateinit var mobileNUmber: String
        private set

    init{
        println("init called")
    }

    constructor(): this("", "")

}

class ShopOwner() : User(){
    lateinit var shopName:String
        private set
    lateinit var rating: ArrayList<String>
        private set
    lateinit var product:ArrayList<Product>
        private set

}

class Buyer() : User(){
//    lateinit var cart:ArrayList<String>



}
