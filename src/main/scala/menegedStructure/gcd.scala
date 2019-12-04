package menegedStructure

object gcd extends App {


  println( gcd(10, 5 ))
  println( gcd(5, 10 ))
  println( gcd(10, 2 ))
      //        10    5  5 10
  def gcd( x: Long, y: Long) : Long = {
    if(y == 0 )   x
      else gcd (y ,  x%y )

  }

}
