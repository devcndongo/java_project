package models;
import interfaces.Personne;

public class Etudiant implements Personne {

    @Override
    public void sePresenter() {
        System.out.println ("Méthode Etudiant::sePresenter().");
    }
}
