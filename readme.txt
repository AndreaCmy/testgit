spring mvc项目 http://localhost:8080/zen/
1.spring.xml中
<mvc:default-servlet-handler/>
<mvc:annotation-driven />

2.log4j需要的jar包
      <dependency>
          <groupId>log4j</groupId>
          <artifactId>log4j</artifactId>
      </dependency> 
      <dependency>
          <groupId>org.slf4j</groupId>
          <artifactId>slf4j-api</artifactId>
      </dependency> 
      <dependency>
          <groupId>org.slf4j</groupId>
          <artifactId>slf4j-log4j12</artifactId>
      </dependency>
	  
3.	  