package com.antaladrien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class Ablak extends JFrame {
    private int szelesseg;
    private int magassag;
    private String cim;

    public Ablak(int szelesseg, int magassag, String cim) {
        this.szelesseg = szelesseg;
        this.magassag = magassag;
        this.cim = cim;
        inicializalas();
    }

    private void inicializalas() {
        this.setSize(szelesseg, magassag);
        this.setTitle(cim);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void ablakbaIr(List<Rendezveny> rendezvenyek, String[] oszlopNevek) {
        String[][] adatok = new String[rendezvenyek.size()][oszlopNevek.length];
        for (int i = 0; i < rendezvenyek.size(); i++) {
            adatok[i][0] = rendezvenyek.get(i).getCim();
            adatok[i][1] = rendezvenyek.get(i).getIdoPont();
            adatok[i][2] = String.valueOf(rendezvenyek.get(i).getJegyAr());
        }

        TableModel tableModel = new DefaultTableModel(adatok, oszlopNevek);
        JTable tabla = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(tabla);

        this.add(jScrollPane);
        this.revalidate();
    }
}
