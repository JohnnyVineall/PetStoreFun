package simulations

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scenarios._
import utils.Environment
import io.gatling.core.controller.inject.open.OpenInjectionStep
import io.gatling.commons.stats.assertion.Assertion
import io.gatling.core.pause.PauseType

import scala.concurrent.duration._

class petStoreSimulation extends Simulation {

  val BaseURL = Environment.baseUrl


  val testType = scala.util.Properties.envOrElse("TEST_TYPE", "perftest")

  //set the environment based on the test type
  val environment = testType match {
    case "perftest" => "perftest"
    case "pipeline" => "perftest"
    case _ => "**INVALID**"
  }

  /* ******************************** */

  /* ADDITIONAL COMMAND LINE ARGUMENT OPTIONS */
  val debugMode = System.getProperty("debug", "off") //runs a single user e.g. ./gradle gatlingRun -Ddebug=on (default: off)
  val env = System.getProperty("env", environment) //manually override the environment aat|perftest e.g. ./gradle gatlingRun -Denv=aat
  /* ******************************** */


      val httpProtocol = http
        .baseUrl(BaseURL)
        .doNotTrackHeader("1")
        .inferHtmlResources()
        .silentResources


      val petStoreSimulation = scenario("Adoption")
        .exitBlockOnFail {
            exec(petStoreScenario.petStore)

        }

        .exec {
          session =>
            println(session)
            session
        }



  setUp(
    petStoreSimulation.inject(nothingFor(1),rampUsers(1) during (2700))
  ).protocols(httpProtocol)

}

