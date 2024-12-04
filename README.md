# Desafio CRUD com Spring Boot

Este projeto é uma aplicação RESTful desenvolvida com **Spring Boot** para gerenciar entidades de **Pessoa** e **Endereço**, que possuem um relacionamento de **um-para-muitos**. O objetivo principal é implementar um CRUD completo, com validações, boas práticas de programação e respostas em formato JSON.

---

## 🚀 Funcionalidades

### Requisitos Atendidos
1. **Listar todas as pessoas e seus respectivos endereços.**
2. **Criar uma nova pessoa com um ou mais endereços.**
3. **Atualizar os dados de uma pessoa e/ou seus endereços.**
4. **Excluir uma pessoa e todos os seus endereços.**
5. **Mostrar a idade da pessoa.**

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal.
- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Data JPA**: Para integração com o banco de dados.
- **Banco de Dados H2**: Banco de dados em memória para facilitar o desenvolvimento e testes.

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/seuprojeto/
│   │   ├── controller/       # Controladores REST
│   │   ├── entity/            # Entidades Pessoa e Endereço
│   │   ├── repository/       # Repositórios JPA
│   │   ├── service/          # Lógica de negócios
│   └── resources/
│       ├── application.yml # Configurações da aplicação
└── test/                    # Testes unitários e de integração
```

---

## 📖 Endpoints da API

### Pessoa
- **GET** `/pessoas`  
  Lista todas as pessoas (com paginação, se implementada) e seus endereços.
  
- **POST** `/pessoas`  
  Cria uma nova pessoa com um ou mais endereços.

- **PUT** `/pessoas/{id}`  
  Atualiza uma pessoa e/ou seus endereços.

- **DELETE** `/pessoas/{id}`  
  Remove uma pessoa e todos os seus endereços.

### Endereço
- **POST** `/enderecos/{pessoaId}`  
  Adiciona um endereço a uma pessoa.

- **PUT** `/enderecos/{id}`  
  Atualiza um endereço específico.

---

## 🛠️ Como Executar

### Pré-requisitos
- **Java 17** ou superior.
- **Maven** para gerenciamento de dependências.

### Passos

1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/GabrielSbruzzi/CRUD.git)
   ```

2. O banco H2 pode ser acessado em:
   - URL: `http://localhost:8080/h2`
   - Credenciais padrão configuradas em `application.yml`.

---

## 📜 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes. 

--- 
