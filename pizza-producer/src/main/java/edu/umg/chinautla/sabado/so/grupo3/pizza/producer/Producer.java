/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.producer;

/**
 *
 * @author jag
 */
public class Producer extends Thread{

	private static final int MAX_SIZE = 3;
	private final List<String> messages = new ArrayList<>();
	
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

	private synchronized void produce() throws Exception {
		
		while(messages.size() == MAX_SIZE){
			Util.getMessageWTS("Limite de la cola alcanzado.  Esperando al consumidor.");
			wait();
			Util.getMessageWTS("Productor obtuvo notificaci[on del consumidor");
		}	
		String data=LocalDateTime.now().toString();
		messages.add(data);
		Util.getMessageWTS("Productor produce data");
		notify();

	}


	private synchronized String consume() throws Exception {
		notify();
		while( messages.isEmpty() ){
			wait();
		}	
		String data = messages.get(0);
		messages.remove(data);
		return data;
	}

}
