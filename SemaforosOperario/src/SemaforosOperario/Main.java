package SemaforosOperario;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        OperarioCinta operarioCinta = new OperarioCinta(semaphore);
        Operario operario1 = new Operario(semaphore, operarioCinta, 1);
        Operario operario2 = new Operario(semaphore, operarioCinta, 2);
        Operario operario3 = new Operario(semaphore, operarioCinta, 3);

        operarioCinta.start();
        operario1.start();
        operario2.start();
        operario3.start();
    }
}