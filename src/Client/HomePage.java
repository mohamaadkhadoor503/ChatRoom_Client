package Client;

import clientInterfaces.clientInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
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

public class HomePage extends javax.swing.JFrame implements clientInterfaces.clientInterface {

    int user_id;
   
    private User client;
    private String host;
    private int port;
    private ChatInterface chatservice;
    ArrayList<String> myrooms = new ArrayList<>();
    ArrayList<String> avilablerooms = new ArrayList<>();
    private DefaultTableModel df = null;

    private DefaultTableModel dff = null;

    public HomePage(int userid, String username, String host, int port) throws RemoteException, NotBoundException, SQLException {
this.setResizable(false);
        initComponents();

        this.user_id = userid;
        this.host = host;
        this.port = port;
        UserName_lbl.setText(username);
        ID_lbl.setText(userid+"");
        getTheService(host, port);
        UnicastRemoteObject.exportObject(this, 0);
        chatservice.sign(this);
        myrooms = chatservice.getMyrooms(user_id);

        for (int i = 0; i < myrooms.size(); i++) {
            combo_my_rooms.addItem(myrooms.get(i));
        }

        avilablerooms = chatservice.getAvailableRooms(user_id);
        for (int i = 0; i < avilablerooms.size(); i++) {
            combo_availbale_room1.addItem(avilablerooms.get(i));
        }


    }

