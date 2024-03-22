# Selenium Java Web Automation Demo Portfolio

## Works
### 1.Regression Test for product purchasing process

#### Code

* [Base File (Starting Point)](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/blob/main/src/test/java/testComponents/BaseTest.java)

  * This is the starting point of automation. Method for driver and browser type initialization is defined here and will be run automatically before each test method execution because I put testNG annotation (@BeforeMethod(alwaysRun=true)).
    
  * createed method for test data interpretation (JSON->String->JavaObject) and screenshot here for convenience because test file is inheriting it. 
  
* [Regression Test](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/blob/main/src/test/java/tests/TestPractice.java)

  * Regression test for the process from login to checkout with assertion.

* [Negative Test](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/blob/main/src/test/java/tests/ErrorValidation.java)

  * Negative test for login page that input invalid credential.
  
* [Page Objects](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/tree/main/src/main/java/pageObjects)

  * Page Objects to seperate selectors and layouts from test performing.
  
* [Utility](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/blob/main/src/main/java/abstractComponents/Utility.java)

  * Commonly used methods by page object classes such as explicit wait or navigation link

* [etc (Data file, Property, Report...](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/tree/main/src/main/java/resources)
  
  * I initialized browser type in a key-value form in the property file.
  * extent report
  * JSON data file

--------------

### 2.What I've learned

* [What I've learned](https://github.com/wohu8292/SeleniumWebTesting_Learning)

* [Handling Dropdown, Checkbox](https://github.com/wohu8292/SeleniumWebTesting_Portfolio_DemoProject/blob/main/src/test/java/tests/UI_components.java)


