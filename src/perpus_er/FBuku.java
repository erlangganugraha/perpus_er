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
public class FBuku extends javax.swing.JFrame {
    public DefaultTableModel tabModel;
    Connection conn;
    /**
     * Creates new form FBuku
     */
    public FBuku() {
        initComponents();
        setJTable();
        BSimpan.setEnabled(false);
        BBatal.setEnabled(false);
    }

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
        txtJudulBuku = new javax.swing.JTextField();
        txtPenerbit = new javax.swing.JTextField();
        txtTahun = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKodeBuku = new javax.swing.JTextField();
        BSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tBuku = new javax.swing.JTable();
        BTambah = new javax.swing.JButton();
        BEdit = new javax.swing.JButton();
        BBatal = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        BClose = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        CBCari = new javax.swing.JComboBox();
        txtCari = new javax.swing.JTextField();
        BCari = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText(" Judul Buku :");

        jLabel2.setText("Penerbit :");

        jLabel3.setText("Tahun Terbit :");

        jLabel4.setText("Kode Buku :");

        BSimpan.setText("Simpan");
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        tBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tBuku);

        BTambah.setText("Tambah");
        BTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambahActionPerformed(evt);
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

        jLabel5.setText("Cari Berdasarkan");

        CBCari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KodeBuku", "JudulBuku" }));

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BCari))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJudulBuku)
                                    .addComponent(txtPenerbit)
                                    .addComponent(txtTahun, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtKodeBuku)))
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
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BSimpan)
                    .addComponent(BTambah)
                    .addComponent(BEdit)
                    .addComponent(BBatal)
                    .addComponent(BHapus)
                    .addComponent(BClose)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCari))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(591, 463));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void simpanData(){
            // TODO add your handling code here:
     try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
            String sql="insert into Buku values(?,?,?,?,?)";
            PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1, txtKodeBuku.getText());
                st.setString(2, txtJudulBuku.getText());
                st.setString(3, txtPenerbit.getText());
                st.setString(4, txtTahun.getText());
                st.setString(5, "Ada");
            int rs=st.executeUpdate();

            if(rs>0){
            JOptionPane.showMessageDialog(this,"Input Berhasil");
            resetText();
      	    setJTable();
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
        txtJudulBuku.setText(""); // txtNoAnggota Tidak Aktif
        txtKodeBuku.setText("");        
        txtPenerbit.setText("");
        txtTahun.setText("");

        txtJudulBuku.setEnabled(false);
        txtKodeBuku.setEnabled(false);
        txtPenerbit.setEnabled(false);
        txtTahun.setEnabled(false);

        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true);       

    }//GEN-LAST:event_BSimpanActionPerformed

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        txtKodeBuku.setEnabled(false); // txtNoAnggota Tidak Aktif
        txtJudulBuku.setEnabled(true);       // txtNama          Aktif
        txtPenerbit.setEnabled(true);     // txtAlamat Aktif
        txtTahun.setEnabled(true);     // txtAlamat Aktif

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

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        // TODO add your handling code here:
        hapus_Data();
    }//GEN-LAST:event_BHapusActionPerformed

    private void BCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariActionPerformed
        // TODO add your handling code here:
        
                // TODO add your handling code here:
        
        String sql;
        int pilih = CBCari.getSelectedIndex();
        String cari = txtCari.getText();
        try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
        if(pilih==0)
        sql ="Select * from Buku WHERE kdBuku ='" +txtCari.getText() + "'";
        else
        sql ="Select * from Buku WHERE judulBuku Like '%" +txtCari.getText() + "%'";

        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs =st.executeQuery();

        hapusIsiJTable();
        // Menampilkan ke JTable  melalui tabModel
        String kdBuku,jdBuku,penerbit,tahun;
            int no=0;
            while(rs.next()){
             no=no+1;
             kdBuku=rs.getString("kdBuku");
             jdBuku=rs.getString("judulBuku");
             penerbit=rs.getString("Penerbit");
             tahun=rs.getString("Tahun");
             Object Data[]={no,kdBuku,jdBuku,penerbit,tahun};
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

    private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
        // TODO add your handling code here:
        txtKodeBuku.setEnabled(true);
        txtJudulBuku.setEnabled(true);
        txtPenerbit.setEnabled(true);
        txtTahun.setEnabled(true);
        BSimpan.setText("Simpan");

        BTambah.setEnabled(false);
        BSimpan.setEnabled(true);
        BEdit.setEnabled(false);
        BBatal.setEnabled(true);
        BHapus.setEnabled(false);
        BClose.setEnabled(false);
    }//GEN-LAST:event_BTambahActionPerformed

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
                // TODO add your handling code here:
        txtKodeBuku.setText(""); // txtNoAnggota Tidak Aktif
        txtJudulBuku.setText("");        // txtNama          Aktif
        txtPenerbit.setText("");
        txtTahun.setText("");

       // Mengatur  Enable Tombol Dan Textfield  
        txtKodeBuku.setEnabled(false);
        txtJudulBuku.setEnabled(false);
        txtPenerbit.setEnabled(false);
        txtTahun.setEnabled(false);

        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true);
    }//GEN-LAST:event_BBatalActionPerformed

    private void BCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_BCloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String reportSource;
        String reportDest;

        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");

            reportSource="D:/laporan_er/Buku.jrxml";
            reportDest="D:/laporan_er/Buku.pdf";

            JasperReport jasperReport=JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,null,conn);

            JasperExportManager.exportReportToPdfFile(jasperPrint,reportDest);

            JasperViewer.viewReport(jasperPrint,false);

        }catch(Exception e){
        System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void hapus_Data() {
        // Konfirmasi sebelum melakukan penghapusan data
        ambilData_dari_JTable();
        int ok = JOptionPane.showConfirmDialog(this,
            "Anda Yakin Ingin Menghapus Data\nDengan Kode Buku = '" + txtKodeBuku.getText() +
            "'", "Konfirmasi Menghapus Data",JOptionPane.YES_NO_OPTION);
        if (ok == 0) {     // Apabila tombol OK ditekan
          try {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
            String sql = "DELETE FROM Buku WHERE kdBuku = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtKodeBuku.getText());
            int rs=st.executeUpdate();
            if(rs>0){
            tampilDataKeJTable();
            JOptionPane.showMessageDialog(this,"Data Sudah dihapus");
            }
            txtJudulBuku.setText(""); // txtNoAnggota Tidak Aktif
        txtKodeBuku.setText("");        
        txtPenerbit.setText("");
        txtTahun.setText("");

        txtJudulBuku.setEnabled(false);
        txtKodeBuku.setEnabled(false);
        txtPenerbit.setEnabled(false);
        txtTahun.setEnabled(false);

        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true); 
          } catch (Exception se) {  // Silahkan tambahkan catch Exception yang lain
             JOptionPane.showMessageDialog(this,"Gagal Hapus Data.. ");
           }
        }
    }
    
    public void rubahData() {
    // Konfirmasi sebelum melakukan perubahan data
    int ok = JOptionPane.showConfirmDialog(this,
        "Anda Yakin Ingin Mengubah Data\n Dengan Kode Buku = '" + txtKodeBuku.getText() +
        "'", "Konfirmasi ",JOptionPane.YES_NO_OPTION);
    // Apabila tombol Yes ditekan
    if (ok == 0) {
      try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");
        String sql ="UPDATE Buku SET judulBuku = ?, Penerbit= ?, Tahun= ? WHERE kdBuku = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        try {
          st.setString(1, txtJudulBuku.getText());
          st.setString(2, txtPenerbit.getText());
          st.setString(3, txtTahun.getText());
          st.setString(4, txtKodeBuku.getText());
          st.executeUpdate();

         // Memanggil Method   tampilDataKeJTable();
          // Memanggil Method   tampilDataKeJTable();
          tampilDataKeJTable();

          txtJudulBuku.setText("");
          txtKodeBuku.setText("");
          txtPenerbit.setText("");
          txtTahun.setText("");
          BSimpan.setText("Simpan");
        } catch (SQLException se) { }     // Silahkan tambahkan Sendiri informasi Eksepsi
      } catch (ClassNotFoundException se) {} // Silahkan tambahkan Sendiri informasi Eksepsi
      catch (SQLException se) {}  // Silahkan tambahkan Sendiri informasi Eksepsi
    }
    
  }
    
    public void hapusIsiJTable() {
        int row = tabModel.getRowCount();
        for (int i = 0; i < row; i++) {
          tabModel.removeRow(0);
        }
    }
    
    public void tampilDataKeJTable() {
        hapusIsiJTable();
        try {
            conn.close();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");   // import java.sql.DriverManager
            String sql="Select * from Buku";
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            String kdBuku,jdBuku,penerbit,tahun;
            int no=0;
            while(rs.next()){
             no=no+1;
             kdBuku=rs.getString("kdBuku");
             jdBuku=rs.getString("judulBuku");
             penerbit=rs.getString("Penerbit");
             tahun=rs.getString("Tahun");
             Object Data[]={no,kdBuku,jdBuku,penerbit,tahun};
             tabModel.addRow(Data);
          }
      }
        catch (Exception e) {}
    }
    
    void ambilData_dari_JTable() {
        int row = tBuku.getSelectedRow();

        // Mengambil data yang dipilih pada JTable
        String kodeBuku = tabModel.getValueAt(row, 1).toString();
        String jdBuku = tabModel.getValueAt(row, 2).toString();
        String penerbit = tabModel.getValueAt(row, 3).toString();
        String tahun = tabModel.getValueAt(row, 4).toString();

        txtKodeBuku.setText(kodeBuku);
        txtJudulBuku.setText(jdBuku);
        txtPenerbit.setText(penerbit);
        txtTahun.setText(tahun);
    }
    /**
     * @param args the command line arguments
     */
    
    public void resetText(){
        
    }
    
    private void setJTable(){
        String [] JudulKolom={"No","Kode Buku","Judul Buku","Penerbit","Tahun","Status"};
        tabModel = new DefaultTableModel(null, JudulKolom){
                      boolean[] canEdit = new boolean [] { false, false, false,false,false,false};
                      @Override
                      public boolean isCellEditable(int rowIndex, int columnIndex) {
                       return canEdit [columnIndex];
                      }
                  };
        tBuku.setModel(tabModel);
        tBuku.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tBuku.getColumnModel().getColumn(0).setPreferredWidth(30);
        tBuku.getColumnModel().getColumn(1).setPreferredWidth(100);
        tBuku.getColumnModel().getColumn(2).setPreferredWidth(200);
        tBuku.getColumnModel().getColumn(3).setPreferredWidth(100);
        tBuku.getColumnModel().getColumn(3).setPreferredWidth(100);
        tBuku.getColumnModel().getColumn(3).setPreferredWidth(100);

        getData();
    }
    
    private void getData(){
       Connection conn;    // import java.sql.connection
       try{
        //Memanggil Driver
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        //Membuat variabel bertipe Connection
        //Kelas Connection berfungsi menyimpan sebuah koneksi yang sudah dilakukan oleh DriverManger
        conn=DriverManager.getConnection("jdbc:odbc:perpus_10514910");   // import java.sql.DriverManager
        //Membuat Variabel bertipe kelas  PreparedStatement
        //Kelas PreparedStatement berfungsi mengirimkan statement Query Ke Database
        String sql="Select * from Buku";
        PreparedStatement st=conn.prepareStatement(sql);  // import java.sql.PreparedStatement
        //Membuat Variabel Bertipe ResulSet
        //Kelas Resultset Berfungsi Menyimpan Dataset(Sekumpulan Data) hasil prepareStatement Query
        ResultSet rs=st.executeQuery();   // import java.sql.ResultSet;

       // Menampilkan ke JTable  melalui tabModel
        String kodeBuku,judulBuku,Penerbit,Tahun,Status;
        int no=0;
        while(rs.next()){
         no=no+1;
         kodeBuku=rs.getString("kdBuku");
         judulBuku=rs.getString("judulBuku");
         Penerbit=rs.getString("Penerbit");
         Tahun=rs.getString("Tahun");
         Status=rs.getString("Status");

         Object Data[]={no,kodeBuku,judulBuku,Penerbit,Tahun,Status};
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
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FBuku().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tBuku;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJudulBuku;
    private javax.swing.JTextField txtKodeBuku;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtTahun;
    // End of variables declaration//GEN-END:variables
}
