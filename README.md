# TaskManagerAPI - Backend

Bem-vindo ao TaskManagerAPI, a API backend para a aplicação de gerenciamento de tarefas.

## Configuração do Ambiente

Certifique-se de ter o JDK e o Maven instalados.

1. Clone o repositório.
2. Navegue até o diretório `TaskManagerAPI`.
3. Execute o comando `mvn spring-boot:run`.

A API estará disponível em [http://localhost:8080](http://localhost:8080).

## Documentação da API

A documentação da API pode ser acessada em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Configuração do Banco de Dados

A aplicação usa um banco de dados H2 incorporado por padrão. Para configurar um banco de dados diferente, ajuste as configurações no arquivo `application.properties`.

## Autenticação

A API utiliza autenticação baseada em tokens JWT. Consulte a documentação para obter detalhes sobre como obter e utilizar tokens de acesso.

## Testes Unitários

Execute `mvn test` para executar os testes unitários.

## Contribuição

Contribuições são bem-vindas! Antes de começar, por favor, abra uma issue para discutir as alterações propostas.

## Licença

Este projeto é
