Trabalho de conclusão de Disciplina

* Fiap 1DVP - 2019 / MICROSERVICES ARCHITECTURE / API / CONTAINERS / TADEU D’ALESSANDRO BARBOSA
* RM 334387 - Adriano Martins 
* RM 334707 - Alexandre Guilherme
* RM 334034 - Vitor Chaluppe Radi

# Solução proposta:
## Caso Netflix
Suponho que você seja contratado para desenvolver algunas funcionalidades do ecossistema do
Netflix, alguns desejos dos usuários são descritos abaixo e você deve desenhar e implementar uma
solução baseada em Microserviços.
- Possibilidade de visualizar os filmes de um determinado gênero;
- Possibilidade de visualizar os detalhes de cada filme;
- Possibilidade de votar nos filmes que mais gostei;
- Possibilidade de marcar um filme ou série para ser visto no futuro;
- Possibilidade de buscar um filme por palavra-chave;
- Possibilidade de exibir os filmes mais vistos por categorias;
- Possibilidade de abrir um chamado técnico de algum problema que está acontecendo;
- Possibilidade de visualizar os filmes e séries que já foram assistidos;

## pré-requisitos
 - Java 8
 - Maven
 - Docker
 
 ## Descrição do projeto
 Estamos usando o Java com o SpringBoot, o Zuul como gateway e Service Discovery, Mensageria e 3 microservices:
  - Filmes: cadastra e lê a base de Filmes
  - Likes  : Adiciona Likes na tabela através da MQ que por sua vez é lida pelo micro-serviço Filmes
  - Chamados: realiza criação de chamados técnicos na tabela chamados


## Inicialização do sistema
### Database
docker rm -f radiflix-mysql; docker run \
  -d \
  --name radiflix-mysql \
  -v //c//work//itau//areas//ms//work-2//radiflix//assets//db:/docker-entrypoint-initdb.d \
  -e MYSQL_USER=user \
  -e MYSQL_PASSWORD=pass \
  -e MYSQL_DATABASE=radiflix-db \
  -e MYSQL_ROOT_PASSWORD=pass \
  -p 3306:3306 \
mysql:5.7

### Services
Entrar na pasta do projeto
docker build -t radiflix .
docker run -d radiflix mvn clean package
docker run -d -p 8080:8080 -v target:/artifact radiflix-container

### Chamadas pelo Postman
A collection encontra-se na pasta assets
