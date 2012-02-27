object Euler021 extends EulerApp {
  def sumdiv (n :Int) = List.range(1, n/2+1).filter(div => n % div == 0).sum
  def answer = List.range(1, 10000).filter(n => {
    val sdn = sumdiv(n); (n == sumdiv(sdn) && n != sdn && sdn < 10000)
  }).sum
}
