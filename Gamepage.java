
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class Gamepage extends javax.swing.JFrame implements ActionListener {

    int i, j, h, l, ze, oe, m = 0, hr = 0, min = 0, sec = 0, msec = 0;
    boolean state = false;
    private JToggleButton[][] jb;
    JFrame jf = new JFrame();
    ImageIcon icon = new ImageIcon("images.jpg");
    Thread t;

    public Gamepage(int x, int y) {
        ze = 0;
        initComponents();
        if (x <= 5 || y <= 5) {
            i = x;
            j = y;
            setTitle("Easy model");
        } else if (x <= 10 || y <= 10) {
            i = x;
            j = y;
            setTitle("medium model");
        } else if (x <= 15 || y <= 15) {
            i = x;
            j = y;
            setTitle("Hard model");
        } else {
            i = x;
            j = y;
            setTitle("very Hard model");
        }
        jb = new JToggleButton[i][j];
        Random rand = new Random();
        gamePAN.setLayout(new GridLayout(i, j));
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                int r = rand.nextInt(2);
                String ra = Integer.toBinaryString(r);
                jb[a][b] = new JToggleButton();
                jb[a][b].setText(ra);
                jb[a][b].setSize(30, 30);
                gamePAN.add(jb[a][b]);
                if (jb[a][b].getText().contains("0") && jb[a][b].getText().contains("")) {
                    ++ze;
                }
                jb[a][b].addActionListener(this);
            }
        }
        if (jb[i - 1][j - 1].getText().matches("0")) {
            ze -= 1;
        }
        lab2.setText(Integer.toString(ze));
        lab3.setText(Integer.toString(m));
        oe = ze;
        while (1 == (oe %= 2)) {
            ze = 0;
            for (int a = 0; a < i; a++) {
                for (int b = 0; b < j; b++) {
                    int r = rand.nextInt(2);
                    String ra = Integer.toBinaryString(r);
                    jb[a][b].setText(ra);
                    if (jb[a][b].getText().contains("0") && jb[a][b].getText().contains("")) {
                        ++ze;
                    }
                }
            }
            if (jb[i - 1][j - 1].getText().matches("0")) {
                ze -= 1;
            }
            lab2.setText(Integer.toString(ze));
            oe = ze;
        }
        jb[i - 1][j - 1].setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (state == false) {
            time();
        }
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                if (e.getSource() == jb[a][b]) {
                    if (jb[a][b].isSelected()) {
                        h = a;
                        l = b;
                    } else {
                        try {
                            if (jb[a][b].getText().matches("1") && jb[a][b - 1].getText().matches("0") && jb[a][b + 1].getText().matches("0")) {
                                jb[a][b - 1].setText("1");
                                jb[a][b + 1].setText("1");
                                ze -= 2;
                                m++;
                                lab2.setText(Integer.toString(ze));
                                lab3.setText(Integer.toString(m));
                                if (ze == 0) {
                                    state = false;
                                    int in = JOptionPane.showConfirmDialog(jf, "You Won the game\n\nTotal moves:" + m + "\nTotal time:" + hr + " : " + min + " : " + sec + "\n\nNeed to continue", "Confirm", JOptionPane.OK_CANCEL_OPTION,1,icon);
                                    if (in == JOptionPane.OK_OPTION) {
                                        new Gamestartpage().setVisible(true);
                                        Gamepage.this.setVisible(false);
                                    } else {
                                        Gamepage.this.setVisible(false);
                                        System.exit(0);
                                    }
                                }
                            }
                        } catch (Exception ex) {
                        }
                    }
                }
                if (e.getSource() != jb[a][b]) {
                    jb[a][b].setSelected(false);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePAN = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lab2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lab3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        hrs = new javax.swing.JLabel();
        mins = new javax.swing.JLabel();
        secs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gamePAN.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("Change Dificulty");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Zeros Remaining :");

        jLabel3.setText("Total Movies       : ");

        jButton2.setText("up");
        jButton2.setMaximumSize(new java.awt.Dimension(59, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(59, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("down");
        jButton5.setMaximumSize(new java.awt.Dimension(59, 25));
        jButton5.setMinimumSize(new java.awt.Dimension(59, 25));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("right");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("left");
        jButton3.setMaximumSize(new java.awt.Dimension(59, 25));
        jButton3.setMinimumSize(new java.awt.Dimension(59, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Total Time          :");

        hrs.setText("00:");

        mins.setText("00:");

        secs.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hrs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secs)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lab2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hrs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mins, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(secs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton6))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gamePAN, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(gamePAN, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if ((jb[h][l].getText().matches("") && (jb[h - 1][l].getText().matches("1") || jb[h - 1][l].getText().matches("0"))) || (jb[h - 1][l].getText().matches("") && (jb[h][l].getText().matches("1") || jb[h][l].getText().matches("0")))) {
                m++;
                String str = jb[h][l].getText();
                String str1 = jb[h - 1][l].getText();
                jb[h][l].setText(str1);
                jb[h - 1][l].setText(str);
                lab3.setText(Integer.toString(m));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if ((jb[h][l].getText().matches("") && (jb[h][l - 1].getText().matches("1") || jb[h][l - 1].getText().matches("0"))) || (jb[h][l - 1].getText().matches("") && (jb[h][l].getText().matches("1") || jb[h][l].getText().matches("0")))) {
                m++;
                String str = jb[h][l].getText();
                String str1 = jb[h][l - 1].getText();
                jb[h][l].setText(str1);
                jb[h][l - 1].setText(str);
                lab3.setText(Integer.toString(m));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if ((jb[h][l].getText().matches("") && (jb[h][l + 1].getText().matches("1") || jb[h][l + 1].getText().matches("0"))) || (jb[h][l + 1].getText().matches("") && (jb[h][l].getText().matches("1") || jb[h][l].getText().matches("0")))) {
                m++;
                String str = jb[h][l].getText();
                String str1 = jb[h][l + 1].getText();
                jb[h][l].setText(str1);
                jb[h][l + 1].setText(str);
                lab3.setText(Integer.toString(m));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int in = JOptionPane.showConfirmDialog(jf, "You will lose the game\n\nNeed to continue", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        if (in == JOptionPane.OK_OPTION) {
            System.exit(0);
            Gamepage.this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            if ((jb[h][l].getText().matches("") && (jb[h + 1][l].getText().matches("1") || jb[h + 1][l].getText().matches("0"))) || (jb[h + 1][l].getText().matches("") && (jb[h][l].getText().matches("1") || jb[h][l].getText().matches("0")))) {
                m++;
                String str = jb[h][l].getText();
                String str1 = jb[h + 1][l].getText();
                jb[h][l].setText(str1);
                jb[h + 1][l].setText(str);
                lab3.setText(Integer.toString(m));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int in = JOptionPane.showConfirmDialog(jf, "You will lose the game\n\nNeed to continue", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        if (in == JOptionPane.OK_OPTION) {
            new Gamestartpage().setVisible(true);
            Gamepage.this.setVisible(false);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    void time() {
        state = true;
        t = new Thread() {
            public void run() {
                for (;;) {
                    if (state == true) {
                        try {
                            sleep(1);
                            if (msec > 1000) {
                                msec = 0;
                                sec++;
                            }
                            if (sec > 60) {
                                msec = 0;
                                sec = 0;
                                min++;
                            }
                            if (min > 60) {
                                msec = 0;
                                sec = 0;
                                min = 0;
                                hr++;
                            }
                            msec++;
                            secs.setText(Integer.toString(sec));
                            mins.setText(Integer.toString(min) + " :");
                            hrs.setText(Integer.toString(hr) + " :");
                        } catch (Exception e) {
                        }
                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Gamepage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gamepage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gamepage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gamepage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePAN;
    private javax.swing.JLabel hrs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lab2;
    private javax.swing.JLabel lab3;
    private javax.swing.JLabel mins;
    private javax.swing.JLabel secs;
    // End of variables declaration//GEN-END:variables
}
