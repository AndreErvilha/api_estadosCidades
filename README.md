# api_estadosCidades

Este repositório contém uma possível solução para o desafio técnico abaixo: 

O desafio consiste em criar um microservice que consulte 2 APIs externas, gerar um
CSV e um JSON e fazer o download.

 a. Deve ser usado a API para consultar os estados do Brasil:
https://servicodados.ibge.gov.br/api/v1/localidades/estados

b. Deve ser usado a API para consultar as cidades:
https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios

c. A documentação completa das APIs está no site:
https://servicodados.ibge.gov.br/api/docs/localidades

d. Os campos do CSV/JSON deverá ser:

* *idEstado*
* *siglaEstado*
* *regiaoNome*
* *nomeCidade*
* *nomeMesorregiao*
* *nomeFormatado {cidade/UF}*

# Abaixo seguem os requisitos da biblioteca a ser desenvolvida.

a. NO CSV, a primeira linha (cabeçalho) deve conter o nome de cada campo e 
*a(s) linha(s) subsequente(s) deve(m) conter os valores resultante da consulta*
*a API.*

*b. Deverá ter um endpoint que retorna um json com todos os dados.*

*c. Deverá ter um endpoint que retorna um CSV com todos os dados.*

*d. Deverá ter um endpoint que envia um parâmetro,  nomeCidade , e retorna*
*somente o ID da cidade.*

*e. Usar um cache no item (d), para que quando o nome de uma cidade for
enviado mais de uma vez, evite a chamada do serviço externo.*

*f. No endpoint do CSV deverá retornar um objeto do tipo  java.io.OutputStream*
*como saída da transformação.*

# Sobre a avaliação

* a. Os procedimentos da biblioteca devem ser logados utilizando o mecanismo de Log do Java;
* b. Nível de cumprimento dos requisitos;
* c. Abrangência dos testes unitários de 30% de cobertura;
* d. Deverá usar somente o Spring boot e suas bibliotecas;
* e. Abrangência dos testes unitários de 70% de cobertura;
* f. A estrutura da biblioteca deverá ser flexível a ponto de permitir o fácil desenvolvimento de futuros formatos de exportação, como XML;
* g. Uso adequado de padrões de projetos;
* h. Flexibilidade do código para futuras evoluções;
* i. Clean code;
* j. Utilização de princípios SOLID;
* k. Utilização de design patterns;
* l. Otimizações em relação ao uso de memória;
* m. Utilização de bibliotecas corretas do Spring Boot;
* n. Implementação de Circuit Breaker no acesso aos serviços externos;
* o. Implementação do Swagger nas API;
* p. Implementação correta do Cache.

## Considerações sobre a solução

1 - A api indicada para no enunciado do desafio apresenta algumas falhas em relação ao momento da requisição da informação, em alguns casos a conexão é realizada porém os dados não são enviados a aplicação que as requisitou, fazendo com que fosse necessário ser implementado um mecanismo de identificação de falhas e multiplas tentativas considerando o timeout da requisição como visto na classe RequestUtils e AppConfig.

2 - Como forma de evitar novas chamadas a api de localidades os dados são reunidos apenas no início da aplicação utilizando a notação @EventListener(ApplicationReadyEvent.class) na controller principal e expostos posteriormente através das urls 'json', 'csv' e cidades/{nomeCidade}
