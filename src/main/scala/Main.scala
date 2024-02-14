object Main {


  val something: PartialFunction[String, String] =
    case x: String if x.startsWith("M") => x.toLowerCase
    case s: String if s.startsWith("2") => s.reverse

  val a : Int => String  = _.toString
  val b : String => Boolean = _.equals("4")

  val moreComplex : Int => Boolean = s => b(a(s))
  val andThen: Int => Boolean = a.andThen(b)


  val squareRoot: PartialFunction[Double, Double] =
    case x if x >= 0 => Math.sqrt(x)


  val firstSoultion: PartialFunction[Double, String] =
    case x => "One cannot calculate a square root for a number that is smaller than 0"


  // For negative numbers, return 0 as the real part and the square root of the absolute value as the imaginary part
  val secondSolution: PartialFunction[Double, (Double, Double)] =
    case x => (0, Math.sqrt(-x))


  def basicSquareRoot(n: Double): Either[Double, String] =
    if (squareRoot.isDefinedAt(n))
      Left(squareRoot(n))
    else
      Right(firstSoultion(n))

    
  def complexSquareRoot(n: Double): Either[Double, (Double, Double)] =
    if (squareRoot.isDefinedAt(n))
      Left(squareRoot(n))
    else
      Right(secondSolution(n))


  def main(args: Array[String]): Unit = {
    println(something("2Michał"))

    println()

  }

}
