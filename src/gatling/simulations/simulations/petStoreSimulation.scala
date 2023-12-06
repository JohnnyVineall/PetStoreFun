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
    petStoreSimulation.inject(rampUsers(1) during (300))
  ).protocols(httpProtocol).maxDuration(600)

}

