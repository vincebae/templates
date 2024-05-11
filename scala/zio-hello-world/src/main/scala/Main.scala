import java.io.IOException

import zio._

object Main extends ZIOAppDefault:
  val msg = "I was compiled by Scala 3. :)"

  def run: IO[IOException, Unit] =
    for
      _ <- Console.printLine("Hello, World!")
      _ <- Console.printLine(msg)
    yield ()
