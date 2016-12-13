/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package perpus_er;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Student
 */
public class FAnggota extends javax.swing.JFrame {
    public DefaultTableModel tabModel;
    Connection conn;
    /**
     * Creates new form FAnggota
     */
    public FAnggota() {
        initComponents();
        setJTable();
        BSimpan.setEnabled(false);
        BBatal.setEnabled(false);
    }
    
    
    public void hapus_Data() {
        // Konfirmasi sebelum melakukan penghapusan data
        ambilData_dari_JTable();
        int ok = JOptionPane.showConfirmDialog(this,
            "Anda Yakin Ingin Menghapus Data\nDengan No Anggota = '" + txtNoAnggota.getText() +
            "'", "Konfirmasi Menghapus Data",JOptionPane.YES_NO_OPTION);
        if (ok == 0) {     // Apabila tombol OK ditekan
          try {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
            String sql = "DELETE FROM Anggota WHERE NoAnggota = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtNoAnggota.getText());
            int rs=st.executeUpdate();
            if(rs>0){
            tampilDataKeJTable();
            JOptionPane.showMessageDialog(this,"Data Sudah dihapus");
            }
            txtNoAnggota.setText("");
            txtNama.setText("");
            txtAlamat.setText("");
          } catch (Exception se) {  // Silahkan tambahkan catch Exception yang lain
             JOptionPane.showMessageDialog(this,"Gagal Hapus Data.. ");
           }
        }
    }

    
    
    // Method Untuk Menghapus Semua Isi JTable
    public void hapusIsiJTable() {
        int row = tabModel.getRowCount();
        for (int i = 0; i < row; i++) {
          tabModel.removeRow(0);
        }
      }
    //  Method Untuk Menampilkan Data dari tabel Anggota Ke JTable
    public void tampilDataKeJTable() {
        hapusIsiJTable();
        try {
            conn.close();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");   // import java.sql.DriverManager
            String sql="Select * from Anggota";
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            String NoAnggota,Nama,Alamat;
            int no=0;
            while(rs.next()){
             no=no+1;
             NoAnggota=rs.getString("NoAnggota");
             Nama=rs.getString("Nama");
             Alamat=rs.getString("Alamat");
             Object Data[]={no,NoAnggota,Nama,Alamat};
             tabModel.addRow(Data);
          }
      }
        catch (Exception e) {}
    }
    
