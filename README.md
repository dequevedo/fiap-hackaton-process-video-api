
# Tech Challenge - Payment API

Microserviço responsável pelo processo de gestão de pagamentos da lanchonete digital.

**Observação:** Este repositório é parte da solução de arquitetura de software para o desafio Tech Challenge da Fiap, com outros microsserviços que compõem o sistema da lanchonete.

📚 Para mais detalhes sobre a solução e arquitetura de software completa, consulte nossa documentação [Repositório Overview](https://github.com/RenatoMartinsXrd/fiap-soat-tech-challenge-overview)

---

## 📦 Tecnologias Utilizadas

- **Java 21** + **Spring Boot**
- **MongoDB**
- **Docker** + **Docker Compose**
- **Swagger (OpenAPI)**
- **JUnit** + **Mockito**
- **Clean Architecture**

---

## ▶️ Executando a API Localmente

### **Pré-requisitos:**
- **Docker** + **Docker Compose**
- **Java 21** (caso queira rodar pela IDE)

### **Passos para executar:**
1. Clone o repositório:
   ```bash
   git clone https://github.com/RenatoMartinsXrd/fiap-soat-tech-challenge-payment-api.git
   cd fiap-soat-tech-challenge-payment-api
   ```

2. Utilize o Docker Compose para rodar o serviço localmente:
   ```bash
   docker-compose up --build
   ```

3. A API estará disponível em [http://localhost:8080](http://localhost:8080).

4. Caso precise acessar o banco de dados, pode usar o Mongo Compass ou outra ferramenta de sua preferência.

---

## 🧠 Arquitetura

Este microserviço adota o padrão **Clean Architecture**, com foco em separação de responsabilidades e independência tecnológica.

### **Principais camadas:**
- **core**: Entidades, regras de negócio, casos de uso e contratos (ports).
- **adapters**: Controladores e mapeadores que traduzem o mundo externo para o domínio.
- **frameworks**: Implementações específicas (REST, MongoDB, integrações externas).
- **shared**: Configurações globais e utilitários comuns.

---

## 🧪 Testes

Os testes são realizados com **JUnit** e **Mockito** para garantir a qualidade do código.

### **Execução dos testes**

1. No diretório do repositório, execute o comando Maven para rodar os testes:

   ```bash
   mvn test
   ```

2. Para gerar o relatório de cobertura de testes com **Jacoco**, execute:

   ```bash
   mvn clean verify
   ```

3. A cobertura mínima exigida é de **80%**.

---

## 👥 Equipe

- Renato Martins - @RenatoMartinsXrd
- Daniel Quevedo - @dequevedo

---
