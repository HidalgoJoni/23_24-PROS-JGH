#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid_padre = getpid(); // Obtenemos el PID del padre antes de crear los hijos
    pid_t pid1, pid2, pid3;
    
    // Crear el primer hijo
    pid1 = fork();
    
    if (pid1 == 0) {
        // Código del primer hijo
        printf("Soy el hijo 1, Mi padre es %d y mi PID es %d\n", pid_padre, getpid());
    } else if (pid1 > 0) {
        // Crear el segundo hijo
        pid2 = fork();
        
        if (pid2 == 0) {
            // Código del segundo hijo
            printf("Soy el hijo 2, Mi padre es %d y mi PID es %d\n", pid_padre, getpid());
        } else if (pid2 > 0) {
            // Crear el tercer hijo
            pid3 = fork();
            
            if (pid3 == 0) {
                // Código del tercer hijo
                printf("Soy el hijo 3, Mi padre es %d y mi PID es %d\n", pid_padre, getpid());
            } else if (pid3 > 0) {
                // Código del padre
                printf("Proceso padre %d\n", pid_padre);
            } else {
                fprintf(stderr, "Error al crear el tercer hijo\n");
            }
        } else {
            fprintf(stderr, "Error al crear el segundo hijo\n");
        }
    } else {
        fprintf(stderr, "Error al crear el primer hijo\n");
    }

    return 0;
}
