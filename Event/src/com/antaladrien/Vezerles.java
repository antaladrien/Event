package com.antaladrien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vezerles {
    private final String RENDEZVENY_ELERES = "rendezvenyek.txt";
    private final String CHAR_SET = "UTF-8";

    private List<Rendezveny> rendezvenyek = new ArrayList<>();

    public Vezerles() {

    }

    void start() {
        adatbBevitel();
        adatKiiras();
        ablakba();
    }

    private void adatbBevitel() {
        try (FileReader fr = new FileReader("rendezvenyek.txt");
             BufferedReader br = new BufferedReader(fr)) {

            String cim, idoPont;
            int ar;
            String sor;
            Rendezveny rendezveny;
            while ((sor = br.readLine()) != null) {
                String[] adatok = sor.split(";");
                cim = adatok[0];
                idoPont = adatok[1];
                ar = Integer.parseInt(adatok[2]);
                rendezveny = new Rendezveny(cim, idoPont, ar);
                rendezvenyek.add(rendezveny);
            }
        } catch (IOException ex) {
            Logger.getLogger(Vezerles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void adatKiiras() {
        System.out.println("A rendezvények: ");
        for (Rendezveny rendezveny : rendezvenyek) {
            System.out.println(rendezveny);
        }
    }

    private void ablakba() {
        int szelesseg = 500, magassag = 200;
        String cim = "Rendezvények";
        Ablak ablak = new Ablak(szelesseg, magassag, cim);
        String[] oszlopNevek = {"Cím","Időpont", "Jegyár (Ft)"};
        ablak.ablakbaIr(new ArrayList<>(rendezvenyek),oszlopNevek);
    }
}
