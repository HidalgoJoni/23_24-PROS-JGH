//actividad9fifocrea.c
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    int bytesleidos;
    char buffer[100]; // Aumentamos el tamaño del buffer

    while (1) {
        fp = open("FIF02", O_RDONLY); // Cambiamos el modo a lectura solamente

        if (fp == -1) {
            printf("Error al abrir el fichero... \n");
            exit(1);
        }

        printf("Obteniendo información...\n");

        while ((bytesleidos = read(fp, buffer, sizeof(buffer))) > 0) {
            printf("%.*s", bytesleidos, buffer); // Utilizamos %.*s para imprimir solo la cantidad de bytes leídos
        }

        close(fp);
    }

    return 0;
}