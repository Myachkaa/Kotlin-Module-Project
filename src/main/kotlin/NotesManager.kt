import java.util.Scanner

class NotesManager( notes: MutableList<Note>,
                    private val archivesManager: ArchivesManager) : Menu<Note>(notes) {
    override fun exit() {
        archivesManager.menu()
    }
    override fun make() {
        val name = addValue("Введите название заметки")
        val content = addValue("Введите заметку")
            list.add(Note(name, content))
            println("Заметка добавлена")
        menu()
    }
    override fun showItem() {
        println("Заметка \"${list[value - 1].name}\"\n${list[value-1].content}\n0. Выход")
        val answer = Scanner(System.`in`).nextLine()
        try {
            value = answer.toInt()
            when (value) {
                0 -> this.menu()
                else -> println("Введено недопустимое значение, попробуйте ещё раз")
            }
        } catch (e: NumberFormatException) {
            println("Введите число")
        }
    }
    override fun point(): String {
        return "0. Создать заметку"
    }
}