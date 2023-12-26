import kotlin.system.exitProcess
class ArchivesManager : Menu<Archive>(mutableListOf()) {
    override fun exit() {
        exitProcess(0)
    }
    override fun make() {
        val name = addValue("Введите название архива")
        list.add(Archive(name))
        menu()
    }
    override fun showItem() {
        val selectedArchive = list[value - 1]
        println("Архив \"${selectedArchive.name}\"")

        val notesManager = NotesManager(selectedArchive.notes, this)
        notesManager.menu()
    }
    override fun point(): String {
        return "0. Создать архив"
    }
}
