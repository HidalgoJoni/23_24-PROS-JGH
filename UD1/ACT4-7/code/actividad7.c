#include <stdio.h>
#include <unistd.h>

int main() {
    int valor = 6;
    printf("Valor inicial de la variable: %d\n", valor);

    pid_t pid = fork();

    if (pid == 0) {
        valor -= 5;
        printf("Variable en Proceso Hijo: %d\n", valor);
    } else if (pid > 0) {
        valor += 5;
        printf("Variable en Proceso Padre: %d\n", valor);
    } else {
        fprintf(stderr, "Error al crear el proceso hijo.\n");
    }

    return 0;
}
