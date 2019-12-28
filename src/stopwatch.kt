fun stopwatch(){

    ShowBannerApp().banner("*****************************           Stoper         ********************************")

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

    Menu().choiceAfterProgram(2)
}