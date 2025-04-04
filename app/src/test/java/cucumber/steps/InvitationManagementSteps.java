package cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cucumber.invitation.InvitationCard;
import cucumber.invitation.InvitationPackage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvitationManagementSteps {
    InvitationPackage invitationPackage = new InvitationPackage();
    InvitationCard card;
    List<InvitationCard> cards;
    String cardNameToDelete;
    String name;
    String newName;
    String errorMessage;

    @Given("Add a person named {string} and id {int} to the invitation card")
    public void add_a_person_named_and_id_to_the_invitation_card(String name, Integer id) {
        card = new InvitationCard(name, id);
    }

    @Then("See an error message with text {string}")
    public void see_an_error_message_with_text(String message) {
        message.equals(errorMessage);
    }

    @Given("Delete a card with name {string}")
    public void delete_a_card_with_name(String name) {
        cardNameToDelete = name;
    }
    @When("Delete that card")
    public void delete_that_card() {
        try {
            invitationPackage.remove(cardNameToDelete);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }
    @Then("A card with name {string} is removed")
    public void a_card_with_name_is_removed(String name) {
        assertFalse(invitationPackage.containsCardName(name));
    }

    @When("Add that person name")
    public void add_that_person_name() {
        try {
            invitationPackage.add(card);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }
    @Then("A card with name {string} and id {int} should be added")
    public void a_card_with_name_and_id_should_be_added(String string, Integer int1) {
        invitationPackage.contains(card);
    }

    @Given("I want to update a card name {string} to a new name {string}")
    public void i_want_to_update_a_card_name_to_a_new_name(String name, String newName) {
        this.name = name;
        this.newName = newName;
    }

    @When("I update the name")
    public void i_update_the_name() {
        invitationPackage.updateCardName(name, newName);
    }
    
    @Then("Both {int} cards are added")
    public void both_cards_are_added(Integer count) {
        for (InvitationCard card: cards) {
            assertTrue(invitationPackage.contains(card));
        }
    }

    @Given("I want to add a following cards")
    public void i_want_to_add_a_following_cards(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datas = dataTable.asMaps(String.class, String.class);
        
        cards = new ArrayList<>();

        for (Map<String, String> data: datas) {
            String cardName = data.get("Name");
            Integer cardId = Integer.parseInt(data.get("Id"));
            cards.add(new InvitationCard(cardName, cardId));
        }
    }

    @When("Add that cards")
    public void add_that_cards() {
        for (InvitationCard card: cards) {
            invitationPackage.add(card);
        }
    }

    @When("Edit that card")
    public void edit_that_card() {
        try {
            invitationPackage.updateCardName(name, newName);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Given("Edit a card with name {string} to {string}")
    public void edit_a_card_with_name_to(String name, String newName) {
        this.name = name;
        this.newName = newName;
    }

    @Then("The card name is updated to {string}")
    public void the_card_name_is_updated_to(String string) {
        assertTrue(invitationPackage.containsCardName(string));
    }
}
