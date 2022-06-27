Feature: PositiveSimilarityTest

  Scenario: find if two similar arrays are identified correctly by the areSimilar() function
    Given I have have two similar arrays
      | 5,1,4,3,6,7,2 | 1,2,3,4,5,6,7 |
      | 5,1,4,3,6,7,2 | 5,1,4,3,6,7,2 |
    When I send the similar arrays to the areSimilar function
    Then All results should be true
