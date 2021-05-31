/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldercreator.model.service;

import foldercreator.model.entities.AlertJeff;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.control.Alert;

/**
 *
 * @author Invasor_zim
 */
public class Standardize {
    
    public Set<String> corrigir(String s){
       Set<String> lista = new TreeSet<>();
       String[] vetor = s.split("\\n");

        for (String x : vetor) {
            try {
                if (!x.isEmpty()) {
                    String[] linha = x.split("'");
                    lista.add(linha[1]);
                }
            } catch (Exception e) {
                String msg = "O botão (PADRONIZAR LISTA) só funciona com a lista do ETCM "
                        + "Click no botão (CRIAR) para criar uma lista de pastas personalizadas";
                AlertJeff.showAlert("Erro de entrada", null, msg, Alert.AlertType.ERROR);
            }

        } 
        
        return lista;
    }
    
}
