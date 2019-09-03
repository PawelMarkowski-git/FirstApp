import kotlin.math.*

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

/*Funckcja uruchamiająca poszczególne programy (funkcje)*/

    when(MenuNumber){

        1 -> sum()
        2 -> stopwatch()
        3 -> quadraticF()
        4 -> login()

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

fun quadraticF(){

    println()
    println("Program obliczający miejsca zerowe funkcji kwadratowej y = ax2 + bx + c")
    println()

    var a: Double
    var b: Double
    var c: Double


    try {

        print("Wprowadź parametr a = ")
        a = readLine()!!.toDouble()

        print("Wprowadź parametr b = ")
        b = readLine()!!.toDouble()

        print("Wprowadź parametr c = ")
        c = readLine()!!.toDouble()
        println()

        if (a == 0.0){

            println("To nie jest funkcja kwadratowa, parametr a nie może być zerem")

        }

        else {


            var delta: Double = b.pow(2) - 4 * a * c

            println()
            println("Delta b2 - 4*a*c = ${round(delta * 100) / 100}")
            println()

            var formFunction: String = ""
            var quantitiPlacesZero: String = ""

            if (a > 0) {

                formFunction = "jest skierowana ramionami w górę"

            } else if (a < 0) {

                formFunction = "jest skierowana ramionami w dół"

            }

            if (delta > 0.0) {

                quantitiPlacesZero = "ma dwa miejsca zerowe"

            } else if (delta < 0.0) {

                quantitiPlacesZero = "nie ma miejsc zerowych"

            } else if (delta == 0.0) {

                quantitiPlacesZero = "ma tylko jedno miejsce zerowe"

            }


            println()
            println("Funkcja $a*x^2 + $b*x + $c $formFunction oraz $quantitiPlacesZero")
            println()

            if (delta > 0.0) {

                var x1: Double = (-b + sqrt(delta)) / (2 * a)
                var x2: Double = (-b - sqrt(delta)) / (2 * a)

                println("x1 = ${round(x1 * 100) / 100}")
                println("x2 = ${round(x2 * 100) / 100}")

            } else if (delta == 0.0) {

                var x: Double = -b / 2 * a

                if (x == -0.0){

                    x = 0.0

                }


                println("x = $x")


            } else {

                println()

            }


            do {

                println()
                println("Czy chcesz obliczyć wartości funkcji dla wybranych argumentów/zakresu argumentów- Tak(T) Nie(N)?")

                var choice: String = readLine()!!.toUpperCase()

                if (choice == "T") {

                    CalculationQuadraticFunction(a,b,c)

                } else if (choice != "T" && choice != "N") {

                    println("Błędny wybór- dostępne wybory (T) lub (N)")

                }

            }while (choice != "T" && choice != "N")

        }

    }
    catch (exception: NumberFormatException){

        println("Wprowadzona wartość nie jest liczbą")

    }

    choiceAfterProgram(3)

}

fun CalculationQuadraticFunction(a: Double,b: Double,c: Double){

    println("Obliczanie wartości funkcj kwadratowej dla wybranego zakresu argumentów")
    println()

        var firstValue: Double
        var endValue: Double

        do {

            print("Wprowadź początek zakresu od: ")
            firstValue = readLine()!!.toDouble()
            println()

            print("Wprowadź koniec zakresu do: ")
            endValue = readLine()!!.toDouble()
            println()

            if (firstValue > endValue){

                println("Wartość zakresu od nie może być większa od wartości do")
                println()

            }

        }while (firstValue > endValue)


        var stepFun: Double


        do {

            print("Wprowadź krok dla podanego zakresu: ")
            stepFun = readLine()!!.toDouble()
            println()

            if (stepFun > endValue - firstValue){

                println("Wartość kroku nie może być większa od rożnicy pomiędzy zakresem do i od")

            }
            else if(stepFun <= 0.0){

                println("Wartość kroku nie może być <= 0")

            }

        }while (stepFun > endValue - firstValue || stepFun <= 0.0)


    var valueOfArgument: Double
    var arraySize: Int = 0

        valueOfArgument = firstValue

        while (valueOfArgument <= endValue){

            valueOfArgument = valueOfArgument + stepFun

            arraySize = arraySize + 1

        }


            var argumentsArray = arrayOfNulls<Double>(arraySize)


            valueOfArgument = firstValue

            argumentsArray[0] = valueOfArgument

            for (i in 1..arraySize - 1) {

                argumentsArray[i] = valueOfArgument + stepFun

                valueOfArgument = valueOfArgument + stepFun

            }

            for (arguments in argumentsArray){

                var argument: Double = arguments!!.toDouble()

                println("Dla argumentu = ${round(argument * 100) / 100} funkcja otrzymuje wartość = ${round(((a*argument.pow(2) + b*argument + c) * 100)/100)}")

            }


    choiceAfterProgram(3)

}

fun main(args: Array<String>) {

    println()
    println("***************************************************************************************")
    println("***************************************************************************************")
    println("**************                                                      *******************")
    println("**************                     FirstApp                         *******************")
    println("**************                                                      *******************")
    println("***************************************************************************************")
    println("***************************************************************************************")



    login()
}
