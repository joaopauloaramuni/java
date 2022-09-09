#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <netdb.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <sys/socket.h>

void utilizacao()
{
   printf ("Uso: http <host> <port> <arquivo>\n");
   exit(-1);   
}

int main (int argc, char *argv[])
{
   char linha[300];
   char resposta[300];
   FILE *in;
   int mysocket, port;
   struct hostent *he;
   struct sockaddr_in hostend;
   
   /* Obtem parametros */
   if (argc != 4)
      utilizacao();
   
   if ((port = atoi(argv[2])) < 1)
      utilizacao();

   /* Consulta a base de dados de hosts para retornar o endereco
    * a partir do nome.
    */
   if ((he=gethostbyname(argv[1])) == NULL) {
      herror ("Host invalido");
      return -1;
   }

   /* Cria um ponto de comunicacao e retorna seu descritor */
   if ((mysocket = socket (AF_INET, SOCK_STREAM, 0)) == -1) {
      perror ("socket");
      return -1;
   }

   /* Configura o endereco e a porta de conexao.
    * Obs: htons converte valores entre a ordem de bytes
    * do host e da rede.
    */
   hostend.sin_family = AF_INET;
   hostend.sin_port   = htons(port);
   hostend.sin_addr   = *((struct in_addr *)he->h_addr);

   /* Inicia a conexao com um socket remoto */
   if (connect (mysocket, (struct sockaddr*)&hostend,
            sizeof(struct sockaddr)) == -1) {
      perror ("connect");
      return -1;
   }
   
   /* Abre o arquivo que contem o comando HTTP
    */
   if (!(in = fopen(argv[3],"r"))) {
      perror ("Abertura do arquivo");
      return -1;
   }

   /* Le o comando do arquivo e envia para o servidor
    */
   memset(linha,0,sizeof(linha));
   while (fgets (linha, sizeof(linha)-1, in)) {
     if (send (mysocket, linha, strlen(linha), 0) == -1) {
        perror ("send");
        return -1;
     }
     
     memset(linha,0,sizeof(linha));
   }
   
   fclose(in);
   
   /* Obtem a resposta do servidor
    */
   memset (resposta, 0, sizeof(resposta));
   while (recv (mysocket, resposta, sizeof(resposta)-1, 0)) {
     printf("%s", resposta);
     memset (resposta, 0, sizeof(resposta));
   }

   return 0;
} 
