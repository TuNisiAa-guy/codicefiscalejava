package com.federicotoluzzo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CodiceFiscale cf = new CodiceFiscale("Federico Toluzzo", 'M', "12/07/2007", "Venezia");
        System.out.println(cf.getCodiceFiscale());
    }
}
