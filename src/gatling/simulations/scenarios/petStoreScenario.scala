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
    * Add goldfish to cart
    ======================================================================================*/

    .group("PS_030_GoldfishClickFish") {
      exec(http("PS_030_005_ClickFish")
        .get(BaseURL + "/actions/Catalog.action?viewCategory=&categoryId=FISH")
        .headers(Headers.navigationHeader)
        .check(substring("Tiger Shark")))
    }
    .pause(ThinkTime)

    .group("PS_040_SelectGoldfish") {
      exec(http("PS_040_005_SelectGoldfish")
        .get(BaseURL + "/actions/Catalog.action?viewProduct=&productId=FI-FW-02")
        .headers(Headers.navigationHeader)
        .check(substring("Adult Male")))
    }
    .pause(ThinkTime)

    .group("PS_050_AddGoldfishToCart") {
      exec(http("PS_050_005_AddMaleToCart")
        .get(BaseURL + "/actions/Cart.action?addItemToCart=&workingItemId=EST-20")
        .headers(Headers.navigationHeader)
        .check(substring("FI-FW-02")))
    }
    .pause(ThinkTime)

    /*======================================================================================
    * Add dalmation to cart
    ======================================================================================*/

    .group("PS_060_DalmationClickDogs") {
      exec(http("PS_060_005_ClickDogs")
        .get(BaseURL + "/actions/Catalog.action?viewCategory=&categoryId=DOGS")
        .headers(Headers.navigationHeader)
        .check(substring("Bulldog")))
    }
    .pause(ThinkTime)

    .group("PS_070_SelectDalmation") {
      exec(http("PS_070_005_SelectDalmation")
        .get(BaseURL + "/actions/Catalog.action?viewProduct=&productId=K9-DL-01")
        .headers(Headers.navigationHeader)
        .check(substring("Spotted Adult Female")))
    }
    .pause(ThinkTime)

    .group("PS_080_Dalmation") {
      exec(http("PS_080_005_AddMalePuppyToCart")
        .get(BaseURL + "/actions/Cart.action?addItemToCart=&workingItemId=EST-9")
        .headers(Headers.navigationHeader)
        .check(substring("K9-DL-01")))
    }
    .pause(ThinkTime)

    /*======================================================================================
    * Add rattlesnake to cart
    ======================================================================================*/

    .group("PS_090_ClickReptiles") {
      exec(http("PS_090_005_ClickReptiles")
        .get(BaseURL + "/actions/Catalog.action?viewCategory=&categoryId=REPTILES")
        .headers(Headers.navigationHeader)
        .check(substring("Iguana")))
    }
    .pause(ThinkTime)

    .group("PS_100_ClickRattlesnake") {
      exec(http("PS_100_005_ClickRattlesnake")
        .get(BaseURL + "/actions/Catalog.action?viewProduct=&productId=RP-SN-01")
        .headers(Headers.navigationHeader)
        .check(substring("Rattleless")))
    }
    .pause(ThinkTime)

    .group("PS_110_AddRattlesnakeToCart") {
      exec(http("PS_110_005_AddRattlesnakeToCart")
        .get(BaseURL + "/actions/Cart.action?addItemToCart=&workingItemId=EST-11")
        .headers(Headers.navigationHeader)
        .check(substring("RP-SN-01")))
    }
    .pause(ThinkTime)

    /*======================================================================================
    * Add persian cat to cart
    ======================================================================================*/

    .group("PS_120_ClickCats") {
      exec(http("PS_120_005_ClickCats")
        .get(BaseURL + "/actions/Catalog.action?viewCategory=&categoryId=CATS")
        .headers(Headers.navigationHeader)
        .check(substring("Manx")))
    }
    .pause(ThinkTime)

    .group("PS_130_ClickPersian") {
      exec(http("PS_130_005_ClickPersian")
        .get(BaseURL + "/actions/Catalog.action?viewProduct=&productId=FL-DSH-01")
        .headers(Headers.navigationHeader)
        .check(substring("With tail")))
    }
    .pause(ThinkTime)

    .group("PS_140_AddTaillessToCart") {
      exec(http("PS_140_005_AddTaillessToCart")
        .get(BaseURL + "/actions/Cart.action?addItemToCart=&workingItemId=EST-14")
        .headers(Headers.navigationHeader)
        .check(substring("FL-DSH-01")))
    }
    .pause(ThinkTime)

    /*======================================================================================
    * Add amazon parrot to cart
    ======================================================================================*/

    .group("PS_150_ClickBirds") {
      exec(http("PS_150_005_ClickBirds")
        .get(BaseURL + "/actions/Catalog.action?viewCategory=&categoryId=BIRDS")
        .headers(Headers.navigationHeader)
        .check(substring("Finch")))
    }
    .pause(ThinkTime)

    .group("PS_160_ClickAmazonParrot") {
      exec(http("PS_160_005_ClickAmazonParrot")
        .get(BaseURL + "/actions/Catalog.action?viewProduct=&productId=AV-CB-01")
        .headers(Headers.navigationHeader)
        .check(substring("Adult Male")))
    }
    .pause(ThinkTime)

    .group("PS_170_AddAdultMaleToCart") {
      exec(http("PS_170_005_AddAdultMaleToCart")
        .get(BaseURL + "/actions/Cart.action?addItemToCart=&workingItemId=EST-18")
        .headers(Headers.navigationHeader)
        .check(substring("AV-CB-01")))
    }
    .pause(ThinkTime)

    /*======================================================================================
    * Enter Account info
    ======================================================================================*/

    .group("PS_030_EnterAccountInfo") {
      exec(http("PS_030_005_EnterAccountInfo")
        .post(BaseURL + "/actions/Account.action")
        .headers(Headers.commonHeader)
        .formParam("username", "Queeny")
        .formParam("password", "PW123")
        .formParam("repeatedPassword", "PW123")
        .formParam("firstName", "Elizabeth")
        .formParam("account.lastName", "Windsor")
        .formParam("account.email", "queen.liz@mailinator.com")
        .formParam("account.phone", "0123456789")
        .formParam("account.address1", "Buckingham Palace")
        .formParam("account.address2", "Tha Mall")
        .formParam("account.city", "London")
        .formParam("account.state", "London")
        .formParam("account.zip", "SW1A1AA")
        .formParam("account.country", "United Kingdom")
        .formParam("account.languagePreference", "english")
        .formParam("ccount.favouriteCategoryId", "DOGS")
        .formParam("newAccount", "")
        .formParam("_sourcePage", "")
        .formParam("__fp", ""))
    }
    .pause(ThinkTime)



}
