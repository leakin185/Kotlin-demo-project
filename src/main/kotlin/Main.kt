fun sayHello(item1:String, vararg item2:String) {
    item2.forEach {item ->
        println("$item1 $item")
    }
}

fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")
// what if the order of input parameters change
// default values added



fun main() {
    val person = Person("Yi", "Wang") // no need to use new, a new instance of a class
    // secondary constructor is not evoked
    val person2 = Person() // secondary constructor is evoked
    // init boxes are always run before the secondary constructor, in the order which they are defined
    println(person.firstName)
    person.nickName = "Shades"
    println(person.nickName)

    person.printInfo()
}
