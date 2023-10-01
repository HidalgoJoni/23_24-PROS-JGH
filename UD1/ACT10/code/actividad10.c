#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

void handle_signal(int signal) {
    printf("Padre recibe señal...%d\n", signal);
}

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Error en fork\n");
        exit(1);
    }

    if (pid > 0) {  // Proceso padre
        signal(SIGUSR1, handle_signal);

        // El proceso padre espera que el hijo termine
        wait(NULL);
    } else {  // Proceso hijo

        // Enviar tres señales SIGUSR1 al proceso padre
        kill(getppid(), SIGUSR1);
        sleep(1);
        kill(getppid(), SIGUSR1);
        sleep(1);
        kill(getppid(), SIGUSR1);
        sleep(1);

        // Enviar una señal SIGKILL para terminar el proceso padre
        kill(getppid(), SIGKILL);
    }

    return 0;
}