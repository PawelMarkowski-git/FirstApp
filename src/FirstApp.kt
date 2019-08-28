fun login(){
/* Funkcja weryfikująca zgodność loginu i hasła. Jeżeli prawda, to przechodzi do menu "menuChoice()",
jeżeli nie prawda, to uruchamia się pętla */

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

fun choiceAfterProgram(Program: Int) {

/*Funkcja uruchamiana po zakończeniu działania wybranego programu. Użytkownik decyduje o ponownym uruchomieniu programu
"menu(Program)" (parameter "Program" jest przekazywany jako identyfikator tego programu, z którego ta funckcja zostałą
wywołana) lub powrocie do menu głównego "menuChoice()"  */

    var choice: String

    do {

        println()
        println("Czy chcesz ponownie uruchomić program (T), czy chcesz wrócić do menu (N)?")
        choice = readLine()!!.toUpperCase()

        if (choice == "T") {

            menu(Program)

        } else if (choice == "N") {

            menuChoice()

        } else {
            println("Błędna wybór- dostępne wybory (T) lub (N)")
        }

    } while (choice != "T" || choice != "N")

    }

fun menuChoice() {

/*Funkcja prezentująca menu główne oraz przekazująca wybór użytkownika do "menu(MenuNumber)"*/

    println()
    println("Opcje menu:")
    println()
    println("1- Dodawanie dwóch liczb")
    println("2- Stoper")
    println("3- Wyloguj się")

       try {

           var menuNumber: Int = readLine()!!.toInt()

           if (menuNumber < 0 || menuNumber > 3) {

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

/*Funckcja uruchamiająca poszczególne programy (funkcje)*/

    when(MenuNumber){

        1 -> sum()
        2 -> stopwatch()
        3 -> login()

    }

}

fun sum() {

/*Funkcja obliczająca sumę dwóch liczb wprowadzanych przez użytkownika*/

    var a: Double
    var b: Double

    println()
    println("Obliczanie sumy dwóch liczb a i b")

    try {

        println()
        print("Wprowadź a = ")
        a = readLine()!!.toDouble()

        print("Wprowadź b = ")
        b = readLine()!!.toDouble()


        println()
        println("Suma $a + $b = ${a + b}")

    }

    catch (exception: NumberFormatException){

        println()
        println("Błędna wartość- spróbuj ponownie, program oczekuje liczby!")

    }

    choiceAfterProgram(1)

}

fun stopwatch(){

/*Fukcja odliczająca sekundy od wartości podanej przez użytkownika*/


    println()
    print("Wprowadź czas: ")

    try {

        var time: Int= readLine()!!.toInt()

        if(time < 0) throw ArithmeticException("Błedna wartość- podaj ponownie prawidłowy czas! Wartość powinna być większa od 0")

        for(i in time downTo 0) {

            if(i != 0) {

                println(i)
                Thread.sleep(1000)
            }
            else {

                println("Koniec czasu!!!")
            }

        }

    }

    catch (exception: NumberFormatException) {

        println()
        println("Błędna wartość- podaj ponownie prawidłowy czas!")
        println()

    }

    catch (exception: ArithmeticException){

        println()
        println(exception.message)
        println()

    }

   choiceAfterProgram(2)
}


fun main(args: Array<String>)
{
    login()
}
