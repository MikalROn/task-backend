# Backend
<p aling="center">Backend do sistema de tasks</p>

## Requisitos

- Docker compose

## Instalar
1. Clone o repositório do backend:
   ```bash
   git clone git@github.com:MikalROn/task-backend.git
   ```
2. Abra o projeto:

   ```bash
   cd task-backend
   ```
3. Inicie o banco de dados:
   ```bash
   docker-compose up -d
   ```
   
4. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Banco de dados

Você pode acessar o banco dedados atravez do phpmyadmin no link *http://localhost:8081/*

![myadmin](http://localhost:8081/)
