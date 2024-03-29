/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.pcb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jag
 */
public class FThreadChinautla extends javax.swing.JFrame {

    /**
     * Creates new form FThreadChinautla
     */
    public FThreadChinautla() {
        initComponents();
        pizzaAleatoria = new Random();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChef = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOrden = new javax.swing.JTextField();
        txtPizza = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCliente = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtChef.setEditable(false);
        txtChef.setColumns(20);
        txtChef.setRows(5);
        jScrollPane1.setViewportView(txtChef);

        jLabel1.setText("# de orden:");

        jLabel2.setText("Pizza actual:");

        txtOrden.setEditable(false);
        txtOrden.setText("jTextField1");

        txtPizza.setEditable(false);
        txtPizza.setText("jTextField2");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel3.setText("Chef (Productor)");

        txtCliente.setEditable(false);
        txtCliente.setColumns(20);
        txtCliente.setRows(5);
        jScrollPane2.setViewportView(txtCliente);

        jLabel4.setText("Cliente (consumidor)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciar)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(txtPizza))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(txtOrden)))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnIniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        limpiaCampos();
        try{
            iniciaHilos();
        }catch(Exception e){
        }
        numeroDeOrden = 0;
    }//GEN-LAST:event_btnIniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FThreadChinautla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FThreadChinautla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FThreadChinautla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FThreadChinautla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FThreadChinautla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtChef;
    private javax.swing.JTextArea txtCliente;
    private javax.swing.JTextField txtOrden;
    private javax.swing.JTextField txtPizza;
    // End of variables declaration//GEN-END:variables

 
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




    private void limpiaCampos() {
        txtOrden.setText("");
        txtPizza.setText("");
        txtChef.setText("");
        txtCliente.setText("");
    }


    private void iniciaHilos() throws InterruptedException {
        limpiaCampos();

        // Object of a class that has both producePizza()
        // and consume() methods
        final ThreadChinautla.ProductorConsumidor pc = new ThreadChinautla.ProductorConsumidor();
 
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



    /** Devuelve una pizza de manera aleatoria*/
    public String getSiguientePizza(){
        return listaPizzas.get( pizzaAleatoria.nextInt( listaPizzas.size() ) );
    }



    /** Pone una pizza en el plato.  Deja lleno el plato.*/
    public void producePizza() throws InterruptedException
    {
        String ppMsg="";
        while (true) {
            synchronized (this)
            {
                // Si el plato esta lleno, esperamos
                while ( plato.size() == capacity )
                    wait();

                pizzaActual = getSiguientePizza();
                numeroDeOrden++;
                pizzaActual += "-"+numeroDeOrden;
                ppMsg = "Chef (productor) preparo y horneo la pizza de: " + pizzaActual+ ", numero de orden: "+numeroDeOrden;
                System.out.println(ppMsg);
                this.txtOrden.setText( Integer.toString(numeroDeOrden) );
                this.txtPizza.setText(pizzaActual);
                this.txtChef.setText(ppMsg);


                // Pone la pizza en el plato
                plato.add( pizzaActual );

                // Le notifica al cliente que se coma la pizza
                notify();

                this.repaint();
this.txtChef.repaint();
super.repaint();

                // Espera un segundo
                Thread.sleep(3000);

            }
        }
    }

    /** Obtiene una pizza del plato y deja el plato vacio.*/
    public void consumePizza() throws InterruptedException
    {
        String cpMsg="";
        while (true) {
            synchronized (this)
            {
                // Si el plato esta vacio, espera
                while (plato.size() == 0)
                    wait();

                // Obtiene la pizza del plato
                pizzaActual = plato.removeFirst();
                cpMsg="Cliente (consumidor) disfruta comiendo su pizza de: " + pizzaActual;
                System.out.println(cpMsg);
                this.txtCliente.setText(cpMsg);


                // Le notifica al chef que el plato esta vacio
                notify();

                this.repaint();

                // Espera un segundo
                Thread.sleep(3000);
            }
        }
    }







}
