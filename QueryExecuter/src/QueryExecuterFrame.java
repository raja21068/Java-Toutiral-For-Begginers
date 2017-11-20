
import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JAY KUMAR
 */
public class QueryExecuterFrame extends javax.swing.JFrame {

    StringBuilder db_URL = new StringBuilder("jdbc:mysql://localhost:3306/");
    StringBuilder db_USERNAME = new StringBuilder("root");
    StringBuilder db_PASSWORD = new StringBuilder("root");
    StringBuilder db_NAME = new StringBuilder("school");
    StringBuilder db_driver = new StringBuilder("com.mysql.jdbc.Driver");
    Connection db_Connection = null;

    DatabaseConfigFrame configFrame;
    
    JFileChooser fileChooser;
    FileNameExtensionFilter filterExcel;
    FileNameExtensionFilter filterCSV;
    
    public QueryExecuterFrame() {
        initComponents();
        configFrame = new DatabaseConfigFrame(db_URL, db_NAME, db_USERNAME, db_PASSWORD, db_driver);
        fileChooser = new JFileChooser(new File("../"));
        filterExcel = new FileNameExtensionFilter("(*.xls)", "xls");
        filterCSV = new FileNameExtensionFilter("(*.csv)", "csv");
        labelError.setText("");
        
        new Thread() {
            public void run() {
                try {
                    updateConnection();
                } catch (Exception ex) {
                    labelError.setText(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opupMenuResultTable = new javax.swing.JPopupMenu();
        menuExportResult = new javax.swing.JMenu();
        menuItemExportExcel = new javax.swing.JMenuItem();
        menuItemExportCSV = new javax.swing.JMenuItem();
        scrollPaneTable = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        treeDatabase = new javax.swing.JTree();
        jToolBar1 = new javax.swing.JToolBar();
        buttonDatabase = new javax.swing.JButton();
        buttonExecute = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        textPaneQuery = new javax.swing.JTextPane(new DocumentStyle().getDocumentStyle());
        labelError = new javax.swing.JLabel();

        menuExportResult.setText("Export ResultSet");

        menuItemExportExcel.setText("Export As Excel");
        menuItemExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportExcelActionPerformed(evt);
            }
        });
        menuExportResult.add(menuItemExportExcel);

        menuItemExportCSV.setText("Export As CSV");
        menuItemExportCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportCSVActionPerformed(evt);
            }
        });
        menuExportResult.add(menuItemExportCSV);

        opupMenuResultTable.add(menuExportResult);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPaneTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "0 rows", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Lucida Console", 0, 8))); // NOI18N

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableResult.setComponentPopupMenu(opupMenuResultTable);
        scrollPaneTable.setViewportView(tableResult);

        treeDatabase.setCellRenderer(getDefaultTreeCellRenderer());
        treeDatabase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeDatabaseMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(treeDatabase);

        jToolBar1.setRollover(true);

        buttonDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/db.Schema.32x32.png"))); // NOI18N
        buttonDatabase.setToolTipText("Database");
        buttonDatabase.setFocusable(false);
        buttonDatabase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDatabase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDatabaseActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonDatabase);

        buttonExecute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/Play-icon.png"))); // NOI18N
        buttonExecute.setToolTipText("Execute Query");
        buttonExecute.setFocusable(false);
        buttonExecute.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonExecute.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecuteActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonExecute);

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/sync-icon.png"))); // NOI18N
        buttonRefresh.setToolTipText("Refresh");
        buttonRefresh.setFocusable(false);
        buttonRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });
        jToolBar1.add(buttonRefresh);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("SQL Query Area"));
        jScrollPane4.setViewportView(textPaneQuery);

        labelError.setForeground(new java.awt.Color(255, 0, 0));
        labelError.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTable)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelError)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteActionPerformed
        labelError.setText("");
        emptyTable();
        executeQuery();
    }//GEN-LAST:event_buttonExecuteActionPerformed

    private void buttonDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDatabaseActionPerformed
        configFrame.setVisible(true);
    }//GEN-LAST:event_buttonDatabaseActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
       try{
           updateConnection();
       }catch(Exception ex){
           labelError.setText(ex.getMessage());
           ex.printStackTrace();
       }
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void treeDatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeDatabaseMouseClicked
        if(evt.getClickCount() == 2){
            String s = treeDatabase.getSelectionPath().getLastPathComponent().toString();
            try{
                textPaneQuery.getStyledDocument().insertString(textPaneQuery.getCaretPosition(), s, null);
            }catch(Exception ex){
                ex.printStackTrace(System.err);
                labelError.setText(ex.getMessage());
            }
        }
    }//GEN-LAST:event_treeDatabaseMouseClicked

    private void menuItemExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExportExcelActionPerformed
        fileChooser.setFileFilter(filterExcel);
        int i =fileChooser.showSaveDialog(this);
        if(i<1)exportExcel(fileChooser.getSelectedFile().getAbsolutePath().endsWith(".xls") ?fileChooser.getSelectedFile().getAbsolutePath():fileChooser.getSelectedFile().getAbsolutePath()+".xls"  );
    }//GEN-LAST:event_menuItemExportExcelActionPerformed

    private void menuItemExportCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExportCSVActionPerformed
        fileChooser.setFileFilter(filterCSV);
        int i =fileChooser.showSaveDialog(this);
        if(i<1)exportCSV(fileChooser.getSelectedFile());
    }//GEN-LAST:event_menuItemExportCSVActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QueryExecuterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryExecuterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryExecuterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryExecuterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueryExecuterFrame().setVisible(true);
            }
        });
    }

    private void updateConnection() throws Exception {
        Class.forName(db_driver.toString());
        db_Connection = DriverManager.getConnection(db_URL.toString() + db_NAME.toString(), db_USERNAME.toString(), db_PASSWORD.toString());
        setTitle(db_Connection.toString());
        setTree();
    }

    private void setTree() {
        DefaultTreeModel treeModel = new DefaultTreeModel(null);

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(db_NAME);
        setTablesNode(node);

        treeModel.setRoot(node);
        treeDatabase.setModel(treeModel);
    }

    private void setTablesNode(DefaultMutableTreeNode parentNode) {
        try {
            String query = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA='" + db_NAME + "'";
            Statement st = db_Connection.createStatement();

            ResultSet rs = st.executeQuery(query);
            System.out.println("query executed: " + query);
            while (rs.next()) {
                String table = rs.getString("TABLE_NAME");
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(table);
                setColumnNode(node);
                parentNode.add(node);
            }
        } catch (Exception ex) {
            labelError.setText(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void setColumnNode(DefaultMutableTreeNode parentNode) {
        try {
            String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='" + db_NAME + "' AND TABLE_NAME='" + parentNode.toString() + "'";
            Statement st = db_Connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String column = rs.getString("COLUMN_NAME");
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(column);
                parentNode.add(node);
            }
        } catch (Exception ex) {
            labelError.setText(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private DefaultTreeCellRenderer getDefaultTreeCellRenderer() {
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

//                System.out.println("value: "+value+" - sel:"+sel+" - expanded:"+expanded+" - leaf:"+leaf+" - row:"+row+" - hasFocus:"+hasFocus);
                if (row == 0) {
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/db.Schema.16x16.png")));
                } else if (row != 0 && !leaf) {
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/auto-completion-table.png")));
                }

                return this;
            }
        };

        return renderer;
    }

    private void executeQuery() {
        if(db_Connection == null){
            JOptionPane.showMessageDialog(null, "Please Connection any database");
            return;
        }
        try {
            String query = textPaneQuery.getText();
            Statement st = db_Connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int total = metaData.getColumnCount();
            String[] headings = new String[total];
            for (int i = 1; i <= total; i++) {
                headings[i - 1] = metaData.getColumnName(i);
            }

            DefaultTableModel tableModel = new DefaultTableModel(headings, 0);
            tableResult.setModel(tableModel);

            while (rs.next()) {
                String s[] = new String[headings.length];
                for (int i = 0; i < headings.length; i++) {
                    s[i] = rs.getString(headings[i]);
                }
                tableModel.addRow(s);
            }
            scrollPaneTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, tableResult.getModel().getRowCount()+" rows fetched", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_BOTTOM, new java.awt.Font("Lucida Console", 0, 8))); // NOI18N
            
        } catch (Exception ex) {
            labelError.setText(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void emptyTable(){
        tableResult.setModel(new DefaultTableModel());
    }
    
    private void exportExcel(String filePath) {
        int totalCol = tableResult.getColumnCount();
        ExcelHandler handler = new ExcelHandler(filePath);
        
        String[] columns = new String[totalCol];
        for(int i=0;i<totalCol;i++){
            columns[i] = tableResult.getColumnName(i);
        }
        
        handler.createSheet();
        handler.appendRow(columns);
        
        int tablerows = tableResult.getRowCount();
        for(int rowNo=0;rowNo<tablerows;rowNo++){
            String[] rowData = new String[columns.length];
            for(int columnNo=0;columnNo<rowData.length;columnNo++){
                rowData[columnNo] = (String)tableResult.getValueAt(rowNo, columnNo);
            }
            handler.appendRow(rowData);
        }
        try{
            handler.readyAndClose();
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            labelError.setText(ex.getMessage());
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDatabase;
    private javax.swing.JButton buttonExecute;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelError;
    private javax.swing.JMenu menuExportResult;
    private javax.swing.JMenuItem menuItemExportCSV;
    private javax.swing.JMenuItem menuItemExportExcel;
    private javax.swing.JPopupMenu opupMenuResultTable;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JTable tableResult;
    private javax.swing.JTextPane textPaneQuery;
    private javax.swing.JTree treeDatabase;
    // End of variables declaration//GEN-END:variables

    private void exportCSV(File selectedFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}