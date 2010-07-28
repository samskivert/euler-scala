object Euler004 extends Application 
{
  def palindrome (value :String) :Boolean = {
    val half :Int = value.length()/2;
    return value.substring(0, half) == value.substring(half).reverse.mkString("","","");
  }

  var palindromes :List[Int] = for {
    a <- List.range(100, 999)
    b <- List.range(100, 999)
    if palindrome(String.valueOf(a * b))
  } yield a*b;

  println(palindromes.sort((a, b) => a<b ));
}
