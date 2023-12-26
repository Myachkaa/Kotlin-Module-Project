import java.util.Scanner
abstract class Menu<T>(val list: MutableList<T>) {
    var value = 0
    fun menu() {
        println("${point()} \n${showListForMenu()}${list.size + 1}. Выход")
        read()
    }
    private fun showListForMenu(): String {
        var string = ""
        for (index in 0 until list.size) {
            val itemName = when (val element = list[index]) {
                is Archive -> element.name
                is Note -> element.name
                else -> element.toString()
            }
            string += "${index + 1}. $itemName\n"
        }
        return string
    }
    private fun read() {
        while (true) {
            val answer = Scanner(System.`in`).nextLine()
            try {
                value = answer.toInt()
                when (value) {
                    0 -> make()
                    in 1..list.size -> showItem()
                    list.size + 1 -> exit()
                    else -> println("Введено недопустимое значение, попробуйте ещё раз")
                }
            } catch (e: NumberFormatException) {
                println("Введите число")
            }
        }
    }
    fun addValue(message: String): String {
        var answer: String
        do {
            println(message)
            answer = Scanner(System.`in`).nextLine()
            if (answer == ""){
                println("Поле не может быть пустым")
            }
        } while (answer == "")
        return answer
    }

    abstract fun exit()
    abstract fun make()
    abstract fun showItem()
    abstract fun point(): String
}
