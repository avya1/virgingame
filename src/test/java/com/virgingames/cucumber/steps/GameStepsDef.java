package com.virgingames.cucumber.steps;

import com.virgingames.VirginGamesSteps.GameSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GameStepsDef {

    @Steps
    GameSteps gameSteps;

    @Then("^User get back a valid status code (\\d+)$")
    public void userGetBackAValidStatusCode(int arg0) {
        gameSteps.getAllGameDataInfo().statusCode(arg0);
    }

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        gameSteps.getAllGameDataInfo();
    }


    @Then("^User verify 'defaultGameFrequency' should always be (\\d+)$")
    public void userVerifyDefaultGameFrequencyShouldAlwaysBe(int arg0) {
        gameSteps.verifyGameFrequency(arg0);
    }

    @Then("^Game startTime should always be future timestamp$")
    public void gameStartTimeShouldAlwaysBeFutureTimestamp() {
    gameSteps.getAllLiveBingoFeedAndAssertStartTime();
    }
}
