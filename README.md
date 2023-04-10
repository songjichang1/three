#JAVA-Project-Library 
Java+Spring Framework+Oracle 도서관프로그램
***
## :computer: 프로젝트 소개
- **도서관에서 회원(추가,수정,삭제,조회), 도서(추가,수정,삭제,조회), 대여(대여,반납,조회)**

## :mag_right: 프로젝트 상세 내용
- **프로그램 실행자는 도서매니저**
- 회원(추가,수정,삭제,조회), 도서(추가,수정,삭제,조회), 대여(대여,반납,조회)
- 대여은 중복된 도서를 제외 하고 n개 대여 가능
- 도서, 회원 삭제 시 대여중인 회원, 도서목록도 함께 삭제
- **특정 도서, 회원 상세정보 확인 후 Update 수정 가능**

## :bulb: **기술스택**
- ` java ` 
- ` Oracle `
- ` 전자정부프레임워크 `
- ` JSP `
- ` Apache Tomcat `

## :scroll: **주요기능**
### :microphone: Apache+Tomcat (Tomcat이 Apache 기능 일부를 가져와 제공! WAS(Web Application Server)
- Tomcat : 동적인 web을 만들기 위한 Web Container(servlet Container)
- Web Server에서 정적으로 처리해야 할 데이터를 제외 (JSP,PHP) 등 Web Container(Tomcat) 전달
- Apache : Web Server 불리우며 Client request(요청)이 있을때만 응답하는 정적 페이지에 사용.

### :computer: Apache+Tomcat 흐름
- Client -> Web Server( 동적인페이지라면 Web Container(servlet Container) 전송) 정적페이지라면 Client 전송.
- Web Container(servlet Container) : JSP,Servlet 구동 환경 제공
- Web Server는 Web Container(servlet Container)받은 결과값을 Client로 전송(정적인 data 전송)

```java
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath*:spring/context-*.xml</param-value>
	</context-param>

	<!-- Creates the Spring Container shared by all Servlets and Filters -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<!-- Processes application requests -->
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath*:spring/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
```
- web.xml 설정파일 중 contextConfigLocation(Spring Framework가 동작하기 위한 설정파일의 위치를 알려주는 파라미터)
- classpath*:spring/context-*.xml(context-*.xml)xml파일로 된 설정파일은 모두 읽는다.
- classpath*:spring/servlet-context.xml(servlet-context.xml)xml파일로 된 설정파일을 읽는다.

```java
servlet-context.xml

<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<context:component-scan base-package="bookMng">
	 <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	 <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
	</context:component-scan>
	
```
- bookMng 패키지 안에 하위패키지를 검색해 @Contoller,@Service를 포함하는 클래스를 Bean으로 자동 등록

```java
context-datasource.xml

<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
		<property name="username" value="c##song1" />
		<property name="password" value="1234" />
	</bean>

	<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
		<constructor-arg ref="hikariConfig" />
	</bean>
```
- 데이터베이스 hikari(커넥션풀)를 하기 위해 데이터베이스의 정보와 hikariConfig는 데이터베이스의 정보를 참조.

```java
context-mapper.xml

<bean  id ="sqlSession" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		
	</bean>

	<mybatis-spring:scan base-package="bookMng.book.service.impl" />
	<mybatis-spring:scan base-package="bookMng.user.service.impl" />
	<mybatis-spring:scan base-package="bookMng.bookRental.service.impl" />

	</beans>
```
 - context-datasource.xml 파일에 있는 id가 dataSource인 bean을 참조하여 Mybatis와 DB 연동
 - Mapper interfase들을 메모리에 올리기위해 scan
 - SqlSessionFactoryBean(SQL을 실행하는 API)

```java
<b>도서ID</b> <br>
<input class="text" type="text" name="bookID" value= "${dto.bookID}"  readonly required> <br>
<b>회원ID</b> <br> 
<input class="text" type="text" name="userID" value="${dto.userID }"  readonly required> <br>
```
- 도서,회원의 상세정보에서 정보를 수정하기 전에 bookID,userID 값을 기준으로  DB에 접근하여 정보를 수정해야 하기 때문에 readonly 하여 고정.
- 정보를 (CRUD) 할 때 입력란에 공백이 없게끔 required 설정
