# Servlets Listeners e Filters

![Java](https://img.shields.io/badge/Java-6%2F7-orange?logo=openjdk) ![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-green) ![Status](https://img.shields.io/badge/status-projeto%20acad%C3%AAmico-blue)

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

Coletânea de projetos **web em Java** (Servlets, Filters, Listeners e JSP), além de exercícios de programação concorrente/distribuída e I/O.

## Funcionalidades

- Servlets: Hello, Calculadora, Fatorial, Fibonacci, Palíndromo, Cifra de César, Monty Hall, Datas, Login/Potência
- Filters: login, trim, rodapé, contador, validação
- Listeners de contexto e de sessão (alertas, contadores)
- Páginas JSP/HTML
- Pastas `Cap*`/`DSD`: exclusão mútua, leitores/escritores, sockets e serviço de nomes
- `IOPrj`: streams, cópia de arquivos e serialização
- `ENTREGA AAI`: validação de IP com Web Service

## Versão do Java

**Java SE 6 / Java SE 7**

Os `.class` presentes foram compilados para Java 6 (bytecode 50), Java 7 (bytecode 51). Os projetos web usam a API Servlet (Java EE 6, Servlet 3.0) e rodam em contêineres como o Apache Tomcat 7.

## Tecnologias

- **Linguagem:** Java (Java SE 6 / Java SE 7)
- **IDE:** Eclipse IDE
- **Interface:** Web (HTML/JSP) — Servlet API em Apache Tomcat

## Estrutura do projeto

```text
Servlets Listeners e Filters/
├── Alerta/
├── Atividade Auto Instrucional.rar
├── Calculadora/
├── Calculadora_2/
├── Cap06Prj/
├── Cap1_Prj/
├── Cap2/
├── Cap3/
├── Cap6/
├── CesarPrj/
├── Correção dos Algoritmos/
├── DSD/
├── DataPrj/
├── ENTREGA AAI/
├── ExemploJSP/
├── ExemploServlet/
├── ExponencialPrj/
├── FatorialPrj/
├── FibonacciPrj/
├── Fibonacci_FilterPrj/
├── Gerador/
├── HelloPrj/
├── IOPrj/
├── Lab04Filter/
├── Lab11Prj/
├── Lab12Prj/
├── Lab13Prj/
├── Listener/
├── MountyHallPrj/
├── P01/
├── P02/
├── PalindromoPrj/
├── PalindromoPrj_html/
├── Play Docs/
├── PotenciaServlet/
├── Prova01Prj/
├── Prova01Prj_2/
├── Prova02Prj/
├── Servers/
├── Solucao1.5/
├── Validacoes/
├── hello/
├── lab01/
├── lab02/
├── lab03/
├── lab04/
├── lab05/
├── lab06/
├── lab09/
├── lab10/
└── pratica-http/
```

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

Cada subpasta é um projeto independente. Para os projetos web (Servlets, Filters, Listeners e JSP):

1. Importe a subpasta no Eclipse como *Dynamic Web Project* (ou no NetBeans como *Web Application*).
2. Configure um servidor **Apache Tomcat 7+** (ou outro contêiner compatível com Servlet 3.0).
3. Execute com *Run on Server* e acesse `http://localhost:8080/<nome-do-projeto>/`.

Os projetos `Cap*`, `DSD`, `IOPrj` e `Solucao1.5` são aplicações Java SE comuns e podem ser executados pela classe que contém o método `main`.

## Conceitos estudados

Como este é um projeto de estudo, segue um resumo dos conceitos e tecnologias praticados no código:

### Classes e Objetos

Uma **classe** é o molde que descreve atributos (estado) e métodos (comportamento); um **objeto** é uma instância concreta criada com `new`. É a base da Programação Orientada a Objetos (POO).

Saiba mais: [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

### Tratamento de Exceções

Blocos `try/catch` capturam erros em tempo de execução sem encerrar o programa. Com `throw new ...` o código sinaliza violações de regra de negócio, que são tratadas na camada de interface com o usuário.

Saiba mais: [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

### Serialização de Objetos (arquivos `.obj`/`.dat`)

Classes que implementam `Serializable` podem ser gravadas em disco com `ObjectOutputStream` e lidas com `ObjectInputStream`, persistindo o cadastro entre execuções do programa.

Saiba mais: [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html) · [java.io.Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)

### Servlets

Classes Java que estendem `HttpServlet` e respondem a requisições HTTP (`doGet`/`doPost`) dentro de um contêiner web como o Apache Tomcat. Configuradas via `web.xml` ou anotação `@WebServlet`.

Saiba mais: [Jakarta Servlet](https://jakarta.ee/specifications/servlet/) · [Java EE 6 Tutorial – Servlets](https://docs.oracle.com/javaee/6/tutorial/doc/bnafd.html)

### Filters

Implementações de `javax.servlet.Filter` interceptam requisições e respostas antes/depois do Servlet — úteis para autenticação (login), validação, *trim* de parâmetros, rodapés e contadores.

Saiba mais: [Filtering Requests and Responses](https://docs.oracle.com/javaee/6/tutorial/doc/bnagb.html)

### Listeners

`ServletContextListener`, `HttpSessionListener` e afins reagem a eventos do ciclo de vida da aplicação web (inicialização, criação/destruição de sessões).

Saiba mais: [Handling Servlet Life-Cycle Events](https://docs.oracle.com/javaee/6/tutorial/doc/bnafi.html)

### JSP (JavaServer Pages)

Páginas HTML com trechos Java/EL processadas no servidor, usadas para gerar a camada de apresentação das aplicações web.

Saiba mais: [JavaServer Pages](https://jakarta.ee/specifications/pages/)

### Programação Concorrente e Distribuída

Algoritmos de exclusão mútua (Peterson, Test-and-Set), problemas clássicos de sincronização (leitores/escritores, canibais), comunicação via *sockets*/datagramas e serviço de nomes.

Saiba mais: [Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) · [Custom Networking](https://docs.oracle.com/javase/tutorial/networking/index.html)

### Cifra de César

Técnica clássica de criptografia por substituição em que cada letra é deslocada um número fixo de posições no alfabeto; descriptografar é aplicar o deslocamento inverso.

Saiba mais: [Cifra de César (Wikipédia)](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar)

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
- [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html)
- [java.io.Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)
- [Jakarta Servlet](https://jakarta.ee/specifications/servlet/)
- [Java EE 6 Tutorial – Servlets](https://docs.oracle.com/javaee/6/tutorial/doc/bnafd.html)
- [Filtering Requests and Responses](https://docs.oracle.com/javaee/6/tutorial/doc/bnagb.html)
- [Handling Servlet Life-Cycle Events](https://docs.oracle.com/javaee/6/tutorial/doc/bnafi.html)
- [JavaServer Pages](https://jakarta.ee/specifications/pages/)
- [Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
- [Custom Networking](https://docs.oracle.com/javase/tutorial/networking/index.html)
- [Cifra de César (Wikipédia)](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
