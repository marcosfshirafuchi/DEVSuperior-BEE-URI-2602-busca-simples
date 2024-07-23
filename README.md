# <a href="https://imgbb.com/"><img src="https://i.ibb.co/51bfmLv/image-2024-07-01-T11-45-10-371-Z.png" alt="image-2024-07-01-T11-45-10-371-Z" border="0" width="300"></a> Java Spring Professional - BEE/URI 2602

#### Desenvolvido na linguagem Java por:
- [Marcos Shirafuchi](https://github.com/marcosfshirafuchi)
## Formação Desenvolvedor Moderno Módulo: Back end
<b>Capítulo: JPA, consultas SQL e JPQL</b>

## Exercício: BEE/URI 2602

Exercício de SQL da plataforma do BEE: 2605 <br><br>
https://judge.beecrowd.com/pt/problems/view/2602<br>

<p align ="center"><b>Select Básico</b></p>
Sua empresa está fazendo um levantamento de quantos clientes estão cadastrados nos estados, porém, faltou levantar os dados do estado do Rio Grande do Sul.<br><br>

Então você deve Exibir o nome de todos os clientes cujo estado seja ‘RS’.<br>

## Esquema

|  customer     |
| ------------- | 

<table>
  <thead>
    <tr align="center">
      <th>customers</th>
       <th>customers</th>
    </tr>
    <tr align="left">
      <th>Coluna</th>
      <th>Tipo</th>
    </tr>
  </thead>
  <tbody align="left">
    <tr>
      <td>id (PK)
      </td>
      <td>numeric</td>
    </tr>
    <tr>
      <td>name</td>
      <td>varchar</td>
    </tr>
    <tr>
      <td>street</td>
      <td>	varchar</td>   
    </tr>
    <tr>
      <td>city</td>
      <td>	varchar</td>   
    </tr>
    <tr>
      <td>state</td>
      <td>char</td>   
    </tr>
    <tr>
      <td>credit_limit</td>
      <td>number</td>   
    </tr>
  </tbody>
  <tfoot></tfoot>
</table>
Você deverá implementar as seguintes consultas (ambas deverão estar corretas):<br><br>

## Relatório de vendas

1. [IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.
2. [OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do
vendedor, das vendas que se enquadrem nos dados informados.<br><br>
Informações complementares:<br>
- Se a data final não for informada, considerar a data atual do sistema. Para instanciar a data atual,
utilize o comando:
LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
- Se a data inicial não for informada, considerar a data de 1 ano antes da data final. Para instanciar
uma data com um ano a menos, use a função minusYears:<br>
LocalDate result = minhaData.minusYears(1L);
- Se o nome não for informado, considerar o texto vazio.
- Dica: receba todos os dados como String no controller, e faça os tratamentos das datas acima,
instanciando os objetos LocalDate, no service.

## Sumário de vendas por vendedor
1. [IN] O usuário informa, opcionalmente, data inicial, data final.<br>
2. [OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor
no período informado.<br><br>
Informações complementares:<br>
- As mesmas do caso de uso Relatório de vendas

## Como o trabalho será corrigido?
1) Importação do projeto<br>
O professor deverá ser capaz de fazer um simples clone do projeto Github, e importar e executar o mesmo na
IDE sem necessidade de qualquer configuração especial diferente daquelas das aulas.<br><br>
2) Testes manuais no Postman<br>
O professor já terá preparado em seu computador as seguintes requisições (link da collection Postman
abaixo). Todas elas deverão funcionar corretamente:<br><br>
https://www.getpostman.com/collections/dea7904f994cb87c3d12<br><br>
2.1) Sumário de vendas por vendedor (teste 1)<br>
<b>GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30<br>
<p align = "center">
Deverá retornar o sumário de vendas por vendedor no período informado:</b>
</p>

```
[
  {
    "sellerName": "Anakin",
    "total": 110571.0
  },
  {
    "sellerName": "Logan",
    "total": 83587.0
  },
  {
    "sellerName": "Loki Odinson",
    "total": 150597.0
  },
  {
    "sellerName": "Padme",
    "total": 135902.0
  },
  {
    "sellerName": "Thor Odinson",
    "total": 144896.0
  }
]
```
2.2) Sumário de vendas por vendedor (teste 2)<br>
<b>GET /sales/summary<br><br>
Deverá retornar o sumário de vendas por vendedor dos últimos 12 meses.</b><br><br>
2.3) Relatório de vendas (teste 1)<br>
<b>GET /sales/report<br><br>
Deverá retornar o relatório de vendas dos últimos 12 meses.</b><br><br>
2.4) Relatório de vendas (teste 2)<br>
<b>GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson<br><br>
<p align ="center">
Deverá retornar o relatório de vendas do período/vendedor informados:</b>
</p>

```
{
  "content": [
    {
        "id": 9,
        "date": "2022-05-22",
        "amount": 19476.0,
        "sellerName": "Loki Odinson"
    },
    {
        "id": 10,
        "date": "2022-05-18",  
        "amount": 20530.0,
        "sellerName": "Thor Odinson"
    },
    {
        "id": 12,
        "date": "2022-05-06",
        "amount": 21753.0,
        "sellerName": "Loki Odinson"
    }
],
...
```

