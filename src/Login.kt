fun login(){

    println()
    println("***************************************************************************************")
    println("**************                    Logowanie                         *******************")
    println("***************************************************************************************")


    val correctLogin = arrayOf("pawel","pawel2","pawel13")
    val correctPassword = arrayOf("123","321","pawel13")

    var login: String?
    var password: String?


    do {

        var indexOfArrayCorrectLogin: Int = 0
        var successLogin: Boolean = true
        var issetLogin: Boolean = false

            println()
            print("Podaj login: ")
            login = readLine()

            print("Podaj hasło: ")
            password = readLine()


            for (elementInArray in correctLogin) {

                if (login == elementInArray) issetLogin = true

                else if(login != elementInArray && !issetLogin) indexOfArrayCorrectLogin += 1

            }

            when {

                indexOfArrayCorrectLogin == correctLogin.size -> {println("Taki użytkownik nie istnieje")
                                                                  successLogin = false}

                password != correctPassword[indexOfArrayCorrectLogin] -> {println("Błędne hasło")
                                                                          successLogin = false}

                password == correctPassword[indexOfArrayCorrectLogin] -> menuChoice()

            }

    }while(!successLogin)

}