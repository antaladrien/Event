package com.antaladrien;

public class Rendezveny {
    private String cim;
    private String idoPont;
    private int jegyAr;

    public Rendezveny(String cim, String idoPont, int jegyAr) {
        this.cim = cim;
        this.idoPont = idoPont;
        this.jegyAr = jegyAr;
    }

    @Override
    public String toString() {
        return cim + ", időpontja: " + idoPont + ", jegyár: " + jegyAr + " Ft";
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getIdoPont() {
        return idoPont;
    }

    public void setIdoPont(String idoPont) {
        this.idoPont = idoPont;
    }

    public int getJegyAr() {
        return jegyAr;
    }

    public void setJegyAr(int jegyAr) {
        this.jegyAr = jegyAr;
    }
}
