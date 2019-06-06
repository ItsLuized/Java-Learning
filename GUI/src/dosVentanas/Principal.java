/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

/**
 *
 * @author CUGSF220
 */
public class Principal extends javax.swing.JFrame implements ActionListener
{
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        suma = new javax.swing.JRadioButton();
        resta = new javax.swing.JRadioButton();
        salir = new javax.swing.JRadioButton();
        multiplicacion = new javax.swing.JRadioButton();
        division = new javax.swing.JRadioButton();
        potencia = new javax.swing.JRadioButton();
        logaritmo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OPERADORA");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        suma.setBackground(new java.awt.Color(255, 255, 255));
        suma.setText("Suma");

        resta.setBackground(new java.awt.Color(255, 255, 255));
        resta.setText("Resta");

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setForeground(new java.awt.Color(255, 51, 51));
        salir.setText("SALIR");

        multiplicacion.setBackground(new java.awt.Color(255, 255, 255));
        multiplicacion.setText("Multiplicacion");

        division.setBackground(new java.awt.Color(255, 255, 255));
        division.setText("Division");

        potencia.setBackground(new java.awt.Color(255, 255, 255));
        potencia.setText("Potenciacion");

        logaritmo.setBackground(new java.awt.Color(255, 255, 255));
        logaritmo.setText("Logaritmacion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(multiplicacion)
                    .addComponent(salir)
                    .addComponent(resta)
                    .addComponent(suma, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(division)
                    .addComponent(potencia)
                    .addComponent(logaritmo))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(suma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(multiplicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(division)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(potencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logaritmo)
                .addGap(18, 18, 18)
                .addComponent(salir)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton division;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton logaritmo;
    private javax.swing.JRadioButton multiplicacion;
    private javax.swing.JRadioButton potencia;
    private javax.swing.JRadioButton resta;
    private javax.swing.JRadioButton salir;
    private javax.swing.JRadioButton suma;
    // End of variables declaration//GEN-END:variables
    //MAS VARIABLES DE CLASE:
    private final ButtonGroup bg;
    //METODOS:
    
    public static void main(String args[]) 
    {
        new Principal();
    }
    
    public Principal() 
    {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.poneaEscuchar();
        this.bg = new ButtonGroup();
        this.inscribirRB();
    }
    
    //De servicio:
    private void poneaEscuchar()
    {
        this.suma.addActionListener(this);
        this.resta.addActionListener(this);
        this.multiplicacion.addActionListener(this);
        this.division.addActionListener(this);
        this.potencia.addActionListener(this);
        this.logaritmo.addActionListener(this);
        this.salir.addActionListener(this);
    }
    
    private void inscribirRB()
    {
        this.bg.add(suma);
        this.bg.add(resta);
        this.bg.add(multiplicacion);
        this.bg.add(division);
        this.bg.add(potencia);
        this.bg.add(logaritmo);
        this.bg.add(salir);        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) 
    {
        if (evento.getSource() == this.suma) 
        {
            this.setVisible(false);
            Operadora ope = new Operadora(1, this);
        }
        if (evento.getSource() == this.resta) 
        {
            this.setVisible(false);
            Operadora ope = new Operadora(2, this);
        }
        if (evento.getSource() == this.multiplicacion) 
        {
            this.setVisible(false);
            Operadora ope = new Operadora(3, this);
        }
        if (evento.getSource() == this.division) 
        {
            this.setVisible(false);
            Operadora ope = new Operadora(4, this);
        }
        if (evento.getSource() == this.potencia) 
        {
            this.setVisible(false);
            Operadora ope = new Operadora(5, this);
        }
        if (evento.getSource() == this.logaritmo) 
        {
            this.setVisible(false);
            Operadora ope = new Operadora(6, this);
        }
        if (evento.getSource() == this.salir) 
        {
            System.exit(0);
        }
    }
}
