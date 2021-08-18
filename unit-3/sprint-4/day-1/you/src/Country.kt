import java.util.*

fun main(){
    val sc= Scanner(System.`in`)

    val n = sc.nextInt()
    val ar = arrayOfNulls<String>(n)
    for (i in 0 until n) {
        ar[i] = sc.next()
    }
    val country=sc.next()
    var boo=false
    for (i in 0 until n){
        if(country==ar[i]) {
            boo=true
        }
    }
    if (boo){
        print("Country found")
    }else{
        print("Not found")
    }

}


