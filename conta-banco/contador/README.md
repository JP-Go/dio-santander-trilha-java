# Desafio controle de fluxo

Resposta ao desafio controle de fluxo do curso Santander Java Backend da DIO.

## Estrutura

O projeto é composto de apenas 3 arquivos principais, duas classes java no
diretório `src` e um script bash executável na raiz do projeto

```sh
. # <raiz>
├── bin # classes geradas pelo compilador (não mantidas no repositório)
│   ├── Contador.class
│   └── ParametrosInvalidosException.class
├── compile-and-run.sh # executável para rodar o projeto
├── README.md # você está aqui
└── src # código-fonte da aplicação
    ├── Contador.java
    └── ParametrosInvalidosException.java
```

## Instruções de uso

O script executável é o instrumento o qual você deve utilizar para rodar o projeto
você pode fornecer os parâmetros diretamente ao script, desta forma:

```sh
./compile-and-run.sh <parametro_1> <parametro_2>
```

ou pode executar o script sem parâmetros

```sh
./compile-and-run.sh
```

executar com 1 parâmetro também é possível, mas o script irá ignorar o parâmetro
passado. Por exemplo

```sh
./compile-and-run.sh 12
Digite o primeiro parâmetro
```

Irá pedir o primero parâmetro, mesmo que você já o tenha passado.
