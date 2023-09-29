#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int fd1[2], fd2[2];
    pid_t hijo, nieto;

    // Crear los pipes
    if (pipe(fd1) == -1 || pipe(fd2) == -1) {
        fprintf(stderr, "Fallo en pipe");
        return 1;
    }

    hijo = fork();
    if (hijo < 0) {
        fprintf(stderr, "Fallo en fork");
        return 1;
    }

    if (hijo > 0) {  // Proceso Abuelo
        close(fd1[0]);  // Cierra el extremo de lectura del pipe fd1

        char saludo_abuelo[] = "Saludo del abuelo";
        printf("El ABUELO envía un mensaje al HIJO...\n");
        write(fd1[1], saludo_abuelo, strlen(saludo_abuelo) + 1);
        close(fd1[1]);  // Cierra el extremo de escritura del pipe fd1

        // Espera a que el proceso hijo termine
        wait(NULL);

        close(fd2[1]);  // Cierra el extremo de escritura del pipe fd2

        char buffer[100];
        read(fd2[0], buffer, sizeof(buffer));
        printf("El ABUELO recibe mensaje del HIJO: %s\n", buffer);

    } else {  // Proceso Hijo
        close(fd1[1]);  // Cierra el extremo de escritura del pipe fd1

        char buffer[100];
        read(fd1[0], buffer, sizeof(buffer));
        printf("\tEl HIJO recibe mensaje del ABUELO: %s\n", buffer);

        nieto = fork();
        if (nieto < 0) {
            fprintf(stderr, "Fallo en fork");
            return 1;
        }

        if (nieto > 0) {  // Proceso Hijo
            close(fd2[0]);  // Cierra el extremo de lectura del pipe fd2

            char saludo_hijo[] = "Saludo del hijo";
            printf("\tEl HIJO envía un mensaje al NIETO...\n");
            write(fd2[1], saludo_hijo, strlen(saludo_hijo) + 1);
            close(fd2[1]);  // Cierra el extremo de escritura del pipe fd2

            // Espera a que el proceso nieto termine
            wait(NULL);

            read(fd2[0], buffer, sizeof(buffer));
            printf("\tEl HIJO recibe mensaje del NIETO: %s\n", buffer);

            char respuesta_hijo[] = "Respuesta del hijo";
            printf("\tEl HIJO envía un mensaje al ABUELO...\n");
            write(fd1[1], respuesta_hijo, strlen(respuesta_hijo) + 1);

        } else {  // Proceso Nieto
            close(fd2[1]);  // Cierra el extremo de escritura del pipe fd2

            char buffer[100];
            read(fd2[0], buffer, sizeof(buffer));
            printf("\t\tEl NIETO recibe mensaje del HIJO: %s\n", buffer);

            char respuesta_nieto[] = "Respuesta del nieto";
            printf("\t\tEl NIETO envía un mensaje al HIJO...\n");
            write(fd2[1], respuesta_nieto, strlen(respuesta_nieto) + 1);
        }
    }

    return 0;
}
