/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dosVentanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luized
 */
public class Operadora extends javax.swing.JFrame implements ActionListener
{
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Dato1 = new javax.swing.JLabel();
        Dato2 = new javax.swing.JLabel();
        dato1 = new javax.swing.JTextField();
        dato2 = new javax.swing.JTextField();
        BotonAccion = new javax.swing.JButton();
        resultado = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OPERADORA");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        Dato1.setText("Dato 1:");
        Dato1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Dato2.setText("Dato 2:");
        Dato2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dato1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        dato2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        BotonAccion.setForeground(new java.awt.Color(51, 102, 255));
        BotonAccion.setText("ACCION");
        BotonAccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonAccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotonAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAccionActionPerformed(evt);
            }
        });

        resultado.setText("Resultado:");
        resultado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Resultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Resultado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BotonRegresar.setForeground(new java.awt.Color(255, 0, 0));
        BotonRegresar.setText("BACK");
        BotonRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        BotonLimpiar.setForeground(new java.awt.Color(0, 153, 0));
        BotonLimpiar.setText("LIMPIAR");
        BotonLimpiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dato2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Dato1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dato1)
                            .addComponent(dato2)
                            .addComponent(BotonAccion, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(Resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dato1)
                    .addComponent(dato1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dato2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dato2))
                .addGap(18, 18, 18)
                .addComponent(BotonAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(BotonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
    private void BotonAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAccionActionPerformed
    }//GEN-LAST:event_BotonAccionActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAccion;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JLabel Dato1;
    private javax.swing.JLabel Dato2;
    private javax.swing.JLabel Resultado;
    private javax.swing.JTextField dato1;
    private javax.swing.JTextField dato2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel resultado;
    // End of variables declaration//GEN-END:variables
     //MAS VARIABLES DE CLASE:
    private int caso;
    private Principal principal;
    //METODOS:
    
    public Operadora(int caso, Principal principal) 
    {
        initComponents();
        this.caso = caso;
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.poneaEscuchar();
        this.principal = principal;
    }
    
    //De servicio:
    private void poneaEscuchar()
    {
        this.BotonAccion.addActionListener(this);
        this.BotonLimpiar.addActionListener(this);
        this.BotonRegresar.addActionListener(this);
    }
    
    private void Operador()
    {
        float a, b, c;
        //tomar los valores de las cajitas
        a = Float.parseFloat(this.dato1.getText());
        b = Float.parseFloat(this.dato2.getText());
        // caso se escoge
        switch (this.caso) {
            case 1:
                c = a + b;
                break;
            case 2:
                c = a - b;
                break;
            case 3:
                c = a * b;
                break;
            case 4:
                c = a / b;
                break;
            case 5:
                c = (float)(Math.pow(a, b));
                break;
            case 6://log b(n) = ln(n) / ln(b)
                c = (float)(Math.log(a) / Math.log(b));
                break;
            default:
                throw new AssertionError();
        }
        //muestra en la cajita resultados
        this.Resultado.setText(String.valueOf(String.format("%.2f",c)));
    }
    
    private void Limpiador()
    {
        this.dato1.setText("");
        this.dato2.setText("");  
        this.Resultado.setText("");
        this.dato1.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) 
    {
        if (evento.getSource() == this.BotonAccion) 
        {
            this.Operador();
        }
        if (evento.getSource() == this.BotonLimpiar) 
        {
            this.Limpiador();
        }
        if (evento.getSource() == this.BotonRegresar) 
        {
            this.dispose();
            this.principal.setVisible(true);
        }
    }
}
