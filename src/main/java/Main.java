import DataBaseModel.DataBaseController;
import DataBaseModel.InsertValues;
import GraphicalUtilisateurInterface.MainFrame;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
/*
        Connection conn = connect();
        //créé les tables si elles n'existent pas.
        SQLiteCreateDataBase.createTables(conn);
        SQLiteInsert.insertInTable(conn);

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

*/
        DataBaseController e = null;

        try {
            e = new DataBaseController();
            //e.onInsertDefaultValues();
        //onInsertDefaultValues()est appelé par defaut au demmarage pas besoin de le rapeller

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
        InsertValues.insertObject(e);

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MainFrame();
            }
        });
    }


}
