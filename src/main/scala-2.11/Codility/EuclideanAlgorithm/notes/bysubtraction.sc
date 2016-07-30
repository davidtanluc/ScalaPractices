// greatest common divisor or factor /////
/*
Example
gcd 21 , 30
21 : 1,3,7,21
30: 1,2,3,10,15,30
gcd 3
 */
def gcd(a:Int,b:Int):Int={
  if(a==b)return a

  if(a>b)gcd(a-b,b) else gcd(a,b-a)

}
gcd(20,30) //10
gcd(21,30)  //3