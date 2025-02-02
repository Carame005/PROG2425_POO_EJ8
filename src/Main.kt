class Libro(val titulo: String, val autor: String, val numPaginas: Int, val calificacion: Double) {
    init {
        require(titulo.isNotEmpty()) { "No puede haber un título vacío" }
        require(autor.isNotEmpty()) { "No puede haber un autor vacío" }
        require(calificacion in 0.0..10.0) { "La calificación debe estar entre 0 y 10" }
    }

    override fun toString(): String {
        return "Título: $titulo, Autor: $autor, Páginas: $numPaginas, Calificación: $calificacion"
    }
}

class ConjuntoLibros {
    private val conjuntoLibros: Array<Libro?> = arrayOfNulls(5)

    fun añadirLibro(nuevoLibro: Libro): Boolean {
        for (i in conjuntoLibros.indices) {
            if (conjuntoLibros[i] == null) {
                conjuntoLibros[i] = nuevoLibro
                return true
            }
        }
        println("No se pudo añadir el libro, el conjunto está lleno.")
        return false
    }

    fun eliminarLibro(titulo: String, autor: String) {
        for (i in conjuntoLibros.indices) {
            val libro = conjuntoLibros[i]
            if (libro != null && (libro.titulo == titulo || libro.autor == autor)) {
                conjuntoLibros[i] = null
                println("Libro eliminado: $titulo por $autor")
                return
            }
        }
        println("No se encontró el libro con título \"$titulo\" o autor \"$autor\".")
    }

    fun mostrarLibros() {
        val librosFiltrados = conjuntoLibros.filterNotNull()
        if (librosFiltrados.isEmpty()) {
            println("No hay libros en la colección.")
            return
        }

        val menor = librosFiltrados.minByOrNull { it.calificacion }
        val mayor = librosFiltrados.maxByOrNull { it.calificacion }

        println("Libro con mayor calificación: $mayor")
        println("Libro con menor calificación: $menor")
    }

    fun mostrarContenido() {
        println("Contenido del conjunto de libros:")
        conjuntoLibros.forEach { libro ->
            if (libro != null) {
                println(libro)
            }
        }
    }
}

fun main() {
    val biblioteca = ConjuntoLibros()

    val libro1 = Libro("El moro", "Pepito Grillo", 120, 7.5)
    val libro2 = Libro("La casa de mi abuela", "Manolo Cabeza de Bolo", 180, 4.3)

    biblioteca.añadirLibro(libro1)
    biblioteca.añadirLibro(libro2)

    biblioteca.mostrarContenido()

    biblioteca.eliminarLibro(libro1.titulo, libro1.autor)
    biblioteca.eliminarLibro(libro2.titulo, libro2.autor)

    biblioteca.mostrarLibros()

    val libro3 = Libro("El principito", "Antoine de Saint-Exupéry", 96, 9.8)
    biblioteca.añadirLibro(libro3)

    biblioteca.mostrarContenido()
}
