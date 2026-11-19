# WebCrawler

![Java](https://img.shields.io/badge/Java-8-orange?logo=openjdk) ![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-green) ![Status](https://img.shields.io/badge/status-projeto%20acad%C3%AAmico-blue)

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

**Robô de busca (web crawler)** simples que navega por páginas a partir de uma URL inicial procurando uma palavra, usando a biblioteca **jsoup**.

## Funcionalidades

- `Spider`: controla páginas visitadas e a fila de páginas a visitar
- `SpiderLeg`: baixa a página, extrai links e procura a palavra
- Limite de páginas visitadas

## Versão do Java

**Java SE 8**

A biblioteca jsoup 1.12.1 exige Java 7 ou superior; os `.class` em `bin/` estão compilados para Java 8 (bytecode 52).

## Tecnologias

- **Linguagem:** Java (Java SE 8)
- **IDE:** Eclipse IDE
- **Interface:** Console (modo texto)
- **Dependências (`lib/`):** `java-json.jar`, `jsoup-1.12.1.jar`

## Estrutura do projeto

```text
WebCrawler/
├── lib/
└── src/
    └── robot/
        ├── Main.java
        ├── Spider.java
        └── SpiderLeg.java
```

> A pasta `bin/` contém os arquivos `.class` compilados e foi omitida da árvore acima.

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

**Pelo Eclipse:** *File → Import → General → Existing Projects into Workspace* (ou crie um projeto Java apontando para esta pasta), depois execute a classe principal com *Run As → Java Application*.

**Pela linha de comando** (a partir da raiz do repositório):

```bash
cd "PROJETOS/WebCrawler"
mkdir -p bin
javac -encoding ISO-8859-1 -cp "lib/*" -d bin $(find src -name "*.java")
java -cp "bin:lib/*" robot.Main
```

> Os fontes estão codificados em **ISO-8859-1 (Latin-1)**, padrão do Eclipse no Windows em 2011 — por isso o parâmetro `-encoding` no `javac`.

## Conceitos estudados

Como este é um projeto de estudo, segue um resumo dos conceitos e tecnologias praticados no código:

### Classes e Objetos

Uma **classe** é o molde que descreve atributos (estado) e métodos (comportamento); um **objeto** é uma instância concreta criada com `new`. É a base da Programação Orientada a Objetos (POO).

Saiba mais: [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

### Encapsulamento (getters e setters)

Os atributos são declarados `private` e acessados apenas por métodos públicos `getX()`/`setX()`. Isso protege o estado interno do objeto e permite validar dados antes de alterá-los.

Saiba mais: [Controlling Access to Members](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

### Tratamento de Exceções

Blocos `try/catch` capturam erros em tempo de execução sem encerrar o programa. Com `throw new ...` o código sinaliza violações de regra de negócio, que são tratadas na camada de interface com o usuário.

Saiba mais: [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

### Coleção `ArrayList`

Lista dinâmica baseada em array, que permite incluir, remover e percorrer objetos sem se preocupar com o tamanho. É a implementação de `List` mais usada em Java.

Saiba mais: [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) · [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)

### Generics

Tipos parametrizados como `Vector<Cliente>` ou `ArrayList<Livro>` garantem, em tempo de compilação, que a coleção só aceite objetos do tipo indicado, dispensando *casts*.

Saiba mais: [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

### Web Crawling com jsoup

jsoup conecta a uma URL, faz o *parse* do HTML e permite selecionar elementos com seletores CSS (ex.: `a[href]`), base de um robô que navega de página em página.

Saiba mais: [jsoup](https://jsoup.org/) · [jsoup Cookbook](https://jsoup.org/cookbook/)

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
- [Controlling Access to Members](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [jsoup](https://jsoup.org/)
- [jsoup Cookbook](https://jsoup.org/cookbook/)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
