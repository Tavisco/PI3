Projeto Integador 3!
===================

## Como subir o banco de dados ##
Por: Otávio Pinheiro

 1. Baixe o Apache Derby clicando [aqui](http://ftp.unicamp.br/pub/apache//db/derby/db-derby-10.13.1.1/db-derby-10.13.1.1-bin.zip);
 2. Descompacte o arquivo zip em um lugar de fácil acesso;
 3. Abra a pasta que acabou de ser gerada e navegue até a pasta LIB, dentro dela você irá encontrar vários arquivos *.jar;
 4.  Ao mesmo tempo que segura shift no teclado, clique com o botão direito em alguma parte **LIVRE, EM BRANCO**, da pasta, no menu que apareceu, clique em `Abrir janela de comando aqui`;
 5. Digite na janela de comando `java -jar derbyrun.jar server start -h 127.0.0.1`
 6. Aguarde aparecer na janela a mensagem `Apache Derby Servidor de Rede - SEU IP - (1765088) iniciado e pronto para aceitar conex§es na porta 1527 em {3}`
 7. Pronto! Banco de dados no ar! Acesse a página de configurações e em seguida adicione uma ação qualquer para popular o banco de dados com dados reais.
