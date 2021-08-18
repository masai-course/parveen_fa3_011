import java.util.*

fun main(){
    val sc=Scanner(System.`in`)
    val n=sc.nextInt()
    var ar=IntArray(n)
    for (i in 0..n-1){
        ar[i]=sc.nextInt()
    }

    for (i in 0..ar.size-1){
        var count=0
        for (j in 0..ar.size-1) {
            if (ar[i] == ar[j]) {
                count++
            }
        }
        if(count==1){
            print(ar[i])
            print(" ")
        }
    }
}