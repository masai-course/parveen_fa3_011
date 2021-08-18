import java.util.*

fun main(){
   var ar= arrayOf(-12,-39,12,41,22,44)
    var sum=0
    for (i in 0..ar.size-1){
        sum=sum+ar[i]
    }
    var avg=sum/ar.size
    print(avg)

}