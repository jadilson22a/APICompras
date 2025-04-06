# API
A api insere as informações de cotação de compra de produtos em uma base de dados relacionais SQL.

## Tabelas
- cotacoes
- produtos

## Exemplo de Requisição
- Request **POST**: http://localhost:8080/cotacao
```JSON
{
    "produtos": [
        {"nome": "arroz", "quantidade": 10},
        {"nome": "feijão", "quantidade": 5},
        {"nome": "macarrão", "quantidade": 8}
    ],
    "status": "ABERTA"
}
```

# Front
Frontend React gerenciado diretamente pelo Spring Boot

# Observações a serem adicionada
- Status da cotação deve ser gerenciada pela aplicação, relacionando-a ao momento da compra
- Inserir Fonecedores para cada produto
- Inserir Função de caucular melhor fornecedor
- Melhorar visualização do usuário
