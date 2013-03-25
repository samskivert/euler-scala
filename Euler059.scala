object Euler059 extends EulerApp {
  val cipher = readline("cipher1.txt") split(',') map(_.toInt)
  def decode (cipher :Array[Int], key :Array[Char]) =
    (0 until cipher.length) map(ii => cipher(ii) ^ key(ii%key.length))
  def answer = (for {
    a <- 'a' to 'z'; b <- 'a' to 'z'; c <- 'a' to 'z'
    decoded = decode(cipher, Array(a, b, c))
    if (decoded.map(_.toChar).mkString.contains(" chapter"))
  } yield decoded.sum).head
}
