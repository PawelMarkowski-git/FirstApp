fun login(){
/* Funkcja weryfikująca zgodność loginu i hasła. Jeżeli prawda, to przechodzi do menu "menuChoice()",
jeżeli nie prawda, to uruchamia się pętla */

    val CorrectLogin: String = "pawel"
    val CorrectPassword: String = "123"

    var Login: String?
    var Password: String?

    do {

        while(true) {

            print("Podaj login: ")
            Login = readLine()!!

            if(Login.length == 0){
                println("Pole Login nie może być puste")
            }
            else {
                break
            }

        }

        while(true) {

            print("Podaj hasło: ")
            Password = readLine()!!

            if(Password.length == 0){
                println("Pole hasło nie może byc puste")
            }
            else{
                break
            }

        }

        if(Login != CorrectLogin || Password != CorrectPassword){
            println("Błędny login lub hasło")
        }

    }while(Login != CorrectLogin || Password != CorrectPassword)

    menuChoice()

}

fun choiceAfterProgram(Program: Int) {

/*Funkcja uruchamiana po zakończeniu działania wybranego programu. Użytkownik decyduje o ponownym uruchomieniu programu
"menu(Program)" (parameter "Program" jest przekazywany jako identyfikator tego programu, z którego ta funckcja zostałą
wywołana) lub powrocie do menu głównego "menuChoice()"  */

    var choice: String
    do {

        println()
        println("Czy chcesz ponownie uruchomić program Stoper (T), czy chcesz wrócić do menu (N)?")
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
    println("1- Dodawanie dwóch liczb")
    println("2- Stoper")
    println("3- Funkcja kwadratowa")
    println("4- Wyloguj się")

    var MenuNumber: Int

    MenuNumber = readLine()!!.toInt()

    menu(MenuNumber)

}

fun menu(MenuNumber: Int){

/*Funckcja uruchamiająca poszczególne programy (funkcje)*/

    when(MenuNumber){

        1 -> sum()
        2 -> stopwatch()
        4 -> login()

    }

}

fun sum() {

/*Funkcja obliczająca sumę dwóch liczb wprowadzanych przez użytkownika*/

    var a: Int
    var b: Int
    var sumab: Int
    var choice: String

    println("Obliczanie sumy dwóch liczb a i b")

            print("Wprowadź a = ")
            a = readLine()!!.toInt()

            print("Wprowadź b = ")
            b = readLine()!!.toInt()

            sumab = a + b
            println("Suma $a + $b = $sumab")


    choiceAfterProgram(1)

}

fun stopwatch(){

/*Fukcja odliczająca sekundy od wartości podanej przez użytkownika*/

    print("Wprowadź czas: ")
    var time: Int = readLine()!!.toInt()

    for(i in time downTo 0)
    {
        if(i != 0)
        {
            println(i)
            Thread.sleep(1000)
        }
        else
        {
            println("Koniec czasu!!!")
        }

    }

   choiceAfterProgram(2)
}


fun main(args: Array<String>)
{
    login()
}