# Portobello Teste Técnico - Gestão de Pedidos B2B

Este projeto é um MVP de um sistema interno para gestão de pedidos B2B, desenvolvido com backend em Java Spring Boot e MongoDB, e frontend em React com TypeScript e Tailwind CSS.

---

## Tecnologias utilizadas

- Backend:
  - Java 17
  - Spring Boot
  - MongoDB
- Frontend:
  - React 18
  - TypeScript
  - Tailwind CSS
  - Vite

---

## Estrutura do Projeto

- `/portobello-back`: microsserviço backend com API REST para pedidos  
- `/portobello-front`: aplicação frontend React para listar, criar e detalhar pedidos

---

## Requisitos

- Java 17+  
- Maven  
- Node.js 18+  
- MongoDB (local ou em container)

---

## Como rodar

### Backend

1. Configure o MongoDB localmente (ou ajuste a conexão no `application.properties`).

2. Na pasta `/portobello-back`, rode o comando:

```bash
mvn clean spring-boot:run
O backend estará disponível em: http://localhost:8080

Frontend
Na pasta /portobello-front, instale as dependências:

bash
Copy code
npm install
Rode o frontend:

bash
Copy code
npm run dev
O frontend estará disponível em: http://localhost:5173 (ou outra porta que o Vite indicar).

Possíveis melhorias futuras
Adicionar autenticação e controle de acesso

Implementar testes unitários e de integração no backend e frontend

Adicionar Docker e docker-compose para facilitar o deploy e desenvolvimento

Melhorar tratamento de erros e feedback no frontend

Adicionar mensageria (RabbitMQ ou AWS SQS) para notificações de novos pedidos

Configurar CI/CD para builds automáticos e deploy

Observações
Este projeto foi desenvolvido como parte de um teste técnico para a Portobello, focando em entregar um MVP funcional, claro e organizado.
