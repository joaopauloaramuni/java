# Utilitarios

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

Código-fonte das **bibliotecas utilitárias** usadas na disciplina: `Console.java` (leitura de teclado) e `POOLib.java` (classe `LtpLib`), além do `POOLib.jar`.

## Funcionalidades

- Leitura de `int`, `double` e `String` pelo console
- Validação de datas, horas, CPF, CNPJ, PIS e e-mail
- Formatação de valores, datas, CPF/CNPJ e valor por extenso
- Leitura/gravação de listas de objetos em arquivo

## Versão do Java

**Java SE 6**

O código foi escrito em 2011 com o **Java SE 6** (JDK 1.6), versão padrão da época, usando recursos do Java 5+ como *generics*, *for-each* e `@Override`. O código é compatível com JDKs atuais (8, 11, 17, 21).

## Tecnologias

- **Linguagem:** Java (Java SE 6)
- **IDE:** Eclipse IDE
- **Interface:** Console (modo texto)
- **Persistência:** arquivos de objetos serializados (`java.io`)
- **Bibliotecas da disciplina:** `Console` e `LtpLib` (pacote `utilitarios`)

## Estrutura do projeto

```text
Utilitarios/
├── Console.java
├── POOLib.jar
└── POOLib.java
```

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

Esta pasta contém bibliotecas, sem programa principal. Para usá-las em outro projeto, copie `Console.java` e `POOLib.java` para o pacote `utilitarios` do seu `src/`, ou adicione `POOLib.jar` ao *classpath*:

```bash
javac -encoding ISO-8859-1 -d bin Console.java POOLib.java
jar cf POOLib.jar -C bin .
```

## Conceitos estudados

Como este é um projeto de estudo, segue um resumo dos conceitos e tecnologias praticados no código:

### Classes e Objetos

Uma **classe** é o molde que descreve atributos (estado) e métodos (comportamento); um **objeto** é uma instância concreta criada com `new`. É a base da Programação Orientada a Objetos (POO).

Saiba mais: [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

### Construtores e Sobrecarga

O **construtor** inicializa o objeto no momento do `new`. Uma classe pode ter vários construtores (ou métodos) com o mesmo nome e parâmetros diferentes — isso é **sobrecarga** (*overloading*).

Saiba mais: [Providing Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html) · [Defining Methods (overloading)](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)

### Membros `static`

Atributos e métodos `static` pertencem à classe, e não a cada objeto. São usados para contadores de código (ex.: último código gerado), listas compartilhadas e métodos utilitários.

Saiba mais: [Understanding Class Members](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)

### Tratamento de Exceções

Blocos `try/catch` capturam erros em tempo de execução sem encerrar o programa. Com `throw new ...` o código sinaliza violações de regra de negócio, que são tratadas na camada de interface com o usuário.

Saiba mais: [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

### Coleção `Vector`

`Vector` é uma lista dinâmica (cresce conforme necessário) e sincronizada, muito usada nos materiais da época. Hoje, em código novo, costuma-se preferir `ArrayList`.

Saiba mais: [java.util.Vector](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html) · [Collections Framework](https://docs.oracle.com/javase/tutorial/collections/index.html)

### Coleção `ArrayList`

Lista dinâmica baseada em array, que permite incluir, remover e percorrer objetos sem se preocupar com o tamanho. É a implementação de `List` mais usada em Java.

Saiba mais: [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) · [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)

### Manipulação de Strings

Métodos da classe `String` como `substring()`, `split()`, `toUpperCase()`, `trim()` e `indexOf()` para percorrer, separar em palavras e padronizar textos.

Saiba mais: [Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html) · [java.lang.String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

### Datas com `GregorianCalendar` e `SimpleDateFormat`

`GregorianCalendar` manipula datas (somar dias, descobrir dia da semana, diferença entre datas) e `SimpleDateFormat` formata/converte datas em texto (ex.: `dd/MM/yyyy`). Em Java 8+ existe a API moderna `java.time`.

Saiba mais: [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html) · [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html) · [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)

### Serialização de Objetos (arquivos `.obj`/`.dat`)

Classes que implementam `Serializable` podem ser gravadas em disco com `ObjectOutputStream` e lidas com `ObjectInputStream`, persistindo o cadastro entre execuções do programa.

Saiba mais: [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html) · [java.io.Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)

### Bibliotecas da Disciplina (`Console` e `LtpLib`)

Classes utilitárias fornecidas pelo professor: `Console` simplifica a leitura do teclado (`readInt`, `readDouble`, `readLine`) e `LtpLib` oferece validação de CPF/CNPJ/PIS/e-mail/datas, formatação de valores, valor por extenso e gravação/leitura de arquivos de objetos.

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
- [Providing Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Defining Methods (overloading)](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Understanding Class Members](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
- [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [java.util.Vector](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)
- [Collections Framework](https://docs.oracle.com/javase/tutorial/collections/index.html)
- [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
- [java.lang.String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
- [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html)
- [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html)
- [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)
- [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html)
- [java.io.Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
