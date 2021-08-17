fun main(){
    var score= arrayOf(10, 5 , 4, 6, 1)
    var low=score[0]
    for(i in score){
        if(i<low){
            low=i
        }
    }
    print(low)
}