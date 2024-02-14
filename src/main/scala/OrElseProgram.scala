object OrElseProgram

  val handleInt: PartialFunction[Int, Output] =
    case x if x > 0 => Message(x * 2)

  val handleString: PartialFunction[String, Output] =
    case s if s.nonEmpty => Score(s.toUpperCase)


  sealed trait Output
  case class Score(s: String) extends Output
  case class Message(i: Int) extends Output


  val handlingOutput: PartialFunction[Any, Output] = handleInt orElse handleString



