/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.pcb;


// Java program to implement solution of producePizzar
// consumer problem.
 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 *  Implementa una solucion al problema de productor/consumidor
 * @author jag
 */ 
public class ThreadChinautla {

    /**
    */
    public static void main(String[] args) throws InterruptedException
    {
        // Object of a class that has both producePizza()
        // and consume() methods
        final ProductorConsumidor pc = new ProductorConsumidor();
 
        // Create producePizzar thread
        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.producePizza();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        // Create consumer thread
        Thread hilo2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consumePizza();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        // Start both threads
        hilo1.start();
        hilo2.start();
 
        // hilo1 finishes before hilo2
        hilo1.join();
        hilo2.join();
    }


 
    // This class has a list, producePizzar (adds items to list
    // and consumer (removes items).
    public static class ProductorConsumidor {
 
        // El plato es un listado compartido por el productor y el consumidor.
        LinkedList<String> plato = new LinkedList<>();
        // La capacidad es de 2 
        int capacity = 1;

        // Tiene el listado de pizzas disponibles    
        private List<String> listaPizzas = Arrays.asList("Pepperoni", "Margarita", "Jamón y Queso", "Jamon y Hongos", "La Suprema");
        // Permitira obtener una pizza de manera aleatoria.
        private Random pizzaAleatoria;
        private String pizzaActual="";
        private int numeroDeOrden=0;


        public ProductorConsumidor()
        {
            pizzaAleatoria = new Random();
            numeroDeOrden=0;
        }

        /** Devuelve una pizza de manera aleatoria*/
        public String getSiguientePizza(){
            return listaPizzas.get( pizzaAleatoria.nextInt( listaPizzas.size() ) );
        }


 
        /** Pone una pizza en el plato.  Deja lleno el plato.*/
        public void producePizza() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // Si el plato esta lleno, esperamos
                    while ( plato.size() == capacity )
                        wait();

                    pizzaActual = getSiguientePizza();
                    numeroDeOrden++;
                    pizzaActual += "-"+numeroDeOrden;
                    System.out.println("Chef (productor) preparo y horneo la pizza de: " + pizzaActual+ ", numero de orden: "+numeroDeOrden);
 
                    // Pone la pizza en el plato
                    plato.add( pizzaActual );
 
                    // Le notifica al cliente que se coma la pizza
                    notify();
 
                    // Espera un segundo
                    Thread.sleep(300);
                }
            }
        }
 
        /** Obtiene una pizza del plato y deja el plato vacio.*/
        public void consumePizza() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // Si el plato esta vacio, espera
                    while (plato.size() == 0)
                        wait();
 
                    // Obtiene la pizza del plato
                    pizzaActual = plato.removeFirst();
 
                    System.out.println("Cliente (consumidor) disfruta comiendo su pizza de: " + pizzaActual);
 
                    // Le notifica al chef que el plato esta vacio
                    notify();
 
                    // Espera un segundo
                    Thread.sleep(300);
                }
            }
        }


    }
}