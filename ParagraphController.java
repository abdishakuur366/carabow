package com.example.javafxsb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParagraphController {

    @FXML
    private Label lblDisplay, lblDisplay1;

    @FXML
    private TextArea taParagraph;

    @FXML
    private TextField txtChar;

    @FXML
    void btnRun(ActionEvent event) {
        String str = taParagraph.getText(),
                str1 = txtChar.getText();
        if (str.isBlank() && str1.isEmpty()) {
            lblDisplay.setText("Please enter a value");
            lblDisplay1.setText("which consonant are you looking for?");
        } else if (str.length() > 0 && str1.isEmpty()) {
            lblDisplay.setText(String.valueOf(countConsonantChar(str)));
            lblDisplay1.setText("which consonant are you looking for?");
        } else if (str.isBlank() && !str1.isEmpty()) {
            lblDisplay1.setText("there no consonant to search for");
            lblDisplay.setText("");
            txtChar.clear();
        } else {
            lblDisplay1.setText(isVowel(str1.charAt(0)) ? "is a vowel" : String.valueOf(searchChar(str1.charAt(0), str)));
            lblDisplay.setText(String.valueOf(countConsonantChar(str)));
        }
    }

    private int countConsonantChar(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                count++;
            }
        }
        return count;
    }

    private int searchChar(char ch, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}