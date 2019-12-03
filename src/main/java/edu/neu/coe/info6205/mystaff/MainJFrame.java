//package edu.neu.coe.info6205.mystaff;
//
//import java.awt.*;
//import javax.swing.*;
//
//
//public class MainJFrame extends javax.swing.JFrame {
//
//    /**
//     * Creates new form MainJFrame
//     */
//    public MainJFrame() {
//        initComponents();
//    }
//
//    private void initComponents() {
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 400, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 300, Short.MAX_VALUE)
//        );
//
//        pack();
//    }// </editor-fold>
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainJFrame().setVisible(true);
//            }
//        });
//    }
//
//}
//
//class Grid extends JFrame {
//
//    private GOL gol;
//
//    public Grid() {
//        gol.generate();
//        gol.display();
//        setSize(620, 650);
//        setVisible(true);
//    }
//
//    /**
//     * Inherit from JFrame, which is also in Window class.
//     * Invoked automatically.
//     * @param g
//     */
//    public void paint(Graphics g) {
//        for (int x = 10; x <= 580; x += 30) {
//            for (int y = 40; y <= 610; y += 30) {
//                g.drawRect(x, y, 30, 30);
//            }
//        }
//
//    }
//
//    public static void main(String args[]) {
//        Grid application = new Grid();
//        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//}
//
