object Euler024 extends EulerApp {
  def fact (n: Int): Int = if (n == 0) 1 else n * fact(n - 1)
  def nthperm (target :Int, nums :List[Int]) :String = {
    if (nums.length == 1) return nums(0).toString;
    val nfact = fact(nums.length-1)
    val idx = (target / nfact).intValue;
    val digit = nums(idx);
    return digit + nthperm(target - nfact*idx, nums.filter(digit.!=));
  }
  def answer = nthperm(1000000, List.range(0, 10))
}
