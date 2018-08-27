## Creating A Spring Config Server

* **Objective** - to implement and consume a Spring Config Server, providing a HTTP resource-based API for external configuration. 

* **Purpose** - to demonstrate
    * ``@EnableConfigServer``
    * Configuring a Config Server through ``application.properties``.
    * Consuming a config server through ``bootstrap.properties``
    * ``@EnableConfigurationProperties``
    * Using ``@ConfigurationProperties`` to map configuration properties to POJOs.
	
### Part 1.0 - Create A Spring Config Server Class
	
* Navigate to <a href="start.spring.io">start.spring.io</a> to initialize a new project.

* Choose your group and artifact, then search for **Config Server** under dependencies and add it to your project.

* After opening up your project annotate the main application class with ``@EnableConfigServer``.

* In the ``application.properties`` file, set your port to ``8888`` via the appropriate property. <a href="https://cloud.spring.io/spring-cloud-config/single/spring-cloud-config.html#_spring_cloud_config_server">Hint</a>

* In the ``application.properties`` file, set the uri of the configuration repository via the appropriate property. <a href="https://cloud.spring.io/spring-cloud-config/single/spring-cloud-config.html#_spring_cloud_config_server">Hint</a>
    * The configuration repository is located at https://github.com/Zipcoder/CR-MesoLab-Spring-Config-Repo
    
* Test that your config server is running by starting the application and navigating to ``localhost:8888\bakery-service\default``. This endpoint exposes all the properties available to a service that exposes itself as "bakery-service". 

### Part 2.0 - Consume A Config Server as a Config Client

* Open up the project contained in this repo via the pom.xml

* Add the following to the pom.xml file

```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```
* Create a ``bootstrap.properties`` file in src/main/java/resources.

* Inside the ``bootstrap.properties`` file, name your project "bakery-service" via the appropriate property. <a href="https://spring.io/guides/gs/centralized-configuration/#_reading_configuration_from_the_config_server_using_the_config_client">Hint</a>

* Inside the ``bootstrap.properties`` file, point your server to the uri where your config server is located. <a href="https://spring.io/guides/gs/centralized-configuration/#_reading_configuration_from_the_config_server_using_the_config_client">Hint</a>

* Start your application. To test if your client is successfully pointing to a config server, navigate to ``localhost:8080/actuator/env/properties``. Find the the "configService" key in the json. If the value points to the correct git repository uri, you're on the right track.

### Part 3.0 Mapping Config Properties to POJOs

* Navigate to the configuration properties git uri and click on ``bakery-service.configuration``. Observe the naming convention of the listed properties. 

* Navigate back to your bakery-service application in IntelliJ and annotate the main application class with ``@EnableConfigurationProperties``

* Navigate to the ``Bakery`` class in the Models folder. Bind the ``owner``, ``name``, and ``description`` fields to ``configuration.bakery.owner``, ``configuration.bakery.name``, and ``configuration.bakery.description``, respectively, using ``@ConfigurationProperties``. Do not use ``@Value``.

* Navigate to the ``BakeryController`` class in Controllers. Notice that there is a ``/bakery`` endpoint that exposes our bakery bean. Visit that endpoint and verify that the owner, name, and description fields have been bound to the appropriate properties.

### Part 3.1 Identifying our Application as a different service

* Navigate to your ``bootstrap.properties`` file. Change the name of your application from ``bakery-service`` to ``leons-bakery-service``. Navigate back to ``localhost:8080/bakery`` and observe the difference. What is happening?

* Navigate to your ``bootstrap.properties`` file. Change the name of your application from ``bakery-service`` to ``wilhems-bakery-service``. Navigate back to ``localhost:8080/bakery`` and observe the difference. What is happening?

* Navigate to your ``bootstrap.properties`` file. Change the name of your application from ``bakery-service`` to ``dominiques-bakery-service``. Navigate back to ``localhost:8080/bakery`` and observe the difference. What is happening?
