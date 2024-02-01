package com.federicotoluzzo;

import java.util.Arrays;
import java.util.HashSet;

public class CodiceFiscale {
    private String nome;
    private String cognome;
    private boolean isMaschio;
    private int giornoDiNascita;
    private int meseDiNascita;
    private int annoDiNascita;
    private String luogoDiNascita;

    private static final HashSet<Character> vocali = new HashSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
    private static final char[] mesi = new char[]{'A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'};

    public CodiceFiscale(String nomecognome, char sesso, String dataDiNascita, String luogoDiNascita){
        this.nome = nomecognome.split(" ")[0];
        this.cognome = nomecognome.split(" ")[1];
        this.isMaschio = sesso == 'M' || sesso == 'm';
        this.giornoDiNascita = Integer.parseInt(dataDiNascita.split("/")[0]);
        this.meseDiNascita = Integer.parseInt(dataDiNascita.split("/")[1]);
        this.annoDiNascita = Integer.parseInt(dataDiNascita.split("/")[2]);
    }

    public String getCodiceFiscale(){
        String codiceFiscale = "";
        codiceFiscale += primeTreLettere();
        codiceFiscale += dallaTerzaAllaSestaLettera();
        codiceFiscale += this.annoDiNascita % 100;
        codiceFiscale += mesi[this.meseDiNascita];
        codiceFiscale += giornoDiNascita + (isMaschio ? 0 : 40);
        return codiceFiscale;
    }

    public String primeTreLettere(){
        char[] temp = this.cognome.toUpperCase().toCharArray();
        String ptl = "";
        for (int i = 0; i < temp.length; i++) {
            if(!vocali.contains(temp[i]) && ptl.length() <= 3){
                ptl += temp[i];
            }
        }
        return ptl;
    }

    public String dallaTerzaAllaSestaLettera(){
        char[] temp = this.nome.toUpperCase().toCharArray();
        String dtasl = "";
        for (int i = 0; i < temp.length; i++) {
            if(!vocali.contains(temp[i]) && dtasl.length() <= 3){
                dtasl += temp[i];
            }
        }
        if(dtasl.length() == 3){
            return dtasl;
        }else if(dtasl.length() < 3){
            for (int i = dtasl.length(); i < 3; i++) {
                dtasl.concat("X");
            }
            return dtasl;
        }else{
            return dtasl.substring(0, 1) + dtasl.substring(2, 4);
        }
    }
}
