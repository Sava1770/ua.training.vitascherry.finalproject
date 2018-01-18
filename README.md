# 12. Система Быстрого Тестирования Студентов
Студент регистрируется э-мейлом, к нему привязывается его Успеваемость
и на нее будут приходить сообщения о результате тестов.
В системе существует каталог Тестов по Темам,
авторизованный Студент может проходить тесты.
В конце теста на странице должна отобразиться форма где показано ошибки Студента.
Все данные об успеваемости и пройденных курсах
отображаются на странице Администратора как сводная таблица по всем Студентам.

## Архитектура приложения
- MVC. Webapp
- При разработке спользованы шаблоны: GoF (e.g. Builder, Singleton, Command, AbstractFactory)
- Сборка приложения происходит при помощи Apache Maven
- Сервер для запуска - Apache Tomcat

## Технологии
- JSP + JSTL
- Servlets + Filters
- Session
- MySQL JDBC
- Log4J2
- JUnit
- Mockito
- Pagination
- Transaction

## Перед запуском убедиться что
1. Установлены JDK и JRE и были созданы переменные среды (e.g. JAVA_HOME, CLASS_PATH) [Скачать](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) / [Инструкции](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
2. Установлен MySQL Server [Скачать](https://dev.mysql.com/downloads/installer/) / [Инструкции](https://dev.mysql.com/doc/refman/5.7/en/installing.html)
3. Установлен Apache Maven и были созданы переменные среды (e.g. M2_HOME) [Скачать](https://maven.apache.org/download.cgi) / [Инструкции](https://maven.apache.org/install.html)
4. Установлен Apache Tomcat и были созданы переменные среды (e.g. TOMCAT_HOME или CATALINA_HOME) [Скачать](https://tomcat.apache.org/download-80.cgi) / [Инструкции](https://www.ntu.edu.sg/home/ehchua/programming/howto/Tomcat_HowTo.html)

## А также присутствуют записи в файлах:
1. **[%TOMCAT_HOME%/conf] tomcat-users.xml**
```
  <role rolename="tomcat"/>
  <role rolename="admin-script"/>
  <role rolename="manager-script"/>
  <role rolename="manager-gui"/>
  <role rolename="manager-jmx"/>
  <role rolename="manager-status"/>
  <role rolename="manager"/>
  <role rolename="admin"/>
  <user password="tomcat" roles="tomcat" username="tomcat"/>
  <user password="admin" roles="manager-gui" username="admin"/>
  <user username="mavenuser" password="password" roles="admin,admin-script,manager-gui,manager-script,manager-jmx,manager-status"/>
```
  
2. **[%MAVEN_HOME%/conf] settings.xml**
```
  <server>
	<id>tomcatserver</id>
	<username>mavenuser</username>
	<password>password</password>
  </server>
```

3. **[%PROJECT%] pom.xml**
```
  <groupId>org.apache.tomcat.maven</groupId>
  <artifactId>tomcat7-maven-plugin</artifactId>
  <version>2.2</version>
  <configuration>
	<url>http://localhost:8080/manager/text</url>
	<server>tomcatserver</server>
	<path>/</path>
	<username>mavenuser</username>
	<password>password</password>
	<update>true</update>
  </configuration>
```

## Инструкции по запуску
1. Скачать и распаковать архив с проектом или загрузить при помощи клиента Git `git clone https://github.com/vitascherry/ua.training.vitascherry.finalproject.git`
2. Подключиться к MySQL Server при помощи MySQL Workbench или командной строки.
3. Создать схему базы данных и необходимые таблицы при помощи скрипта `%PROJECT%/src/main/resources/create_db.sql`
4. Запустить Apache Tomcat локально (e.g. `%TOMCAT_HOME%/bin/startup.bat`)
5. Запустить приложение из корневой директории (с `pom.xml`) с командной строки при помощи: `mvn tomcat7:deploy` или `mvn tomcat7: run-war`
6. Посмотреть сайт можно на http://localhost:8080/

## Для входа
- как **Администратор** используйте e-mail `root.root@gmail.com` и пароль `password`
- как **Студент** зарегистрируйтесь или используйте готовые логины в базе данных. Пароль для всех `password`