    public void rubahData() {
    // Konfirmasi sebelum melakukan perubahan data
    int ok = JOptionPane.showConfirmDialog(this,
        "Anda Yakin Ingin Mengubah Data\n Dengan No Anggota = '" + txtNoAnggota.getText() +
        "'", "Konfirmasi ",JOptionPane.YES_NO_OPTION);
    // Apabila tombol Yes ditekan
    if (ok == 0) {
      try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
        String sql ="UPDATE Anggota SET Nama = ?, Alamat= ? WHERE NoAnggota = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        try {
          st.setString(1, txtNama.getText());
          st.setString(2, txtAlamat.getText());
          st.setString(3, txtNoAnggota.getText());
          st.executeUpdate();

         // Memanggil Method   tampilDataKeJTable();
          tampilDataKeJTable();

          txtNoAnggota.setText("");
          txtNama.setText("");
          txtAlamat.setText("");
          BSimpan.setText("Simpan");
        } catch (SQLException se) { }     // Silahkan tambahkan Sendiri informasi Eksepsi
      } catch (ClassNotFoundException se) {} // Silahkan tambahkan Sendiri informasi Eksepsi
      catch (SQLException se) {}  // Silahkan tambahkan Sendiri informasi Eksepsi
    }
    
  }
    
    public void simpanData(){
//Connection conn;
     try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
            String sql="Insert into Anggota values(?,?,?)";
            PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1, txtNoAnggota.getText());
                st.setString(2, txtNama.getText());
                st.setString(3, txtAlamat.getText());
            int rs=st.executeUpdate();

            if(rs>0){
            JOptionPane.showMessageDialog(this,"Input Berhasil");
      	    tampilDataKeJTable();
            }
            st.close();
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
           System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
        }
        catch (SQLException sqle) {
           System.out.println("Input  Gagal = " + sqle.getMessage());
        }
        catch(Exception e){
           System.out.println("Koneksi Gagal " +e.getMessage());
        }
  }



    
    void ambilData_dari_JTable() {
        int row = TAnggota.getSelectedRow();

        // Mengambil data yang dipilih pada JTable
        String NoAnggota = tabModel.getValueAt(row, 1).toString();
        String Nama = tabModel.getValueAt(row, 2).toString();
        String Alamat = tabModel.getValueAt(row, 3).toString();

        txtNoAnggota.setText(NoAnggota);
        txtNama.setText(Nama);
        txtAlamat.setText(Alamat);
    }

    
    private void setJTable(){
        String [] JudulKolom={"No","No Anggota","Nama Anggota","Alamat"};
        tabModel = new DefaultTableModel(null, JudulKolom){
                      boolean[] canEdit = new boolean [] { false, false, false };
                      @Override
                      public boolean isCellEditable(int rowIndex, int columnIndex) {
                       return canEdit [columnIndex];
                      }
                  };
        TAnggota.setModel(tabModel);
        TAnggota.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TAnggota.getColumnModel().getColumn(0).setPreferredWidth(30);
        TAnggota.getColumnModel().getColumn(1).setPreferredWidth(100);
        TAnggota.getColumnModel().getColumn(2).setPreferredWidth(200);
        TAnggota.getColumnModel().getColumn(3).setPreferredWidth(300);

        getData();
    }


    private void getData(){
       try{
        //Memanggil Driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        //Membuat variabel bertipe Connection
        //Kelas Connection berfungsi menyimpan sebuah koneksi yang sudah dilakukan oleh DriverManger
        conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");   // import java.sql.DriverManager
        //Membuat Variabel bertipe kelas  PreparedStatement
        //Kelas PreparedStatement berfungsi mengirimkan statement Query Ke Database
        String sql="Select * from Anggota";
        PreparedStatement st=conn.prepareStatement(sql);  // import java.sql.PreparedStatement
        //Membuat Variabel Bertipe ResulSet
        //Kelas Resultset Berfungsi Menyimpan Dataset(Sekumpulan Data) hasil prepareStatement Query
        ResultSet rs=st.executeQuery();   // import java.sql.ResultSet;

       // Menampilkan ke JTable  melalui tabModel
        String NoAnggota,Nama,Alamat;
        int no=0;
        while(rs.next()){
         no=no+1;
         NoAnggota=rs.getString("NoAnggota");
         Nama=rs.getString("Nama");
         Alamat=rs.getString("Alamat");

         Object Data[]={no,NoAnggota,Nama,Alamat};
         tabModel.addRow(Data);
        }
          // Tutup Koneksi
          st.close();
          conn.close();
    }
    catch (ClassNotFoundException cnfe) {         // Ketika Gagal Memanggil Driver
           System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
           System.exit(0);
    }
    catch (SQLException sqle) {                   // Ketika Gagal Sql   // import java.sql.SQLException
           System.out.println("Proses Query Gagal = " + sqle);
           System.exit(0);
    }
    catch(Exception e){
           System.out.println("Koneksi Access Gagal " +e.getMessage());
           System.exit(0);
    }

    }    // Akhir Method getData

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNoAnggota = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAnggota = new javax.swing.JTable();
        BTambah = new javax.swing.JButton();
        BSimpan = new javax.swing.JButton();
        BEdit = new javax.swing.JButton();
        BBatal = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        BClose = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CBCari = new javax.swing.JComboBox();
        txtCari = new javax.swing.JTextField();
        BCari = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Anggota");

        jLabel1.setText("No Anggota");

        jLabel2.setText("Nama");

        jLabel3.setText("Alamat");

        TAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TAnggota);

        BTambah.setText("Tambah");
        BTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambahActionPerformed(evt);
            }
        });

        BSimpan.setText("Simpan");
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        BEdit.setText("Edit");
        BEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditActionPerformed(evt);
            }
        });

        BBatal.setText("Batal");
        BBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBatalActionPerformed(evt);
            }
        });

        BHapus.setText("Hapus");
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        BClose.setText("Close");
        BClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCloseActionPerformed(evt);
            }
        });

        jLabel4.setText("Cari Berdasarkan");

        CBCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NoAnggota", "Nama" }));

        BCari.setText("Cari");
        BCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariActionPerformed(evt);
            }
        });

        jButton1.setText("Preview");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoAnggota)
                            .addComponent(txtNama)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCari)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BCari))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTambah)
                    .addComponent(BSimpan)
                    .addComponent(BEdit)
                    .addComponent(BBatal)
                    .addComponent(BHapus)
                    .addComponent(BClose)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCari))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(584, 624));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void resetText(){
        txtNoAnggota.setText(null);
        txtNama.setText(null);
        txtAlamat.setText(null);
    }
    
    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        // TODO add your handling code here:
      // TODO add your handling code here:
        if(BSimpan.getText().equalsIgnoreCase("Simpan")){
            simpanData();
            resetText();
        }else{
            rubahData();
            resetText();
        }
        txtNoAnggota.setText(""); // txtNoAnggota Tidak Aktif
        txtNama.setText("");        
        txtAlamat.setText("");

        txtNoAnggota.setEnabled(false);
        txtNama.setEnabled(false);
        txtAlamat.setEnabled(false);

        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true);       



    }//GEN-LAST:event_BSimpanActionPerformed

    private void BCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCloseActionPerformed
        // TODO add your handling code here:
        dispose();  
    }//GEN-LAST:event_BCloseActionPerformed

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        hapus_Data();
    }//GEN-LAST:event_BHapusActionPerformed

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        // TODO add your handling code here:
        txtNoAnggota.setEnabled(false); // txtNoAnggota Tidak Aktif
        txtNama.setEnabled(true);       // txtNama          Aktif
        txtAlamat.setEnabled(true);     // txtAlamat Aktif

        BSimpan.setText("Update"); // Merubah Teks Tombol Simpan
        
        BTambah.setEnabled(false);
        BSimpan.setEnabled(true);
        BEdit.setEnabled(false);
        BBatal.setEnabled(true);
        BHapus.setEnabled(false);
        BClose.setEnabled(false);


        // Memanggil Method  ambilData_dari_JTable()
        ambilData_dari_JTable();

    }//GEN-LAST:event_BEditActionPerformed

    private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
                // Mengatur  Enable Tombol Dan Textfield  
        txtNoAnggota.setEnabled(true);
        txtNama.setEnabled(true);
        txtAlamat.setEnabled(true);
        BSimpan.setText("Simpan");

        BTambah.setEnabled(false);
        BSimpan.setEnabled(true);
        BEdit.setEnabled(false);
        BBatal.setEnabled(true);
        BHapus.setEnabled(false);
        BClose.setEnabled(false);

    }//GEN-LAST:event_BTambahActionPerformed

    private void BCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariActionPerformed
        // TODO add your handling code here:
        
        String sql;
        int pilih = CBCari.getSelectedIndex();
        String cari = txtCari.getText();
        try {
        conn.close();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
        if(pilih==0)
        sql ="Select * from Anggota WHERE NoAnggota ='" +txtCari.getText() + "'";
        else
        sql ="Select * from Anggota WHERE Nama Like '%" +txtCari.getText() + "%'";

        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs =st.executeQuery();

        hapusIsiJTable();
        // Menampilkan ke JTable  melalui tabModel
        String NoAnggota,Nama,Alamat;
        int no=0;
        while(rs.next()){
         no=no+1;
         NoAnggota=rs.getString("NoAnggota");
         Nama=rs.getString("Nama");
         Alamat=rs.getString("Alamat");

         Object Data[]={no,NoAnggota,Nama,Alamat};
         tabModel.addRow(Data);
        }

         if(tabModel.getRowCount()>0)         
           JOptionPane.showMessageDialog(this,"Data Ditemukan ");        
        else
            JOptionPane.showMessageDialog(this,"Data Tidak Ditemukan.. ");

        }
        catch (ClassNotFoundException se) {}  // Silahkan tambahkan sendiri informasi eksepsi
        catch (SQLException se) {} 

    }//GEN-LAST:event_BCariActionPerformed

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        txtNoAnggota.setText(""); // txtNoAnggota Tidak Aktif
        txtNama.setText("");        // txtNama          Aktif
        txtAlamat.setText("");

       // Mengatur  Enable Tombol Dan Textfield  
        txtNoAnggota.setEnabled(false);
        txtNama.setEnabled(false);
        txtAlamat.setEnabled(false);

        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true);

    }//GEN-LAST:event_BBatalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String reportSource;
        String reportDest;

        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");

            reportSource="D:/laporan_er/anggota.jrxml";
            reportDest="D:/laporan_er/anggota.html";

            JasperReport jasperReport=JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,null,conn);

            JasperExportManager.exportReportToHtmlFile(jasperPrint,reportDest);

            JasperViewer.viewReport(jasperPrint,false);

        }catch(Exception e){
        System.out.println(e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBatal;
    private javax.swing.JButton BCari;
    private javax.swing.JButton BClose;
    private javax.swing.JButton BEdit;
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BSimpan;
    private javax.swing.JButton BTambah;
    private javax.swing.JComboBox CBCari;
    private javax.swing.JTable TAnggota;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoAnggota;
    // End of variables declaration//GEN-END:variables
}
