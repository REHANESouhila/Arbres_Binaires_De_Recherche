import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void insertionDansArbre(ArbreBinaire dico, Element[] aInserer, String fichier) {
        long debut = System.currentTimeMillis();
        for (Element e : aInserer) {
            dico.ajouter(e);
        }
        long fin = System.currentTimeMillis();
        long duree = fin - debut;
        double moyenne = (double) duree / aInserer.length;

        System.out.println("Temps nécessaire pour l'insertion de 1000 éléments est : " + duree + " ms");
        System.out.println("Temps moyen de l'insertion de 1000 éléments est : " +
                           String.format("%.3f", moyenne) + " ms");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true))) {
            bw.write(Long.toString(duree));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void suppressionDansArbre(ArbreBinaire dico, Element[] aSuppr, String fichier) {
        long debut = System.currentTimeMillis();
        for (Element e : aSuppr) {
            dico.supprimer(e);
        }
        long fin = System.currentTimeMillis();
        long duree = fin - debut;
        double moyenne = (double) duree / aSuppr.length;

        System.out.println("Temps nécessaire pour la suppression de 1000 éléments est : " + duree + " ms");
        System.out.println("Temps moyen pour la suppression de 1000 éléments est : " +
                           String.format("%.3f", moyenne) + " ms");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true))) {
            bw.write(Long.toString(duree));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertionDansListeChainee(DicoListe dico, Element[] aInserer, String fichier) {
        long debut = System.currentTimeMillis();
        for (Element e : aInserer) {
            dico.ajouter(e);
        }
        long fin = System.currentTimeMillis();
        long duree = fin - debut;
        double moyenne = (double) duree / aInserer.length;

        System.out.println("Temps nécessaire pour l'insertion de 1000 éléments est : " + duree + " ms");
        System.out.println("Temps moyen de l'insertion de 1000 éléments est : " +
                           String.format("%.3f", moyenne) + " ms");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true))) {
            bw.write(Long.toString(duree));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void suppressionDansListeChainee(DicoListe dico, Element[] aSuppr, String fichier) {
        long debut = System.currentTimeMillis();
        for (Element e : aSuppr) {
            dico.supprimer(e);
        }
        long fin = System.currentTimeMillis();
        long duree = fin - debut;
        double moyenne = (double) duree / aSuppr.length;

        System.out.println("Temps nécessaire pour la suppression de 1000 éléments est : " + duree + " ms");
        System.out.println("Temps moyen pour la suppression de 1000 éléments est : " +
                           String.format("%.3f", moyenne) + " ms");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true))) {
            bw.write(Long.toString(duree));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gestion des fichiers
        String fichierResuInsertionAbr   = "resuInsertionAbr.txt";
        String fichierResuSuppressionAbr = "resuSuppressionAbr.txt";
        String fichierResuInsertionListe = "resuInsertionListe.txt";
        String fichierResuSuppressionListe= "resuSuppressionListe.txt";

        // Étape 1 : création de l'ensemble de  10 000 éléments à inserer 
        int nbElement = 10000;
        Element[] elements = new Element[nbElement];
        Random rand = new Random();
        for (int i = 0; i < nbElement; i++) {
            int cle = rand.nextInt(1000000);
            elements[i] = new Element(cle, String.valueOf(i));
        }

        // Étape 2 : sélection de 1000 éléments à supprimer
        double probaSuppression = 0.15;
        Element[] aSuppr = new Element[1000];
        int nbElemSuppr = 0;
        for (Element e : elements) {
            if (rand.nextDouble() < probaSuppression && nbElemSuppr < 1000) {
                aSuppr[nbElemSuppr++] = e;
            }
        }

        // Génération de 1000 nouveaux éléments à insérer
        Element[] aInserer = new Element[1000];
        for (int i = 0; i < 1000; i++) {
            int cle = rand.nextInt(1000000);
            aInserer[i] = new Element(cle, String.valueOf(i));
        }

        // Arbre binaire
        ArbreBinaire dicoAbr = new ArbreBinaire();
          
        // Insertion des 10000 éléments
        for (Element e : elements) {
            dicoAbr.ajouter(e);
        }

        System.out.println("\n--- ABR : ---");
        //Insertion des 10000 éléments
        insertionDansArbre(dicoAbr, aInserer, fichierResuInsertionAbr);

        //Suppression des éléments conservés 
        suppressionDansArbre(dicoAbr, aSuppr, fichierResuSuppressionAbr);
        System.out.println("Hauteur : " + dicoAbr.hauteur());

        // Liste chaînée
        System.out.println("\n--- Liste chaînée : ---");
        DicoListe dicoListe = new DicoListe();

        //Insertion des 10000 éléments
        for (Element e : elements) {
            dicoListe.ajouter(e);
        }

        //Insertion des 10000 éléments supplémentaires
        insertionDansListeChainee(dicoListe, aInserer, fichierResuInsertionListe);

        //Suppression des 1000 éléments consérveés 
        suppressionDansListeChainee(dicoListe, aSuppr, fichierResuSuppressionListe);
        System.out.println("Longueur finale de la liste chaînée : " + dicoListe.longueurDicoListe());
    }
}

