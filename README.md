📘 Conversor de Moedas em Java
Projeto desenvolvido como Challenge da Alura – Turma G9

Este projeto é um Conversor de Moedas que utiliza a API ExchangeRate-API para obter cotações em tempo real e converter valores de USD para qualquer outra moeda desejada.
O objetivo do desafio é praticar:

Java básico

Entrada de dados com Scanner

Requisições HTTP com HttpURLConnection

Leitura de JSON

Uso da biblioteca Gson

Manipulação de Map e classes modelo

Tratamento de erros

🧠 O que o programa faz?

Pergunta o nome e idade do usuário (humaniza a interface)

Conecta à API de câmbio

Baixa o JSON com todas as taxas de câmbio

Converte o JSON em objeto Java usando Gson

O usuário escolhe:

A moeda de destino (BRL, EUR, JPY, etc.)

O valor em USD que quer converter

O programa calcula e exibe o valor final convertido

Fecha tudo e encerra com uma mensagem simpática 😄

🧩 Tecnologias Utilizadas

Java 17+

Gson (Google)

API ExchangeRate

HttpURLConnection

BufferedReader / InputStreamReader

📡 Como funciona a API utilizada

O programa faz uma requisição GET para:

https://v6.exchangerate-api.com/v6/SEU_API_KEY/latest/USD


A API retorna um JSON com diversas moedas e suas taxas de conversão em relação ao dólar.

📌 Código Principal (Main.java)

O código completo está em Main.java e include:

Classe ExchangeRateResponse para mapear o JSON

Conexão HTTP

Leitura e conversão do JSON

Interface com o usuário

Cálculo final do valor convertido

🚀 Como executar

Instale o Java 17+

Adicione a biblioteca Gson ao classpath

Compile:

javac Main.java


Execute:

java Main

📚 Sobre o Challenge Alura – G9

Este projeto foi desenvolvido como parte do Challenge da Alura para a Turma G9, onde os alunos colocam em prática conceitos fundamentais do curso através da criação de um projeto real.
O objetivo é reforçar lógica, Java, APIs e boas práticas de desenvolvimento.

🧑‍💻 Autor

Projeto desenvolvido durante o Challenge Alura – G9
Criado por: Vinícius Chagas
