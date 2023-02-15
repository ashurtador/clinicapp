package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioAdmin extends User implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA{

//... importa definición de clase...

    // Dentro de la clase:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

    // PARA HACER: Implementar un constructor que tome un ID y un rol

    public UsuarioAdmin(Integer id) {
        super(id);
    }

    public UsuarioAdmin(Integer id, String role) {
        super(id);
        this.role = role;
    }

    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!

    @Override
    public void printSecurityIncidents() {
        AdminCompatibleConHIPAA.super.printSecurityIncidents();
    }

    @Override
    public boolean adminQATest(ArrayList<String> expectedIncidents) {
        return AdminCompatibleConHIPAA.super.adminQATest(expectedIncidents);
    }

    // PARA HACER: ¡Implementar AdminCompatibleConHIPAA

    @Override
    public boolean assignPin(int pin) {
        if (String.valueOf(pin).length() >= 6) {

            setPin(pin);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID == id) {
            return true;
        } else {

            authIncident();
            return false;
        }
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    public void newIncident(String notes) {
        String report = String.format(
                "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n",
                new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }

    // PARA HACER: Setters y Getters

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}
