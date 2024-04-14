//> using test.dep org.scalatest::scalatest::3.2.18
//> using dep info.picocli:picocli:4.7.5

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.featurespec._
import org.scalatest.matchers.should.Matchers._
import picocli.CommandLine
import java.io.StringWriter
import java.io.PrintWriter

/*
 * Unit tests for {@link Greet}.
 */
class GreetTest extends AnyFlatSpec {

  "Greet.greeting" should "be Hello, World!" in {
    Greet.greeting(None) should be("Hello, World!")
  }

}

/*
 * End-to-end test for {@link MyApp}.
 */
class MyAppTest extends AnyFeatureSpec with GivenWhenThen {

  info("As a application user")
  info("I want to execute the command line")

  feature("Execute command line") {
    scenario("User execute without any command-line argument") {

      Given("no prerequisite")

      When("the application is executed without arguments")
      val (cmd, sw) = prepareApp
      val exitCode = cmd.execute();

      Then("exit code should be 0 and Hello, World! is printed out to stdout")
      exitCode should be(0)
      sw.toString should be("Hello, World!\n")
    }

    scenario("User execute with --name option") {

      Given("no prerequisite")

      When("the application is executed with '--name John'option")
      val (cmd, sw) = prepareApp
      val exitCode = cmd.execute("--name", "John");

      Then("exit code should be 0 and Hello, John! is printed out to stdout")
      exitCode should be(0)
      sw.toString should be("Hello, John!\n")
    }

  }

  private def prepareApp = {
    val sw = StringWriter();
    val cmd = CommandLine(MyApp(PrintWriter(sw)))
    (cmd, sw)
  }
}
