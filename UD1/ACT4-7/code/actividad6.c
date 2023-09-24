#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid1, pid2, pid3;

    printf("Soy el proceso padre con PID %d\n", getpid());

    pid1 = fork();

    if (pid1 == 0) {
        printf("Yo soy el hijo 1, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());

        pid3 = fork();

        if (pid3 == 0) {
            printf("Yo soy el hijo 3, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        }

        wait(NULL);
    } else {
        pid2 = fork();

        if (pid2 == 0) {
            printf("Yo soy el hijo 2, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        }

        wait(NULL);
        wait(NULL);
    }

    return 0;
}
