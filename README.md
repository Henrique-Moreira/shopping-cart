# Shopping Cart

## Para que serve esse programa ?
Esse programa simula um carrinho de compras de um e-commerce, onde um cliente pode inserir ou excluir vários produtos em um carrinho de compras, calculando dinamicamente o valor total dos produtos,
valor total do frete e valor total da compra, vale lembrar que a cada produto adicionado o frete é incrementado em R$10,00 e caso o subtotal da compra ultrapasse o valor de R$250,00
o frete será grátis.

## Quais foram as tecnologias utilizadas ?
- Java 11
- Spring Boot
- Spring data Jpa
- H2 Database
- Hibernate Validator
- Junit tests

## Como executar o programa ?
1. Faça o download ou clone o projeto https://github.com/Henrique-Moreira/shopping-cart para a sua máquina.
2. Importe o arquivo na sua IDE de preferência(recomendo a Spring Tools Suite).
3. Execute o localmente ná sua máquina e siga as instruções da documentação abaixo para executar e rodar os endpoints.

## Documentação
A documentação foi feita pelo Postman clicando <a href="https://documenter.getpostman.com/view/14018783/Tzm2KdxE#d3721ca6-04e5-4ce4-b008-d8cce036c94c">aqui</a> e pelo Swagger, 
clicando <a href="http://localhost:8080/swagger-ui.html#/">aqui</a> quando o programa já tiver executando.

## Considerações finais
A efeito de testes, inseri um arquivo chamado import.sql para nao haver a necessidade de criar toda vez uma lista de produtos, foram feitos poucos testes e poucas validações 
devido ao curto prazo e correria de final de semestre na faculdade. 
<br>Meu e-mail: henriquemoreiraa@gmail.com
