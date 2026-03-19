# cp1-funcionarios

Projeto desenvolvido em Java para a disciplina de Java Advanced, com o objetivo de representar diferentes perfis de funcionários, gerar SQL automaticamente via Reflection e realizar operações de CRUD utilizando JPA/Hibernate com banco de dados Oracle.

## Integrantes

Gustavo Crevelari - RM561408
Lucca Gomes - RM561996
Rafaela Santos - RM561671

## Descrição do projeto

O sistema possui:

- Classe `Funcionario` com:
  - nome
  - horas trabalhadas
  - valor por hora
  - cálculo de salário
  - impressão de informações detalhadas

- Subclasse `FuncionarioSenior`, que:
  - herda de `Funcionario`
  - recebe bônus a cada 15 horas trabalhadas
  - sobrescreve os métodos de cálculo e impressão

- Subclasse `FuncionarioComissionado`, que:
  - herda de `Funcionario`
  - recebe comissão
  - sobrescreve os métodos de cálculo e impressão

## Anotações personalizadas

O projeto utiliza as anotações:

- `@Descricao`
- `@Coluna`

Essas anotações são usadas junto com Reflection para gerar automaticamente comandos SQL com base na estrutura da classe.

## Funcionalidades

- Cálculo de salário de funcionários
- Exibição de informações detalhadas
- Geração automática de SQL via Reflection
- Integração com Oracle usando JPA/Hibernate
- Operações de CRUD:
  - Create
  - Read
  - Update
  - Delete

## Tecnologias utilizadas

- Java 21
- Maven
- Hibernate / JPA
- Oracle Database
- Oracle SQL Developer
- IntelliJ IDEA

## Estrutura principal

- `anotacoes` -> anotações personalizadas
- `modelo` -> classes de funcionários
- `reflection` -> geração de SQL via Reflection
- `persistencia` -> configuração de persistência e acesso ao banco
- `app` -> classe principal para testes

## Objetivo acadêmico

Este projeto foi desenvolvido para demonstrar os conceitos de:

- orientação a objetos
- herança
- sobrescrita de métodos
- anotações customizadas
- Reflection
- persistência com JPA/Hibernate
- integração com banco Oracle
