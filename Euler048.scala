object Euler48 extends Application {
  println(1.to(1000).map(a => BigInt(a).pow(a)).reduceRight(_+_) % BigInt(10).pow(10))
}
