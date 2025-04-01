Feature: Calculator Service

  Scenario: Valid addition operation
    Given I have the numbers 5 and 3
    When I perform the "SUM" operation
    Then the result should be 8

  Scenario: Unsupported operation error
    Given I have the numbers 10 and 4
    When I perform the "DIVIDE" operation
    Then I receive an error message "Operation not supported"