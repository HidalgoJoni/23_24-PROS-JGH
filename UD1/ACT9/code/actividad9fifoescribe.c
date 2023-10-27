//actividad9fifoescribe.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    char saludo[] = "Un saludo !!!!!\n";

    // Crear el FIFO solo si no existe
    if (access("FIF02", F_OK) == -1) {  // Verificar si el archivo no existe
        if (mknod("FIF02", S_IFIFO | 0666, 0) == -1) {
            perror("Error al crear el FIFO");
            exit(0);
        }
    }

    fp = open("FIF02", O_WRONLY);

    if (fp == -1) {
        printf("Error al abrir el fichero... \n");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");

    write(fp, saludo, strlen(saludo));
    close(fp);

    return 0;
}