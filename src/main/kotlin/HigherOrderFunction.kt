fun printFilteredStrings(list: List<String>, predicate:(String) -> Boolean){
list.forEach{
    if(predicate(it)){
        println(it)
    }
}
}
// predicate is a function that takes in string and returns boolean, functional types
fun printFilteredStrings2(list: List<String>, predicate: ((String) -> Boolean)?){
    list.forEach{
        if(predicate?.invoke(it) == true){
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

fun getPrintPredicate(): (String) -> Boolean {
    return {it.startsWith("J")}
}

fun main() {
    val list = listOf("Kotlin", "C++", "Java", "Python")
    // printFilteredStrings(list, {it.startsWith("K")}) OR the way below
//    printFilteredStrings(list){
//        it.startsWith("J")
//    }
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate())
    printFilteredStrings2(list, null)
}