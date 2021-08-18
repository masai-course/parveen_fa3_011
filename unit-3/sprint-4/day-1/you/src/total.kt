fun main(){
    val ar= arrayOf("HTML","JS","JAVA","CS","ANDROID")
    var sum=0
    for (i in 0..ar.size-1){
        sum=sum+ar[i].length

    }
    print(sum)

}