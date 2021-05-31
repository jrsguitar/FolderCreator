/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldercreator.gui;

import foldercreator.model.service.Standardize;
import foldercreator.model.entities.AlertJeff;
import foldercreator.model.service.CreateFolder;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Invasor_zim
 */
public class FolderViewController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField local;
    @FXML
    private TextField mes;
    @FXML
    private TextField ano;
    @FXML
    private RadioButton adicionaisBtn;
    @FXML
    private Button limparBtn;
    @FXML
    private Button criarBtn;
    @FXML
    private Button abrirBtn;
    @FXML
    private Button pastaDefault;
    @FXML
    private Button corrigir;

    public void onBtLimpar() {
        textArea.clear();
        mes.clear();
        ano.clear();

    }

    public void onBtCorrigir() {
        String s = textArea.getText();
        Set<String> lista = new Standardize().corrigir(s);
        textArea.clear();
        lista.forEach((x) -> {
            textArea.setText(textArea.getText() + "\n" + x);
        });

    }

    public void onBtCriar() {
        CreateFolder create = new CreateFolder();
        create.create(local, adicionaisBtn, textArea, ano, mes);
    }

    public void onBrAbrir() {
        File pathAtual = new File(local.getText());
        if (pathAtual.exists()) {
            try {
                Runtime.getRuntime().exec("explorer " + local.getText());
            } catch (java.io.IOException ex) {
                AlertJeff.showAlert("Erro", null, "Local não encontrado!", Alert.AlertType.ERROR);
            }
        } else {
            AlertJeff.showAlert("Erro", null, "Local não encontrado!", Alert.AlertType.ERROR);
        }
    }

    public void alterarURL() {
        local.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
