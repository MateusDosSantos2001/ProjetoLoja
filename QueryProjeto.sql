CREATE TABLE JOGOS (
Id INT AUTO_INCREMENT, 
Nome VARCHAR(64),
Gênero VARCHAR(64),
Data_de_lançamento DATE,
Descrição VARCHAR(1024),
Avaliação DOUBLE,
Preço DOUBLE,
PRIMARY KEY(Id)
);


INSERT INTO JOGOS VALUES (1, 'Detroit: Become Human', 'Aventura de ação, Mundo aberto, Terceira pessoa', '2018-04-24', 'Inspirado no curta chamado "Kara", Detroit é um thriller neo-noir ambientado na cidade de Detroit, em um futuro próximo. Os andróides, que se parecem exatamente com seres humanos, substituíram os seres humanos na maioria das tarefas: são trabalhadores, babás, jardineiros, enfermeiras, professores, funcionários. A história de Detroit começa com um incidente inexplicável que começa a afetar os Androids. Alguns desaparecem sem nenhuma explicação, outros têm comportamentos inesperados e estranhamente mostram sinais de emoções. Os rumores de andróides "desviantes" começam a se espalhar, mas ninguém parece saber o que realmente está acontecendo.', 8.7, 99), (2, 'Mineirinho', 'Realista, 3D, Ação e aventura', '2017-01-27', 'Jogo muito bom para se divertir com a familia e amigos e não quebrar o computador.', 10, 1);
