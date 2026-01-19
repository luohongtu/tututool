# tututool

### A lightweight Java tool collection

#### Project Description
This is a versatile tool collection for Java developers, focusing on solving common development pain points with efficient and concise solutions. Currently includes an exception handling module, with additional modules to be added in the future.

**Core Features:**
- Exception Handling Module: A flexible exception handling framework based on the Bridge design pattern

#### Software Architecture
##### Exception Handling Module Architecture

```
+-----------------+        +------------------------+        +----------------------+
|   AnomalyBridge |        | BsAssertExceptionFactory |       |      AnomalyState   |
+-----------------+        +------------------------+        +----------------------+
|  registerFactory()       |  exception(P stateInfo)        |  state()             |
|  exception(P stateInfo)  +------------------------+        |  stateMessage()      |
+-----------------+               ^                          +----------------------+
        ^                          |                                      ^
        |                          |                                      |
+-------+-----------+              |                                      |
| DefaultAnomalyState |             +--------------+                       |
+---------------------+              |              |                       |
                                     |              |                       |
                          +----------+--+ +---------+--------+        +----+----------------+
                          | AnomalyExceptionFactory | | DistributedAnomalyExceptionFactory | | ... custom exception factories ... |
                          +--------------------------+ +-----------------------------------+ +-----------------------+
                                     |                                      |
                                     v                                      v
                          +---------------------+              +------------------------------+
                          | AnomalyException   |              | DistributedAnomalyException   |
                          +---------------------+              +------------------------------+
```

**Architecture Features:**
- **Bridge Design Pattern**: Separates the abstraction of exceptions from their implementation, allowing them to vary independently
- **Extensible Architecture**: Easily add new exception types and exception factories
- **Decoupled Design**: Separates exception creation from usage, improving code flexibility and maintainability

#### Quick Start

##### Dependencies
Currently, the project is in development phase. It is recommended to clone the project locally and build using Maven.

```bash
git clone https://github.com/your-repo/tututool.git
cd tututool
mvn clean install
```

Add the following dependency to your project's pom.xml to use the exception handling module:

```xml
<dependency>
    <groupId>cn.foolishbird</groupId>
    <artifactId>tututool-anomaly</artifactId>
    <version>1.0.0</version>
</dependency>
```

##### Usage Example for Exception Handling Module

**Basic Usage:**

1. Create an exception state class

```java
public enum DemoException implements AnomalyState {
    PARAM_ERROR("400", "Parameter error"),
    DATA_NOT_FOUND("404", "Data not found"),
    SYSTEM_ERROR("500", "Internal system error");

    private final String state;
    private final String message;

    DemoException(String state, String message) {
        this.state = state;
        this.message = message;
    }

    @Override
    public String state() {
        return this.state;
    }

    @Override
    public String stateMessage() {
        return this.message;
    }
}
```

2. Register exception factories

```java
// Register custom exception factory
AnomalyBridge.registerFactory(new AnomalyExceptionFactory<>());

// Register distributed exception factory
AnomalyBridge.registerFactory(new DistributedAnomalyExceptionFactory<>());

// Register default runtime exception factory
AnomalyBridge.registerFactory(new RuntimeExceptionFactory<>());
```

3. Throw exceptions

```java
// Check parameter and throw exception if null
if (param == null) {
    throw AnomalyBridge.exception(DemoException.PARAM_ERROR);
}
```

**Notes:**
- You must register at least one exception factory. By default, RuntimeExceptionFactory will be used if no factories are registered
- Multiple exception factories can be registered, and the system will search in registration order
- The exception state can be any class that implements the AnomalyState interface

#### Contribution

1. Fork this repository
2. Create a Feat_xxx branch
3. Commit your code
4. Create Pull Request

#### About the Author
- **Author**: foolish-bird
- **Email**: your-email@example.com

#### License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.