import java.util.*

fun main(){
    val sc= Scanner(System.`in`)
    val s = sc.next()
    val ar = s.toCharArray()
    for (i in ar.indices.reversed()) {
        print(ar[i])
    }
}