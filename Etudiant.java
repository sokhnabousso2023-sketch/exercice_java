package POO;

import java.time.LocalDate;
import java.time.Period;

public class Etudiant{
        String nom;
        String prenom;
        LocalDate dateNaissance;
        String adresse;
        String tel;
        double note;
        String mail;
        
        
public Etudiant() {
        	
}


        // Constructeur
public Etudiant(String nom, String prenom, LocalDate dateNaissance,
                 String adresse, String tel, double note, String mail) {
            this.nom = nom;
            this.prenom = prenom;
            this.dateNaissance = dateNaissance;
            this.adresse = adresse;
            this.tel = tel;
            this.note = note;
            this.mail = mail;
        }

        // Calcul de l'âge
      public int getAge() {
            return Period.between(dateNaissance, LocalDate.now()).getYears();
        }

        void afficher() {
            System.out.println(prenom + " " + nom +
                    " Age: " + getAge() +
                    " Note: " + note);
        }

    // ===== Programme principal =====
    public static void main(String[] args) {

        Etudiant[] etudiants = new Etudiant[50];

        // Création de 50 étudiants
        for (int i = 0; i < 50; i++) {
            etudiants[i] = new Etudiant(
                    "Nom" + i,
                    "Prenom" + i,
                    LocalDate.of(2000 + (i % 5), 1, 1),
                    "Adresse " + i,
                    "773722151" + i,
                    Math.round(Math.random() * 20),
                    "etudiant" + i + "@mail.com"
            );
        }

        // Afficher les 5 etudiants les plus âgés et les 5 les moins âgés
        trierParAge(etudiants);

        System.out.println("les 5 étudiants les moins âgés");
        for (int i = 0; i < 5; i++) {
            etudiants[i].afficher();
        }

        System.out.println("les 5 étudiants les plus âgés");
        for (int i = 45; i < 50; i++) {
            etudiants[i].afficher();
        }

        // Meilleure et plus faible note
        Etudiant meilleure = etudiants[0];
        Etudiant faible = etudiants[0];

        for (int i = 1; i < 50; i++) {
            if (etudiants[i].note > meilleure.note) {
                meilleure = etudiants[i];
            }
            if (etudiants[i].note < faible.note) {
                faible = etudiants[i];
            }
        }

        System.out.println("Meilleure note :");
        meilleure.afficher();

        System.out.println("Plus faible note :");
        faible.afficher();

        // Supprimer l'étudiant le moins âgé
        supprimerPlusJeune(etudiants);

        System.out.println("supprimer l'étudiant le moins agé");
    }

    // Trier par âge 
    static void trierParAge(Etudiant[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (t[i].getAge() > t[j].getAge()) {
                    Etudiant temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                }
            }
        }
    }

    //  Supprimer le plus jeune 
    static void supprimerPlusJeune(Etudiant[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            t[i] = t[i + 1];
        }
        t[t.length - 1] = null;
    }
}
