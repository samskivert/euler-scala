object Euler59 extends EulerApp {
  def decode (nums :List[Int], key :List[Char]) =
    0.until(nums.length).map(ii => nums(ii) ^ key(ii%key.length)).toList
  val nums = readnums("cipher1.txt")
  val sols = for {
    a <- 'a'.to('z'); b <- 'a'.to('z'); c <- 'a'.to('z')
    val decoded = decode(nums, List(a, b, c))
    if (decoded.map(_.toChar).mkString.indexOf(" chapter") != -1)
  } yield decoded.sum
  println(sols.next)
}
