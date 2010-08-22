object Euler063 extends EulerApp {
  def pows (n :Int) = Stream.from(1) prefixLength(p => BigInt(n).pow(p).toString.length == p)
  def answer = 1 to 9 map(pows) sum
}
