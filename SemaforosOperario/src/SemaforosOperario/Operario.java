package SemaforosOperario;

import java.util.concurrent.Semaphore;

import SemaforosOperario.OperarioCinta;

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