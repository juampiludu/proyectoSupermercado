/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.k;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;


/**
 *
 * @author diegacho
 */

public class PDF {
    

Document documento = new Document() {
    @Override
    public int getLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDocumentListener(DocumentListener dl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeDocumentListener(DocumentListener dl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUndoableEditListener(UndoableEditListener ul) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUndoableEditListener(UndoableEditListener ul) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProperty(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putProperty(Object o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int i, int i1) throws BadLocationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getText(int i, int i1) throws BadLocationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getText(int i, int i1, Segment sgmnt) throws BadLocationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position getStartPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position getEndPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position createPosition(int i) throws BadLocationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Element[] getRootElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Element getDefaultRootElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Runnable r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
};  
FileOutputStream ficheroPdf;
try 
{
    try {
        ficheroPdf = new FileOutputStream("/home/ejemplos/ejemplo.PDF");
    } catch (FileNotFoundException ex) {
        Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
    }
 PdfWriter.getInstance(
                       documento, 
                       ficheroPdf
                       ).setInitialLeading(20);
}
catch (Exception ex) 
{
 System.out.println(ex.toString());
}
try{
    documento.open();
    documento.add(new Paragraph("nuestro texto"));
    Paragraph parrafo2 = new Paragraph("nuestro segundo Texto");
    parrafo2.setAlignment(1);//el 1 es para centrar
    documento.add(parrafo2);
    documento.add(new Paragraph(" "));
    PdfPTable tabla = new PdfPTable(3);
    //el numero indica la cantidad de Columnas
    tabla.addCell("celda1");
    tabla.addCell("celda2");
    tabla.addCell("celda3");
    tabla.addCell("celda4");
    tabla.addCell("celda5");
    tabla.addCell("celda6");
    // esto nos crea una tabla de 3 Columnas por dos Filas
    documento.add(tabla);
    documento.add(new Paragraph(" "));
    PdfPTable tabla2 = new PdfPTable(3);
    PdfPCell celda = new PdfPCell(
                       new Paragraph("celda \nmodificada")
                                 );
    celda.setColspan(2);
   //cantidad de columnas que ocupa esta celda
    celda.setRowspan(2);
   //cantidad de filas que ocupa esta celda
    tabla2.addCell(celda);
    tabla2.addCell("celda5");
    tabla2.addCell("celda6");
    tabla2.addCell("celda7");
    tabla2.addCell("celda8");
    tabla2.addCell("celda9");
    documento.add(tabla2);
    documento.close();



}