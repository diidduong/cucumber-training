Feature: Invitation Management

  Background: Setup a new card
    Given Add a person named "Khang" and id 1 to the invitation card
    When Add that person name
    Then A card with name "Khang" and id 1 should be added

  Scenario: Add a new card
    Given Add a person named "Hao" and id 2 to the invitation card
    When Add that person name
    Then A card with name "Hao" and id 2 should be added

  Scenario: Add a new card
    Given Add a person named "Khang" and id 3 to the invitation card
    When Add that person name
    Then See an error message with text "Duplicate name"

  Scenario: Add a new card
    Given Add a person named "Minh" and id 1 to the invitation card
    When Add that person name
    Then See an error message with text "Duplicate id"

  Scenario: Delete a card
    Given Delete a card with name "Khang"
    When Delete that card
    Then A card with name "Khang" is removed

  Scenario: Delete a card
    Given Delete a card with name "Hao"
    When Delete that card
    Then See an error message with text "Name not found"

  Scenario: Edit a card
    Given Edit a card with name "Khang" to "Hao"
    When Edit that card
    Then The card name is updated to "Hao"

  Scenario: Edit a card
    Given Edit a card with name "Hao" to "Khang"
    When Edit that card
    Then See an error message with text "Name not found"

  Scenario: Add cards
    Given I want to add a following cards
      | Name | Id |
      | Huy  |  2 |
      | Hao  |  3 |
    When Add that cards
    Then Both 2 cards are added

  Scenario Outline: Edit a card
    Given I want to update a card name "<Name>" to a new name "<NewName>"
    When I update the name
    Then The card name is updated to "<NewName>"

    Examples:
      | Name  | NewName      |
      | Khang | Khang Nguyen |
      | Khang | Khang Tran   |
