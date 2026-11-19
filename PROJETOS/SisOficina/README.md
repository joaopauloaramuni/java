# SisOficina

![Java](https://img.shields.io/badge/Java-7-orange?logo=openjdk) ![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-green) ![Status](https://img.shields.io/badge/status-projeto%20acad%C3%AAmico-blue)

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

**Sistema de Oficina** mecânica com veículos (`Carro`, `Moto`) derivados da classe abstrata `Veiculo`.

## Funcionalidades

- Cadastrar, consultar, editar, excluir e listar veículos
- Registro de saída do veículo
- Relatório gerencial
- Tratamento polimórfico com `instanceof`

## Versão do Java

**Java SE 7**

Os `.class` em `bin/` foram compilados para Java 7 (bytecode 51). O Java SE 7 foi lançado em julho de 2011, durante o 2º semestre da disciplina.

## Tecnologias

- **Linguagem:** Java (Java SE 7)
- **IDE:** Eclipse IDE
- **Interface:** Console (modo texto)
- **Persistência:** arquivos de objetos serializados (`java.io`)
- **Bibliotecas da disciplina:** `Console` e `LtpLib` (pacote `utilitarios`)

## Estrutura do projeto

```text
SisOficina/
└── src/
    ├── controller/
    │   └── Oficina.java
    ├── model/
    │   ├── Carro.java
    │   ├── Moto.java
    │   └── Veiculo.java
    ├── utilitarios/
    │   ├── Console.java
    │   └── LtpLib.java
    └── view/
        └── InterfaceUsuario.java
```

> A pasta `bin/` contém os arquivos `.class` compilados e foi omitida da árvore acima.

## Como executar

Pré-requisito: um JDK instalado (`java -version`).

**Pelo Eclipse:** *File → Import → General → Existing Projects into Workspace* (ou crie um projeto Java apontando para esta pasta), depois execute a classe principal com *Run As → Java Application*.

**Pela linha de comando** (a partir da raiz do repositório):

```bash
cd "PROJETOS/SisOficina"
mkdir -p bin
javac -encoding ISO-8859-1 -d bin $(find src -name "*.java")
java -cp "bin" view.InterfaceUsuario
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

### Construtores e Sobrecarga

O **construtor** inicializa o objeto no momento do `new`. Uma classe pode ter vários construtores (ou métodos) com o mesmo nome e parâmetros diferentes — isso é **sobrecarga** (*overloading*).

Saiba mais: [Providing Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html) · [Defining Methods (overloading)](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)

### Herança

Com `extends`, uma subclasse herda atributos e métodos da superclasse, especializando-a (ex.: `PessoaFisica extends Pessoa`). A palavra-chave `super(...)` chama o construtor da classe-mãe, reaproveitando código.

Saiba mais: [Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html) · [Using the Keyword super](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

### Classes e Métodos Abstratos

Uma classe `abstract` não pode ser instanciada e serve como modelo comum para as subclasses. Métodos abstratos declaram *o que* deve ser feito, obrigando cada subclasse concreta a implementar *como*.

Saiba mais: [Abstract Methods and Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

### Polimorfismo

Uma referência do tipo da superclasse (ou interface) pode apontar para objetos de subclasses diferentes; em tempo de execução, o Java chama a versão do método da classe real do objeto (*ligação dinâmica*). Assim, o mesmo código trata objetos distintos de forma uniforme.

Saiba mais: [Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)

### Sobrescrita de Métodos (`@Override`)

A subclasse redefine um método herdado (como `toString()`, `equals()` ou um método abstrato) mantendo a mesma assinatura. A anotação `@Override` pede ao compilador que confirme que a sobrescrita é válida.

Saiba mais: [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html) · [Object.toString()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--)

### Operador `instanceof` e Casting

`instanceof` verifica, em tempo de execução, se um objeto é de determinado tipo; depois é possível fazer o *cast* para acessar métodos específicos da subclasse.

Saiba mais: [Equality, Relational and Conditional Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html)

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

### Serialização de Objetos (arquivos `.obj`/`.dat`)

Classes que implementam `Serializable` podem ser gravadas em disco com `ObjectOutputStream` e lidas com `ObjectInputStream`, persistindo o cadastro entre execuções do programa.

Saiba mais: [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html) · [java.io.Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)

### Bibliotecas da Disciplina (`Console` e `LtpLib`)

Classes utilitárias fornecidas pelo professor: `Console` simplifica a leitura do teclado (`readInt`, `readDouble`, `readLine`) e `LtpLib` oferece validação de CPF/CNPJ/PIS/e-mail/datas, formatação de valores, valor por extenso e gravação/leitura de arquivos de objetos.

### Menus em Modo Texto (`switch`/`do-while`)

A interação com o usuário acontece por menus no console, implementados com laço `do-while` e estrutura `switch/case`, chamando um método para cada opção.

Saiba mais: [The switch Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html) · [The while and do-while Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)

### Separação em Camadas (Modelo / Cadastro / Interface)

O código é dividido em pacotes com responsabilidades distintas — classes de **dados/modelo**, classes de **cadastro/controle** (regras de negócio) e classes de **interface com o usuário** — uma aproximação do padrão MVC.

Saiba mais: [Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)

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
- [Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Using the Keyword super](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)
- [Abstract Methods and Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
- [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
- [Object.toString()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--)
- [Equality, Relational and Conditional Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html)
- [Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
- [java.util.ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [The List Interface](https://docs.oracle.com/javase/tutorial/collections/interfaces/list.html)
- [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [java.util.GregorianCalendar](https://docs.oracle.com/javase/8/docs/api/java/util/GregorianCalendar.html)
- [java.text.SimpleDateFormat](https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html)
- [Date-Time API (java.time)](https://docs.oracle.com/javase/tutorial/datetime/index.html)
- [Object Streams](https://docs.oracle.com/javase/tutorial/essential/io/objectstreams.html)
- [java.io.Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)
- [The switch Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
- [The while and do-while Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)
- [Packages](https://docs.oracle.com/javase/tutorial/java/package/index.html)
- [Repositório completo de projetos Java](https://github.com/joaopauloaramuni/java)

## Licença

Este projeto está licenciado sob a **Licença MIT** — consulte o arquivo [LICENSE](../../LICENSE) na raiz do repositório.

---

<sub>Projeto acadêmico — Universidade FUMEC, Ciência da Computação, LTP III e IV (2011), Prof. Erix Morato.</sub>
