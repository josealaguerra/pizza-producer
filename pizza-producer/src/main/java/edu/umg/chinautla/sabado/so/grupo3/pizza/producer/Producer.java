/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.producer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jag
 */
public class Producer extends Thread{

    private List<String> listaPizzas = Arrays.asList("Pepperoni", "Margarita", "Jamón y QUeso", "Jamon y Hongos","La Suprema");
    private Random pizzaAleatoria;
    private String data = null;
    private static final int MAX_SIZE = 5;
    private final List<String> messages = new ArrayList<>();


    public Producer(){
        pizzaAleatoria = new Random();
    }

    public String getSiguientePizza(){
        return listaPizzas.get( pizzaAleatoria.nextInt( listaPizzas.size() ) );
    }


    @Override
    public void run(){
        try{
            while(true){
                produce();
            }
        }catch (Exception e){
            Util.printException("Producer.run", e);
        }
    }


    public synchronized void produce() throws Exception {
        while(messages.size() == MAX_SIZE){
            Util.getMsgWTS("Limite de la cola alcanzado.  Esperando al consumidor.");
            wait();
            Util.getMsgWTS("Productor obtuvo notificaci[on del consumidor");
        }	
        //data = LocalDateTime.now().toString();
        data = getSiguientePizza();
        messages.add( data );
        Util.getMsgWTS("Productor produce pizza de: "+data);
        notify();
    }


    public synchronized String consume() throws Exception {
        notify();
        while( messages.isEmpty() ){
            wait();
        }	
        String data = messages.get(0);
        messages.remove(data);
        return data;
    }

}