    private void getTheService(String host, int port) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(host, port);
        chatservice = (ChatInterface) reg.lookup(ChatInterface.LOOKUP_NAME);

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
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        deleteRoomBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        regbutton2 = new javax.swing.JButton();
        ID_lbl = new javax.swing.JLabel();
        UserName_lbl = new javax.swing.JLabel();
        combo_my_rooms = new javax.swing.JComboBox<>();
        combo_availbale_room1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMyrooms = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAvailable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        addRoomBtn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        addRoomBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 237, 237));
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 393);

        jLabel7.setFont(new java.awt.Font("Palatino Linotype", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(175, 145, 145));
        jLabel7.setText("your userName :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 51, 210, 33);

        jPanel3.setBackground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(200, 10, 306, 14);

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(840, 10, 13, 260);

        jPanel5.setBackground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(870, 20, 13, 242);

        deleteRoomBtn.setBackground(new java.awt.Color(153, 0, 153));
        deleteRoomBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteRoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteRoomBtn.setText("حذف غرفة");
        deleteRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteRoomBtn);
        deleteRoomBtn.setBounds(540, 250, 220, 40);

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(175, 145, 145));
        jLabel6.setText("My Room");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(560, 150, 140, 42);

        regbutton2.setBackground(new java.awt.Color(153, 0, 153));
        regbutton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        regbutton2.setForeground(new java.awt.Color(255, 255, 255));
        regbutton2.setText("انضم الأن");
        regbutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regbutton2ActionPerformed(evt);
            }
        });
        jPanel1.add(regbutton2);
        regbutton2.setBounds(80, 250, 220, 40);
        jPanel1.add(ID_lbl);
        ID_lbl.setBounds(240, 90, 110, 30);
        jPanel1.add(UserName_lbl);
        UserName_lbl.setBounds(240, 46, 110, 30);

        combo_my_rooms.setForeground(new java.awt.Color(102, 0, 102));
        combo_my_rooms.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_my_roomsItemStateChanged(evt);
            }
        });
        combo_my_rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_my_roomsActionPerformed(evt);
            }
        });
        jPanel1.add(combo_my_rooms);
        combo_my_rooms.setBounds(540, 200, 220, 40);

        combo_availbale_room1.setForeground(new java.awt.Color(102, 0, 102));
        combo_availbale_room1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_availbale_room1ItemStateChanged(evt);
            }
        });
        combo_availbale_room1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_availbale_room1ActionPerformed(evt);
            }
        });
        jPanel1.add(combo_availbale_room1);
        combo_availbale_room1.setBounds(80, 200, 220, 40);

        jLabel8.setFont(new java.awt.Font("Palatino Linotype", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(175, 145, 145));
        jLabel8.setText("your ID :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(6, 90, 140, 42);

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(175, 145, 145));
        jLabel9.setText("Available Room");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(110, 150, 210, 42);

        TableMyrooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", " user Name", "First Name", "Last Name", "Room Name"
            }
        ));
        jScrollPane1.setViewportView(TableMyrooms);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(410, 360, 390, 90);

        tableAvailable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "User Name", "First Name", "Last Name", "Room Name"
            }
        ));
        jScrollPane2.setViewportView(tableAvailable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 360, 390, 220);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("عند الضغط على هذا الزر سيقوم بحذف غرفة دردشة مختارة من القائمة My Room");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(490, 290, 270, 40);

        jPanel6.setBackground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(200, 40, 306, 14);

        addRoomBtn1.setBackground(new java.awt.Color(153, 0, 153));
        addRoomBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addRoomBtn1.setForeground(new java.awt.Color(255, 255, 255));
        addRoomBtn1.setText("اضافة غرفة");
        addRoomBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(addRoomBtn1);
        addRoomBtn1.setBounds(540, 50, 220, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("عند الضغط على هذا الزر سيتم اختيار الغرفة المختارة في available Room للانضمام عليها");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 290, 300, 40);

        addRoomBtn2.setBackground(new java.awt.Color(153, 0, 153));
        addRoomBtn2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addRoomBtn2.setForeground(new java.awt.Color(255, 255, 255));
        addRoomBtn2.setText("رؤية الغرف التي انضممت إليها");
        addRoomBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(addRoomBtn2);
        addRoomBtn2.setBounds(310, 100, 220, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomBtnActionPerformed

        try {
            String choice = (String) combo_my_rooms.getSelectedItem();
            if (choice == null) {
                JOptionPane.showMessageDialog(null, "لايوجد غرف لحذفها");

            } else {
                try {
                    chatservice.deleteRoom(choice);
                    JOptionPane.showMessageDialog(null, "تم حذف  الغرفة بنجاح");
                } catch (RemoteException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            combo_my_rooms.removeAllItems();

            myrooms = chatservice.getMyrooms(user_id);

            for (int i = 0; i < myrooms.size(); i++) {
                combo_my_rooms.addItem(myrooms.get(i));
            }
        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_deleteRoomBtnActionPerformed

    private void regbutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regbutton2ActionPerformed
        try {
    

            String choice = (String) combo_availbale_room1.getSelectedItem();

            chatservice.joinToRoom(user_id, choice);
            combo_availbale_room1.removeAllItems();
            avilablerooms = chatservice.getAvailableRooms(user_id);
            for (int i = 0; i < avilablerooms.size(); i++) {
                combo_availbale_room1.addItem(avilablerooms.get(i));
            }

            JOptionPane.showMessageDialog(null, "تم الانضمام للغرفة ..." + choice);

        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_regbutton2ActionPerformed

    private void combo_my_roomsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_my_roomsItemStateChanged

        try {
            String selectchoice = (String) combo_my_rooms.getSelectedItem();
            this.df = (DefaultTableModel) TableMyrooms.getModel();
            int rowCount = df.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                df.removeRow(i);
            }
            ArrayList<String> members = new ArrayList<>();
            members = chatservice.getAllMembersGroup(selectchoice);
            for (int i = 0; i < members.size(); i++) {
                df.addRow(new Object[]{
                    members.get(i),
                    selectchoice,
                    chatservice.getUserName(members.get(i)),
                    chatservice.getFirstName(members.get(i)),
                    chatservice.getLastName(members.get(i)),});
            }
        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_combo_my_roomsItemStateChanged

    private void combo_my_roomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_my_roomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_my_roomsActionPerformed

    private void combo_availbale_room1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_availbale_room1ItemStateChanged
        // TODO add your handling code here:
        
  try {
            String selectchoice = (String) combo_availbale_room1.getSelectedItem();
            this.dff = (DefaultTableModel) tableAvailable.getModel();
            int rowCount = dff.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dff.removeRow(i);
            }
            ArrayList<String> members = new ArrayList<>();
            members = chatservice.getAllMembersGroup(selectchoice);
            for (int i = 0; i < members.size(); i++) {
                System.out.println("Client.HomePage.combo_availbale_room1ItemStateChanged()");
                dff.addRow(new Object[]{
                    members.get(i),
                    chatservice.getUserName(members.get(i)),
                    chatservice.getFirstName(members.get(i)),
                    chatservice.getLastName(members.get(i)),
                 selectchoice
                });
            }
        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_combo_availbale_room1ItemStateChanged

    private void combo_availbale_room1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_availbale_room1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_availbale_room1ActionPerformed

    private void addRoomBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomBtn1ActionPerformed

        try {

            String nameroom = JOptionPane.showInputDialog("ادخل اسم الغرفةالتي تريد انشاءها  من فضلك ");

            if (nameroom.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "يجب ادخال اسم للغرفة");
            } else {
                if (chatservice.addRoom(user_id, nameroom)) {
                    JOptionPane.showMessageDialog(null, "تم اضافة الغرفة بنجاح");

                    myrooms = chatservice.getMyrooms(user_id);
                    combo_my_rooms.removeAllItems();
                    for (int i = 0; i < myrooms.size(); i++) {
                        combo_my_rooms.addItem(myrooms.get(i));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "هذا الاسم موجود مسبقا يرجى اضافة اسم غير موجود ومميز");
                }
            }

        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_addRoomBtn1ActionPerformed

    private void addRoomBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomBtn2ActionPerformed
        try {
            // TODO add your handling code here:

            MyRooms myrooms_gui = new MyRooms(user_id);
            this.setVisible(false);
            myrooms_gui.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_addRoomBtn2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID_lbl;
    private javax.swing.JTable TableMyrooms;
    private javax.swing.JLabel UserName_lbl;
    private javax.swing.JButton addRoomBtn1;
    private javax.swing.JButton addRoomBtn2;
    private javax.swing.JComboBox<String> combo_availbale_room1;
    private javax.swing.JComboBox<String> combo_my_rooms;
    private javax.swing.JButton deleteRoomBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton regbutton2;
    private javax.swing.JTable tableAvailable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void reciveMessage(String message) throws RemoteException {
//        reciveMessagesTextArea.append(message + "\n");
    }

    @Override
    public String getClientName() throws RemoteException {
        return client.getUserName();
    }

    @Override
    public int getId() throws RemoteException {
        return user_id;

    }

    @Override
    public void recieveFile(String fileName, byte[] data) throws RemoteException {
        FileOutputStream output = null;
        try {
            File file = new File(fileName);
            output = new FileOutputStream(file);
            output.write(data);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
