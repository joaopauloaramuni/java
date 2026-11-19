# SisLocadora

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

**Sistema de Locadora** de filmes com interface gráfica Swing e banco de dados **Firebird** via JDBC (projeto de 2011).

## Funcionalidades

- Splash screen e tela principal
- Cadastro de clientes e filmes com `JTable`
- Locação e devolução de filmes
- Camadas `dados`, `bdlocadora` (acesso a dados), `locnegocio` (regras) e `usuario` (telas)

## Versão do Java

**Java SE 6**

O código foi escrito em 2011 com o **Java SE 6** (JDK 1.6), versão padrão da época, usando recursos do Java 5+ como *generics*, *for-each* e `@Override`. O código é compatível com JDKs atuais (8, 11, 17, 21).

## Tecnologias

- **Linguagem:** Java (Java SE 6)
- **IDE:** NetBeans IDE (projeto Ant)
- **Interface gráfica:** Swing (`javax.swing`) e AWT
- **Banco de dados:** Firebird via JDBC (driver Jaybird – `org.firebirdsql.jdbc`)
- **Look and feel:** Substance (`org.pushingpixels.substance`)

## Estrutura do projeto

```text
SisLocadora/
├── build.xml
├── config.apj
├── manifest.mf
└── src/
    ├── bdlocadora/
    │   └── BDLocadora.java
    ├── dados/
    │   ├── Cliente.java
    │   ├── Filme.java
    │   └── Locacao.java
    ├── locnegocio/
    │   └── LocNegocio.java
    ├── sislocadora/
    │   └── Main.java
    └── usuario/
        ├── JFrame3D.form
        ├── JFrame3D.java
        ├── JFrameClientes.form
        ├── JFrameClientes.java
        ├── JFrameFilmes.form
        ├── JFrameFilmes.java
        ├── JFrameLocadora.form
        ├── JFrameLocadora.java
        ├── JFrameLocar.form
        ├── JFrameLocar.java
        ├── SplashLocadora.form
        ├── SplashLocadora.java
        ├── jDialogSobre.form
        ├── jDialogSobre.java
        ├── recursos/
        │   ├── 3D-Penguins-icon.png
        │   ├── 3dimg.jpg
        │   ├── Film-Maker-Male-Light-icon.png
        │   ├── Help.gif
        │   ├── Host.gif
        │   ├── Host1.gif
        │   ├── Movies-icon.png
        │   ├── US-dollar-icon.png
        │   ├── User-Clients-icon.png
        │   ├── anterior.gif
        │   ├── anterior_desabilitado.gif
        │   ├── apply.png
        │   ├── atualizar.gif
        │   ├── atualizar_desabilitado.gif
        │   ├── broom.gif
        │   ├── buscar.gif
        │   ├── buscar_desabilitado.gif
        │   ├── button_cancel.png
        │   ├── cancelar.gif
        │   ├── cancelar_desabilitado.gif
        │   ├── colors.png
        │   ├── conectar.gif
        │   ├── confirmar.gif
        │   ├── confirmar_desabilitado.gif
        │   ├── displayconfig.png
        │   ├── editar.gif
        │   ├── editar_desabilitado.gif
        │   ├── exit.png
        │   ├── fexit.gif
        │   ├── fexit16.gif
        │   ├── filefind.png
        │   ├── folder_cool.png
        │   ├── fonts.png
        │   ├── fullhd3d.jpg
        │   ├── imprimir.gif
        │   ├── inserir.gif
        │   ├── inserir_desabilitado.gif
        │   ├── movieclip.png
        │   ├── ok.png
        │   ├── personal.png
        │   ├── primeiro.gif
        │   ├── primeiro_desabilitado.gif
        │   ├── proximo.gif
        │   ├── proximo_desabilitado.gif
        │   ├── remover.gif
        │   ├── remover_desabilitado.gif
        │   ├── sair_desabilitado.gif
        │   ├── salvar.gif
        │   ├── switchuser.png
        │   ├── ultimo.gif
        │   └── ultimo_desabilitado.gif
        └── relatorios/
```

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

**Pelo Eclipse:** *File → Import → General → Existing Projects into Workspace* (ou crie um projeto Java apontando para esta pasta), depois execute a classe principal com *Run As → Java Application*.

**Pela linha de comando** (a partir da raiz do repositório):

```bash
cd "PROJETOS/SisLocadora"
mkdir -p bin
javac -encoding ISO-8859-1 -cp "lib/*" -d bin $(find src -name "*.java")
java -cp "bin:lib/*" sislocadora.Main
```

