# Arbre Binaire de Recherche (ABR)

Ce projet contient une implémentation en Java d'un dictionnaire basé sur un Arbre Binaire de Recherche (ABR).

## Classes

Le projet contient les classes suivantes :

* `Element` : Cette classe représente un élément qui contient une clé et une valeur.
* `Noeud` : Cette classe représente un noeud dans l'ABR. Chaque noeud contient un élément et des références vers son noeud gauche et son noeud droit.
* `ArbreBinaire` : Cette classe implémente les opérations de base sur un dictionnaire basé sur un ABR, y compris l'ajout, la recherche et la suppression d'éléments.
* `Main` : Cette classe contient un exemple d'utilisation de l'arbre binaire.
* `TestArbreBinaire` : Cette classe contient un test de performance pour l'ajout et la suppression d'éléments.

## Fonctionnalités

* **Ajout d'éléments** : Les éléments sont ajoutés en suivant la logique de l'ABR. Si la clé de l'élément est inférieure à la clé du noeud actuel, l'élément est ajouté à gauche, sinon, il est ajouté à droite.
* **Recherche d'éléments** : La recherche d'un élément se fait également en suivant la logique de l'ABR.
* **Suppression d'éléments** : La suppression d'un élément se fait en trois cas possibles : Si le noeud à supprimer n'a pas d'enfants, il est simplement supprimé. Si le noeud a un seul enfant, ce dernier remplace le noeud. Si le noeud a deux enfants, son successeur dans l'ordre infixe (le plus petit noeud de son sous-arbre droit) le remplace.
* **Affichage des éléments** : Les éléments sont affichés dans l'ordre croissant de leurs clés.

## Test de performance

La classe TestArbreBinaire génère un grand nombre d'éléments aléatoires et les ajoute à l'arbre. Ensuite, elle supprime un certain nombre d'éléments aléatoires. Le temps nécessaire pour ces opérations est mesuré et affiché.
