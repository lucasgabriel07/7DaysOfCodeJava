# 7DaysOfCode
Projeto criado para o desafio #7daysofcode da @alura

## Descrição

O desafio consiste em utilizar a linguagem Java para consumir uma API, 
puxando o ranking dos top 250 filmes do IMDB, e gerando uma página HTML
com as informações obtidas.

## Desafios

### ✅ Dia 1
Consumir a API do IMDB, buscando os top 250 filmes do ranking.

### ✅ Dia 2
Parsear a resposta JSON obtida a partir do IMDB para extrair as suas informações e atributos (título, pôster, nota).

### ✅ Dia 3
Criar uma estrutura 'Movie' com alguns atributos, com o intuito de que cada objeto desse tipo encapsule seus próprios dados.

### ✅ Dia 4
Gerar uma página HTML a partir da lista de objetos obtida, com as informações sobre os filmes.

### ✅ Dia 5
Encapsular algumas das chamadas desenvolvidas em novas classes.

### ✅ Dia 6
Deixar o código mais genérico, preparado para receber dados de outras APIs, utilizando interfaces.

### ✅ Dia 7
Ordenar a lista com base em diferentes atributos, utilizando a classe Collections e as interfaces Comparable e Comparator.

## Rodando a aplicação

Para rodar a aplicação corretamente, é necessária uma API Key.

- Obtenha uma API Key em https://imdb-api.com/api
- Crie um arquivo com o nome ".env" na raiz do projeto, contendo a chave da API com o formato "API_KEY=\<Sua chave aqui\>"
  
  No terminal:
  
  ```(bash)
  echo API_KEY=<Sua chave aqui> >> .env
  ```
