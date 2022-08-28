### 工程模板自动生成

#### 变量

* groupId    | 组名                             
* artifactId | 工程名字 op-xxsrv                                   
* package    | 包名 
* appName     | appName                                             


service 工程模板执行
```

mvn archetype:generate  -DgroupId=com.only4play -DartifactId=demosrv -Dversion=1.0.0-SNAPSHOT -Dpackage=com.only4play.demo -DappName=demo-srv -DarchetypeArtifactId=op-service-archetype -DarchetypeGroupId=com.only4play -DarchetypeVersion=1.0.0-SNAPSHOT
```
web 工程模板执行
```
mvn archetype:generate  -DgroupId=com.only4play -DartifactId=demoweb -Dversion=1.0.0-SNAPSHOT -Dpackage=com.only4play.demoweb -DappName=demo-web -DarchetypeArtifactId=op-web-archetype -DarchetypeGroupId=com.only4play -DarchetypeVersion=1.0.0-SNAPSHOT

```
api 工程模板执行
```

mvn archetype:generate  -DgroupId=com.com.only4play -DartifactId=demoapi -Dversion=1.0.0-SNAPSHOT -Dpackage=com.only4play.demoapi -DarchetypeArtifactId=op-api-archetype -DarchetypeGroupId=com.only4play -DarchetypeVersion=1.0.0-SNAPSHOT

```