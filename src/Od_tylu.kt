fun main(args: Array<String>)
{
    var tablica = arrayOf("pawel", "lukasz", "")
    var i = 0

    for (slowo in tablica)
    {
        i = i + 1
    }

    print(i)

    /*

    for (slowo in tablica)
    {
        var dlugosc = slowo.length

        while(dlugosc > 0)
        {
            print(slowo[dlugosc - 1])
            dlugosc = dlugosc - 1

        }

        println()

    }

     */

}