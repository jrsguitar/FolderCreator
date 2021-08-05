/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldercreator.model.service;

import foldercreator.model.entities.AlertJeff;
import foldercreator.model.entities.Folder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Invasor_zim
 */
public class CreateFolder {

    public void create(TextField local, RadioButton adicionaisBtn, TextArea textArea, TextField ano, TextField mes) {
        List<Folder> folders = new ArrayList<>();
        File pathAtual = new File(local.getText());
        if (!pathAtual.exists()) {
            new File(local.getText()).mkdir();
        }

        if (adicionaisBtn.isSelected()) {
            folders.add(new Folder("Documentos Adicionais"));
        }

        if (pathAtual.exists()) {
            String s = textArea.getText();
            String[] vetor = s.split("\\n");
            String pasta;
            for (String vetor1 : vetor) {
                pasta = vetor1;
                folders.add(new Folder(pasta));
                folders.forEach((f) -> {
                    new File(pathAtual + "\\" + ano.getText() + "\\" + mes.getText() + "\\" + f.getName()).mkdirs();
                });
            }
            String file = pathAtual + "\\" + ano.getText() + "\\" + mes.getText() + "\\" + "lista.txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(textArea.getText());
            } catch (IOException e) {
                AlertJeff.showAlert("Erro", null, "Local não encontrado!", Alert.AlertType.ERROR);
            }
        } else {
            AlertJeff.showAlert("Erro", null, "Caminho digitado incorreto!", Alert.AlertType.ERROR);
        }
        textArea.clear();

    }

}
