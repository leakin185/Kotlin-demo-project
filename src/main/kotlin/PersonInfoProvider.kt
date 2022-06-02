interface PersonInfoProvider {
    val providerInfo: String
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

// abstract class BasicInfoProvider: PersonInfoProvider // need not apply all methods from interface

// a class implementing > 1 interfaces
open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic Info Provider"

    protected open val sessionIdPrefix = "Session" // need to be open to be overriden, enforces immutability

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val provider = object : PersonInfoProvider{
        override val providerInfo: String
            get() = "New info provider"

        fun getSessionId() = "id"

        // object expressions helps to create annonymous class without naming it
    }

    provider.printInfo(Person())
    provider.getSessionId()
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider is SessionInfoProvider) { // if sesioninfoprovider is a superclass of infoprovider
        println("is a session info provider ")
        infoProvider.getSessionId() // smart casting (system checks type)
    }
    else {
        println ("not a session info provider")}
    (infoProvider as SessionInfoProvider).getSessionId() // use as to cast
}