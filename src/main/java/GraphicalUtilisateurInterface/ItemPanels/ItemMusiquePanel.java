package GraphicalUtilisateurInterface.ItemPanels;


import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Musique;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ItemMusiquePanel extends AbstractItemMusiquePanel {
    public ItemMusiquePanel() {
        addBtn.addMouseListener(new CreateMusiqueListener(this));
    }
    public class CreateMusiqueListener extends AbstractCreateListener {

        public CreateMusiqueListener(JPanel caller) {
            super(caller);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            super.mouseClicked(mouseEvent);
            
            Oeuvre oeuvre_to_insert = new Musique();

            oeuvre_to_insert.setTitre(titleField.getText());
            oeuvre_to_insert.setCommentaire(commentField.getText());

            oeuvre_to_insert.setDateEdition(yearField.getText());

        }
    }
}