import java.util.*

fun main(){
    val sc=Scanner(System.`in`)
    val start = sc.nextInt()
    val decrement = sc.nextInt()

        var i = start
        while (i >= 0) {
            println(i)
            i = i - decrement
        }


}