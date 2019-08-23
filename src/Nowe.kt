fun main(args: Array<String>)
{
    print("Wprowadź czas: ")
    var czas: Int = readLine()!!.toInt()

    for(i in czas downTo 0)
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

}