import java.util.*

fun main(){
    val sc=Scanner(System.`in`)
    val left=sc.nextInt()
    val right=sc.nextInt()
    for (i in 1..left) {
        for (j in 1..right) {
            println("$i.$j")
        }
    }
}