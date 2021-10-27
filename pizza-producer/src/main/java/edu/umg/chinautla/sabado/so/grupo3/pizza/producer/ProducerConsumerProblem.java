/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.producer;

/**
 *
 * @author jag
 */
public class ProducerConsumerProblem {

    public void main(String []args){
		
		Producer p = new Producer();
		p.setName("Chef 1");
		p.setStart();
		
		Consumer c = new Consumer(p);
		c.setName("Cliente 1");
		c.setStart();
		
	}
}
