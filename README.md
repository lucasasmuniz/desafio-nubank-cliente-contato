# Desafio Nubank Gerenciamento Clientes e Contatos

Este projeto é uma API REST desenvolvida para gerenciar **clientes** e seus respectivos **contatos**. Cada cliente pode ter um ou mais contatos associados.

---

## Desafio

> Construa uma API REST para gerenciamento de clientes e seus contatos.  
> Cada cliente pode ter um ou mais contatos associados.

---

## Requisitos Técnicos

A aplicação deve conter:

- ✅ Cadastro de Cliente (`POST /clientes`)
- ✅ Cadastro de Contato (`POST /contatos`) associado a um cliente existente
- ✅ Listagem de todos os clientes com seus contatos (`GET /clientes`)
- ✅ Listagem de contatos de um cliente específico (`GET /clientes/{id}/contatos`)
- ✅ Uso de Spring Boot + Spring Data JPA
- ✅ Banco de dados PostgreSQL (e H2 para testes)
- ✅ Entidades Cliente e Contato com relacionamento `@OneToMany` / `@ManyToOne`

---

## Requisitos de Código

O código foi desenvolvido seguindo boas práticas, incluindo:

- ✅ Separação de responsabilidades (`controller`, `service`, `repository`)
- ✅ Uso de **DTOs** para entrada e saída de dados
- ✅ Tratamento adequado de erros
- ✅ Uso do **Lombok**
- ✅ Injeção de dependências via construtor (sem `@Autowired`, como recomendado atualmente)
- ✅ Uso de `JOIN FETCH` para evitar o problema de consultas N+1

---

## Diferenciais (Não obrigatórios)

- [ ] Uso de Docker para subir o PostgreSQL *(em testes)*
- [x] Testes automatizados *(previstos)*
- [x] Documentação com Swagger *(prevista)*

---

## 🔌 Tecnologias e Dependências

- Java 17
- Spring Boot
- Spring Web / MVC
- Spring Data JPA
- PostgreSQL
- H2 Database (para testes locais)
- Lombok
- Spring DevTools
- Bean Validation (Jakarta)

---

## Estrutura dos Endpoints e Exemplos

### POST /clientes

Cria um cliente sem contatos inicialmente.

**Requisição:**
```json
{
  "nome": "Lucas Muniz"
}
```

Resposta:

```json
{
  "id": 3,
  "nome": "Lucas Muniz",
  "contatos": []
}
```

### GET /clientes
Retorna uma lista de todos os clientes com seus contatos.

Resposta:

```json
[
  {
    "id": 1,
    "nome": "Empresa Alpha",
    "contatos": [
      {
        "id": 1,
        "nome": "João Silva",
        "email": "joao@alpha.com",
        "clienteId": 1
      },
      {
        "id": 2,
        "nome": "Maria Souza",
        "email": "maria@alpha.com",
        "clienteId": 1
      }
    ]
  },
  {
    "id": 2,
    "nome": "Empresa Beta",
    "contatos": [
      {
        "id": 3,
        "nome": "Carlos Lima",
        "email": "carlos@beta.com",
        "clienteId": 2
      }
    ]
  }
]
```

### GET /clientes/{id}/contatos
Retorna todos os contatos associados a um cliente específico.

Resposta:

```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@alpha.com",
    "clienteId": 1
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "email": "maria@alpha.com",
    "clienteId": 1
  }
]
```

### POST /contatos
Cria um novo contato vinculado a um cliente existente.

Requisição:

```json
{
  "nome": "Anna Luiza",
  "email": "anna@gmail.com",
  "clienteId": 3
}
```
Resposta:

```json
{
  "id": 4,
  "nome": "Anna Luiza",
  "email": "anna@gmail.com",
  "clienteId": 3
}
```

Se o clienteId informado não existir, a API retorna erro.

## Diagrama de Classes (UML)

![Image](https://github.com/user-attachments/assets/84f3f5d5-799c-4f05-a3ce-73233af13f09)
