import java.util.*

fun main(){
    val sc= Scanner(System.`in`)

    val n = sc.nextInt()
    val ar = arrayOfNulls<String>(n)
    for (i in 0 until n) {
        ar[i] = sc.next()
    }
    val country=sc.next()

    for (i in 0 until n){
        if(country==ar[i]) {
           println(ar[i]+" "+ i)
        }
    }
}