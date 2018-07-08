## Desafio Desenvolvedor Java
> **Desenvolvedor:** Eduardo Martins - [LinkedIn
](https://www.linkedin.com/in/eduardo-martins-849534110/)

<br>
<br>
Projeto para avaliação no processo seletivo da empresa Global Hitss. <br>
A ideia do projeto implementar um serviço web REST e um cliente que possa consumir tal serviço.
<br>Considere o cenário de cadastro de produtos para uma loja virtual. 
<br>
<br>
<br>

|                  
|Tecnologias Utilizadas                          |
|-------------------------------------------|-------------------------------|
|Linguagem de Programação:  |`Java`            |
|Framework MVC              |`Spring MVC`            |
|RESTful Web Services        |`Jersey`|
|Message Broker        |`ActiveMQ`|
|Manuseio do Banco de Dados |`Spring JDBC`|
|Criação de Arquivos de Log           |`Log4J`|
|Ferramenta de Automação de Compilação      |`Apache Maven`|
|Framework Front-End      |`AngularJS`|
|Framework Front-End      |`BootStrap`|
|Container de Servlet/Servidor de Aplicação |`Apache TomCat`|
|Banco de Dados                             |`MySQL`|
|Desenvolvimento de componente de Interface |`BootStrap`|
|Ambiente de Desenvolvimento(IDE)           |`Eclipse`|


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
```sql
CREATE DATABASE projetoHitss;
use projetoHitss;

CREATE TABLE Produtos (
	id int not null auto_increment,
	nome VARCHAR(100),
    preco DECIMAL(6,2),
    quantidade int,
    data_inclusao timestamp,
    data_ultima_alteracao timestamp,
    usuario VARCHAR(20),
    status VARCHAR(1) not null,
    PRIMARY KEY (id)
);

CREATE TABLE Compras (
	id int not null auto_increment,
	nome_comprador VARCHAR(100),
    email_comprador VARCHAR(100),
    telefone bigint,
    data_compra timestamp,
    id_produto int,
    quantidade int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id)
);

SELECT * FROM Produtos;
SELECT * FROM Compras;
```	
#### Página Inicial - Tabela de Produtos no Estoque
    
    http://localhost:8080/PROJ-Hitss/

#### WebServices

    @GET
    http://localhost:8080/PROJ-Hitss/rest/produto/obterProduto  - Endpoint referente a obtenção de um determinado produto a partir do seu nome.
    
    @GET
    http://localhost:8080/PROJ-Hitss/rest/produto/obterProdutos - Endpoint referente a obtenção de todos os produtos ativos e/ou inativos cadastrados.
	
    @POST
    http://localhost:8080/PROJ-Hitss/rest/produto/incluirProduto - Endpoint referente ao cadastro de produtos no estoque.
	
    @POST
    http://localhost:8080/PROJ-Hitss/rest/produto/comprarProduto - Endpoint referente a compra de um determinado produto no estoque.

    @PUT
    http://localhost:8080/PROJ-Hitss/rest/produto/alterarProduto - Endpoint referente a alteração das informações de um produto no estoque.

    @DELETE
    http://localhost:8080/PROJ-Hitss/rest/produto/removerProduto - Endpoint referente a remoção de um produto no estoque.
	
	
#### Instalação e Configuração do ActiveMQ	
	
> **Primeiramente**, faça o download do [ActiveMQ 
](http://activemq.apache.org/activemq-5154-release.html)

	Após realizar o download do ActiveMQ compactado em um arquivo.zip, 
    extraia o arquivo no local de sua preferência.
     
    Abra o prompt de comando/terminal e navegue até o diretório onde o ActiveMQ foi instalado.
    Em seguida, navegue até a pasta **bin** e utilize o comando a seguir diretamente no prompt de comando/terminal: activemq start
	Abra o navegador de sua preferencia e acesse o a URL http://localhost:8161 com usuario: admin e senha: admin conforme a imagem a seguir.
	
![Tela inicial ActiveMQ](https://uploaddeimagens.com.br/images/001/499/797/full/MQ1.PNG?1531073748)

	
	Clique no menu **QUEUES**
     
    No menu Queue Names, digite **FL.HITSS.COMPRAR.PRODUTO** conforme a imagem a seguir.
	
![Criação de Filas ActiveMQ](https://uploaddeimagens.com.br/images/001/499/802/full/MQ2.PNG?1531074019)	
	
	
#### Configuração da Aplicação no Eclipse

    O exemplo a seguir pode ser utilizado para configurar a aplicação PROJ-Hitss em seu Eclipse/Apache Tomcat.
	Após realizar o download do projeto compactado em um arquivo.zip, 
    extraia o arquivo no local de sua preferência.
     
    Na aba Project Explorer do Eclipse, clique com o botão direto e selecione
    as opções conforme as imagens abaixo.
   
![Etapa 1](https://image.ibb.co/cHueYn/Etapa_1.png)

![Etapa 2](https://image.ibb.co/mt1F67/Etapa_2.png)

![Etapa 3](https://image.ibb.co/btnNm7/Etapa_3.png)

    Pressione Finish e o projeto será incluído na aba Project Explorer.
     
    Em seguida, será necessário atualizar as dependencias que 
    serão utilizadas na aplicação através do Maven.
    Siga os passos abaixo conforme as imagens.

![Etapa 4](https://image.ibb.co/jbWRDn/Etapa_4.png)

    Após a realização do download de todas as dependencias utilizadas,
    o projeto está pronto para ser inicializado através do Apache Tomcat.
     
    Para isso, precisamos criar um servidor conforme as imagens abaixo.
    
*Obs: Nesta etapa, é necessario realizar o download das bibliotecas do Apache Tomcat 7.0 e extrair o arquivo .zip no local de sua preferência. [Apache Tomcat 7.0 Download](https://tomcat.apache.org/download-70.cgi)

![Etapa 5](https://image.ibb.co/bwsYtn/Etapa_5.png)

![Etapa 6](https://image.ibb.co/h04PzS/Etapa_6.png)

![Etapa 8](https://image.ibb.co/eSJjzS/Etapa_7.png)

    Pressione Finish e será criado um servidor do Apache Tomcat 7.0 e o mesmo
    aparecerá na aba Servers.
     
    Agora, é necessário incluir o projeto no servidor do Tomcat mas antes 
    é preciso configurar a Server Library do projeto referenciando as
    bibliotecas do tomcat.
     
    Clique com o botão direito no projeto -> Build Path -> Configure BuildPath
    Clique em ADD e em seguida clique em Server Runtime, selecione o
    Apache Tomcat 7.0 e de OK.
     
    Agora sim podemos incluir o projeto no servidor Tomcat, 
    Para isso, clique com o botão direito no servidor Tomcat, selecione
    a opção Add and Remove. Clique na seta passando o projeto da esquerda para
    direita e clique em FINISH.

![ETAPA 8](https://image.ibb.co/f7iTR7/Etapa_8.png)
    
        Para finalizar, clique com o botão direito em cima do servidor Tomcat
        e selecione a opção START.

![Etapa 9](https://image.ibb.co/cCmMeS/Etapa_9.png)