# Cucumber Training

This is a code example for Cucumber training using Java, Gradle, Cucumber, Junit, and VSCode.

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
