# ProjetoBancoDeDados

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

Aplicação desktop com **SWT** e **MySQL** para cadastro de **empresas e funcionários**, usando JDBC e o padrão DAO.

## Funcionalidades

- Tela principal com menu (SWT)
- Grid de empresas com inclusão, alteração e exclusão
- Grid de funcionários por empresa
- Camadas `connection`, `dao`, `entity`, `view` e `util`

## Versão do Java

**Java SE 8**

As bibliotecas SWT/JFace incluídas em `lib/` (Eclipse Oxygen, 2017) exigem Java 8; os `.class` em `bin/` estão compilados para Java 8 (bytecode 52).

## Tecnologias

- **Linguagem:** Java (Java SE 8)
- **IDE:** Eclipse IDE
- **Interface gráfica:** SWT / JFace (Eclipse)
- **Banco de dados:** MySQL via JDBC (`mysql-connector-java-5.1.40`)
- **Dependências (`lib/`):** `com.ibm.icu_58.2.0.v20170418-1837.jar`, `mysql-connector-java-5.1.40-bin.jar`, `org.eclipse.core.commands_3.9.0.v20170530-1048.jar`, `org.eclipse.core.runtime_3.13.0.v20170207-1030.jar`, `org.eclipse.equinox.common_3.9.0.v20170207-1454.jar`, `org.eclipse.equinox.registry_3.7.0.v20170222-1344.jar`, `org.eclipse.jface_3.13.1.v20170810-0135.jar`, `org.eclipse.osgi_3.12.50.v20170928-1321.jar`, `org.eclipse.swt.win32.win32.x86_64_3.106.1.v20170926-0519.jar`, `org.eclipse.text_3.6.100.v20170203-0814.jar`, `org.eclipse.ui.forms_3.7.101.v20170815-1446.jar`, `org.eclipse.ui.workbench_3.110.1.v20170704-1208.jar`

## Estrutura do projeto

```text
ProjetoBancoDeDados/
├── lib/
└── src/
    ├── connection/
    │   ├── ConnectionConfig.java
    │   └── ConnectionManager.java
    ├── dao/
    │   ├── DAOUtil.java
    │   ├── EmpresaDAO.java
    │   └── FuncionarioDAO.java
    ├── entity/
    │   ├── Empresa.java
    │   └── Funcionario.java
    ├── util/
    │   └── DataUtil.java
    └── view/
        ├── TelaDeEmpresas.java
        ├── TelaDeFuncionarios.java
        └── TelaPrincipal.java
```

> A pasta `bin/` contém os arquivos `.class` compilados e foi omitida da árvore acima.

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

**Pelo Eclipse:** *File → Import → General → Existing Projects into Workspace* (ou crie um projeto Java apontando para esta pasta), depois execute a classe principal com *Run As → Java Application*.

**Pela linha de comando** (a partir da raiz do repositório):

```bash
cd "PROJETOS/ProjetoBancoDeDados"
mkdir -p bin
javac -encoding ISO-8859-1 -cp "lib/*" -d bin $(find src -name "*.java")
java -cp "bin:lib/*" view.TelaDeEmpresas
```

Classes com método `main` neste projeto: `view.TelaDeEmpresas`, `view.TelaDeFuncionarios`, `view.TelaPrincipal`.

> É necessário um servidor **MySQL** acessível e ajustar host, banco, usuário e senha em `connection/ConnectionManager.java`. A biblioteca SWT incluída é para **Windows 64 bits**; em outros sistemas, substitua pelo JAR SWT da sua plataforma.

> Os fontes estão codificados em **ISO-8859-1 (Latin-1)**, padrão do Eclipse no Windows em 2011 — por isso o parâmetro `-encoding` no `javac`.

## Conceitos estudados

Como este é um projeto de estudo, segue um resumo dos conceitos e tecnologias praticados no código:

### Classes e Objetos

Uma **classe** é o molde que descreve atributos (estado) e métodos (comportamento); um **objeto** é uma instância concreta criada com `new`. É a base da Programação Orientada a Objetos (POO).

