import java.util.*

fun main(){
    val sc=Scanner(System.`in`)
    val sale=sc.nextInt()
    if(sale<300){
        print("Discount=0")
    }else if(sale>=300 && sale<=1000) {
        var dis = sale / 10;
        print("Discount= $dis")
    }else{
        print("Discount=100")
    }
}