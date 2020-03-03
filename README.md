# Project 3: Object-Oriented Design and Analysis

## Program Name

Rental Car Simulator

## Team Members

Nicole Richter

Holden Kjerland-Nicoletti

Munkhbayan (Bryan) Togtokh

## Language & Environment

Java 8 via IntelliJ IDEA

## Design Patterns Used

*Factory Pattern* is used in the `CarFactory` class for instantiating all of the cars available for rent

*Decorator Pattern* is used for calculating costs, Base Cost is just number of days * daily rate, Total Cost covers that plus the options of Satelite Radio, GPS, and Car Seats.

*Observer Patter* is used for notifying rented cars that the day has ended, and their rented days left should decrease.
