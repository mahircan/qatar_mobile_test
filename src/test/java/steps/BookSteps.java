package steps;

import com.testinium.qatar.core.BasePage;
import com.testinium.qatar.page.HomePage;
import com.testinium.qatar.page.TutorialPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static constants.ConstantsBookPages.*;

public class BookSteps extends BasePage {
    private TutorialPage tutorialPage = new TutorialPage();
    private HomePage homePage = new HomePage();

    @Given("^I open Qatar Airways$")
    public void accessApplication() throws Throwable {
        navigateTo();
    }
    @And("^Skip Location Page$")
    public void skipThatTutorialFirst() throws Throwable {
        clickId(locationPageSkip);

    }
    @And("^Skip Welcome Page$")
    public void skipThatTutorialSecond() throws Throwable {
        clickId(welcomePageSkip);
    }

    @When("^show Get notified, never miss an offer!$")
    public void show_Get_notified_never_miss_an_offer() throws Throwable {
        checkOnElement(notifiedMessage);

    }

    @When("^decline Get notified, never miss an offer!$")
    public void decline_Get_notified_never_miss_an_offer() throws Throwable {
        clickId(notifiedMessageDecline);
        Thread.sleep(3);
    }

    @Then("^accept permission$")
    public void accept_permission() throws Throwable {
        checkOnOrCountinue(acceptPermission, 2);
    }

    @When("^Switch to booking tab$")
    public void switch_to_booking_tab() throws Throwable {
        waitBySecond(2);
        clickId(bookingTab);
    }

    @When("^Choose one-way flight$")
    public void choose_one_way_flight() throws Throwable {
        Thread.sleep(3);
        clickAccessibilityId(oneWayLocator);
    }

    @When("^Select \"([^\"]*)\" as departure city$")
    public void select_Milan_as_departure_city(String text) throws Throwable {
        clickId(destinationText);
        writeTextById(destinationFilterText , text);
        Thread.sleep(1);
        clickByXpath(locationFilterName);
    }

    @Then("^Select \"([^\"]*)\" as destination city$")
    public void select_Paris_as_destination_city(String text) throws Throwable {
        clickId(backDestinationText);
        writeTextById(backDestinationFilterText , text);
        clickByXpath(locationFilterName);
    }

    @When("^Select random departure time$")
    public void select_random_departure_time() throws Throwable {
        clickId(departureTime);
        Thread.sleep(3);
        swipeUntilFindText("May 2022");
        clickRandomByXpath(calenderDays);
        clickId(departureTimeConfirmButton);
    }

    @Then("^Click Search flights$")
    public void click_Search_flights() throws Throwable {
        clickId(clickSearchFlight);
        waitBySecond(4);

    }

    @When("^Select first flight$")
    public void select_first_flight() throws Throwable {
        waitBySecond(3);
        clickByXpath(firstFlight);
    }

    @When("^Select flight experience$")
    public void select_flight_experience() throws Throwable {
        clickId(flightExperienceButton);
        waitBySecond(4);
    }

    @Then("^Continue as a guest$")
    public void continue_as_a_guest() throws Throwable {
        clickId(guestButton);

    }

    @When("^Go to passenger details section$")
    public void go_to_passenger_details_section() throws Throwable {
        clickId(passengerDetailsButton);
    }

    @When("^Choose Mr as a title$")
    public void choose_Mr_as_a_title() throws Throwable {
        clickId(titleButton);
        clickByXpath(titleText);
    }

    @When("^Enter \"([^\"]*)\" as a firstname$")
    public void enter_as_a_firstname(String text) throws Throwable {
        writeTextByXpath(firstNameText, text);
    }

    @When("^Enter \"([^\"]*)\" as a lastname$")
    public void enter_as_a_lastname(String text) throws Throwable {
        writeTextByXpath(lastNameText, text);
    }

    @When("^Select male from gender$")
    public void select_male_from_gender() throws Throwable {
        clickId(genderButton);
        Thread.sleep(2);
        clickByXpath(genderMaleButton);
    }

    @When("^Choose \"([^\"]*)\" from date of birth$")
    public void choose_from_date_of_birth(String text) throws Throwable {
        clickByXpath(dateOfBirthButton);
        clear(dateOfBirthYearLabel);
        writeTextByXpath(dateOfBirthYearLabel,text);
        clickByXpath(dateOfBirthYearLabel);
        clickId(dateOfBirthConfirmButton);

    }

    @When("^Select \"([^\"]*)\" from nationality$")
    public void select_Turkey_from_nationality(String text) throws Throwable {
        clickId(nationalityButton);
        writeTextById(nationalityTextBox , text);
        clickId(nationalityTextLabel);
    }

    @Then("^Click 'Done'$")
    public void click_Done() throws Throwable {
        clickId(doneButton);
    }

    @When("^Click 'I have verified that the details provided'$")
    public void click_I_have_verified_that_the_details_provided() throws Throwable {
        clickId(verifiedText);
    }

    @Then("^Click Continue$")
    public void click_Continue() throws Throwable {
        clickId(continueButton);
    }




}