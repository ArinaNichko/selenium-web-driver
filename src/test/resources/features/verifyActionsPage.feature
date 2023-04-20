Feature: Verify actions page functionality

  Background:
    Given User opens Home page
    When User clicks on the Actions link
    And User switches to another tab

  Scenario: Verify that user can drag and drop element successfully
    When User moves element to container
    Then the container text should contain "Dropped!"

  Scenario: Verify that user can double click on an element
    When User performs double click
    Then the double clickable item should have color "rgb(147, 203, 90)"

  Scenario: Verify that user can click and hold on an element
    When User clicks and holds on the box
    Then the box color should be "rgb(0, 255, 0)"
    And the box text should be "Well done! keep holding that click now....."
