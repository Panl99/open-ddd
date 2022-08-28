> [Follow](https://gitee.com/only4playgroup/op-system-center)

### 领域服务业务编程实战全纪录

#### 现实中什么有哪些框架是领域服务

* 注册中心、配置中心（提供了信息注册，注册信息同步，注册信息读取）
* 调度平台（提供任务的管理及调度）
* 批处理框架（spring batch)，数据读取、数据处理、数据写出
* 权限框架（spring security) ，权限上下文管理，认证、授权
* 工作流引擎（flowable) ,流程的管理
* 规则引擎（drools) 规则的管理

#### 现实世界中

* 计算机主板
* 汽车的发动机

#### 领域服务是什么

* 面向对象编程，符合开闭原则的编程方式
* 编程思想
* 内部封装复杂性，对外提供优雅易用的接口

#### 领域服务不是什么

* 不是六边形架构，洋葱架构，条条框框
* 不是值对象、不是什么战略设计，战术设计等虚无缥缈的概念
* 不是标准固化的，服务可大可小，汽车如果从交通工具上来说，汽车整体就是领域服务，但是要从汽车本身来讲，发动机又可以作为汽车的领域服务
* 不是什么方法都要通过Dispatch进行分发，什么都要发送领域事件，这种复杂的用其他方式封装变化就好。保存个用户和角色的关系，还要什么通过网关分发，那是不懂得变通。

#### 学好领域服务的前提有哪些

* 设计模式（精通常见设计模式）
* 优秀框架源码经常要阅读
* 学会抽象思维，发散思维，用现实世界去比对代码世界
* 业务专家，有一定的架构能力
* 不要循规蹈矩，没有编程规则


#### 什么情况下建议使用DDD

* 业务足够复杂，团队部门划分比较清楚,团队人员水平较高，不然踏实CRUD
* 技术驱动公司，有技术追求
* 个人极客
* 代码复用，懒人
* 不是先有表再开发的公司，面向数据库编程还是算了吧
* 不是产品驱动的公司（技术必须具有主导权限)

#### 如何评价好的DDD实现方式

* 写的代码与服务，复制过去能用到别的公司就OK！
* 服务之间接口定义优雅，放在一个项目中是不同的包，放到不同的项目里是不同的服务（这点非常重要）


#### 实现场景

假设有一个集团化的公司，技术人员足够多，100多人左右，有多种产品业务线，有电商业务，有租赁业务，有虚拟服务，有金融服务。公司有多个管理后台，发票管理系统，运营管理系统，审核系统，报表系统，客服系统等几十个后台管理系统。公司有丰富的运营和营销体系，支付方式多种多样（类似京东），开发票方式可以根据不同的支付方式设置不同的开票规则，公司对接多个短信平台，对接多个支付渠道，消息推送方式多种多样。后台管理系统有足够的数据权限层级，业务需求千变万化。

如果这样的系统由你一个人来开发，请问你如何设计这个系统，如何顶层架构，如何具体落地，如何用最快的速度开发。

用先建表的方式，然后凭你一个人去记住所有的表关联，这种明显不行，这时就能够用到领域设计的思想了。

#### 编程后期围绕什么来实现

从通用性上进行业务划分，主要分为以下几个中心

* 订单中心（通用订单服务）
* 支付中心（扣款）
* 消息中心（短信发送、钉钉消息、邮件发送）
* 三方中心（三方服务对接）
* 发票中心
* 营销中心
* 数据中心（审计日志保存、通用字典、点击记录、监控）
* 认证中心
* 文件中心
* 通用网关
* 用户中心

#### 技术选型

* spring cloud &emsp;2021.0.1
* spring-cloud-alibaba &emsp;2021.0.1.0
* querydsl &emsp;5.0
* spring-data &emsp;2021.1.4
* springdoc-openapi-ui &emsp;1.6.8
* spring-cloud-starter-sleuth
* spring-cloud-stream-binder-kafka
* javers(审计框架)
* flowable (流程引擎)
* spring-boot-starter-data-elasticsearch（elasticsearch 7.15.2)
* spring cloud gateway
* spring security(权限控制)
* flink(1.13.2)，flinkcdc
* elasticjob (分布式任务调度)
* spring batch(批处理框架)
* drools （规则引擎）

#### 监控相关

* cerebro (es监控)
* logstash、kibana (日志收集)
* EFAK (kafka 监控)
* 阿里云效（自动化发布平台）
* skywalking(链路追踪)

#### 学习方式

* 业务驱动学习，用到的技术都会用知识点重点标记出来，然后去主动学习，带有目的性的学习是最高效的学习方式

#### 为什么要学习领域设计（或者就叫编程思维）

* 领域设计实际是需要大量的设计模式，在这个过程中会养成面向对象的编程思维，不是上来就先考虑表如何设计。然后怎么按照产品的需求去做增删改查。
* 在最初也写了，一个优秀的框架本身就是一个领域设计实现，分析及使用一个框架的时候如果站在设计者的角度去思考，那么使用一个框架的时候靠猜就能知道怎么去使用了。



