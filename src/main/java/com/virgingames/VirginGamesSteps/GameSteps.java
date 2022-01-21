package com.virgingames.VirginGamesSteps;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import jxl.common.Assert;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class GameSteps {



    public static ValidatableResponse response;

    @Step("Getting all Bingo Game Data information")
    public ValidatableResponse getAllGameDataInfo() {
       response = SerenityRest.rest()
                .given()
                .when()
                .get(EndPoints.GET_ALL_DATA)
                .then().statusCode(200);
       return response;
    }

    @Step("Verify Default Game Frequency is 300000")
    public void verifyGameFrequency(int frq) {
        response = getAllGameDataInfo();
                int gameFreq = response.extract()
                    .jsonPath().getInt("bingoLobbyInfoResource.streams[5].defaultGameFrequency");
            Assert.verify(gameFreq == frq);


    }

@Step("startTime should always be future timestamp")
public void getAllLiveBingoFeedAndAssertStartTime() {
    long systemTime = System.currentTimeMillis();
    response = getAllGameDataInfo();
    long startTime = response.extract().jsonPath().getLong("bingoLobbyInfoResource.streams[3].startTime");
    Assert.verify(startTime>systemTime);
     }

 }






