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

## Partie II: Création d'un service de configuration (service-config)
Ce service permet de centraliser la configuration et la gestion de 
tous nos services(api) du microservice. 
Et pour que ça fonctionne, nous devons créer un répository git qui sera lié au service de configuration par:
1. si le répository git se trouve en local:
	<code>spring.cloud.config.server.git.uri=file://${home.user</code>,
2. si le répository git se trouve en ligne:
	<code>spring.cloud.config.server.git.uri=url</code>, 
ensuite on crée un fichier properties pour chaque service et en plus ces fichiers doivent avoir même nom que le service,
c'est dans ces fichier que nous ferons toutes les configurations des services correspondants
on peut vérifier son fonctionnement à travers cet **URI** avec la méthode **GET** <code>http://localhost:8085/application/master</code>
notre cas présent, nous avons crée un répository <code>cloud-config</code>: (cette ligne pour indiqué l'emplacement du fichier seulement)

### Configuration réquise:
<code>sercvice-config/src/main/resources/application.properties</code>: (cette ligne pour indiqué l'emplacement du fichier seulement)<br>
<pre>
	<code>
		server.port=8085
		spring.cloud.config.server.git.uri=https://github.com/camara94/cloud-config.git
		#file://${user.home}/microservice-spring/cloud-config
	</code>
</pre>

### Dépendances maven
* spring-cloud-config-server

