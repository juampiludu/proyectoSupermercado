DefaultTableModel dtm = (DefaultTableModel) 
jTable1.getModel(); 
int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount(); 
Object[][] tableData = new Object[nRow][nCol]; 
for (int i = 0 ; i < nRow ; i++) 
for (int j = 0 ; j < nCol ; j++) 
tableData[i][j] = dtm.getValueAt(i,j); 
for (int i = 0 ; i < nRow ; i++){ 
for (int j = 0 ; j < nCol ; j++){ 
jrecieptArea1.append((String) tableData[i][j] ); 
jrecieptArea1.append("\t"); } 
} 
}
