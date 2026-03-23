# 📚 API de Gestão Escolar

Este projeto é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento completo de uma instituição de ensino. A aplicação permite o controle de alunos, professores, turmas, disciplinas e lançamento de notas.

## 🚀 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de dados)
* **Bean Validation** (Validação de campos com Hibernate Validator)
* **SpringDoc OpenAPI (Swagger)** (Documentação interativa da API)
* **H2 Database / MySQL** (Banco de dados)

---

## 📖 Documentação da API (Swagger)

A API conta com uma documentação completa e interativa gerada pelo Swagger (OpenAPI 3). Através dela, é possível visualizar todos os endpoints, schemas de dados e realizar testes em tempo real.

### Como acessar a documentação:
1. Com a aplicação rodando, abra o seu navegador.
2. Acesse o endereço: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Recursos Disponíveis:
* **Alunos**: Cadastro, atualização, listagem e remoção de estudantes.
* **Professores**: Gestão do corpo docente e suas especialidades.
* **Turmas**: Organização de turmas e enturmação de alunos.
* **Aulas & Cursos**: Planejamento da estrutura acadêmica.
* **Notas**: Lançamento de avaliações e histórico de desempenho.

---

## 🛠️ Como Executar o Projeto

1. **Clone este repositório:**
   ```bash
   git clone [https://github.com/matheusengell/api-gestao-escolar.git](https://github.com/matheusengell/api-gestao-escolar.git)
