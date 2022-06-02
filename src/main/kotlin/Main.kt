val name2:String = "top-level variable" // top-level variables
var name3:String? = "mutable top-level variable" // mutable

fun main() {
    println ("Hello Kotlin")
    val name:String = "Lea"
    var name1:String = "Lea"
    name1 = "hi Lea!"

    name3 = "I like kotlin!"
    name3 = null

    println(name1)
    println(name2)
    println(name3)
}

// variables
// 1. mutable variables, declared with var keywords
// 2. local (only be used within the main() function) read-only variables, values can only be assigned once, use val keyword

// types in Kotlin are not null by default, string != nullable string
// val name: String = null -> returns error
// val name: String? = null -> nullable string, no error

// we can omit type declaration because kotlin can infer the assignment of value
val greeting = null
val greeting2 = "string inference"