Saiba mais: [Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

### Encapsulamento (getters e setters)

Os atributos são declarados `private` e acessados apenas por métodos públicos `getX()`/`setX()`. Isso protege o estado interno do objeto e permite validar dados antes de alterá-los.

Saiba mais: [Controlling Access to Members](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

### Construtores e Sobrecarga

O **construtor** inicializa o objeto no momento do `new`. Uma classe pode ter vários construtores (ou métodos) com o mesmo nome e parâmetros diferentes — isso é **sobrecarga** (*overloading*).

Saiba mais: [Providing Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html) · [Defining Methods (overloading)](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)

### Sobrescrita de Métodos (`@Override`)

A subclasse redefine um método herdado (como `toString()`, `equals()` ou um método abstrato) mantendo a mesma assinatura. A anotação `@Override` pede ao compilador que confirme que a sobrescrita é válida.

Saiba mais: [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html) · [Object.toString()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--)

### Classes Internas e Anônimas

Classes declaradas dentro de outra classe (*inner classes*) ou criadas "na hora" sem nome (*anonymous classes*), muito usadas para implementar `Comparator` e tratadores de eventos (`ActionListener`).

Saiba mais: [Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html) · [Anonymous Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html)

### Tratamento de Exceções

Blocos `try/catch` capturam erros em tempo de execução sem encerrar o programa. Com `throw new ...` o código sinaliza violações de regra de negócio, que são tratadas na camada de interface com o usuário.

Saiba mais: [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

### Coleção `ArrayList`

Lista dinâmica baseada em array, que permite incluir, remover e percorrer objetos sem se preocupar com o tamanho. É a implementação de `List` mais usada em Java.

Saiba mais: [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) · [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)

### Generics

Tipos parametrizados como `Vector<Cliente>` ou `ArrayList<Livro>` garantem, em tempo de compilação, que a coleção só aceite objetos do tipo indicado, dispensando *casts*.

Saiba mais: [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

### Datas com `GregorianCalendar` e `SimpleDateFormat`

`GregorianCalendar` manipula datas (somar dias, descobrir dia da semana, diferença entre datas) e `SimpleDateFormat` formata/converte datas em texto (ex.: `dd/MM/yyyy`). Em Java 8+ existe a API moderna `java.time`.

Saiba mais: [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html) · [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html) · [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)

### Separação em Camadas (Modelo / Cadastro / Interface)

O código é dividido em pacotes com responsabilidades distintas — classes de **dados/modelo**, classes de **cadastro/controle** (regras de negócio) e classes de **interface com o usuário** — uma aproximação do padrão MVC.

Saiba mais: [Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)

### Acesso a Banco de Dados com JDBC

JDBC é a API padrão para conectar o Java a bancos relacionais: `DriverManager` abre a `Connection`, `PreparedStatement` executa SQL parametrizado (evitando SQL Injection) e `ResultSet` percorre os resultados.

Saiba mais: [JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html) · [Using Prepared Statements](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)

### Padrão DAO (Data Access Object)

Isola o código SQL em classes próprias (`EmpresaDAO`, `FuncionarioDAO`), separando a persistência das regras de negócio e da interface.

Saiba mais: [Core J2EE Patterns – DAO](https://www.oracle.com/java/technologies/dataaccessobject.html)

### Interface Gráfica com SWT

SWT (Standard Widget Toolkit), da Eclipse Foundation, usa os componentes nativos do sistema operacional (`Shell`, `Table`, `Button`, `Menu`).

Saiba mais: [Eclipse SWT](https://www.eclipse.org/swt/)

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
- [Providing Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Defining Methods (overloading)](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
- [Object.toString()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--)
- [Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
- [Anonymous Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html)
- [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html)
- [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html)
- [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)
- [Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)
- [JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
- [Using Prepared Statements](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
- [Core J2EE Patterns – DAO](https://www.oracle.com/java/technologies/dataaccessobject.html)
- [Eclipse SWT](https://www.eclipse.org/swt/)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
