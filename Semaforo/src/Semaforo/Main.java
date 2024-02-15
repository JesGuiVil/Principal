package Semaforo;

import java.util.Random;
import java.util.concurrent.Semaphore;

class OperarioCinta extends Thread {
    private final Semaphore semaphore;
    private final Random random = new Random();
    private int[] cinta = new int[4];
    int totalRetirados = 0;
    private int totalDepositados = 0;

    public OperarioCinta(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (totalRetirados < 15) {
            try {
                semaphore.acquire();
                int depositados = depositarPaquetes();
                totalDepositados += depositados;
                System.out.println("OperarioCinta deposita " + depositados + " paquetes. Nuevo estado de la cinta: " + java.util.Arrays.toString(cinta));
                semaphore.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Recuento final de paquetes depositados en la cinta: " + totalDepositados);
    }

    private int depositarPaquetes() {
        int depositados = 0;
        for (int i = 0; i < 4; i++) {
            if (cinta[i] == 0) {
                cinta[i] = random.nextInt(3) + 1;
                depositados++;
            }
        }
        return depositados;
    }

    public int[] getCinta() {
        return cinta;
    }

    public synchronized int retirarPaquete(int operarioId) {
        for (int i = 0; i < 4; i++) {
            if (cinta[i] == operarioId) {
                int paquete = cinta[i];
                cinta[i] = 0;
                totalRetirados++;
                return paquete;
            }
        }
        return 0;
    }
}

class Operario extends Thread {
    private final Semaphore semaphore;
    private final OperarioCinta operarioCinta;
    private final int operarioId;
    private int paquetesRecogidos = 0;

    public Operario(Semaphore semaphore, OperarioCinta operarioCinta, int operarioId) {
        this.semaphore = semaphore;
        this.operarioCinta = operarioCinta;
        this.operarioId = operarioId;
    }

    @Override
    public void run() {
        while (operarioCinta.totalRetirados < 15) {
            try {
                semaphore.acquire();
                int paquete = operarioCinta.retirarPaquete(operarioId);
                if (paquete == operarioId) {
                    paquetesRecogidos++;
                    System.out.println("Operario " + operarioId + " retira paquete tipo " + paquete);
                    System.out.println("Nuevo estado de la cinta: " + java.util.Arrays.toString(operarioCinta.getCinta()));
                }
                semaphore.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Operario " + operarioId + " ha recogido un total de " + paquetesRecogidos + " paquetes.");
    }

    public int getPaquetesRecogidos() {
        return paquetesRecogidos;
    }
}

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
