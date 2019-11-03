fun login(){

    val correctLogin: String = "pawel"
    val correctPassword: String = "123"

    var login: String?
    var password: String?

        do {

            println()
            print("Podaj login: ")
            login = readLine()!!

            print("Podaj hasło: ")
            password = readLine()!!

            if(login != correctLogin || password != correctPassword){

                println()
                println("Błędny login lub hasło")

            }

        }while(login != correctLogin || password != correctPassword)

    menuChoice()

}