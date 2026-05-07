# Selenium Automation Framework – SauceDemo

## Known Issue

One test case related to checkout without cart items is currently skipped due to a valid application defect where checkout is allowed with an empty cart.

---

## Framework Choice

This project is developed using:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- GitHub Actions

### Why this framework was chosen

- **Selenium WebDriver** provides reliable browser automation support for end-to-end UI testing.
- **Java** offers strong object-oriented capabilities and is widely used in enterprise automation frameworks.
- **TestNG** enables flexible test execution, assertions, grouping, and reporting support.
- **Maven** simplifies dependency management and project build execution.
- **Page Object Model (POM)** improves code maintainability, readability, and reusability.
- **Extent Reports** provides detailed HTML execution reports with screenshot support for failures.
- **GitHub Actions** enables CI/CD execution on every code push for automated validation.

---

## Current Framework Features

- Reusable utility methods
- Listener-based reporting
- Screenshot capture on test failure
- Cross-browser support
- Centralized driver management
- CI execution using GitHub Actions
- Automated Extent Report upload after pipeline execution

---

## Extension Plan

### Parallelisation

The framework can be enhanced further using:

- ThreadLocal WebDriver for thread-safe parallel execution
- TestNG parallel execution support
- Selenium Grid / Docker integration for distributed execution
- Optimized driver lifecycle management for better resource utilization

### Reporting Enhancements

Future reporting improvements may include:

- Improved screenshot attachment handling in Extent Reports
- Allure Report integration
- Execution trend dashboards
- Automatic report publishing in CI pipeline
- Email notification support after execution
- Retry mechanism for flaky test handling