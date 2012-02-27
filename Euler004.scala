object Euler004 extends EulerApp {
  def palindrome (value :String) =
    value.substring(0, value.length/2) == value.substring(value.length/2).reverse
  def answer = (for (a <- 100 until 999 ; b <- 100 until 999
                     if palindrome(a * b toString))
                yield a*b).max
}
