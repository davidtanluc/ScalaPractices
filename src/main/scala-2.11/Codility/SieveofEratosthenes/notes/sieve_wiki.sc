/*
function eratosthenes(limit) {
    var primes = [];
    if (limit >= 2) {
        var sqrtlmt = Math.sqrt(limit) - 2;
        var nums = new Array(); // start with an empty Array...
        for (var i = 2; i <= limit; i++) // and
            nums.push(i); // only initialize the Array once...
        for (var i = 0; i <= sqrtlmt; i++) {
            var p = nums[i]
            if (p)
                for (var j = p * p - 2; j < nums.length; j += p)
                    nums[j] = 0;
        }
        for (var i = 0; i < nums.length; i++) {
            var p = nums[i];
            if (p)
                primes.push(p);
        }
    }
    return primes;
}

var primes = eratosthenes(100);
 */

def eratostheses(limit:Int):Array[Int]={
  val primes = Array.fill(limit+1)(0)

  if(limit>=2){
    var sqrtlimit = Math.sqrt(limit) - 2

    for(i<- 2 to limit){

    }
  }
  ///??????


  Array(1)
}