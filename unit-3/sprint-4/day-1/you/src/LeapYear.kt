import java.util.*

fun main(){
    val sc= Scanner(System.`in`)
    var year=sc.nextInt()
    if(year%4==0 && year%100!=0){
        print("Leap Year")
    }else if(year%400==0){
        print("Leap Year")
    }else{
        print("Not Leap Year")
    }
}