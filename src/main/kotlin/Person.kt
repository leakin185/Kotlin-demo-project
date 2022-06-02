//class Person(_firstName: String, _lastName: String) {
//    // pass inputs into the constructor
//    val firstName: String = _firstName
//    val lastName: String = _lastName
//
//    // OR
////    init {
////        firstName = _firstName
////        lastName = _lastName
////    }
//
//}

//class Person(val firstName: String,  val lastName: String) { // more efficient
//    init {
//        println("init 1")
//    }
//
//    constructor() : this("Peter", "Parker") {
//        println("Secondary constructor")
//    }
//
//    init {
//        println("init 2")
//    }
//}

// secondary constructors

class Person (val firstName: String = "Peter",  val lastName: String = "Parker") {
    var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value") // override
        }
    get() {
        println("the returned value is $field")
    return field // we use field to get the stored value
    }

    fun printInfo() {
        // val nickNamePrint = if(nickName != null) nickName else "No Nickname" // may be inconvenient
        val nickNamePrint = nickName ?: "no nickname" // better
        println("$firstName ($nickNamePrint) $lastName")
    }
}
// secondary constructors are not so necessary with the use of default parameters
// properties in classes in kotlin will get getters and setters generated for them automatically, can override

// visibility modifier, public by default
// we can add internal before class: visible only within the module, private: only visible within the file itself
// similarly for variables and functions
// protected/private properties/methods are only visible within that class/subclasses (not available to main.kt)
// private means visible inside this class only (including all its members);
//protected — same as private + visible in subclasses too;