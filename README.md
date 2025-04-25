# Cucumber Training

This is a code example for Cucumber training using MacOS, Java, Gradle, Cucumber, Junit, and VSCode.

## Run Test

Run `./gradlew test` to view a simple result of tests.

Run `./gradlew test --info` to view test result and stack trace of failed tests.

## VSCode

### Plugins

- Extension Pack for Java
- Cucumber

### Cucumber

To detect `.feature` files and step definitions, need to add to `settings.json`

```json
  "cucumber.features": [
    "**/features/*.feature",
  ],
  "cucumber.glue": [
    "**/steps/*.java",
  ],
```

## Gherkin
Based on BDD framework. Here is the template,

`Feature`

`Scenario`

- `Given`
- `When`
- `Then`

> Steps in `Scenario` don't need to be in order

## Java
We can use **Cucumber** integrated with `JUnit` for unit testing and `Selenium` for automation. First, you need to complete the prerequisites:

1. Install your favorite IDE (Eclipse, VSCode)
2. Install Java JDK
3. Install Maven/Gradle
4. Import `cucumber` and `cucumber-junit` dependency
5. Install **ChromeDriver** directly from Chrome
6. Import `selenium-java` and `selenium-chrome-driver` dependencies

We should **set up Cucumber** and **Test Runner** before creating actual classes, following these steps:

1. Create a `.feature` file, eg. `MenuManagement.feature` to describe all the scenarios following Gherkin template. When running the feature file, it should populate suggested feature methods to be implemented.
2. Create a step definition `.java` class, eg. `MenuManagementSteps.java` and input all the step methods.
3. Create a runner class, `MenuManagementTest.java` and specify these annotations

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/...",          // path to MenuManagementSteps.class
    glue = "stepdefinitions",      // to glue step classes
    plugin = { "pretty" }          // beatify test result
)
public class MenuManagementClass {}
```

> Cucumber uses Cucumber Expression as default. If you want to use Regex, add `^` and `&` to beginning and end of sentence. They **do not** mix of expressions.

We can run only specific scenario using tag with any name, `@TestA`, tied to `Scnenario`.

`Background` can be used to run before each `Scenario` and its steps are the same.

**Hooks** can be used `@Before` and `@After` to make output clean. **Tagged hooks** can be used.

## Cucumber Options
- features: to include feature files
- glue: to attach definitions and hooks
- plugin: extension used for output
- dryRun: verify every scenario has step definitions without running the code
- monochrome: make output more readable, no random special characters

## Generate Reports
There are plugins we can use to generate report, we can specify the location where we want the report to live

- `"html:target/SystemTestReports/html"`
- `"json:target/SystemTestReports/report.json"`
- `"junit:target/SystemTestReports/report.html"`

## Data Tables
Data Table is in a tabular form. It's used for compacting tests.

Create table without a header, we will need `List<String>` or `List<List<String>>`

```txt
Given: I place an order with following items
| Chicken | 1 | 5  |
| Beef    | 2 | 10 |
```

Create a table with header, we will need `List<Map<String, String>>`. The **key** will be the header text value.

```txt
Given: I place an order with following items
| ItemName | Units | UnitPrice |
| Chicken  | 1     | 5         |
| Beef     | 2     | 10        |
```

Or `Scenario Outline` can also provide similar result. Need to use `<Value>` in statement.
```txt
Scenario Outline: Customer Bill Calculation
Given: I have a customer
And User enters inital bill amount as <InitalBillAmount>
And Sales Tax Rate is <TaxRate> percent
Then the final bill is <CalculatedBillAmount>
Examples:
| InitialBillAmount | TaxRate | CalculatedBillAmount |
| 100               | 10      | 110                  |
| 200               | 8       | 216                  |
| 100               | 1.55    | 101.55               |
```


