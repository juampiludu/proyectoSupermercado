package proyecto.k;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Interface extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Zona de Cobro - H&L Co.");
        frame.setSize(780, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.lightGray);

        //////////////////////
        JTextField product = new JTextField();
        product.setBounds(30, 40, 180, 30);
        product.requestFocus();

        JTextField cantidad = new JTextField();
        cantidad.setBounds(30, 120, 180, 30);

        JTextField codigo = new JTextField();
        codigo.setBounds(30, 200, 180, 30);
        codigo.requestFocus();

        JTextField precio = new JTextField();
        precio.setBounds(30, 280, 180, 30);
        precio.requestFocus();
 
        //CAJA DE CAMBIO 
        JTextField dinero = new JTextField();
        dinero.setBounds(120,450,90,30);
        dinero.requestFocus();
        dinero.setBackground(Color.BLACK);
        dinero.setForeground(Color.GREEN);
        dinero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JTextField total = new JTextField();
        total.setBounds(120,490,90,30);
        total.requestFocus();
        total.setBackground(Color.BLACK);
        total.setForeground(Color.GREEN);
        total.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JTextField vuelto = new JTextField();
        vuelto.setBounds(120,530,90,30);
        vuelto.requestFocus();
        vuelto.setBackground(Color.BLACK);
        vuelto.setForeground(Color.GREEN);
        vuelto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       
        ////////////////////
        JButton agregar = new JButton("Agregar");
        agregar.setBounds(30, 320, 120, 30);

        JButton actualizar = new JButton("Actualizar");
        actualizar.setBounds(30, 360, 120, 30);

        JButton quitar = new JButton("Quitar");
        quitar.setBounds(30, 400, 120, 30);

        /////////////////////////
        JLabel label = new JLabel("Nombre del Producto:");
        label.setBounds(30, 10, 160, 30);

        JLabel label2 = new JLabel("Código del Producto:");
        label2.setBounds(30, 170, 160, 30);

        JLabel label3 = new JLabel("Precio del Producto:");
        label3.setBounds(30, 250, 160, 30);

        JLabel label4 = new JLabel("Cantidad de Productos:");
        label4.setBounds(30, 90, 170, 30);
        
        JLabel label5 = new JLabel ("Dinero  :");
        label5.setBounds(30,450,160,30);
        
        
        JLabel label6 = new JLabel ("Total     :");
        label6.setBounds(30,490,160,30);
        
        JLabel label7 = new JLabel ("Vuelto   :");
        label7.setBounds(30,530,160,30);
        
   
        ///////////////////////////
        JTable tabla = new JTable();
        Object[] columns = {"Producto", "Cantidad", "Código", "Precio $"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tabla.setModel(model);
        tabla.setRowHeight(30);
        tabla.setBackground(Color.GREEN);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(300, 20, 450, 500);

        Object[] row = new Object[4];
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (codigo.getText().equals("")) {

                } else {
                    row[0] = product.getText();
                    row[1] = cantidad.getText();
                    row[2] = codigo.getText();
                    row[3] = precio.getText();

                    model.addRow(row);

                    product.setText("");
                    cantidad.setText("");
                    codigo.setText("");
                    precio.setText("");
                }

            }

        });

        quitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea quitar el producto?",
                        "Quitar Producto",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {
                    int i = tabla.getSelectedRow();
                    if (i >= 0) {
                        model.removeRow(i);
                    } else {
                        System.out.println("Delete Error");
                    }
                }

            } 
        
        });

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int i = tabla.getSelectedRow();
                product.setText(model.getValueAt(i, 0).toString());
                cantidad.setText(model.getValueAt(i, 1).toString());
                codigo.setText(model.getValueAt(i, 2).toString());
                precio.setText(model.getValueAt(i, 3).toString());

            }
        });

        actualizar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    model.setValueAt(product.getText(), i, 0);
                    model.setValueAt(cantidad.getText(), i, 1);
                    model.setValueAt(codigo.getText(), i, 2);
                    model.setValueAt(precio.getText(), i, 3);
                } else {
                    System.out.println("Update Error");
                }
            }
        });

        frame.add(product);
        frame.add(label);
        frame.add(label2);
        frame.add(precio);
        frame.add(label3);
        frame.add(label4);
        frame.add(codigo);
        frame.add(agregar);
        frame.add(actualizar);
        frame.add(quitar);
        frame.add(scroll);
        frame.add(cantidad);
        frame.add(dinero);
        frame.add(total);
        frame.add(vuelto);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.setVisible(true);

    }

}
