class FancyInfoProvider : BasicInfoProvider(){

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy Info Provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        print ("Fancy Info")
    }
}

// default: classes are closed, cannot be extended/inherited, add open before class to make it inheritable