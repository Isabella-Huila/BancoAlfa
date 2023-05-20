package com.example.seguimiento14;

import java.util.ArrayList;
public class DataRegister {
    private ArrayList<Dato> datos= new ArrayList<>();

    public ArrayList<Dato> getDatos() {
        datos.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
            return datos;
        }
    private DataRegister(){

    }

    private static DataRegister instance = null;

    public static DataRegister getInstance() {
        if (instance == null) {
            synchronized (DataRegister.class) {
                if (instance == null) {
                    instance = new DataRegister();
                }
            }
        }
        return instance;
    }

    public double calculateBalance() {
        double balance = 0;
        for (Dato dato : datos) {
            if (dato.getTipo().equals(Type.INCOME)) {
                balance += dato.getMonto();
            } else if (dato.getTipo().equals(Type.EXPENSE)) {
                balance -= dato.getMonto();
            }
        }
        return balance;
    }
}
