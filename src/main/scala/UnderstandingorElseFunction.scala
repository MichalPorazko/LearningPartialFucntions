object UnderstandingorElseFunction {


  val squareRoot: PartialFunction[Double, Either[Double, String]] =
    case x if x >= 0 => Left(Math.sqrt(x))


  val firstSoultion: PartialFunction[Double, Either[Double, String]] =
    case x => Right("One cannot calculate a square root for a number that is smaller than 0")

  def basicSquareRoot(n: Double): Either[Double, String] =
    squareRoot.orElse(firstSoultion)(n)
}
