object Euler001 extends EulerApp {
  println(List.range(0, 1000).filter((a) => (a % 3 == 0 || a % 5 == 0)).sum);
}
