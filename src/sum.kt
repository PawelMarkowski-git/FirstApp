    fun sum() {

        ShowBannerApp().banner("************************    Oblicznie sumy dwóch liczb     ****************************")

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

        } catch (exception: NumberFormatException) {

            println()
            println("Błędna wartość- spróbuj ponownie, program oczekuje liczby!")

        }

        Menu().choiceAfterProgram(1)

    }
