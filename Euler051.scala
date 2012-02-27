object Euler051 extends EulerApp {
  def cprimes (n :String)(d :Char) = {
    val variants = "0123456789".toList.map(nd => n.replace(d, nd))
    variants.filter(!_.startsWith("0")).map(Integer.parseInt).filter(isprime).length
  }
  def count (prime :String) = prime.toSet.map(cprimes(prime)).max
  def answer = genprimes(150000).find(p => count(p.toString) > 7).get
}
