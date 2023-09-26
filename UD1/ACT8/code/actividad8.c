#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void imprimir_mensaje(const char *mensaje) {
    printf("%s", mensaje);
    fflush(stdout);
}

int main() {
    int fd1[2], fd2[2];
    char buffer[100];
    pid_t pid_hijo, pid_nieto;

    if (pipe(fd1) == -1 || pipe(fd2) == -1) {
        perror("Error al crear los pipes");
        exit(-1);
    }

    pid_hijo = fork();

    if (pid_hijo == -1) {
        perror("Error al crear el proceso hijo");
        exit(-1);
    }

    if (pid_hijo == 0) {
        // Proceso nieto

        close(fd1[1]); // Cierra el extremo de escritura de fd1
        close(fd2[0]); // Cierra el extremo de lectura de fd2

        read(fd1[0], buffer, sizeof(buffer));
        imprimir_mensaje(buffer);

        char mensaje_nieto[] = "El NIETO envia un mensaje al HIJO.....\n";
        write(fd2[1], mensaje_nieto, sizeof(mensaje_nieto));

        exit(0);
    } else {
        pid_nieto = fork();

        if (pid_nieto == -1) {
            perror("Error al crear el proceso nieto");
            exit(-1);
        }

        if (pid_nieto == 0) {
            // Proceso hijo

            close(fd1[0]); // Cierra el extremo de lectura de fd1
            close(fd2[1]); // Cierra el extremo de escritura de fd2

            char mensaje_hijo[] = "El HIJO envia un mensaje al NIETO.....\n";
            write(fd1[1], mensaje_hijo, sizeof(mensaje_hijo));

            read(fd2[0], buffer, sizeof(buffer));
            imprimir_mensaje(buffer);

            char mensaje_nieto2[] = "El NIETO envia un mensaje al HIJO.....\n";
            write(fd1[1], mensaje_nieto2, sizeof(mensaje_nieto2));

            exit(0);
        } else {
            // Proceso abuelo

            close(fd1[0]); // Cierra el extremo de lectura de fd1
            close(fd2[1]); // Cierra el extremo de escritura de fd2

            char mensaje_abuelo[] = "El ABUELO envia un mensaje al HIJO....\n";
            write(fd1[1], mensaje_abuelo, sizeof(mensaje_abuelo));

            wait(NULL);
            wait(NULL);

            read(fd2[0], buffer, sizeof(buffer));
            imprimir_mensaje(buffer);

            exit(0);
        }
    }

    return 0;
}
