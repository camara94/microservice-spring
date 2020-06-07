# Microservice en Spring

## Test chez vous
1. Pour télecharger le projet en local:
	<code>git clone https://github.com/camara94/microservice-spring.git</code>
2. ensuite ouvrez dans votre éditeur préferer
3. puis lancer les quatre (4) services
4. vous pouvez vérifier tous les services à travers le proxy<br>
	<code>http://localhost:8091/company-service/companies</code> ou bien
5. vous pouvez vérifier tous le service à travers cet uri<br>
	<code>http://localhost:8088/companies</code>

## Partie I: Création d'un service de company (service-company)
Ce service est accessible à travers cet endpoint par la méthode **GET** 
<code>http://localhost:8088/companies</code><br>
### Configuration réquise:
<code>sercvice-company/src/main/resources/bootstrap.properties</code>: (cette ligne pour indiqué l'emplacement du fichier seulement)<br>
<pre>
	<code>
		spring.application.name=company-service
		spring.cloud.config.uri=http://localhost:8085
		management.endpoints.web.exposure.include=*
		spring.devtools.add-properties=false
		server.port=8088
	</code>
</pre><br>

<code>cloud-config/company-service.properties</code>: (cette ligne pour indiqué l'emplacement du fichier seulement) <br>
<pre>
	<code>
		yParam=99
		ldc=ldamaro98@gmail.com
	</code>
</pre>

### Dépendances maven
* spring-boot-starter-actuator
* spring-boot-starter-data-jpa
* spring-boot-starter-data-rest
* spring-boot-starter-web
* spring-cloud-netflix-eureka-client
* spring-cloud-starter-config
* spring-cloud-starter-netflix-eureka-client