> Dependências externas que não estão no repositório e devem ser colocadas em `lib/`: o driver JDBC **Jaybird** (Firebird), o *look and feel* **Substance** (`org.pushingpixels.substance`) e a biblioteca da disciplina **LtpUtil** (`utilitarios.LtpUtil`, disponível em `PROJETOS/ComponentesBasicos/LtpUtil.jar`). Também é necessário um servidor **Firebird** com o banco da locadora.

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

### Coleção `Vector`

`Vector` é uma lista dinâmica (cresce conforme necessário) e sincronizada, muito usada nos materiais da época. Hoje, em código novo, costuma-se preferir `ArrayList`.

Saiba mais: [java.util.Vector](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html) · [Collections Framework](https://docs.oracle.com/javase/tutorial/collections/index.html)

### Mapas com `HashMap`

Estrutura chave → valor (ex.: CPF → Cliente) com busca muito rápida pela chave. Ideal para cadastros em que existe um identificador único.

Saiba mais: [java.util.HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html) · [The Map Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html)

### Generics

Tipos parametrizados como `Vector<Cliente>` ou `ArrayList<Livro>` garantem, em tempo de compilação, que a coleção só aceite objetos do tipo indicado, dispensando *casts*.

Saiba mais: [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

### Manipulação de Strings

Métodos da classe `String` como `substring()`, `split()`, `toUpperCase()`, `trim()` e `indexOf()` para percorrer, separar em palavras e padronizar textos.

Saiba mais: [Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html) · [java.lang.String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)

### Datas com `GregorianCalendar` e `SimpleDateFormat`

`GregorianCalendar` manipula datas (somar dias, descobrir dia da semana, diferença entre datas) e `SimpleDateFormat` formata/converte datas em texto (ex.: `dd/MM/yyyy`). Em Java 8+ existe a API moderna `java.time`.

Saiba mais: [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html) · [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html) · [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)

### Separação em Camadas (Modelo / Cadastro / Interface)

O código é dividido em pacotes com responsabilidades distintas — classes de **dados/modelo**, classes de **cadastro/controle** (regras de negócio) e classes de **interface com o usuário** — uma aproximação do padrão MVC.

Saiba mais: [Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)

### Interface Gráfica com Swing

Construção de janelas com `JFrame`, `JPanel`, `JButton`, `JTextField`, `JLabel` e gerenciadores de layout. Swing é o toolkit gráfico padrão do Java SE.

Saiba mais: [Creating a GUI With Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html) · [Laying Out Components](https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html)

### Caixas de Diálogo com `JOptionPane`

Exibição de mensagens, confirmações e entrada de dados em pequenas janelas modais, sem precisar construir um formulário completo.

Saiba mais: [How to Make Dialogs](https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html)

### Tabelas com `JTable`

Componente Swing que exibe dados em linhas e colunas, normalmente alimentado por um `TableModel` (ex.: `DefaultTableModel`).

Saiba mais: [How to Use Tables](https://docs.oracle.com/javase/tutorial/uiswing/components/table.html)

### Threads e Concorrência

Execução de tarefas em paralelo com `Thread`/`Runnable` (e `SwingWorker` em interfaces Swing), por exemplo para exibir uma splash screen ou atualizar uma barra de progresso sem travar a tela.

Saiba mais: [Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) · [Concurrency in Swing](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html)

### Splash Screen

Janela de abertura exibida por alguns segundos (normalmente com imagem e barra de progresso) enquanto a aplicação principal é carregada.

Saiba mais: [How to Create a Splash Screen](https://docs.oracle.com/javase/tutorial/uiswing/misc/splashscreen.html)

### Acesso a Banco de Dados com JDBC

JDBC é a API padrão para conectar o Java a bancos relacionais: `DriverManager` abre a `Connection`, `PreparedStatement` executa SQL parametrizado (evitando SQL Injection) e `ResultSet` percorre os resultados.

Saiba mais: [JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html) · [Using Prepared Statements](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)

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
- [java.util.Vector](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)
- [Collections Framework](https://docs.oracle.com/javase/tutorial/collections/index.html)
- [java.util.HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
- [The Map Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html)
- [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [Strings](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
- [java.lang.String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html)
- [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html)
- [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html)
- [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)
- [Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)
- [Creating a GUI With Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html)
- [Laying Out Components](https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html)
- [How to Make Dialogs](https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html)
- [How to Use Tables](https://docs.oracle.com/javase/tutorial/uiswing/components/table.html)
- [Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
- [Concurrency in Swing](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html)
- [How to Create a Splash Screen](https://docs.oracle.com/javase/tutorial/uiswing/misc/splashscreen.html)
- [JDBC Basics](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
- [Using Prepared Statements](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
