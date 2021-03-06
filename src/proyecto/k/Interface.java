package proyecto.k;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Interface extends JFrame {

    public Interface() {

        JFrame frame = new JFrame("Zona de Cobro - H&L Co.");
        frame.setSize(780, 635);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/icono.png"));
        try {
            Fondo fondo = new Fondo(ImageIO.read(new File("src/imagenes/blanco.jpg")));
            JPanel panel = (JPanel) frame.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        ////////TEXT AREA DE LA TABLA//////////////
        JTextField product = new JTextField();
        product.setBounds(30, 40, 180, 30);
        product.requestFocus();
        product.setToolTipText("Ingrese");

        JTextField cantidad = new JTextField();
        cantidad.setBounds(30, 120, 180, 30);
        cantidad.setToolTipText("Ingrese");
        cantidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        JTextField codigo = new JTextField();
        codigo.setBounds(30, 200, 180, 30);
        codigo.requestFocus();
        codigo.setToolTipText("Ingrese");
        codigo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        JTextField precio = new JTextField();
        precio.setBounds(30, 280, 180, 30);
        precio.requestFocus();
        precio.setToolTipText("Ingrese");
        precio.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        //CAJA DE CAMBIO 
        JTextField total = new JTextField();
        total.setBounds(120, 450, 90, 30);
        total.requestFocus();
        total.setBackground(Color.BLACK);
        total.setForeground(Color.GREEN);
        total.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        total.setEditable(false);
        total.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        JTextField recibido = new JTextField();
        recibido.setBounds(120, 490, 90, 30);
        recibido.requestFocus();
        recibido.setBackground(Color.BLACK);
        recibido.setForeground(Color.GREEN);
        recibido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        recibido.setToolTipText("Ingrese el dinero abonado por el cliente");
        recibido.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        JTextField vuelto = new JTextField();
        vuelto.setBounds(120, 530, 90, 30);
        vuelto.requestFocus();
        vuelto.setBackground(Color.BLACK);
        vuelto.setForeground(Color.GREEN);
        vuelto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        vuelto.setEditable(false);
        vuelto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }

            }
        });

        ////////BOTONES DE LA TABLA////////////
        DecimalFormat formato1 = new DecimalFormat("#.##");

        JButton agregar = new JButton("Agregar");
        agregar.setBounds(30, 320, 120, 30);

        JButton actualizar = new JButton("Actualizar");
        actualizar.setBounds(30, 360, 120, 30);

        JButton quitar = new JButton("Quitar");
        quitar.setBounds(30, 400, 120, 30);

        JButton salir = new JButton("Atrás");
        salir.setBounds(650, 550, 100, 30);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea salir del programa?",
                        "Salir",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    LogIn log = new LogIn();
                    log.setVisible(true);
                }
            }
        });

        JButton ok = new JButton("OK");
        ok.setBounds(220, 490, 55, 30);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (recibido.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "No se puede realizar la operacion", "Error", JOptionPane.ERROR_MESSAGE);

                } else {

                    if (total.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "No se puede realizar la operacion", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {

                        double x = Double.valueOf(recibido.getText());
                        double y = Double.valueOf(total.getText());
                        double z = x - y;

                        vuelto.setText(String.valueOf(formato1.format(z)));
                    }
                }
            }

        });

        /////////LABELS ///////////////
        JLabel label = new JLabel("Nombre del Producto:");
        label.setBounds(30, 10, 160, 30);

        JLabel label2 = new JLabel("Código del Producto:");
        label2.setBounds(30, 170, 160, 30);

        JLabel label3 = new JLabel("Precio del Producto:");
        label3.setBounds(30, 250, 160, 30);

        JLabel label4 = new JLabel("Cantidad de Productos:");
        label4.setBounds(30, 90, 170, 30);

        JLabel label5 = new JLabel("Total :");
        label5.setBounds(30, 450, 160, 30);
        label5.setFont(new java.awt.Font("Tahoma", 1, 20));
        label5.setForeground(new java.awt.Color(50, 205, 50));

        JLabel label6 = new JLabel("Recibido :");
        label6.setBounds(30, 490, 160, 30);

        JLabel label7 = new JLabel("Vuelto     :");
        label7.setBounds(30, 530, 160, 30);

        JLabel hora = new JLabel();
        hora.setBounds(30, 565, 200, 40);

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date HorNew = new Date();
                SimpleDateFormat fechaforma = new SimpleDateFormat("dd/MM/YYYY   -   HH:mm:ss");
                String FfechaSystemA = fechaforma.format(HorNew);

                GestorTime.setFfechaSystem(FfechaSystemA);
                hora.setText(GestorTime.getFfechaSystem());
            }
        });
        timer.start();

        ///////////TABLA////////////////
        JTable tabla = new JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        Object[] columns = {"Producto", "Cantidad", "Código", "Precio $"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tabla.setModel(model);
        tabla.setRowHeight(30);
        tabla.setBackground(Color.GREEN);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(300, 20, 450, 450);

        Object[] row = new Object[4];
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (codigo.getText().equals("") || product.getText().equals("") || cantidad.getText().equals("") || precio.getText().equals("")) {

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

                    String a = "";
                    String c = "";
                    double totaly = 0;
                    double ivatotaly = 0;
                    double subtotal = 0;
                    double b = 0;

                    for (int fila = 0; fila < tabla.getRowCount(); fila++) {

                        a = String.valueOf(tabla.getValueAt(fila, 3));
                        c = String.valueOf(tabla.getValueAt(fila, 1));
                        b = Integer.valueOf(a) * Integer.valueOf(c);
                        totaly = totaly + b;
                        ivatotaly = totaly * 5 / 100;
                        subtotal = totaly + ivatotaly;
                    }
                    total.setText(String.valueOf(subtotal));

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

                        String a = "";
                        String c = "";
                        double totaly = 0;
                        double ivatotaly = 0;
                        double subtotal = 0;
                        double b = 0;

                        for (int fila = 0; fila < tabla.getRowCount(); fila++) {

                            a = String.valueOf(tabla.getValueAt(fila, 3));
                            c = String.valueOf(tabla.getValueAt(fila, 1));
                            b = Integer.valueOf(a) * Integer.valueOf(c);
                            totaly = totaly + b;
                            ivatotaly = totaly * 5 / 100;
                            subtotal = totaly + ivatotaly;
                        }
                        total.setText(String.valueOf(subtotal));

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

                int i = tabla.getSelectedRow();

                if (i >= 0) {
                    model.setValueAt(product.getText(), i, 0);
                    model.setValueAt(cantidad.getText(), i, 1);
                    model.setValueAt(codigo.getText(), i, 2);
                    model.setValueAt(precio.getText(), i, 3);

                    String a = "";
                    String c = "";
                    double totaly = 0;
                    double ivatotaly = 0;
                    double subtotal = 0;
                    double b = 0;

                    for (int fila = 0; fila < tabla.getRowCount(); fila++) {

                        a = String.valueOf(tabla.getValueAt(fila, 3));
                        c = String.valueOf(tabla.getValueAt(fila, 1));
                        b = Integer.valueOf(a) * Integer.valueOf(c);
                        totaly = totaly + b;
                        ivatotaly = totaly * 5 / 100;
                        subtotal = totaly + ivatotaly;
                    }
                    total.setText(String.valueOf(subtotal));

                } else {
                    System.out.println("Update Error");
                }
            }
        });

        //////////////DESCUENTOS///////////
        JLabel desc = new JLabel("Descuentos %:");
        desc.setBounds(300, 490, 160, 30);

        JComboBox combo = new JComboBox();
        combo.addItem("-");
        combo.addItem(10);
        combo.addItem(20);
        combo.addItem(30);
        combo.addItem(40);
        combo.addItem(50);
        combo.setBounds(475, 490, 100, 30);

        JButton validar = new JButton("Validar");
        validar.setBounds(650, 490, 100, 30);
        validar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String opcion = combo.getSelectedItem().toString();

                if (opcion.equals("-")) {
                    JOptionPane.showMessageDialog(null, "No hay descuentos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    String a = "";
                    String c = "";
                    double totaly = 0;
                    double ivatotaly = 0;
                    double descuento1 = 0;
                    double subtotal = 0;
                    double total1 = 0;
                    double b = 0;
                    int comb = (int) combo.getSelectedItem();

                    for (int fila = 0; fila < tabla.getRowCount(); fila++) {

                        a = String.valueOf(tabla.getValueAt(fila, 3));
                        c = String.valueOf(tabla.getValueAt(fila, 1));
                        b = Integer.valueOf(a) * Integer.valueOf(c);
                        totaly = totaly + b;
                        ivatotaly = totaly * 5 / 100;
                        subtotal = totaly + ivatotaly;
                        descuento1 = comb * subtotal / 100;
                        total1 = subtotal - descuento1;
                    }
                    total.setText(String.valueOf(total1));
                }
            }

        });

        ////// Boton para generar Ticket //////////
        JButton fin = new JButton("Finalizar");
        fin.setBounds(300, 550, 100, 30);
        fin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea finalizar con la venta?",
                        "Finalizar",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {

                    if (vuelto.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "No se ingreso dinero para la compra de los productos", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {

                        if (respuesta == JOptionPane.YES_OPTION) {
                            TicketDeVenta ticket = new TicketDeVenta();
                            ticket.setVisible(true);
                            ticket.setLocationRelativeTo(null);
                            JTextArea ti = ticket.areaTicket;
                            String opcion = combo.getSelectedItem().toString();

                            tabla.getModel();
                            int nRow = model.getRowCount();
                            ti.append((String) "H&L Co. Software\n");
                            ti.append((String) "-------------------------------------");
                            for (int i = 0; i < nRow; i++) {
                                ti.append((String) "\nProducto = " + tabla.getValueAt(i, 0));
                                ti.append((String) "\nCantidad = x" + tabla.getValueAt(i, 1));
                                ti.append((String) "\nPrecio x Unidad = $" + tabla.getValueAt(i, 3));
                                ti.append((String) "\nCódigo = #" + tabla.getValueAt(i, 2));
                                ti.append("\n");

                            }
                            if (opcion.equals("10")) {
                                ti.append((String) "\n\nDescuento del 10 %");
                            }
                            if (opcion.equals("20")) {
                                ti.append((String) "\n\nDescuento del 20 %");
                            }
                            if (opcion.equals("30")) {
                                ti.append((String) "\n\nDescuento del 30 %");
                            }
                            if (opcion.equals("40")) {
                                ti.append((String) "\n\nDescuento del 40 %");
                            }
                            if (opcion.equals("50")) {
                                ti.append((String) "\n\n\nDescuento del 50 %");
                            }
                            ti.append((String) "\n\nTOTAL = $" + total.getText());
                            ti.append((String) "\nVuelto = $" + vuelto.getText());
                            ti.append((String) "\nIVA del 5 %");
                            ti.append((String) "\n\n\n¡Gracias por su compra!");

                        }

                    }

                }
            }

        });

        JButton limpiar = new JButton("Limpiar");
        limpiar.setBounds(475, 550, 100, 30);
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Limpiar ventana?",
                        "Limpiar",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {

                    product.setText("");
                    cantidad.setText("");
                    codigo.setText("");
                    precio.setText("");
                    total.setText("");
                    recibido.setText("");
                    vuelto.setText("");

                    tabla.getModel();
                    int a = tabla.getRowCount() - 1;
                    for (int i = a; i >= 0; i--) {
                        model.removeRow(model.getRowCount() - 1);
                    }

                }
            }
        });

        ///////////////////////////////////
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
        frame.add(recibido);
        frame.add(total);
        frame.add(vuelto);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(hora);
        frame.add(salir);
        frame.add(ok);
        frame.add(fin);
        frame.add(limpiar);
        frame.add(combo);
        frame.add(desc);
        frame.add(validar);
        frame.setVisible(true);

    }

}
