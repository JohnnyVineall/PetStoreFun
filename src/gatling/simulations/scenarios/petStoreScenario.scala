package scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.{Common, Environment, Headers}


object petStoreScenario {

  val BaseURL = Environment.baseUrl
  val ThinkTime = Environment.thinkTime


  val petStore =


    exec(_.setAll(
      "randomString" -> Common.randomString(5),
      "randomDay" -> Common.getDay(),
      "randomMonth" -> Common.getMonth(),
      "adultDobYear" -> Common.getDobYear(),
      "adoptionYear" -> Common.yearMinusOne(),
      "childDobYear" -> Common.getDobYearChild()))


      /*======================================================================================
* Load HomePage
======================================================================================*/

    .group("PS_010_HomePage") {
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
      .formParam("username", "lol")
      .formParam("password", "true")
      .formParam("repeatedPassword", "lol")
      .formParam("firstName", "true")
      .formParam("account.lastName", "lol")
      .formParam("account.email", "true")
      .formParam("account.phone", "lol")
      .formParam("account.address1", "true")
      .formParam("account.address2", "lol")
      .formParam("account.city", "true")
      .formParam("account.state", "lol")
      .formParam("account.zip", "true")
      .formParam("account.country", "lol")
      .formParam("account.languagePreference", "true")
      .formParam("ccount.favouriteCategoryId", "lol")
      .formParam("newAccount", "true")
      .formParam("_sourcePage", "lol")
      .formParam("__fp", "true"))
  }
    .pause(ThinkTime)



}
