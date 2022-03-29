Feature:Qatar Test

  Scenario:Android Booking Flight As a Guest

    Given I open Qatar Airways
    And Skip Location Page
    And Skip Welcome Page
    When show Get notified, never miss an offer!
    And decline Get notified, never miss an offer!
    Then accept permission
    When Switch to booking tab
    And Choose one-way flight
    And Select "Milan" as departure city
    Then Select "Paris" as destination city
    When Select random departure time
    Then Click Search flights
    When Select first flight
    And Select flight experience
    Then Continue as a guest
    When Go to passenger details section
    And Choose Mr as a title
    And Enter "John" as a firstname
    And Enter "Doe" as a lastname
    And Select male from gender
    And Choose "1997" from date of birth
    And Select "Turkey" from nationality
    Then Click 'Done'
    When Click 'I have verified that the details provided'
    Then Click Continue


