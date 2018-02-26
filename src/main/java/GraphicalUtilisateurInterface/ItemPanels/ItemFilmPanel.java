package GraphicalUtilisateurInterface.ItemPanels;

import Database.Model.LibraryDatabaseModel;
import GraphicalUtilisateurInterface.MouseListeners.AbstractCreateListener;
import Database.Model.Film;
import Database.Model.Oeuvre;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ItemFilmPanel extends AbstractItemFilmPanel {

	public ItemFilmPanel(LibraryDatabaseModel parent_library){

		super(parent_library);
		addBtn.addMouseListener(new CreateFilmListener(this));
	}

	public class CreateFilmListener extends AbstractCreateListener {

		public CreateFilmListener(JPanel caller) {
			super(caller);
		}

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {

			super.mouseClicked(mouseEvent);

			Oeuvre oeuvre_to_insert = new Film();
			String[] temp_genres;
			ArrayList<String> genres = new ArrayList<>();


			oeuvre_to_insert.setTitre(titleField.getText());
			oeuvre_to_insert.setCommentaire(commentField.getText());
			oeuvre_to_insert.setDateEdition(yearField.getText());
			oeuvre_to_insert.setDuree(timeField.getText());
            oeuvre_to_insert.setId_note(ratingCombo.getSelectedIndex());

			temp_genres = typeField.getText().split(",");
			for (String genre : temp_genres
				 ) {
				genres.add(genre);
			}
			oeuvre_to_insert.setGenres_label_list(genres);

            ArrayList personne_list = new ArrayList();
            ArrayList type_personne_list = new ArrayList();
            if (artistNomField.getText() != "" ){
                personne_list.add(artistNomField.getText());
                type_personne_list.add(artistTypeCombo.getSelectedItem());
            }
            if (artist2NomField.getText() != "" ){
                personne_list.add(artist2NomField.getText());
                type_personne_list.add(artist2TypeCombo.getSelectedItem());
            }




			JOptionPane jop1 = new JOptionPane();
			if (oeuvre_to_insert.getTitre().isEmpty()){
				jop1.showMessageDialog(null, "Titre non renseigné", "Information", JOptionPane.INFORMATION_MESSAGE);
			}else {

				jop1.showMessageDialog(null, "Oeuvre Sauvegardée !", "Information", JOptionPane.INFORMATION_MESSAGE);
			}


		}
	}
}
