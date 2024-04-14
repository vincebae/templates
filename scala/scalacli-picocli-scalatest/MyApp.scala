//> using dep info.picocli:picocli:4.7.5

import java.util.Optional
import java.util.concurrent.Callable
import picocli.CommandLine
import picocli.CommandLine.{Option as CommandLineOption, *}
import scala.jdk.OptionConverters._
import java.io.PrintWriter

object Greet {
  def greeting(name: Option[String]) = s"Hello, ${name.getOrElse("World")}!"
}

@Command(
  name = "My template app",
  version = Array("0.0.1"),
  mixinStandardHelpOptions = true,
  description = Array("my template app")
)
class MyApp(val out: PrintWriter = PrintWriter(System.out))
    extends Callable[Int] {

  @CommandLineOption(
    names = Array("-n", "--name"),
    description = Array("name")
  )
  private var name: Optional[String] = Optional.empty

  def call(): Int = {
    out.println(Greet.greeting(name.toScala))
    out.flush()
    0 // exit code
  }

}

@main def main(args: String*): Unit =
  System.exit(CommandLine(MyApp()).execute(args*))
