# 12. Система Быстрого Тестирования Студентов
Студент регистрируется э-мейлом, к нему привязуеться его Успешность
и на него будут приходить сообщения о результате тестов.
В системе существует каталог Тестов по темам,
авторизованный Студент может проходить тесты.
В конце теста должна на странице отобразится форма где показано ошибки студента.
Все данные об успеваемости и пройденных курсах
отображаются на странице Администратора как сводная таблица по всем Студентам.

# Архитектура приложения
- MVC. Webapp
- Сборка приложения происходит при помощи Maven
- Использованы шаблоны: GoF (e.g. Builder, Singleton, Command, AbstractFactory)

# Технологии
- JSP + JSTL
- Servlets + Filters
- Session
- MySQL JDBC
- Log4J2
- JUnit
- Mockito
- Pagination
- Transaction

# Перед запуском убедиться что
1. Установлена последняя Java JDK и были созданы переменные среды (e.g. JAVA_HOME, CLASS_PATH)
2. Установлена база данных MySQL (e.g. MySQL Installer)
3. Установлен Apache Maven и были созданы переменные среды (e.g. M2_HOME)
4. Установлен Apache Tomcat и были созданы переменные среды (e.g. TOMCAT_HOME или CATALINA_HOME)

А также присутствуют записи в файлах:
1. [%TOMCAT_HOME%/conf] tomcat-users.xml
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

2. [%MAVEN_HOME%\conf] settings.xml
  <server>
	<id>tomcatserver</id>
	<username>mavenuser</username>
	<password>password</password>
  </server>
  
3. [%PROJECT%] pom.xml
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

# Инструкции по запуску
1. Скачать архив с проектом или загрузить при помощи git clone
2. Создать схему базы данных и необходимые таблицы (e.g. %PROJECT%/src/main/resources/create_db.sql)
2. Запустить Apache Tomcat локально (e.g. %TOMCAT_HOME%\bin\startup.sh)
3. Запустить с командной строки при помощи: mvn tomcat7:deploy или mvn tomcat7: run-war
4. Посмотреть сайт можно на http://localhost:8080/