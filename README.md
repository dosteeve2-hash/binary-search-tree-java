Binary Search Tree & AVL Tree – Java (GUI)
Description

Ce projet est une implémentation complète d’un Binary Search Tree (BST) et d’un AVL Tree en Java, avec une interface graphique Swing permettant d’interagir dynamiquement avec les arbres.

L’application permet d’insérer, supprimer, parcourir et visualiser les arbres, tout en comparant le comportement d’un BST classique et d’un AVL auto-équilibré.

Technologies utilisées

Java

Programmation Orientée Objet (OOP)

Structures de données

Java Swing (GUI)

Fonctionnalités implémentées
🌳 Binary Search Tree (BST)

Insertion de valeurs

Suppression de nœuds

Recherche de valeurs

Parcours :

Inorder

Preorder

Postorder

Calcul :

Nombre total de nœuds

Liste des feuilles

Gestion des cas limites (arbre vide, structure dynamique)

⚖️ AVL Tree

Insertion avec équilibrage automatique

Rotations AVL (gauche, droite)

Maintien du facteur d’équilibre

Parcours inorder pour vérification de la structure

🖥️ Interface Graphique (Swing)

Interface interactive pour :

Insérer des valeurs

Supprimer des valeurs

Afficher les parcours

Bouton pour basculer entre BST et AVL

Affichage des résultats dans une zone de texte

Visualisation logique du comportement des arbres

Structure du projet
binary-search-tree-java/
│
├── BinarySearchTree.java   // Implémentation du BST
├── AVLTree.java            // Implémentation de l’AVL Tree
├── TreeGUI.java            // Interface graphique Swing
└── README.md

Exécution du projet
Prérequis

Java JDK 8 ou plus

Compilation
javac *.java

Lancement
java TreeGUI

Concepts abordés

Binary Search Tree (BST)

AVL Tree et équilibrage

Récursivité

Rotations d’arbres

Parcours d’arbres binaires

Structures de données avancées

Interaction utilisateur via GUI

Séparation logique / interface

Ce que j’ai appris avec ce projet

Implémenter des arbres binaires en Java

Comprendre la différence entre BST et AVL

Gérer l’équilibrage automatique via rotations

Concevoir une interface graphique pour manipuler des structures de données

Structurer un projet Java clair et maintenable

Améliorations possibles

Visualisation graphique réelle de l’arbre (dessin des nœuds)

Support des types génériques (Tree<T>)

Ajout de tests unitaires (JUnit)

Sauvegarde / chargement de l’arbre

Comparaison des performances BST vs AVL

Auteur

Steeve Donald
Computer Science Student
Data Structures & Algorithms – Java
