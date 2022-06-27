Feature: NegativeSimilarityTest

  Scenario: find if two different arrays are identified correctly by the areSimilar() function
    Given I have have two different arrays
      | 5,1,4,3,6,7,3 | 1,2,3,4,5,6,7 |
      | 1,2,3 | 1,3,4 |
      | 1,2,3 | 1,2,3,4 |
    When I send the different arrays to the areSimilar function
    Then All results should be false
