# JTable

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

Projeto **NetBeans** de exemplo de uso do componente **`JTable`** para exibir um cadastro em tabela (classes `TesteJTable` e `Cadastro`). O repositório contém o build compilado e o formulário `.form`.

## Funcionalidades

- Tela com `JTable` e botões de ação
- Formulário desenhado no GUI Builder do NetBeans

## Versão do Java

**Java SE 6**

O código foi escrito em 2011 com o **Java SE 6** (JDK 1.6), versão padrão da época, usando recursos do Java 5+ como *generics*, *for-each* e `@Override`. Os arquivos `.class` presentes no repositório estão compilados para Java 5 (bytecode 49), Java 8 (bytecode 52), pois foram recompilados posteriormente. O código é compatível com JDKs atuais (8, 11, 17, 21).

## Tecnologias

- **Linguagem:** Java (Java SE 6)
- **IDE:** NetBeans IDE (projeto Ant)
- **Interface gráfica:** Swing (`javax.swing`) e AWT

## Estrutura do projeto

```text
JTable/
├── build.xml
└── manifest.mf
```

> A pasta `bin/` contém os arquivos `.class` compilados e foi omitida da árvore acima.

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

O repositório contém as classes compiladas do projeto NetBeans:

```bash
cd "PROJETOS/JTable"
java -cp bin teste.TesteJTable
```

## Conceitos estudados

Como este é um projeto de estudo, segue um resumo dos conceitos e tecnologias praticados no código:

### Classes e Objetos

Uma **classe** é o molde que descreve atributos (estado) e métodos (comportamento); um **objeto** é uma instância concreta criada com `new`. É a base da Programação Orientada a Objetos (POO).

Saiba mais: [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

### Interface Gráfica com Swing

Construção de janelas com `JFrame`, `JPanel`, `JButton`, `JTextField`, `JLabel` e gerenciadores de layout. Swing é o toolkit gráfico padrão do Java SE.

Saiba mais: [Creating a GUI With Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html) · [Laying Out Components](https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html)

### Tratamento de Eventos

Interfaces *listener* (`ActionListener`, `MouseListener`, `WindowListener`...) recebem notificações de cliques, movimentos do mouse e ações na janela, ligando a interface gráfica à lógica do programa.

Saiba mais: [Writing Event Listeners](https://docs.oracle.com/javase/tutorial/uiswing/events/index.html)

### Tabelas com `JTable`

Componente Swing que exibe dados em linhas e colunas, normalmente alimentado por um `TableModel` (ex.: `DefaultTableModel`).

Saiba mais: [How to Use Tables](https://docs.oracle.com/javase/tutorial/uiswing/components/table.html)

### Projeto NetBeans / Ant (GUI Builder)

Projeto criado no NetBeans IDE, com build via Apache Ant (`build.xml`, `nbproject/`) e telas desenhadas no editor visual (arquivos `.form`).

Saiba mais: [Apache NetBeans](https://netbeans.apache.org/) · [Apache Ant](https://ant.apache.org/)

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
- [Creating a GUI With Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html)
- [Laying Out Components](https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html)
- [Writing Event Listeners](https://docs.oracle.com/javase/tutorial/uiswing/events/index.html)
- [How to Use Tables](https://docs.oracle.com/javase/tutorial/uiswing/components/table.html)
- [Apache NetBeans](https://netbeans.apache.org/)
- [Apache Ant](https://ant.apache.org/)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
