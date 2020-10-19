package com.farsitel.bazaar.inappupdate.exception

class BazaarNotFoundException : IllegalStateException() {

    override val message: String?
        get() = "Bazaar is not installed"

}
