/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.producer;

/**
 *
 * @author jag
 */
public class Consumer extends Thread{

    private Producer productor;
	
	public Consumer(Producer paramProductor){
		this.productor=paramProductor;
	}

	@Override
	public void run(){
		try{
			while(true){
				String data=productor.consume();
				Util.getMessageWTS("Consumido por: "+Thread.currentThread().getName() + ", data: " + data);
			}
		}catch (Exception e){
			Util.printException("Producer.run", e);
		}
	}

}
