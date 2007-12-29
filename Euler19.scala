object Euler19 extends Application {
  val months = Array(
    "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
  val monlens = Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

  def days (year :Int, month :Int) :Int = {
    if ((month == 1) && (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0))
      return monlens(month)+1;
    else
      return monlens(month);
  }

  var days = 0;
  var firstSundays = 0;
  for (year <- List.range(1900, 2001)) {
    for (month <- List.range(0, 12)) {
      if (year > 1900 && days % 7 == 6) {
        firstSundays = firstSundays + 1;
      }
      days += days(year, month);
    }
  }
  println(firstSundays);
}
