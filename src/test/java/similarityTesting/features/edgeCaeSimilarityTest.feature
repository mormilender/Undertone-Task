Feature: EdgeCaseSimilarityTest

  Scenario: find if two different edge case arrays are handled correctly by the areSimilar() function
    Given I have have two different edge case arrays
      |  | 1,2,3,4,5,6,7 |
      | 1,2,3 | |
      | | |
    When I send the different edge case arrays to the areSimilar function
    Then All results should be false with no exception thrown
