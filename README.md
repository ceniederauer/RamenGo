# Ramen Go API

## Tecnologias utilizadas:
- Java (17)
- Maven
- Spring (3.3.0)
- H2 Database
- AWS

## Sobre o projeto
Temos 3 rotas que podem ser utilizadas:
> O header de todas deve ser:
```
x-api-key: ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf
```
* 44.192.59.53:8080/proteins
* 44.192.59.53:8080/broths
* 44.192.59.53:8080/orders

/proteins e /broths são duas GET requests
/orders é uma POST request

O body de /orders deve ser:
```
{
  "brothId": "1",
  "proteinId": "1"
}
```
Na AWS foi criada uma instância EC2 e uma VPC, a regra da EC2 é permitir qualquer requisição HTTP tcp para a porta 8080 e também permitir acesso via SSH
## Para o futuro
- Adicionar testes unitários
- Criar um CI e um CD para melhorar a forma de deploy da aplicação
- Adicionar um filtro mais rebuscado para confirmar o header da API
