# 🛍️ APICompras

[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-green?style=flat-square)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue?style=flat-square)](https://maven.apache.org/)
[![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-green?style=flat-square)](https://www.mongodb.com/)

API REST desenvolvida em Java para gerenciamento e processamento de compras utilizando banco de dados não relacional (MongoDB).

## 📋 Índice

- [Visão Geral](#visão-geral)
- [Tecnologias](#tecnologias)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Endpoints da API](#endpoints-da-api)
- [Variáveis de Ambiente](#variáveis-de-ambiente)
- [Testes](#testes)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## 🎯 Visão Geral

A **APICompras** é uma API REST para gerenciamento de compras de compradores. O projeto utiliza MongoDB como banco de dados não relacional, garantindo flexibilidade no armazenamento de dados e escalabilidade.

### Características Principais

✅ API REST com Spring Boot 4.0.6  
✅ Banco de dados não relacional (MongoDB)  
✅ Suporte a operações reativas com Spring Data MongoDB Reactive  
✅ Java 21 para melhor performance  
✅ Lombok para redução de boilerplate code  
✅ Hot reload com Spring Boot DevTools  
✅ Testes automatizados  

## 🛠️ Tecnologias

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 4.0.6 | Framework web e IoC |
| **MongoDB** | Latest | Banco de dados NoSQL |
| **Spring Data MongoDB** | Latest | Persistência de dados |
| **Lombok** | Latest | Redução de código boilerplate |
| **Maven** | 3.6+ | Gerenciador de dependências |

## 📦 Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- **Java 21** ou superior
  ```bash
  java -version
  ```

- **Maven 3.6** ou superior
  ```bash
  mvn -version
  ```

- **MongoDB** (local ou remoto)
  - Serviço MongoDB em execução
  - Conexão com credenciais (se necessário)

- **Git**
  ```bash
  git --version
  ```

## 📥 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/jadilson22a/APICompras.git
cd APICompras
```

### 2. Instale as dependências

```bash
mvn clean install
```

Ou usando o wrapper Maven incluído:

```bash
./mvnw clean install
```

## ⚙️ Configuração

### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
# MongoDB Configuration
MONGO_USERNAME=seu_usuario
MONGO_PASSWORD=sua_senha
```

### Arquivo application.properties

Ou configure diretamente em `src/main/resources/application.properties`:

```properties
# MongoDB
spring.application.name=APICompras
spring.mongodb.host=localhost
spring.mongodb.port=27017
spring.mongodb.database=compras
spring.data.mongodb.username=
spring.data.mongodb.password=
```

## 🚀 Como Executar

### Opção 1: Maven

```bash
mvn spring-boot:run
```

### Opção 2: Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Opção 3: JAR Executável

```bash
mvn clean package
java -jar target/APICompras-0.0.1-SNAPSHOT.jar
```

### Opção 4: IDE

Se estiver usando uma IDE (IntelliJ, Eclipse, VS Code):

1. Abra o projeto
2. Execute a classe principal: `com.github.jadilson22a.ApicomprasApplication`
3. A API estará disponível em `http://localhost:8080/api`

## 📁 Estrutura do Projeto

```
APICompras/
├── .mvn/                          # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/github/jadilson22a/
│   │   │       ├── controller/    # Controladores REST
|   |   |       ├── Dtos/          # Dto para proteção de entidades
│   │   │       ├── service/       # Lógica de negócio
│   │   │       ├── repository/    # Acesso a dados
│   │   │       ├── model/         # Entidades
│   │   └── resources/
│   │       ├── application.properties
│   └── test/
│       └── java/
│           └── com/github/jadilson22a/
│               └── ...            # Testes unitários e de integração
├── pom.xml                        # Configuração Maven
├── mvnw                           # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                       # Maven Wrapper (Windows)
├── .gitignore                     # Arquivos ignorados pelo Git
└── README.md                      # Este arquivo
```

## 🔌 Endpoints da API

### Exemplo Base

Todos os endpoints estão disponíveis em: `http://localhost:8080/cotacao`

### Padrão de Respostas

#### Sucesso (200 OK)
```json
{
  "id": "507f1f77bcf86cd799439011",
  "data": "2026-04-26",
  "status": "success"
}
```

#### Erro (4xx/5xx)
```json
{
  "status": "error",
  "message": "Descrição do erro",
  "timestamp": "2026-04-26T10:30:00Z"
}
```

### Documentação dos Endpoints

```
POST   /cotacao                             - Criar uma nova cotacao
DELETE /cotacao?id={id}                     - Deletar compra
PUT    /cotacao?id={id}                     - Atualizar compra
GET    /cotacao/id?id={id}                  - Busca por id
GET    /cotacao/tudo                        - Busca tudo
GET    /cotacao/requisicoes                 - Busca por requisicoes
GET    /cotacao/estado?concluido={boolean}  - Busca por estado
```

## 🌍 Variáveis de Ambiente

| Variável | Descrição | Padrão | Obrigatória |
|----------|-----------|--------|------------|
| `MONGO_HOST` | Host do MongoDB | localhost | Não |
| `MONGO_PORT` | Porta do MongoDB | 27017 | Não |
| `MONGO_DATABASE` | Nome do banco de dados | compras | Não |
| `MONGO_USERNAME` | Usuário do MongoDB | - | Não |
| `MONGO_PASSWORD` | Senha do MongoDB | - | Não |
| `SERVER_PORT` | Porta da aplicação | 8080 | Não |
| `SPRING_PROFILES_ACTIVE` | Profile ativo | dev | Não |

## 📚 Dependências

As dependências principais estão configuradas em `pom.xml`:

- **Spring Boot Starter Data MongoDB**: Persistência com MongoDB
- **Spring Boot Starter Data MongoDB Reactive**: Operações reativas
- **Spring Boot Starter WebMVC**: API REST
- **Lombok**: Redução de boilerplate
- **Spring Boot DevTools**: Hot reload em desenvolvimento
- **Spring Boot Test**: Framework de testes

## 🔐 Segurança

### Recomendações

- [ ] Implementar autenticação (JWT/OAuth2)
- [ ] Validar entrada de dados
- [ ] Usar HTTPS em produção
- [ ] Configurar CORS adequadamente
- [ ] Implementar rate limiting
- [ ] Adicionar validação de permissões

## 📝 Logs

Os logs são configurados em `application.properties`:

```properties
logging.level.root=INFO
logging.level.com.github.jadilson22a=DEBUG
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %logger{36} - %msg%n
```

## 🐛 Troubleshooting

### Problema: Conexão com MongoDB recusada

```
MongoException: connect ECONNREFUSED 127.0.0.1:27017
```

**Solução**: 
- Certifique-se de que o MongoDB está rodando
- Verifique as credenciais em `.env` ou `application.properties`
- Confirme a URI de conexão

### Problema: Port 8080 já está em uso

```
Address already in use
```

**Solução**:
```bash
# Mudar porta em application.properties
server.port=8081
```

### Problema: Dependências não foram baixadas

```bash
mvn clean install -U
```

## 🤝 Contribuindo

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob licença. Para mais informações, veja o arquivo `LICENSE`.

## 👤 Autor

**jadilson22a**

- GitHub: [@jadilson22a](https://github.com/jadilson22a)
- Repositório: [APICompras](https://github.com/jadilson22a/APICompras)

## 📞 Suporte

Para suporte, abra uma issue no repositório GitHub.

---

**Última atualização**: 26 de abril de 2026

**Status**: Em desenvolvimento

**Versão**: 0.0.1-SNAPSHOT
