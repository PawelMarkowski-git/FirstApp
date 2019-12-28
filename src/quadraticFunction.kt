import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

fun quadraticF(){

ShowBannerApp().banner("****** Program obliczający miejsca zerowe funkcji kwadratowej y = ax2 + bx + c ********")

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

    Menu().choiceAfterProgram(3)

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


    Menu().choiceAfterProgram(3)

}