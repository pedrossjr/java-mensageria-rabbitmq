## 📦 Sistema de pedidos com uso de mensageria

### Descrição do projeto

Neste projeto, apresento um sistema simples de pedidos com uma
arquitetura monolita, utilizando uma API REST desenvolvida em Java com
Spring Boot para demonstrar o uso de mensageria com RabbitMQ.

### 🔧 Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring AMQP
- Maven
- Swagger
- PostgreSQL
- PgAdmin4
- Insomnia
- Docker

### ⚙️ Ferramentas utilizadas

- IntelliJ IDEA (Community Edition)
- Git
- GitHub
- Docker Desktop
- [MailHog](https://github.com/mailhog/MailHog)
- [RabbitMQ Simulator](https://tryrabbitmq.com/)
- RabbitMQ

### 🚀 Objetivo

- Demonstrar conceitos práticos de mensageria.
- Implementar comunicação assíncrona entre serviços.
- Simular cenários reais de sistemas distribuídos com desacoplamento.

### 🧩 Arquitetura monolita dividida em três principais serviços:

#### 1. Serviço de Pedidos (Order Service)

- Responsável por receber os pedidos via API REST e enviá-los de
  forma assíncrona para a fila do RabbitMQ.

#### 2. Serviço de notificação

- Responsável pelo serviço de envio de notificação ao cliente sobre o
  pedido de compra.

#### 3. Serviço de Processamento (Consumer Service)

- Responsável por escutar a fila do RabbitMQ e processar os pedidos
- recebidos, simulando ações como envio de confirmação,
- persistência ou envio de e-mails.

### 🔄 Comunicação Assíncrona com RabbitMQ

A utilização do RabbitMQ permite a desacoplagem entre os serviços,
além de garantir maior resiliência e escalabilidade no fluxo de dados.
Ao invés de um serviço chamar diretamente o outro, os dados são
trafegados via fila, permitindo que cada parte evolua de forma
independente.

### 🛠️ Configurando o projeto?

#### 1. Pré-requisitos

- Java 17+
- IDE de sua preferência
- Maven instalado
- Insomnia para testes dos endpoints
- Docker Desktop para uso do RabbitMQ, MailHog, PostgreSQL e PgAdmin4

#### 2. Clonar o repositório

```
- git clone https://github.com/pedrossjr/java-mensageria-rabbitmq.git
``` 

#### 3. Criação do container para uso do PostgreSQL e PgAdmin

```
- cd java-mensageria-rabbitmq
- docker-compose up -d
``` 

#### 4. Acesse o pgAdmin

- Abra o navegador e acesse:

> 🔗 http://localhost:5050

- Faça login com as credenciais que definiu no docker-compose:

```
Email: admin@admin.com
Senha: admin
```

#### 5. Registrar um novo servidor

- Na janela de Dashboard, clique em "Add New Server".
- Aba "General"
- Name: Pode ser qualquer nome, ex: PostgreSQL Local
- Aba "Connection"
- Host name/address: postgres
- Port: 5432
- Maintenance database: postgres (ou db_pedidos, se já tiver sido criado)
- Username: postgres
- Password: postgres
- Marque a opção "Save Password"
- Clique em Save

#### 6. Criar um novo banco de dados

- Após registrar o servidor, expanda ele na lateral esquerda.
- Clique com o botão direito em Databases → Create > Database...
- Database name: ex: db_pedidos
- Owner: postgres (ou outro usuário, se quiser)
- Clique em Save

#### 7. Executando a aplicação:

- Execute o projeto em cada serviço nesta ordem (pedido, notificação, 
processador) com sua IDE de preferência através do botão __Run__ ou na 
raiz da aplicação, digite o comando abaixo:

```
./mvnw clean spring-boot:run
``` 

### 🛠️ Testando a alicação

#### 1. Aplicação estará disponível em:

> 🔗 http://localhost:8080

#### 2. Exemplo do Endpoint

#### 📘 Pedidos

> http://localhost:8080/api/v1/pedidos

```
{
  "cliente": "João Guilherme",
  "itens": [
    {
      "quantidade": 2,
	  "produto": {
	    "nome": "Fone de ouvido",
	    "valor": 30.50
	  }
    }
  ],
  "valorTotal": 61.00,
  "emailNotificacao": "joao.guilherme@yahoo.com"
}
```

#### 3. PgAdmin estará disponível em

> 🔗 http://localhost:5050

#### 4. Documentação Swagger estará disponível em:

> 🔗 http://localhost:8080/pedido/docs/api

### 🙋‍♂️ Issues e sugestões

Fique à vontade para abrir issues e fazer sugestões ao projeto. Melhorias
sempre são bem-vindas e meu objetio é compartilhar conhecimento com a
linguagem Java!