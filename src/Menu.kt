class Menu {

    fun menuChoice() {

        println()
        println("Opcje menu:")
        println()
        println("1- Dodawanie dwóch liczb")
        println("2- Stoper")
        println("3- Funkcja kwadratowa")
        println("4- Wyloguj się")

        try {

            var menuNumber: Int = readLine()!!.toInt()

            if (menuNumber < 0 || menuNumber > 4) {

                println("Błędny numer opcji!- spróbuj ponownie")
                menuChoice()

            }

            menu(menuNumber)


        } catch (exception: NumberFormatException) {

            println("Błędny numer opcji!- spróbuj ponownie")
            menuChoice()

        }

    }


    fun menu(MenuNumber: Int){

        when(MenuNumber){

            1 -> sum()
            2 -> stopwatch()
            3 -> quadraticF()
            4 -> {ShowBannerApp()
                .banner("**************                    Logowanie                         *******************")
                  Login().checkLoginAndPassword()}

        }

    }


    fun choiceAfterProgram(Program: Int) {

        var choice: String

        do {

            println()
            println("Czy chcesz ponownie uruchomić program (T), czy chcesz wrócić do menu (N)?")
            choice = readLine()!!.toUpperCase()

            if (choice == "T") {

                Menu().menu(Program)

            } else if (choice == "N") {

                Menu().menuChoice()

            } else {
                println("Błędna wybór- dostępne wybory (T) lub (N)")
            }

        } while (choice != "T" || choice != "N")

    }

}