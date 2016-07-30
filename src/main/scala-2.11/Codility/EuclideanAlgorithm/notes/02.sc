def gcd(a:Int,b:Int):Int={

  if(a%b ==0)b else gcd(b,a%b)

}
//gcd(10,30)//10
//gcd(25,50)//25
//gcd(10,12)//2

/////////////

def lcm(a:Int,b:Int):Int={
  a*b / gcd(a,b)
}

//lcm(10,12)//60
lcm(10,30)//30

/*
 The least common multiple (lcm) of two integers a and b is the
 smallest positive integer that
 is divisible by both a and b.
 There is the following relation
 */