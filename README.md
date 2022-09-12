<h1>FIAP - Ambiente de Alta Disponibilidade - Monitoramento de Informações de Drones - FIAP</h1> 

<p align="center">
  <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

<div align="center">
<a href="https://www.fiap.com.br" target="_blank">
    <img src="https://www.fiap.com.br/wp-content/themes/fiap2016/images/mobile/mba/vitrine/mba-logo.png" height="100px" alt="FIAP" class="center"/>
</a>

![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
</div>

> Status do Projeto: :heavy_check_mark: :warning: (concluido, com possíbilidade de um versão com autenticação, e front-end simplificado)

### Tópicos

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Funcionalidades](#funcionalidades)

:small_blue_diamond: [Deploy da Aplicação](#deploy-da-aplicação-dash)

:small_blue_diamond: [Pré-requisitos](#pré-requisitos)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)

## Descrição do projeto

Este sistema compôem 3 modulos de um Projeto de Monitoramento de Drones:

- **drone-monitor-job** -> Responsável por enviar de forma simulada 4 drones com informações aleatórias do temperatura e de umidade
- **drone-monitor-producer** -> Responsável por receber dados do drone através do end-point (localhost:8082/api/v1/drones-monitor/drones/register/), validar suas rastreabilidade, e envia para o tópico do Kafka.
- **drone-monitor-consumer** -> Responsável por consumir as mensagens do tópico do kafka e trata-las a sua deserialização e validar as informações do drone, estando dentro das regras de alerta, será enviado um e-mail

## Funcionalidades

#### :heavy_check_mark: **Monitoramento de Informações enviadas de Drones**
- ##### Monitoramento de Informações enviadas de Drones

  - ###### Seleção de drones para recuperar informações
  - ###### Postagema automatizada de informações do drone no end-point do produtor kafka
  - ###### Validar rastreabilidade do drone e serialização dos dados
  - ###### Postar no tópico do kafka
  - ###### Consumir do tópico do kafka
  - ###### Deserializar as informações do drone
  - ###### Validar a regra para envio do alerta
  - ###### Enviar e-mail quando igual ou superior a regra parametrizada

## Tecnologias

- [Docker](https://www.docker.com/products/docker-desktop)
- [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.htm)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Docker Swarm](https://docs.docker.com/engine/swarm/)
- [Kafka](https://kafka.apache.org/)
- [Kafka Web UI](https://cloudhut.dev)
- [Lombok](https://projectlombok.org/)
- [Gradle](https://gradle.org/)
- [Spring](https://spring.io/)
- [Spring Kafka](https://spring.io/projects/spring-kafka)
- [Spring RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
- [Spring Freemarker](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/ch16s04.html)



## Vídeo-1 Apresentação da Aplicação :dash:

> Link em vídeo da aplicação rodando. https://www.loom.com/share/2cbb9686bbc442de93fa1f238a52d546

## Vídeo-2 Apresentação da Aplicação :dash:

> Link em vídeo-2 da aplicação rodando.  https://www.loom.com/share/1605329bd5e54e60915623a4a59367d5

## Vídeo-3 Apresentação da Aplicação em ambiente de Alta Disponibilidade (AWS/DOCKER SWARM - Passo a Passo):dash:

> Link em vídeo-3 da aplicação rodando. https://www.loom.com/share/ff40bceee57842539dc14fb4f9822de9

> Roteiro execução 
  > [https://github.com/ricardosoareslacerda/broker-drone-cluster-monitor/blob/master/passo-a-passo-aws-cloud9-exec-proj..txt]
  
- Print execução drones 
> [https://github.com/ricardosoareslacerda/broker-drone-cluster-monitor/blob/master/requisitos/img.png]

## Vídeo-4 Demonstração da Aplicação em ambiente de Alta Disponibilidade (AWS/DOCKER SWARM):dash:

> Link em vídeo-4 da aplicação rodando. https://www.loom.com/share/edc26089fa384a639288b60a841d66de
- Última Atualização

## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto:

```
git clone [git clone https://github.com/ricardosoareslacerda/broker-drone-cluster-monitor.git](https://github.com/ricardosoareslacerda/broker-drone-cluster-monitor.git)
```

- [Instalar o Docker](https://www.docker.com/products/docker-desktop)
- Baixar o projeto do git [git clone https://github.com/ricardosoareslacerda/broker-drone-cluster-monitor.git]
- Editar as variáveis de ambiente para ajuste das configurações de envio de e-mail
  - Para receber o envio de alerta, das informações do drone, será necessário configurar o e-mail nas variáveis de ambiente no docker-compose.
  ```  projeto -> drone-monitor-consumer
      - CONFIG_GMAIL_USERNAME: {e-mail a ser usado para configurar o envio de e-mail}
      - CONFIG_GMAIL_APP_PASSWORD: {senha de aplicativos configurada na conta do gmail.com}
      - MAIL_ADDRESS_FROM: {e-mail usado para envio} -> ****@gmail.com
      - MAIL_ADDRESS_TO: {e-mail usado para recebimento} -> ****@gmail.com
- Executar o Docker Compose:
  - docker-compose up (na raiz do projeto)
  - aguardar a instalação do server (Zookeeper/Kafka)
  
- API - Swagger - Kafka Drone Producer
    - http://localhost:8082/api/v1/drones-monitor/swagger-ui/
    
- Kowl - Kafka WebUI
    - http://localhost:8080
    
- Mongo Express - Mongo WebUI
    http://localhost:8081
    - user: root
    - password: MongoExpress2022!
    
## Desenvolvedores/Contribuintes :octocat:

Liste o time responsável pelo desenvolvimento do projeto
[<br><sub>Ricardo Lacerda</sub>](https://github.com/ricardosoareslacerda) | [<br><sub>Marcos Porto</sub>](https://github.com/maporto) |  [<br><sub>Gabriel Batalha</sub>]() |

## Licença

The [Apacha 2]() (MIT)

Copyright :copyright: Ano - Titulo do Projeto
