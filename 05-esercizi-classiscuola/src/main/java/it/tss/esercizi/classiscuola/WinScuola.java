/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package it.tss.esercizi.classiscuola;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ospite
 */
public class WinScuola extends javax.swing.JFrame {

    static ArrayList<Corso> elencoCorsi;

    /**
     * Creates new form WinScuola
     */
    public WinScuola() {
        initComponents();
        elencoCorsi = new ArrayList<Corso>();
        caricaCorsi();
        refreshCorsi();
        if (elencoCorsi.size() > 0) {
            lstCorsi.setSelectedIndex(0);
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

        lblCorso = new javax.swing.JLabel();
        btnSendCorso = new javax.swing.JButton();
        etNomeCorso = new javax.swing.JTextField();
        etDurataCorso = new javax.swing.JTextField();
        etCosto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        etDescrizione = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txpViewCorsi = new javax.swing.JTextPane();
        btnResetDati = new javax.swing.JButton();
        btnLoadCorsi = new javax.swing.JButton();
        btnSaveCorsi = new javax.swing.JButton();
        btnFindCorso = new javax.swing.JButton();
        btnUpdateCorso = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstCorsi = new javax.swing.JList<>();
        btnDeleteCorso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCorso.setBackground(new java.awt.Color(250, 107, 103));
        lblCorso.setFont(new java.awt.Font("Noto Mono", 1, 18)); // NOI18N
        lblCorso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorso.setText("Gestione Scuola ver. FRAME WINDOW");

        btnSendCorso.setText("invia corso");
        btnSendCorso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCorsoActionPerformed(evt);
            }
        });

        etNomeCorso.setToolTipText("ins cognome");

        etDescrizione.setColumns(20);
        etDescrizione.setRows(5);
        jScrollPane1.setViewportView(etDescrizione);

        jLabel1.setText("NOMECORSO");

        jLabel2.setText("DURATA ORE");

        jLabel3.setText("COSTO EURO");

        jLabel4.setText("DESCRIZIONE");

        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsg.setText("---");

        jScrollPane2.setViewportView(txpViewCorsi);

        btnResetDati.setText("cancella dati");
        btnResetDati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDatiActionPerformed(evt);
            }
        });

        btnLoadCorsi.setText("Load Corsi");
        btnLoadCorsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCorsiActionPerformed(evt);
            }
        });

        btnSaveCorsi.setText("Save Corsi");
        btnSaveCorsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCorsiActionPerformed(evt);
            }
        });

        btnFindCorso.setText("find");
        btnFindCorso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCorsoActionPerformed(evt);
            }
        });

        btnUpdateCorso.setText("upd");
        btnUpdateCorso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCorsoActionPerformed(evt);
            }
        });

        lstCorsi.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCorsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCorsiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lstCorsi);

        btnDeleteCorso.setText("del");
        btnDeleteCorso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCorsoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etNomeCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etDurataCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnResetDati)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSendCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblMsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFindCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(btnSaveCorsi, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLoadCorsi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCorso)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadCorsi)
                            .addComponent(btnSaveCorsi)
                            .addComponent(btnFindCorso)
                            .addComponent(btnUpdateCorso)
                            .addComponent(btnDeleteCorso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etNomeCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etDurataCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSendCorso, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnResetDati))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendCorsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCorsoActionPerformed
        Corso newc = creaCorso();
        if (newc == null) {
            return;
        }
        //adesso lo aggiungo all'elenco dei miei corsi
        elencoCorsi.add(newc);
        lblMsg.setText("Operazione confermata! Corso inserito");
        txpViewCorsi.setText(getCorsiCSV());
        refreshListaCorsi();
        salvaCorsi();
    }//GEN-LAST:event_btnSendCorsoActionPerformed

    private void btnResetDatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDatiActionPerformed
        etNomeCorso.setText("");
        etCosto.setText("50");
        etDurataCorso.setText("16");
        etDescrizione.setText("");
        lblMsg.setText("inserire dati nuovo corso");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetDatiActionPerformed

    private void btnLoadCorsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCorsiActionPerformed
        caricaCorsi();
        refreshCorsi();


    }//GEN-LAST:event_btnLoadCorsiActionPerformed

    private void btnSaveCorsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCorsiActionPerformed
        salvaCorsi();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveCorsiActionPerformed

    private void btnFindCorsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCorsoActionPerformed
        /*String val = etIndexCorso.getText();
        int index = Integer.parseInt(val) -1;
         */
        int index = lstCorsi.getSelectedIndex();
        Corso c = elencoCorsi.get(index);
        etNomeCorso.setText(c.getNomeCorso());
        etDurataCorso.setText(String.valueOf(c.getDurataOre()));
        etDescrizione.setText(c.getDescrizione());
        etCosto.setText(String.valueOf(c.getCosto()));

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindCorsoActionPerformed

    private void btnUpdateCorsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCorsoActionPerformed
        Corso newc = creaCorso();
        if (newc == null) {
            return;
        }
        //adesso aggiorno l'iesimo corso in update

        elencoCorsi.set(lstCorsi.getSelectedIndex(), newc);
        lblMsg.setText("Operazione confermata! Corso aggiornato");
        txpViewCorsi.setText(getCorsiCSV());
        refreshListaCorsi();
        salvaCorsi();

// TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateCorsoActionPerformed

    private void lstCorsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCorsiMouseClicked
        // TODO add your handling code here:
        btnFindCorsoActionPerformed(null);
    }//GEN-LAST:event_lstCorsiMouseClicked

    private void btnDeleteCorsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCorsoActionPerformed
        // TODO add your handling code here:
        int indexDelete = lstCorsi.getSelectedIndex();
        if (indexDelete >= 0) {
            elencoCorsi.remove(indexDelete);
            refreshListaCorsi();
            refreshCorsi();
            salvaCorsi();

        }
    }//GEN-LAST:event_btnDeleteCorsoActionPerformed

    private Corso creaCorso() {
        // input leggo da etNomocorso cosahai scritto
        //1 recupero i dati da interfaccia
        String ncorso = etNomeCorso.getText();
        String tdurata = etDurataCorso.getText();
        String tcosto = etCosto.getText();
        String descr = etDescrizione.getText();
        //2 converto in formati corretti
        // eventuali try catch
        int durata = Integer.parseInt(tdurata);
        float costo = Float.parseFloat(tcosto);
        //3 verifico correttezza info VALIDAZIONE
        // adesso o demando al costruttore dell'oggetto
        // no \n in descrizione
        descr = descr.replaceAll(".\n", "\n");
        descr = descr.replaceAll("\n", ". ");
        if (durata < 0 || durata > 3000) {
            lblMsg.setText("Operazione annnullata! durata errata");
            return null;

        }
        if (costo < 0 || costo > 3000) {
            lblMsg.setText("Operazione annnullata! costo errato");
            return null;

        }
        // se arrivo qua posso creare il corso
        Corso newc = new Corso(ncorso, durata, costo, descr);
        return newc;

    }

    private void refreshCorsi() {
        txpViewCorsi.setText(getCorsiCSV());
        btnResetDatiActionPerformed(null);
    }

    private void salvaCorsi() {
        /* 
        un file di testo che si chiama "Corsi.txt"
        java;120,100
        database;90;100
        web;150;200
         */
        String testoXfile = "";
        for (Corso c : elencoCorsi) {
            if (c == null) {
                break; // scatola vuota esco da for
            }
            String riga = c.getNomeCorso() + ";" + c.getDurataOre() + ";";
            riga += c.getCosto() + ";" + c.getDescrizione();
            riga += "\n";
            // riga ok  "java;120;100;corso java\n"
            testoXfile += riga;
        }
        //fase salvataggio file CSV
        try {
            FileWriter filecsv = new FileWriter("Corsi.csv");
            filecsv.write(testoXfile);
            filecsv.close();
        } catch (Exception e) {
            System.out.println("ERRORE: " + e.getLocalizedMessage());
        }

    }

    private String getCorsiCSV() {
        String tx = "";
        for (Corso c : elencoCorsi) {
            tx += c.infoCSV() + "\n";
        }
        return tx;
    }

    public void caricaCorsi() {
        /*dovrei aprire il file Corsi.csv
        leggere una riga per volta 
        caricare i dati in un corso e aggiungerlo alla lista corsi
        alla fine liberare il file
         */
        // puntatore al file corretto
        try {
            //azzero il mio elenco corsi ricostruendolo
            elencoCorsi = new ArrayList<Corso>();
            File filecsv = new File("Corsi.csv");
            // creo lettore che puntera' cursore inizio file
            Scanner lettore = new Scanner(filecsv);
            while (lettore.hasNextLine()) {
                //in riga la riga di dati fino al \n
                String riga = lettore.nextLine();
                // creo array dei singoli dati separsati dal ;
                String[] dati = riga.split(";");
                // dati[0] contiene nomecorso dati[1] durata ...
                String ncorso = dati[0];
                String descr = dati[3];
                // converto dati[1] da string a int
                int durata = Integer.parseInt(dati[1]);
                float costo = Float.parseFloat(dati[2]);
                // ho tutt i dati per costruire un corso
                Corso newcorso = new Corso(ncorso, durata, costo);
                newcorso.setDescrizione(descr);
                // lo inserisco in elenco
                elencoCorsi.add(newcorso);

            }
            refreshListaCorsi();

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }

    }

    private void refreshListaCorsi() {
        //oggettostile lista a cui aggiungere gli elementi che dovro'
        //vedere in lista grafica
        DefaultListModel listModel = new DefaultListModel();
        for (Corso c : elencoCorsi) {
            //String nc= c.getNomeCorso();
            listModel.addElement(c.getNomeCorso());
        }
        lstCorsi.setModel(listModel);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinScuola().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCorso;
    private javax.swing.JButton btnFindCorso;
    private javax.swing.JButton btnLoadCorsi;
    private javax.swing.JButton btnResetDati;
    private javax.swing.JButton btnSaveCorsi;
    private javax.swing.JButton btnSendCorso;
    private javax.swing.JButton btnUpdateCorso;
    private javax.swing.JTextField etCosto;
    private javax.swing.JTextArea etDescrizione;
    private javax.swing.JTextField etDurataCorso;
    private javax.swing.JTextField etNomeCorso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCorso;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JList<String> lstCorsi;
    private javax.swing.JTextPane txpViewCorsi;
    // End of variables declaration//GEN-END:variables

}
