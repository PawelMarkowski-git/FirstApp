fun main(args: Array<String>)
{

   val CorrectLogin: String = "pawel"
   val CorrectPassword: String = "123"

   var Login: String?
   var Password: String?

    while(true)

    {

        print("Podaj login: ")
        Login = readLine()!!

        print("Podaj hasło: ")
        Password = readLine()!!


       // println("Wpisałem $Login")

       // println("Hasło $Password")

        if((Login == CorrectLogin) && (Password == CorrectPassword))
        {

            println("Opcje menu")
            println("1- Dodawanie dwóch liczb")
            println("2- Stoper")
            println("3- Funkcja kwadratowa")
            println("4- ?")
            println("5- ?")
            break
        }

        else
        {

            println("Błędne logowanie- spróbuj ponownie")

        }


    }


}