package GraphicalUtilisateurInterface.ItemPanels;

import DataBaseModel.DatabaseController;
import DataBaseModel.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import SQLite_DataBase.Object_to_insert.Film;
import SQLite_DataBase.Object_to_insert.Oeuvre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class ItemJeuPanel extends AbstractItemJeuVideoPanel {

    public ItemJeuPanel() {
        addBtn.addMouseListener(new CreateJeuListener(this));
    }


    public class CreateJeuListener extends AbstractCreateListener {

        public CreateJeuListener(JPanel caller) {
            super(caller);
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            super.mouseClicked(mouseEvent);


            Oeuvre oeuvre_to_insert = new Film();
            oeuvre_to_insert.setTitre(titleField.getText());
            oeuvre_to_insert.setCommentaire(commentField.getText());

            oeuvre_to_insert.setDateEdition(yearField.getText());

            System.out.println("save button");
            JOptionPane jop1 = new JOptionPane();
            if (oeuvre_to_insert.getTitre().isEmpty()){
                jop1.showMessageDialog(null, "Titre non renseigné", "Information", JOptionPane.INFORMATION_MESSAGE);
            }else {

                jop1.showMessageDialog(null, "Oeuvre Sauvegardée !", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}
