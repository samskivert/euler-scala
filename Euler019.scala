object Euler019 extends EulerApp {
  def cnst (days :Int) = (_ :Int) => days
  val leapfeb = (year :Int) =>
    if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) 29 else 28
  val mdays = Array(cnst(31), leapfeb,  cnst(31), cnst(30), cnst(31), cnst(30),
                    cnst(31), cnst(31), cnst(30), cnst(31), cnst(30), cnst(31))
  val yearmos = for (year <- (1900 to 2000); month <- (0 to 11)) yield (year, month)
  def answer = (((0, 0) /: yearmos) {
    case ((suns, days), (year, month)) =>
      (if (year > 1900 && days % 7 == 6) suns+1 else suns, days + mdays(month)(year))
  })._1
}
