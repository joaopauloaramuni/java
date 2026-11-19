# Exemplo Classe Scanner

![Java](https://img.shields.io/badge/Java-6-orange?logo=openjdk) ![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-green) ![Status](https://img.shields.io/badge/status-projeto%20acad%C3%AAmico-blue)

> **Universidade FUMEC** — Curso de Ciência da Computação  
> **Disciplinas:** Linguagem e Técnica de Programação III e IV (LTP III e LTP IV)  
> **Período:** 1º e 2º semestres de 2011  
> **Professor:** Prof. Erix Morato — ajudou a fundar o curso de Ciência da Computação da FUMEC, onde lecionou por 41 anos  
> **Aluno:** [João Paulo Aramuni](https://github.com/joaopauloaramuni)

Projeto desenvolvido durante a graduação como exercício prático das disciplinas de LTP, com foco em Programação Orientada a Objetos em Java.

## Sumário

- [Sobre o projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Versão do Java](#versão-do-java)
- [Tecnologias](#tecnologias)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Como executar](#como-executar)
- [Conceitos estudados](#conceitos-estudados)
- [Documentação e links úteis](#documentação-e-links-úteis)
- [Licença](#licença)

## Sobre o projeto

Exemplo mínimo de **leitura de dados do teclado** com `java.util.Scanner`.

## Funcionalidades

- Leitura de valores digitados pelo usuário
- Exibição dos valores lidos

## Versão do Java

**Java SE 6**

O código foi escrito em 2011 com o **Java SE 6** (JDK 1.6), versão padrão da época, usando recursos do Java 5+ como *generics*, *for-each* e `@Override`. Os arquivos `.class` presentes no repositório estão compilados para Java 8 (bytecode 52), pois foram recompilados posteriormente. O código é compatível com JDKs atuais (8, 11, 17, 21).

## Tecnologias

- **Linguagem:** Java (Java SE 6)
- **IDE:** Eclipse IDE
- **Interface:** Console (modo texto)

## Estrutura do projeto

```text
Exemplo Classe Scanner/
└── src/
    └── teste/
        └── Leitura.java
```

> A pasta `bin/` contém os arquivos `.class` compilados e foi omitida da árvore acima.

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

**Pelo Eclipse:** *File → Import → General → Existing Projects into Workspace* (ou crie um projeto Java apontando para esta pasta), depois execute a classe principal com *Run As → Java Application*.

**Pela linha de comando** (a partir da raiz do repositório):

```bash
cd "PROJETOS/Exemplo Classe Scanner"
mkdir -p bin
javac -encoding ISO-8859-1 -d bin $(find src -name "*.java")
java -cp "bin" teste.Leitura
```

> Os fontes estão codificados em **ISO-8859-1 (Latin-1)**, padrão do Eclipse no Windows em 2011 — por isso o parâmetro `-encoding` no `javac`.

## Conceitos estudados

Como este é um projeto de estudo, segue um resumo dos conceitos e tecnologias praticados no código:

### Classes e Objetos

Uma **classe** é o molde que descreve atributos (estado) e métodos (comportamento); um **objeto** é uma instância concreta criada com `new`. É a base da Programação Orientada a Objetos (POO).

Saiba mais: [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

### Entrada de Dados com `Scanner`

`java.util.Scanner` lê dados digitados no teclado (`System.in`) ou de arquivos, convertendo-os para `int`, `double`, `String` etc.

Saiba mais: [Scanning](https://docs.oracle.com/javase/tutorial/essential/io/scanning.html)

## Documentação e links úteis

- [Java SE 6 – Documentação da API](https://docs.oracle.com/javase/6/docs/api/)
- [Java SE 8 – Documentação da API](https://docs.oracle.com/javase/8/docs/api/)
- [The Java Tutorials (Oracle)](https://docs.oracle.com/javase/tutorial/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)
- [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/)
- [Apache NetBeans](https://netbeans.apache.org/)
- [OpenJDK / Adoptium (JDK gratuito)](https://adoptium.net/)
- [Universidade FUMEC](https://www.fumec.br/)
- [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)
- [Scanning](https://docs.oracle.com/javase/tutorial/essential/io/scanning.html)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
