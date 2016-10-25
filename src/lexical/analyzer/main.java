package lexical.analyzer;

import java.util.ArrayList;
import sun.security.util.Length;
import java.util.Arrays;

public class main extends javax.swing.JFrame {

    private int count, token;
    public static String type, temp = "";
    public static ArrayList<ArithmaticEx> arex = new ArrayList<ArithmaticEx>();
    public static char[] cont;
    public static String inp;

    public main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input = new javax.swing.JTextField();
        analyze = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        alert = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        analyze.setText("ANALYZE");
        analyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ARITHMATIC EXPRESSION PARSER ");

        alert.setEditable(false);
        alert.setForeground(new java.awt.Color(255, 51, 51));
        alert.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input)
                            .addComponent(analyze, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(analyze)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed


    private void analyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeActionPerformed
        if (input.getText().isEmpty()) {
            alert.setText("Please type an input to analyze");
        } else if ((input.getText().contains(" "))) {
            alert.setText("Please remove 'space' character");
        } else {
            inp = input.getText();
            printChar();
            analyzeLexic();

            analyzer a = new analyzer(arex);
            this.setVisible(false);
            a.setLocationRelativeTo(null);
            a.showExpression();
            a.setVisible(true);
        }
    }//GEN-LAST:event_analyzeActionPerformed

    private void printChar() {
        cont = (inp).toCharArray();
        count = (cont).length;
        System.out.println("Character Array Length : " + (cont).length);
    }

    public void analyzeLexic() {
        boolean mark = false;
        int i = 0;

        while (mark == false) {
//-------------------------------------------------------------------------------------------------------------------------//
            // Mendeteksi Operator Angka
            if (Character.isDigit(cont[i])) {
                System.out.println("Char " + cont[i] + " : Integer");

                if (i != count - 1) {
                    temp += (cont[i]);
                } else {
                    temp += (cont[i]);
                    defString();
                }
//-------------------------------------------------------------------------------------------------------------------------//
                // Mendeteksi Operand Alphabeth
            } else if (Character.isLetter(cont[i])) {
                System.out.println("Char " + cont[i] + " : Alphabeth");
                if ((i != count - 1)) {
                    if (temp.isEmpty()) {
                        temp += cont[i];
                    } else if (Character.isLetter(temp.charAt(0))) {
                        if ((i == (count - 1))) {
                            temp += (cont[i]);
                            defString();
                        } else {
                            temp += cont[i];
                        }
                    } else {
                        temp += cont[i];
                    }
                } else {
                    temp += (cont[i]);
                    defString();
                }
//-------------------------------------------------------------------------------------------------------------------------//
                //Mendeteksi grouping symbol buka dan tutup kurung
            } else if (((cont[i]) == '(') || ((cont[i]) == ')')) {
                if (temp.isEmpty()) {
                    temp += cont[i];
                    defString();
                } else {
                    defString();
                    temp += cont[i];
                    defString();
                }
//-------------------------------------------------------------------------------------------------------------------------//
                // Mendeteksi Operator Tambah dan kurang
            } else if ((cont[i] == '+') || (cont[i] == '-')) {

                if (((count - 1) != 0) && (i >= 2)) {

                    if ((cont[i - 1] != 'E') && (cont[i - 1] != 'e')) {
                        if (temp.isEmpty()) {
                            temp += cont[i];
                            defString();
                        } else {
                            defString();
                            temp += cont[i];
                            defString();
                        }
                    } else {
                        if (Character.isDigit(temp.charAt(0))) {
                            temp += (cont[i]);
                        } else {
                            defString();
                            temp += cont[i];
                            defString();
                        }
                    }
                } else {
                    if (temp.isEmpty()) {
                        temp += cont[i];
                        defString();
                    } else {
                        defString();
                        temp += cont[i];
                        defString();
                    }
                }
//-------------------------------------------------------------------------------------------------------------------------//
                // Mendeteksi Operator kali dan bagi
            } else if ((cont[i] == '*') || (cont[i] == '/')) {
                if (((count - 1) != 0) && (i >= 2)) {
                    if (temp.isEmpty()) {
                        temp += cont[i];
                        defString();
                    } else {
                        defString();
                        temp += cont[i];
                        defString();
                    }
                } else {
                    if (temp.isEmpty()) {
                        temp += cont[i];
                        defString();
                    } else {
                        defString();
                        temp += cont[i];
                        defString();
                    }
                }
//-------------------------------------------------------------------------------------------------------------------------//
                //Mendeteksi karakter lain         
            } else {
                if (i != count - 1) {
                    temp += cont[i];
                } else {
                    temp += cont[i];
                    defString();
                }
            }
//-------------------------------------------------------------------------------------------------------------------------//
            //n+1
            if (i >= (count - 1)) {
                mark = true;
            } else {
                i++;
            }
        }
        System.out.println("Current temp : " + temp);
    }

    public void defString() {
        int coma = 0, E = 0;
        boolean chk = true;

//-------------------------------------------------------------------------------//  
        //Memberikan Token Bilangan Bulat
        if (isInteger(temp) == true) {
            type = "Operand";
            token = 3;
//-------------------------------------------------------------------------------//
            //Memberikan Token Bilangan Real
        } else if ((temp.contains(",") || (temp.contains("E")) || (temp.contains("e"))) && (Character.isDigit(temp.charAt(0)))) {
            if ((temp.charAt((temp.length()) - 1) != 'e') && (temp.charAt((temp.length()) - 1) != 'E')) {
                for (int i = 0; i < temp.length(); i++) {
                    if ((temp.charAt(i) == 'E') || (temp.charAt(i) == 'e')) {
                        E++;
                        if ((i > 1) && ((temp.charAt(i - 1) == ','))) {
                            chk = false;
                        }
                    } else if (temp.charAt(i) == ',') {
                        coma++;
                        if (!Character.isDigit(temp.charAt(i - 1))) {
                            chk = false;
                        }
                    }
                }
                if (((E <= 1) && (coma <= 1)) && (temp.charAt(temp.length() - 1) != ',') && (chk == true) && (Character.isDigit(temp.charAt(temp.length() - 1)))) {
                    if (isReal(temp) == true) {
                        type = "Operand";
                        token = 2;
                    } else {
                        type = "Unknown";
                        token = 0;
                    }
                } else {
                    type = "Unknown";
                    token = 0;
                }
            } else {
                type = "Unknown";
                token = 0;
            }
            System.out.println("-----------reg------------");
//-------------------------------------------------------------------------------//
            //Memberikan Token Variabel
        } else if (Character.isLetter(temp.charAt(0))) {
            if ((isAlpha(temp) == true) && (temp.charAt(temp.length() - 1) != '_')) {
                type = "Operand";
                token = 1;
            } else {
                type = "Unknown";
                token = 0;
            }
//-------------------------------------------------------------------------------//
            //Memberikan Token Buka kurung
        } else if (temp.contains("(")) {
            type = "Grouping Symbol";
            token = 4;
//-------------------------------------------------------------------------------//
            //Memberikan Token Tutup kurung
        } else if (temp.contains(")")) {
            type = "Grouping Symbol";
            token = 5;
//-------------------------------------------------------------------------------//
            //Memberikan Token Operator tambah
        } else if (temp.contains("+")) {
            type = "Operator";
            token = 6;
//-------------------------------------------------------------------------------//
            //Memberikan Token Operator kurang
        } else if (temp.contains("-")) {
            type = "Operator";
            token = 7;
//-------------------------------------------------------------------------------//
            //Memberikan Token Operator kali
        } else if (temp.contains("*")) {
            type = "Operator";
            token = 8;
//-------------------------------------------------------------------------------//  
            //Memberikan Token Operator bagi
        } else if (temp.contains("/")) {
            type = "Operator";
            token = 9;
//-------------------------------------------------------------------------------//   

        } else {
            type = "Unknown";
            token = 0;
        }
//-------------------------------------------------------------------------------//  

        ArithmaticEx Aa = new ArithmaticEx(temp, type, token);
        arex.add(Aa);
        Aa = null;
        temp = "";
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if ((!Character.isLetter(c)) && (c != '_') && (!Character.isDigit(c))) {
                return false;
            }
        }

        return true;
    }

    public boolean isReal(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if ((!Character.isDigit(c)) && (c != ',') && (c != 'e') && (c != 'E') && (c != '+') && (c != '-')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alert;
    private javax.swing.JButton analyze;
    private javax.swing.JTextField input;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
