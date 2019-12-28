class Login {

    private val correctLogin = arrayOf("pawel","pawel2","pawel13")
    private val correctPassword = arrayOf("123","321","pawel13")

    private var login: String? = null
    private var password: String? = null

    fun checkLoginAndPassword(){

        do {

            var indexOfArrayCorrectLogin: Int = 0
            var successLogin: Boolean = false
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

                password == correctPassword[indexOfArrayCorrectLogin] -> Menu().menuChoice()

            }

        }while(!successLogin)

    }

}