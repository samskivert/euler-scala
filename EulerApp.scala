import scala.io.Source
import scala.collection.mutable.{BitSet => MBitSet, ArrayBuffer}
import java.io.File

abstract class EulerApp {
  /** A map for doing memoized calculations. */
  abstract class MemoMap[K,V] extends collection.mutable.HashMap[K,V] {
    override def apply (k :K) = getOrElseUpdate(k, compute(k))
    protected def compute (k :K) :V
  }

  /** A map for doing memoized calculations with two args. */
  abstract class MemoMap2[K1,K2,V] extends collection.mutable.HashMap[(K1,K2),V] {
    def apply (k1 :K1, k2 :K2) = getOrElseUpdate((k1, k2), compute(k1, k2))
    protected def compute (k1 :K1, k2 :K2) :V
  }

  /** Checks the primality of `n`. Slowly. */
  def isprime (n :Int) :Boolean = {
    val limit = math.sqrt(n).toInt+1
    var ii = 2
    while (ii < limit) {
      if (n % ii == 0) return false
      ii = ii+1
    }
    true
  }

  /** Checks the primality of `n`. Slowly. */
  def isprime (n :Long) :Boolean = {
    val limit = math.sqrt(n).toInt+1
    var ii = 2
    while (ii < limit) {
      if (n % ii == 0) return false
      ii = ii+1
    }
    true
  }

  /** Checks the primality of `n`. Slowly. */
  def isprime (n :BigInt) :Boolean = {
    val limit = math.sqrt(n.doubleValue).toInt+1
    var ii = 2
    while (ii < limit) {
      if (n % ii == 0) return false
      ii = ii+1
    }
    true
  }

  /** Generates an array `[0, range)` where non-prime elements = 0 and prime elements = p. */
  def genprimevec (range :Int) :Array[Int] = {
    val primes = Array.range(0, range)
    primes(1) = 0
    var idx = 2
    while (idx < range) {
      var midx = idx+idx
      while (midx < range) { primes(midx) = 0; midx += idx }
      do idx = idx+1
      while (idx < range && primes(idx) == 0)
    }
    return primes
  }

  /** Generates a seq containing primes < `range`. */
  def genprimes (range :Int) = foldprimes(range, ArrayBuffer[Int]())(_ += _).toSeq

  /** Folds `f` over all primes less than `range` using zero value `z`. */
  def foldprimes[Z] (range :Int, z :Z)(f :(Z, Int) => Z) :Z = {
    var zacc = z
    val nonprimes = MBitSet(range)
    nonprimes.add(1)
    var idx = 2
    while (idx < range) {
      zacc = f(zacc, idx)
      var midx = idx+idx
      while (midx < range) { nonprimes.add(midx); midx += idx }
      do idx = idx+1
      while (idx < range && nonprimes(idx))
    }
    zacc
  }

  /** Returns the greatest common divisor of `n` and `d`. */
  def gcd (n :Int, d :Int) :Int = if (d == 0) n else gcd(d, n%d)

  /** Generates a stream of primes. */
  def primegen = {
    def from (n: Int): Stream[Int] = Stream.cons(n, from(n + 1))
    def sieve (s: Stream[Int]): Stream[Int] =
      Stream.cons(s.head, sieve(s.tail filter { _ % s.head != 0 }))
    sieve(from(2))
  }

  /** Returns unique prime factors of the supplied `n`. */
  def primefacts (primes :Iterable[Int], n :Int) = {
    var facts :List[Int] = Nil
    var curn = n
    for (div <- primes takeWhile(p => p*p <= n) filter(curn % _ == 0)) {
      facts = div :: facts
      do curn = curn / div while (curn % div == 0)
    }
    if (curn == 1) facts else curn :: facts
  }

  /** Returns all prime factors of the supplied `n`. */
  def factors (n :Int) = {
    def loop (n :Int, primes :Stream[Int], facts :List[Int]) :List[Int] = {
      val p = primes.head
      if (n % p == 0) loop(n/p, primes, p :: facts)
      else if (n > p) loop(n, primes.tail, facts)
      else facts
    }
    loop(n, primegen, Nil)
  }

  /** Reads the first line from the supplied source file. */
  def readline (file :String) :String =
    Source.fromFile(file).getLines().next.stripLineEnd

  /** Reads the first line from the supplied source file and splits on `,`. */
  def readwords (file :String) :List[String] =
    readline(file).split(',').map(n => n.slice(1, n.length-1)).toList.sortWith(_<_)

  /** Reads the first line from the supplied source file, splits on `,` and `toInt`s. */
  def readnums (file :String) :List[Int] =
    readline(file).split(',').toList.map(_.toInt)

  /** Reads all lines from the supplied source file, stripping line endings. */
  def readlines (file :String) :List[String] =
    Source.fromFile("data" + File.separator + file).getLines().map(_.stripLineEnd).toList

  // computes and returns the solution
  def answer :Any

  /** The main entry point for an Euler solution. Just calls `answer`. */
  def main (args :Array[String]) {
    println(answer)
  }
}
