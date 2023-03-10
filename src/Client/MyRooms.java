package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import serverInterfaces.ChatInterface;

public class MyRooms extends javax.swing.JFrame {

    private ChatInterface chatservice;
    private DefaultTableModel dff = null;
    private int user_id;
    ArrayList<String> myrooms_join = new ArrayList<>();

    public MyRooms(int id) throws RemoteException, NotBoundException {
        this.setResizable(false);
        initComponents();
        this.user_id = id;

        Registry reg = LocateRegistry.getRegistry("127.0.0.1", 10008);
        chatservice = (ChatInterface) reg.lookup(ChatInterface.LOOKUP_NAME);
        this.dff = (DefaultTableModel) tableMyRoomsJoinied.getModel();
        myrooms_join = chatservice.getMyRoomsJoined(user_id);

        for (int i = 0; i < myrooms_join.size(); i++) {

            myrooms_comobo_joinied.addItem(myrooms_join.get(i));

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        myrooms_comobo_joinied = new javax.swing.JComboBox<>();
        leafRoomBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMyRoomsJoinied = new javax.swing.JTable();
        startChatBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 194, 194));

        jPanel1.setBackground(new java.awt.Color(248, 237, 237));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(175, 145, 145));
        jLabel1.setText("your rooms");

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("my rooms");

        myrooms_comobo_joinied.setForeground(new java.awt.Color(102, 0, 102));
        myrooms_comobo_joinied.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                myrooms_comobo_joiniedItemStateChanged(evt);
            }
        });
        myrooms_comobo_joinied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myrooms_comobo_joiniedActionPerformed(evt);
            }
        });

        leafRoomBtn.setBackground(new java.awt.Color(153, 0, 153));
        leafRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        leafRoomBtn.setText("???????????? ???? ????????????");
        leafRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leafRoomBtnActionPerformed(evt);
            }
        });

        tableMyRoomsJoinied.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "User Name", "First Name", "Last Name", "Name Room"
            }
        ));
        jScrollPane2.setViewportView(tableMyRoomsJoinied);

        startChatBtn.setBackground(new java.awt.Color(153, 0, 153));
        startChatBtn.setForeground(new java.awt.Color(255, 255, 255));
        startChatBtn.setText("???????????? ????????????");
        startChatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startChatBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(153, 0, 153));
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("???????????? ??????????");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myrooms_comobo_joinied, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leafRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startChatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(myrooms_comobo_joinied, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(startChatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(leafRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myrooms_comobo_joiniedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myrooms_comobo_joiniedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myrooms_comobo_joiniedActionPerformed

    private void leafRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leafRoomBtnActionPerformed

        try {
            String selectchoice = (String) myrooms_comobo_joinied.getSelectedItem();
            chatservice.exitFromRoom(selectchoice, user_id);
            JOptionPane.showMessageDialog(null, "???? ???????????? ????  ???????????? ??????????");
            myrooms_comobo_joinied.removeAllItems();
            myrooms_join = chatservice.getMyRoomsJoined(user_id);

            for (int i = 0; i < myrooms_join.size(); i++) {

                myrooms_comobo_joinied.addItem(myrooms_join.get(i));

            }
        } catch (RemoteException ex) {
            Logger.getLogger(MyRooms.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_leafRoomBtnActionPerformed

    private void myrooms_comobo_joiniedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_myrooms_comobo_joiniedItemStateChanged

        try {
            String selectchoice = (String) myrooms_comobo_joinied.getSelectedItem();
            this.dff = (DefaultTableModel) tableMyRoomsJoinied.getModel();
            int rowCount = dff.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dff.removeRow(i);
            }
            ArrayList<String> members = new ArrayList<>();
            members = chatservice.getAllMembersGroup(selectchoice);
            for (int i = 0; i < members.size(); i++) {
                dff.addRow(new Object[]{
                    members.get(i),
                    chatservice.getUserName(members.get(i)),
                    chatservice.getFirstName(members.get(i)),
                    chatservice.getLastName(members.get(i)),
                    selectchoice,});
            }
        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_myrooms_comobo_joiniedItemStateChanged

    private void startChatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startChatBtnActionPerformed
        try {
            // TODO add your handling code here:
            String selectchoice = (String) myrooms_comobo_joinied.getSelectedItem();
            ChatForm chat = new ChatForm(user_id, selectchoice);
            this.dispose();
            chat.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(MyRooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MyRooms.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_startChatBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        try {
            // TODO add your handling code here:
            String username = chatservice.getUserName(user_id + "");
            HomePage homepage = new HomePage(user_id, username, "127.0.0.1", 10008);
            homepage.setVisible(true);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(MyRooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MyRooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyRooms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton leafRoomBtn;
    private javax.swing.JComboBox<String> myrooms_comobo_joinied;
    private javax.swing.JButton startChatBtn;
    private javax.swing.JTable tableMyRoomsJoinied;
    // End of variables declaration//GEN-END:variables
}
