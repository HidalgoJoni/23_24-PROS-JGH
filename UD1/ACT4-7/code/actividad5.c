#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

void crearHijos(int n, pid_t padre) {
    if (n <= 0) {
        return;
    }

    pid_t pid = fork();

    if (pid == 0) {
        printf("Yo soy el hijo %d, mi padre es PID= %d, yo soy PID= %d\n", 6 - n, padre, getpid());
        crearHijos(n - 1, getpid());
        _exit(0);
    } else if (pid < 0) {
        fprintf(stderr, "Error al crear el hijo %d\n", 6 - n);
    } else {
        wait(NULL);
    }
}

int main() {
    int n = 4; // Cambia este valor para ajustar el número de hijos

    printf("Soy el proceso padre con PID %d\n", getpid());

    crearHijos(n, getpid());

    return 0;
}
