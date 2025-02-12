/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPack;

import dataPack.SingleEntry;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class FrmLoadCSV extends javax.swing.JFrame {
    Vector<String[]> dataVec;
    MainForm parent;

    int calledBy = 0;
    boolean processComplete = false;
    public FrmLoadCSV(MainForm parent, int calledBy) {
        this.calledBy = calledBy;
        this.parent = parent;
        initComponents();
        Dimension sd  = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(sd.width / 2 - this.getWidth()/ 2, sd.height / 2 - this.getHeight()/ 2); 
        //jLabel2.setText("Mining User Events for Health Care Data");
    }

 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        new JavaLib.LoadForm();
        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        new JavaLib.LoadForm();
        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        new JavaLib.LoadForm();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyPack/recom - Copy.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Student Facebook Analysis");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Using Domain Knowledge");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(15, 15, 15))
                    .addComponent(jLabel6))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Import Dataset");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        new JavaLib.LoadForm();
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Select File");

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Load");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        new JavaLib.LoadForm();
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        if(calledBy == 0){
            parent.setVisible(true);
        }else{
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        processComplete = false;
        try{
            int cols = 9;
            FileDialog fd = new FileDialog(this);
            fd.setVisible(true);
            String fname = "";
            if(fd.getFile() == null){
                return;
            }
            fname = fd.getDirectory() + fd.getFile();
            jTextArea1.setText(fname);
            dataVec = new Vector<String[]>();
            Vector<String>  inputVector = new Vector<String>();
            try{
                BufferedReader br = new BufferedReader(new FileReader(fname));
                 String contents = "";
                while(br.readLine()!=null){
                  contents=br.readLine();
                   contents=contents.replaceAll("/","");
                     contents=contents.replaceAll("\"","");
                     System.out.println(contents);
                     String sp[]=contents.split(",");
                     System.out.println("====="+sp.length);
                     if(sp.length>=5){
                     //System.out.println("insert into dataset (col2,col3,col4,col5,col6) values('"+sp[1]+"','"+sp[2]+"','"+sp[3]+"','http://www.microsoft.com/"+sp[4]+"',1)");
                     System.out.println("insert into dataset (col2,col3,col4,col5,col6) values('"+sp[1]+"','"+sp[2]+"','"+sp[3]+"','',1)");
                     DatabaseConnection.executeUpdate("insert into dataset (col2,col3,col4,col5,col6) values('"+sp[1]+"','"+sp[2]+"','"+sp[3]+"','',1)");
                     }
                 /*    else if(sp.length<5){
                         ResultSet rs=DatabaseConnection.executeQuery("select * from dataset where col2='"+sp[1]+"'");
                         if(rs.next()){
                             DatabaseConnection.executeUpdate("update dataset set col6=col6+1 where col2='"+sp[1]+"'");
                         }
                     }*/
//                    if(contents == null)
//                        break;
//                    if(!(contents.startsWith("%") || contents.startsWith("@")))
//                        inputVector.add(contents);
                }
                br.close();
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,"Error Reading file : " + e);
                return;
            }
//            try{
//                Vector<String> sarr = new Vector<String>();
//                for(int cnt=0;cnt<inputVector.size();cnt++){
//                    StringTokenizer stok = new StringTokenizer(inputVector.elementAt(cnt), ",");
//                    sarr.clear();
//                    while(stok.hasMoreElements()){
//                        sarr.addElement(stok.nextToken());
//                    }
////                    if(sarr.size() != cols){
////                        JOptionPane.showMessageDialog(this,"Invalid Entry [" + cnt + "]: " + inputVector.elementAt(cnt) + "\nProcess Stopped.");
////                        return;
////                    }
//                    String s[] = new String[sarr.size()];
//                    for(int i=0;i<sarr.size();i++){
//                        s[i] = sarr.elementAt(i);
//                    }
//                    dataVec.addElement(s);
//                }
//                
//                System.out.println("Total Entries : " + dataVec.size());
//               for(int i=0;i<dataVec.size();i++){
//                    if(i==0)
//                        continue;
//                 //  System.out.println(dataVec.elementAt(i).length);
//                    int len=dataVec.elementAt(i).length;
//                    if(len>=9){
//                        String data=dataVec.elementAt(i)[8];
//                        String val="";
//                        if(data.equals("1")){
//                            val="positive";
//                        }else if(data.equals("-1")){
//                            val="negative";
//                        }else if(data.equals("0")){
//                            val="neutral";
//                        }else{
//                            continue;
//                        }
//                    DatabaseConnection.executeUpdate("insert into dataset values(null,'"+dataVec.elementAt(i)[0]+"','"+dataVec.elementAt(i)[1]+"','"+dataVec.elementAt(i)[2]+"','"+dataVec.elementAt(i)[3]+"','"+dataVec.elementAt(i)[4]+"','"+dataVec.elementAt(i)[5]+"','"+dataVec.elementAt(i)[6]+"','"+dataVec.elementAt(i)[7]+"','"+val+"','','','','','','')");                   
//                    }
//                    else if(len==8){
//                        String data=dataVec.elementAt(i)[7];
//                        String val="";
//                        if(data.equals("1")){
//                            val="positive";
//                        }else if(data.equals("-1")){
//                            val="negative";
//                        }else if(data.equals("0")){
//                            val="neutral";
//                        }else{
//                            continue;
//                        }
//                    DatabaseConnection.executeUpdate("insert into dataset values(null,'"+dataVec.elementAt(i)[0]+"','"+dataVec.elementAt(i)[1]+"','"+dataVec.elementAt(i)[2]+"','"+dataVec.elementAt(i)[3]+"','"+dataVec.elementAt(i)[4]+"','"+dataVec.elementAt(i)[5]+"','"+dataVec.elementAt(i)[6]+"','','"+val+"','','','','','','')");                                       
//                    }
//                    else if(len==7){
//                        String data=dataVec.elementAt(i)[6];
//                        String val="";
//                        if(data.equals("1")){
//                            val="positive";
//                        }else if(data.equals("-1")){
//                            val="negative";
//                        }else if(data.equals("0")){
//                            val="neutral";
//                        }else{
//                            continue;
//                        }
//                    DatabaseConnection.executeUpdate("insert into dataset values(null,'"+dataVec.elementAt(i)[0]+"','"+dataVec.elementAt(i)[1]+"','"+dataVec.elementAt(i)[2]+"','"+dataVec.elementAt(i)[3]+"','"+dataVec.elementAt(i)[4]+"','"+dataVec.elementAt(i)[5]+"','','','"+val+"','','','','','','')");                                                           
//                    }
//               }
////                for(int i=0;i<inputVector.size();i++){
////                    System.out.println("value "+(i+1)+" =="+inputVector.elementAt(i).toString());
////                    String sp[]=inputVector.elementAt(i).toString().split(",");
////                    DatabaseConnection.executeUpdate("insert into dataset values(null,'"+sp[1]+"','"+sp[2]+"','"+sp[3]+"','"+sp[4]+"','"+sp[5]+"','"+sp[6]+"','"+sp[7]+"','"+sp[8]+"','"+sp[9]+"','','','','','','')");
////                }
//            }catch(Exception e){
//               e.printStackTrace();
//            }

        }catch(Exception e){
            System.out.println("Error2 : " + e);
        }
        processComplete = true;
        JOptionPane.showMessageDialog(this, "Data Loading Successful !");
        this.setVisible(false);
        if(calledBy == 0){
            parent.setVisible(true);
            new viewDataset(parent).setVisible(true);
        }else{
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    void printLeftoutLine(String sarr[], int lineNumber){
        System.out.print("Discarding Entry at line " + lineNumber + " : ");
        for(int i=0;i<sarr.length;i++){
            System.out.print(sarr[i] + ",");
        }
        System.out.println();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
