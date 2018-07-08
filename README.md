## PROJ-Hitss
> **Desenvolvedor:** Eduardo Martins - [LinkedIn
](https://www.linkedin.com/in/eduardo-martins-849534110/)

<br>
<br>
Projeto para avaliação no processo seletivo da empresa Global Hitss. <br>
A ideia do projeto implementar um serviço web REST e um cliente que possa consumir tal serviço.
<br>Considere o cenário de cadastro de produtos para uma loja virtual. A entidade produto possui as propriedades: nome, preço e quantidade
<br>
<br>
<br>
|                  
|Tecnologias Utilizadas                          |
|-------------------------------------------|-------------------------------|
|Linguagem de Programação:  |`Java`            |
|Framework MVC              |`Spring MVC`            |
|RESTful Web Services        |`Jersey`|
|Mensageria        |`ActiveMQ`|
|Manuseio do Banco de Dados |`Spring JDBC`|
|Criação de Arquivos de Log           |`Log4J`|
|Ferramenta de Automação de Compilação      |`Apache Maven`|
|Framework Front-End      |`jQuery`|
|Framework Front-End      |`BootStrap`|
|Container de Servlet/Servidor de Aplicação |`Apache TomCat`|
|Banco de Dados                             |`MySQL`|
|Desenvolvimento de componente de Interface |`BootStrap`|
|Ambiente de Desenvolvimento(IDE)           |`Eclipse`|

<br>
<br>
<br>
# Configurações Necessárias

Abaixo, um tutorial rápido de como inicializar a aplicação PROJ-Hitss em sem ambiente de desenvolvimento.


#### Dependencias do Maven

```xml 
<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.3.2.RELEASE</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>3.0.5.RELEASE</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>5.1.21</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.7</version>
		</dependency>
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-context-support</artifactId>
		    <version>4.3.2.RELEASE</version>
		</dependency>
		<dependency>
		    <groupId>org.quartz-scheduler</groupId>
		    <artifactId>quartz</artifactId>
		    <version>2.2.1</version>
		</dependency>
		<dependency>
		    <groupId>org.glassfish.jersey.containers</groupId>
		    <artifactId>jersey-container-servlet</artifactId>
		    <version>2.22.1</version>
		</dependency>	
		<dependency>
		    <groupId>org.glassfish.jersey.media</groupId>
		    <artifactId>jersey-media-moxy</artifactId>
		    <version>2.22.1</version>
		</dependency>
		<dependency>
		    <groupId>org.glassfish.jersey.core</groupId>
		    <artifactId>jersey-server</artifactId>
		    <version>2.22.1</version>
		</dependency>
		<dependency>
		    <groupId>commons-codec</groupId>
		    <artifactId>commons-codec</artifactId>
		    <version>1.10</version>
		</dependency>
	    <!-- Jersey extension module providing support for Spring 3 integration -->
	    <dependency>
	        <groupId>org.glassfish.jersey.ext</groupId>
	        <artifactId>jersey-spring3</artifactId>
	        <version>2.22.1</version>
	        <exclusions>
	            <exclusion>
	                <groupId>org.springframework</groupId>
	                <artifactId>spring-core</artifactId>
	            </exclusion>
	            <exclusion>
	                <groupId>org.springframework</groupId>
	                <artifactId>spring-web</artifactId>
	            </exclusion>
	            <exclusion>
	                <groupId>org.springframework</groupId>
	                <artifactId>spring-beans</artifactId>
	            </exclusion>
	        </exclusions>
	    </dependency>		
	    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>jstl</artifactId>
		    <version>1.2</version>
		</dependency>
		<!-- Log4j -->
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>		
		<dependency>
		  <groupId>org.apache.activemq</groupId>
		  <artifactId>activemq-all</artifactId>
		  <version>5.6.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jms -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-jms</artifactId>
		    <version>4.3.2.RELEASE</version>
		</dependency>				
	</dependencies>
```

#### Servlet Container/Servidor de Aplicação

    Apache TomCat 7.0
	
#### Message Broker

    ActiveMQ 5.15.4

#### Ambiente de Desenvolvimento(IDE)

    Eclipse JEE Oxygen
    
#### Banco de Dados

    MySQL Community Server 5.5