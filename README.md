# automation framework with spring
This project shows how spring can be used in automation testing framework.

## Table of content 
* [General Info](#general-information)
* [Design Patterns](#design-patterns)
* [Features](#features)
* [Additional information](#additional-information)  
* [Spring extended description](#spring-extended-description)
* [BDD extended description](#bdd-extended-description)
* [Room for Improvement](#room-for-improvement)

## General Information
- Purpose of this project is to demonstrate how an automation framework may look like with the usage of Spring framework.
- Framework is created as Maven project, it focuses on User Interface (web shop) and test cases are written with BDD approach (with support of Cucumber and Gherkin language). 

## Design patterns
- There is design pattern used for Selenium: POM (Page Object Model) with the usage of Page Factory class.
    - POM is a design pattern used in Selenium, where we create an object repository to store web elements. Package `pages` consists java classes in which there are locators present which correspond to WebElements on specific pages.
      PageFactory is a way of implementing the POM.
      
- There are also 2 design patterns: Singleton and Strategy.
  - Strategy Pattern is used in Web Drivers, because I want to check more just than one driver.
  - Singleton Pattern is used in connection to Web Driver. I want a single instance of a driver to be reachable from any place from a code. 
   
## Features
- There are 2 basic BDD scenarios in `features` package : SignIn and Checkout. 

## Additional information
- To avoid hardcoding, values which won’t change and are needed through entire framework are in ‘Constants’ class.
- Password is encoded with base64 api (present in `Utils` class), so it is not publicly visible.
- As mentioned above Locators are in pages package and every POM class has a corresponding name to specific page.
- There can be screenshots taken (implementation of it is in `Utils` class).


## Spring extended description
- This is an additional part of README file. It could not be here, but I wanted to clarify how Spring features look in this framework.

    - There is a usage of Spring Boot framework. Automation framework could be used without it, but here it is treated as a foundation for BDD tests.
  It helps to handle objects in a better way thanks to spring beans. They help to manage objects during their whole lifecycle. They provide a way to efficiently manage those objects, to allow the execution of the tests. The framework knows when to inject those objects, when to create them, when to delete them and all other operations that are usually handled by people.  
  This provides a good management of those objects, and it makes everything more efficient in terms of performance, in terms of managing our resources within the framework when test cases are executed.
  Additionally it implements the concept of inversion of control – it is basically a design principle.
  Control of an object is inverted to a more professional dedicated framework, that handles that object and responsibility of the object on our behalf.
  In class `ConfigurationProperties` in `utils` package there is added annotation `@Component` - a spring bean, so it’s a part of inversion of control. Also there are annotations `@Value` which define a variable. Additional annotation `@PropertySource` points to file `framework.properties` where are pairs key-value placed.
    - There is also a basic class `AutomationFrameworkConfiguration` in package `confi`’, which scans framework for components. There is annotation `@Configuration` and annotation `@ComponentScan` where we specify a package where do we want to perform component scan in a search for `@Components` annotations.


## BDD extended description

- Similarly to Spring description, I added more detailed explanation about BDD in this section.

  -  TODO

## Room for Improvement
- As mentioned above, the idea of this project was to put focus on spring functionalities, so there are only basic features created.
  However, it is still developed. README file will be improved and implementation itself will also grow.
  