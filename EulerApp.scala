import scala.io.Source
import java.io.File

abstract class EulerApp {
  def isprime (n :Int) :Boolean = {
    val limit = math.sqrt(n).toInt+1
    var ii = 2
    while (ii < limit) {
      if (n % ii == 0) return false
      ii = ii+1
    }
    true
  }
  def isprime (n :Long) :Boolean = {
    val limit = math.sqrt(n).toInt+1
    var ii = 2
    while (ii < limit) {
      if (n % ii == 0) return false
      ii = ii+1
    }
    true
  }
  def isprime (n :BigInt) :Boolean = {
    val limit = math.sqrt(n.doubleValue).toInt+1
    var ii = 2
    while (ii < limit) {
      if (n % ii == 0) return false
      ii = ii+1
    }
    true
  }

  def genprimes (range :Int) :Array[Int] = {
    val primes = Array.range(0, range)
    primes(1) = 0
    var idx = 2
    while (idx < range) {
      for (midx <- List.range(idx+idx, primes.length, idx)) primes(midx) = 0
      do idx = idx+1
      while (idx < range && primes(idx) == 0)
    }
    return primes
  }

  def gcd (n :Int, d :Int) :Int = if (d == 0) n else gcd(d, n%d)

  def primefacts (primes :Iterable[Int], n :Int) = {
    var facts :List[Int] = Nil
    var curn = n
    for (div <- primes takeWhile(p => p*p <= n) filter(curn % _ == 0)) {
      facts = div :: facts
      do curn = curn / div while (curn % div == 0)
    }
    if (curn == 1) facts else curn :: facts
  }

  def readline (file :String) :String =
    Source.fromFile(file).getLines().next.stripLineEnd
  def readwords (file :String) :List[String] =
    readline(file).split(',').map(n => n.slice(1, n.length-1)).toList.sortWith(_<_)
  def readnums (file :String) :List[Int] =
    readline(file).split(',').toList.map(_.toInt)
  def readlines (file :String) :List[String] =
    Source.fromFile("data" + File.separator + file).getLines().map(_.stripLineEnd).toList

  // computes and returns the solution
  def answer :Any

  def main (args :Array[String]) {
    println(answer)
  }
}
