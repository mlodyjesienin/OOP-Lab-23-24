package agh.ics.oop.model;
import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class    SimulationEngine {
    private final List<Simulation> Simulations;
    private final List<Thread> Threads = new ArrayList<>();
    private  ExecutorService executorService;
    public SimulationEngine(List<Simulation> Simulations){
        this.Simulations = Simulations;
    }
    public void runSync(){
        for(Simulation specificSimulation : Simulations){
            specificSimulation.run();
        }
    }
    public void runAsync() throws InterruptedException {
        for(Simulation specificSimulation : Simulations){
            Thread thread =  new Thread(specificSimulation);
            Threads.add(thread);
            thread.start();
        }
        try {
            awaitSimulationsEnd();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void runAsyncInThreadPool() throws InterruptedException {
        executorService = Executors.newFixedThreadPool(4);
        for(Simulation specificSimulation : Simulations){
            executorService.submit(specificSimulation);
        }
        awaitSimulationsEndThreadPool();
    }
    private void awaitSimulationsEnd() throws InterruptedException {
        for(Thread thread: Threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void awaitSimulationsEndThreadPool() {
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException exception){
            throw new RuntimeException(exception);
        }

    }
}
