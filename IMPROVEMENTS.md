
### Decisões Técnicas e Melhorias Futuras

### Decisões Técnicas

### Backend
Tecnologia: Java 17 com Spring Boot
Escolhi Spring Boot pela facilidade de criar APIs REST robustas e pela popularidade no mercado, além da boa integração com MongoDB.

Banco de Dados: MongoDB
Usei MongoDB por ser um banco NoSQL flexível, ideal para protótipos rápidos e sistemas que precisam armazenar documentos com estruturas variáveis.

### Estrutura do Projeto: Microsserviço simples
Optei por uma estrutura leve e modular, facilitando a escalabilidade futura.

### Frontend
Tecnologia: React com TypeScript e Tailwind CSS
React permite criação de interfaces reativas e componetizadas. TypeScript garante tipagem estática, ajudando a evitar erros. Tailwind CSS facilita a criação de layouts responsivos e bonitos sem sair do código.

---

### Ferramentas: Vite
Vite oferece uma experiência de desenvolvimento rápida e simples, com hot reload e configuração mínima.

---

### Comunicação Frontend-Backend
Utilizei fetch API para chamadas HTTP simples, mantendo o código limpo e fácil de entender.

---

### Melhorias Futuras

- Autenticação e Controle de Acesso: Implementar autenticação JWT para proteger as rotas da API e permitir diferentes níveis de usuário.
- Testes Automatizados: Criar testes unitários e de integração para backend e frontend, aumentando a confiabilidade do sistema.
- Docker e Docker Compose: Adicionar containers para backend, frontend e MongoDB, facilitando o deploy e a replicação do ambiente.
- Mensageria: Integrar RabbitMQ ou AWS SQS para envio de notificações assíncronas e melhor escalabilidade.
- CI/CD: Configurar pipelines para builds, testes e deploy automático.
- Melhorias na UX/UI: Adicionar feedbacks mais ricos, carregamentos e tratamento de erros visuais no frontend.
- Monitoramento e Logs: Implementar monitoramento da aplicação e logs centralizados para facilitar a manutenção.

