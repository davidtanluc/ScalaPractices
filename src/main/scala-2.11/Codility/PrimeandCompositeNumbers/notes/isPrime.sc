//https://codility.com/media/train/8-PrimeNumbers.pdf
isPrime(50)//f
isPrime(13)//t
isPrime(12)//f
isPrime(7)//true
def isPrime(n:Int):Boolean ={
  for(i<-2 to Math.sqrt(n).toInt){
    if(n%i==0) return false
  }
  true
}
