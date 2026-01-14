# tututool

### 一个轻量级的Java工具包集合

#### 项目介绍
这是一个为Java开发者提供的多功能工具包集合，专注于解决常见的开发痛点，提供高效、简洁的解决方案。目前已包含异常处理模块，后续将逐步扩展其他工具模块。

**核心功能：**
- 异常处理模块：基于桥接设计模式实现的灵活异常处理框架

#### 软件架构
##### 异常处理模块架构

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
                          | AnomalyExceptionFactory | | DistributedAnomalyExceptionFactory | | ... 自定义异常工厂 ... |
                          +--------------------------+ +-----------------------------------+ +-----------------------+
                                     |                                      |
                                     v                                      v
                          +---------------------+              +------------------------------+
                          | AnomalyException   |              | DistributedAnomalyException   |
                          +---------------------+              +------------------------------+
```

**架构特点：**
- **桥接设计模式**：将异常的抽象与实现分离，使它们可以独立变化
- **可扩展架构**：允许轻松添加新的异常类型和异常工厂
- **解耦合**：异常的创建与使用分离，提高了代码的灵活性和可维护性

#### 快速开始

##### 依赖导入
目前项目处于开发阶段，建议直接克隆项目到本地，使用Maven进行构建。

```bash
git clone https://github.com/your-repo/tututool.git
cd tututool
mvn clean install
```

在需要使用异常处理模块的项目中，添加以下依赖：

```xml
<dependency>
    <groupId>cn.foolishbird</groupId>
    <artifactId>tututool-anomaly</artifactId>
    <version>1.0.0</version>
</dependency>
```

##### 异常处理模块使用示例

**基本使用方式**：

1. 创建异常状态信息类

```java
public enum DemoException implements AnomalyState {
    PARAM_ERROR("400", "参数错误"),
    DATA_NOT_FOUND("404", "数据不存在"),
    SYSTEM_ERROR("500", "系统内部错误");

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

2. 注册异常工厂

```java
// 注册自定义异常工厂
AnomalyBridge.registerFactory(new AnomalyExceptionFactory<>());

// 注册分布式异常工厂
AnomalyBridge.registerFactory(new DistributedAnomalyExceptionFactory<>());

// 注册默认运行时异常工厂
AnomalyBridge.registerFactory(new RuntimeExceptionFactory<>());
```

3. 抛出异常

```java
// 检查参数，如果为null则抛出异常
if (param == null) {
    throw AnomalyBridge.exception(DemoException.PARAM_ERROR);
}
```

**注意事项**：
- 必须先注册至少一个异常工厂，否则默认将使用RuntimeExceptionFactory
- 可以注册多个异常工厂，系统将按注册顺序进行查找匹配
- 异常状态类可以是任何实现了AnomalyState接口的类或枚举

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

#### 关于作者
- **Author**：foolish-bird
- **Email**：your-email@example.com

#### 许可证
本项目采用MIT许可证，详见[LICENSE](LICENSE)文件。