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

A URL base dos serviços está em http://localhost



#####################################################################################################################################################################
## LAUNCHERS ########################################################################################################################################################
#####################################################################################################################################################################

############ Database ############
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

############ Services ############
docker run 
 
 
 
#####################################################################################################################################################################
## DB SCHEMA ########################################################################################################################################################
#####################################################################################################################################################################
| assistido |
| id |[PK bigint(20)] |
| client_id | [bigint(20)] |
|filme_id | [bigint(20)] |
 
| chamado |
| id | [PK binary(16)] |
| client_id | [bigint(20)] |
| data_abertura | [datetime()] |
| data_fechamento | [datetime()] |
| descricao | [text] |
| motivo | [varchar(255)] |
 
cliente
    id               [PK bigint(20)]
    cpf              [varchar(255)]
    idade            [int(11)]
    nome             [varchar(255)]
 
favorito
    id               [PK bigint(20)]
    client_id        [bigint(20)]
    filme_id         [bigint(20)]
 
filme
    id               [PK bigint(20)]
    ano_lancamento   [int(11)]
    genero           [varchar(255)]  
    lingua           [varchar(255)]  
    tipo             [varchar(255)]  
    titulo           [varchar(255)]  
    detalhe          [text]  
    assistido        [int(11)]
    likes            [int(11)]
 
gostei
    id               [PK bigint(20)]
    client_id        [bigint(20)]
    filme_id         [bigint(20)]
 
#####################################################################################################################################################################
## JAVA SCHEMA ######################################################################################################################################################
#####################################################################################################################################################################
 
Filme {
    anoLancamento           integer($int32)
    assistido              integer($int32)
    detalhe                    string
    genero                     string
    id                    integer($int64)
    likes           integer($int32)
    lingua                        string
    tipo            string
    titulo         string
}
 
 
Chamado{
    cliente              integer($int64)
    dataAbertura string($date-time)
    dataFechamento         string($date-time)
    descricao             string
    id                    string($uuid)
    motivo                     string
}
 
Cliente {
    cpf                 string
    id                    integer($int64)
    idade         integer($int32)
    nome         string
}
 
 
 
 
#####################################################################################################################################################################
## RESOURCES ########################################################################################################################################################
#####################################################################################################################################################################
 
 
#########################################################################
## Marca um filme para ser visto no futuro ##############################
#########################################################################
POST /v1/favoritos
{
  "clienteId": 0,
  "filmeId": 0,
  "id": 0
}
 
#########################################################################
## Abre um chamado  #####################################################
#########################################################################
POST /v1/chamados
{
  "cliente": 0,
  "dataAbertura": "2019-10-29T11:07:20.200Z",
  "dataFechamento": "2019-10-29T11:07:20.200Z",
  "descricao": "string",
  "id": "string",
  "motivo": "string"
}
 
#########################################################################
## Busca um cahamado ####################################################
#########################################################################
GET /v1/chamados/{id}
 
 
#########################################################################
## Fecha um chamado  ####################################################
#########################################################################
POST /v1/chamados
{
  "cliente": 0,
  "dataAbertura": "2019-10-29T11:07:20.200Z",
  "dataFechamento": "2019-10-29T11:07:20.200Z",
  "descricao": "string",
  "id": "string",
  "motivo": "string"
}
 
 
#########################################################################
## Likes  ###############################################################
#########################################################################
POST /v1/likes
{
  "clienteId": 0,
  "filmeId": 0,
  "id": 0
}
 
 
#########################################################################
## Filmes assistidos  ###################################################
#########################################################################
POST /v1/assistidos
 
 
 
