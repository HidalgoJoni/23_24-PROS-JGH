//actividad9fifocrea.c
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main (void) {
    int fp;
    int p, bytesleidos;
    char buffer [100]; // Aumentamos el tamaño del buffer

    p = mknod("FIF02", S_IFIFO|0666, 0);

    if (p == -1) {
        printf("Ha ocurrido un error.... \n");
        exit (0);
    }

    while (1) {
        fp = open ("FIF02", O_RDONLY); // Cambiamos el modo a lectura solamente
        bytesleidos = read(fp, buffer, sizeof(buffer)); // Leemos más bytes
        printf("Obteniendo información...\n");

        while (bytesleidos > 0) {
            printf("%.*s", bytesleidos, buffer); // Utilizamos %.*s para imprimir solo la cantidad de bytes leídos
            bytesleidos = read (fp, buffer, sizeof(buffer)); // leemos más bytes
        }

        close (fp);
    }

    return(0);
}
