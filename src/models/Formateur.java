package models;
import interfaces.Personne;

public class Formateur implements Personne {

    @Override
    public void sePresenter() {
        System.out.println ("Méthode Formateur::sePresenter().");
    }
}
