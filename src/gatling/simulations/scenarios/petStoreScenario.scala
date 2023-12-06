package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.{Environment, Headers}


object petStoreScenario {

  val BaseURL = Environment.baseUrl
  val ThinkTime = Environment.thinkTime


  val petStore =



    /*======================================================================================
    * Load HomePage
    ======================================================================================*/

    group("PS_010_HomePage") {
      exec(http("PS_010_005_HomePage")
        .get(BaseURL)
        .headers(Headers.navigationHeader)
        .check(substring("Welcome to JPetStore")))
    }
    .pause(ThinkTime)


    /*======================================================================================
    * Enter the Pet Store
    ======================================================================================*/

    .group("PS_020_EnterStore") {
      exec(http("PS_020_005_EnterStore")
        .get(BaseURL + "/actions/Catalog.action")
        .headers(Headers.navigationHeader)
        .check(substring("Various Breeds")))
    }
    .pause(ThinkTime)


    /*======================================================================================
    * Enter Account info
    ======================================================================================*/

    .group("PS_030_EnterAccountInfo") {
      exec(http("PS_030_005_EnterAccountInfo")
        .get(BaseURL + "/actions/Account.action")
        .headers(Headers.commonHeader)
        .formParam("username", "")
        .formParam("password", "")
        .formParam("repeatedPassword", "")
        .formParam("firstName", "")
        .formParam("account.lastName", "")
        .formParam("account.email", "")
        .formParam("account.phone", "")
        .formParam("account.address1", "")
        .formParam("account.address2", "")
        .formParam("account.city", "")
        .formParam("account.state", "")
        .formParam("account.zip", "")
        .formParam("account.country", "")
        .formParam("account.languagePreference", "")
        .formParam("ccount.favouriteCategoryId", "")
        .formParam("newAccount", "")
        .formParam("_sourcePage", "")
        .formParam("__fp", ""))
    }
    .pause(ThinkTime)



}
