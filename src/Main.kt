

class Libro(val titulo : String, val autor : String, val numPaginas : Int, val calificacion : Double){
    init {
        require(titulo.isNotEmpty()){"No puede haber un titulo vacío"}
        require(autor.isNotEmpty()){"No puede haber un autor vacío"}
        require(calificacion in 0..10){"La calificacion debe estar entre 0 y 10"}
    }
}

class ConjuntoLibros(){
    val conjuntoLibros : Array<Libro?> = Array(5) { null }
    fun añadirLibro(nuevoLibro : Libro) : Array<Libro?>{
        var i = 0
        if(i <= conjuntoLibros.size){
            conjuntoLibros[i] = nuevoLibro
            i += 1
        }
        return conjuntoLibros
    }

    /* TO DO FUNCION PARA RELLENAR LOS NULL CON LIBROS QUE NO EXISTAN*/
    fun añadirLibrosImaginarios(){

    }
    fun eliminarLibro(titulo: String,autor: String){
        for (libro in conjuntoLibros){
            if (libro?.autor == autor || libro?.titulo == titulo){
                libro = null
            }
        }
    }
    fun mostrarLibros() {
        var menor: Libro
        var mayor: Libro

        for(libro in conjuntoLibros){
            if (menor.calificacion > libro.calificacion){
                if (libro != null) {
                    menor = libro
                }
            }
            if (mayor.calificacion < libro.calificacion){
                if (libro != null) {
                    mayor = libro
                }
            }
        }
        println("El libro con mayor calificacion tiene la siguiente descripcion: $mayor")
        println("El libro con menor calificacion tiene la siguiente descripcion: $menor")
    }
    fun mostrarContenido(){
        println(conjuntoLibros)
    }
}

fun main() {
    val libro1 = Libro("El moro", "Pepito Grillo",120,7.5)
    val libro2 = Libro("La casa de mi abuela", "Manolo Cabeza de Bolo",180,4.3)
    añadirLibro(libro1)
    añadirLibro(libro2)
    eliminarLibro(libro1.autor,libro1.titulo)
    eliminarLibro(libro2.autor,libro2.titulo)
    mostrarLibros()
    mostrarContenido()
}