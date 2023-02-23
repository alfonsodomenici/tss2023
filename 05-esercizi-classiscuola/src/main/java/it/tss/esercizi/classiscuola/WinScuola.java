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
    static ArrayList<Materia> elencoMaterie;

    /**
     * Creates new form WinScuola
     */
    public WinScuola() {
        initComponents();
        caricaMaterie();
        refreshListaMaterie();
        caricaCorsi();
        refreshCorsi();

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
        etDurataCorso = new javax.swing.JSpinner();
        etCosto = new javax.swing.JSpinner();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstMaterie = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        etMateria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        spDurataMateria = new javax.swing.JSpinner();
        btnInsNewMateria = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstMaterieCorso = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        btnAddMateriaCorso = new javax.swing.JButton();

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

        jLabel3.setText("COSTO €");

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

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mattino", "Pomeriggio", "Serale", "PreSerale", "Giorno Intero" }));
        cbTipo.setToolTipText("");

        jLabel5.setText("TIPO ORARIO");

        lstMaterie.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstMaterie);

        jLabel6.setText("materia:");

        jLabel7.setText("durata:");

        btnInsNewMateria.setText("INS NEW MATERIA");
        btnInsNewMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsNewMateriaActionPerformed(evt);
            }
        });

        lstMaterieCorso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(lstMaterieCorso);

        jLabel8.setText("MATERIE:");

        btnAddMateriaCorso.setText("ADD Materia");
        btnAddMateriaCorso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMateriaCorsoActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etNomeCorso))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(btnResetDati)
                                            .addComponent(jLabel8)
                                            .addComponent(btnAddMateriaCorso))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(btnSendCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(etDurataCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(etCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFindCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSaveCorsi, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLoadCorsi, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(etMateria))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(spDurataMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(btnInsNewMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
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
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etNomeCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(etDurataCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(etCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddMateriaCorso)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSendCorso)
                            .addComponent(btnResetDati))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadCorsi)
                    .addComponent(btnSaveCorsi)
                    .addComponent(btnFindCorso)
                    .addComponent(btnUpdateCorso)
                    .addComponent(btnDeleteCorso)
                    .addComponent(lblMsg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spDurataMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsNewMateria)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        etCosto.setValue(0);
        etDurataCorso.setValue(0);
        etDescrizione.setText("");
        cbTipo.setSelectedIndex(0);
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
        etDurataCorso.setValue(c.getDurataOre());
        etDescrizione.setText(c.getDescrizione());
        etCosto.setValue(c.getCosto());
        cbTipo.setSelectedItem(c.getFasciaOraria());
        refreshListaMaterieCorso();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindCorsoActionPerformed

    private void btnUpdateCorsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCorsoActionPerformed
        Corso newc = creaCorso();
        if (newc == null) {
            return;
        }
        //adesso aggiorno l'iesimo corso in update
        updateCorso(lstCorsi.getSelectedIndex());
        //elencoCorsi.set(lstCorsi.getSelectedIndex(), newc);
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

    private void btnInsNewMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsNewMateriaActionPerformed
        // TODO add your handling code here:
        String nmateria = etMateria.getText();
        // durata mat
        int duratamat = (int) spDurataMateria.getValue();

        Materia materia = new Materia(nmateria, duratamat);
        materia.setDocente("NN");
        elencoMaterie.add(materia);
        refreshListaMaterie();

    }//GEN-LAST:event_btnInsNewMateriaActionPerformed

    private void btnAddMateriaCorsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMateriaCorsoActionPerformed
        int idxmat = lstMaterie.getSelectedIndex();
        Materia mat = elencoMaterie.get(idxmat);
        int idxcorso = lstCorsi.getSelectedIndex();
        Corso cor = elencoCorsi.get(idxcorso);
        cor.addMateriaFullOre(mat);
        refreshListaMaterieCorso();


    }//GEN-LAST:event_btnAddMateriaCorsoActionPerformed

    private Corso creaCorso() {
        // input leggo da etNomocorso cosahai scritto
        //1 recupero i dati da interfaccia
        String ncorso = etNomeCorso.getText();
        etDurataCorso.getValue();

        String descr = etDescrizione.getText();
        String fascia = (String) cbTipo.getSelectedItem();
        //2 converto in formati corretti
        // eventuali try catch
        int durata = (int) etDurataCorso.getValue();
        float costo = 0;
        int val = (int) etCosto.getValue();
        costo = val + costo;

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
        Corso newc = new Corso(ncorso, durata, costo,
                descr, fascia);
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
            // riga ok  "java;120;100;corso java\n"
            testoXfile += c.infoCSV() + "\n";
        }
        //fase salvataggio file CSV
        try {
            FileWriter filecsv = new FileWriter("Corsi.csv");
            filecsv.write(testoXfile.trim());
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
                //obbligatorio 5 item in dati length==5
                if (dati.length != 6) {
                    System.out.println("dato ko:" + riga);
                    continue;
                }
                String ncorso = dati[0];
                String descr = dati[3];
                String fascia = dati[4]; // la fascia oraria
                // converto dati[1] da string a int
                int durata = Integer.parseInt(dati[1]);
                float costo = Float.parseFloat(dati[2]);
                // ho tutt i dati per costruire un corso
                Corso newcorso = new Corso(ncorso, durata, costo,
                        descr, fascia);
                String[] arMat = dati[5].split("\\|");
                // armat [Sicurezza,Inglese,Arabo]
                for (String nomemat : arMat) {
                    //scorro elencomaterie e cerco "Sicurezza"
                    Materia newmat = null;
                    for (Materia mat : elencoMaterie) {
                        if (nomemat.equalsIgnoreCase(mat.getNomeMateria())) {
                            newmat = mat;
                            break;
                        }
                    }
                    //aggiungo materia al corso
                    if (newmat != null) {
                        newcorso.addMateriaFullOre(newmat);
                    }
                }

                // lo inserisco in elenco
                elencoCorsi.add(newcorso);

            }
            refreshListaCorsi();

        } catch (Exception e) {
            System.out.println("Errore lettura file csv: " + e.getMessage());
        }

    }

    public void caricaMaterie() {

        // puntatore al file corretto
        try {
            //azzero il mio elenco corsi ricostruendolo
            elencoMaterie = new ArrayList<Materia>();
            File filecsv = new File("Materie.csv");
            // creo lettore che puntera' cursore inizio file
            Scanner lettore = new Scanner(filecsv);
            while (lettore.hasNextLine()) {
                //in riga la riga di dati fino al \n
                String riga = lettore.nextLine();
                // creo array dei singoli dati separsati dal ;
                String[] dati = riga.split(";");
                // dati[0] contiene nomemateria dati[1] durata ...
                //obbligatorio 5 item in dati length==5
                if (dati.length != 3) {
                    System.out.println("dato materia ko:" + riga);
                    continue;
                }
                String nmateria = dati[0];
                int durata = Integer.parseInt(dati[1]);
                String docente = dati[2];
                Materia newmateria = new Materia(nmateria, durata);
                newmateria.setDocente(docente);
                // lo inserisco in elenco
                elencoMaterie.add(newmateria);

            }
            refreshListaMaterie();

        } catch (Exception e) {
            System.out.println("Errore lettura file csv: " + e.getMessage());
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

    private void refreshListaMaterie() {
        //oggettostile lista a cui aggiungere gli elementi che dovro'
        //vedere in lista grafica
        DefaultListModel listModel = new DefaultListModel();
        for (Materia m : elencoMaterie) {
            listModel.addElement(m.getNomeMateria());
        }
        lstMaterie.setModel(listModel);

    }

    private void refreshListaMaterieCorso() {
        //oggettostile lista a cui aggiungere gli elementi che dovro'
        //vedere in lista grafica
        // devo capire il corso selezionato
        int idx = lstCorsi.getSelectedIndex();

        Corso c = elencoCorsi.get(idx);

        DefaultListModel listModel = new DefaultListModel();
        for (Materia m : c.getElencoMaterieCorso()) {
            listModel.addElement(m.getNomeMateria());
        }
        lstMaterieCorso.setModel(listModel);

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
    private javax.swing.JButton btnAddMateriaCorso;
    private javax.swing.JButton btnDeleteCorso;
    private javax.swing.JButton btnFindCorso;
    private javax.swing.JButton btnInsNewMateria;
    private javax.swing.JButton btnLoadCorsi;
    private javax.swing.JButton btnResetDati;
    private javax.swing.JButton btnSaveCorsi;
    private javax.swing.JButton btnSendCorso;
    private javax.swing.JButton btnUpdateCorso;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JSpinner etCosto;
    private javax.swing.JTextArea etDescrizione;
    private javax.swing.JSpinner etDurataCorso;
    private javax.swing.JTextField etMateria;
    private javax.swing.JTextField etNomeCorso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCorso;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JList<String> lstCorsi;
    private javax.swing.JList<String> lstMaterie;
    private javax.swing.JList<String> lstMaterieCorso;
    private javax.swing.JSpinner spDurataMateria;
    private javax.swing.JTextPane txpViewCorsi;
    // End of variables declaration//GEN-END:variables

    private boolean updateCorso(int selectedIndex) {
        Corso c = elencoCorsi.get(selectedIndex);
        String ncorso = etNomeCorso.getText();
        etDurataCorso.getValue();

        String descr = etDescrizione.getText();
        String fascia = (String) cbTipo.getSelectedItem();
        //2 converto in formati corretti
        // eventuali try catch
        int durata = (int) etDurataCorso.getValue();
        float costo = 0;
        int val = (int) etCosto.getValue();
        costo = val + costo;

        //3 verifico correttezza info VALIDAZIONE
        // adesso o demando al costruttore dell'oggetto
        // no \n in descrizione
        descr = descr.replaceAll(".\n", "\n");
        descr = descr.replaceAll("\n", ". ");
        if (durata < 0 || durata > 3000) {
            lblMsg.setText("Operazione annnullata! durata errata");
            return false;

        }
        if (costo < 0 || costo > 3000) {
            lblMsg.setText("Operazione annnullata! costo errato");
            return false;

        }
        c.setNomeCorso(ncorso);
        c.setCosto(costo);
        c.setDurataOre(durata);
        c.setDescrizione(descr);
        return true;
    }

}
