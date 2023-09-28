# Journal de Bord

## Lundi 05/06

### Objectifs  : 
- Choix du chef de groupe
- Début de réfléxion sur le projet
- S'entrainer aux manipulations git
### Travail réalisé : 
- Cheffe de groupe : Asmae
- Mise en commun des idées de jeu : 2 idées distinctes
- Compréhension des contraintes du projet
- Lecture des FAQ

## Mardi 06/06
### Objectifs : 
- Préparation d'une proposition de jeu
### Travail réalisé : 
- Choix du jeu parmi les 2 idées de la veille suite à une discussion avec Olivier Gruber
- Discussion de ce que nous voulons mettre en place dans le jeu :le but, les enjeux, l'interface graphique, ...

## Mercredi 07/06
### Objectifs :
- Réunion avec Olivier Gruber
- Revue de la proposition 
- Discussion autour des prototypes
### Travail réalisé : 
- Discussion plus approndie sur le jeu : aspects techniques
- Début de discussion sur le choix  du prototypages et des hiérarchies de classes sur les automates et sur le model
## Jeudi 08/06
### Objectifs : 
- Rédaction d'une proposition avancée
- Suite du prototypage
- Début de réflexion sur le rôle des automates dans le jeu
### Travail réalisé : 
- Abandon des enigmes, car l'idée était trop flou. A la place dans les salles, il y aura un ennemi à combattre pour obtenir les récompenses
- Jeux de test sur l'archive fournie : 
	- Ali et Pamela : division de l'écran ainsi que placement des deux joueurs 
	-  Grégory et Brice : gérer les collisions avec les obstacles 
	-  Asmae et Louane : déplacement saut gauche, droite et vertical 
	-  Hakim : gérer git, répartiton de l'architecture vue/model/controler
## Vendredi 09/06
### Objectifs : 
- Commencer à manipuler l'archive fournie


### Travail réalisé : 
- 

| Team |Travail réalisé  |Conclusion 
|-------|-------|--------|---------|
| Grégory et Pamela|Implémentation de la 'caméra' qui suit le personnage lorsqu'il bouge | Fait et testé
|Louane|Mise en place du journal de bord, design des sprites et des personnages |Reste des srpites à trouver
|Hakim|Génération aléatoire |A continuer
|Asmae et Brice|Suite du choix des classes et des méthodes à instancier dans le model |A continuer
|Ali|Tentative de la visualisation de la salle en vue du dessus |Abandon

- Choix de la vue de profil pour la salle, car la vue du dessus est plus compliquée à implémenter (c'est possible mais il nous aurait fallu plus de temps)
## Lundi 12/06
### Objectifs : 
- Validation du contrat
- Commencer les implémentations : 


### Travail réalisé : 
-
| Team |Travail réalisé  |Conclusion 
|-------|-------|--------|---------|
| Brice et Grégory|Mise en place des automates : <br> - Création des classes <br>- Début de l'impémentation de ces classes| A finir 
|Ali|Suite de l'écran scindé en deux |A finir 
|Pamela|Déplacement du fond lorsque le personnage bouge |Fait et testé
|Louane|Compréhension du langage gal et début de création de petit automate|A continuer
|Hakim|Prototypage du modèle |A continuer


## Mardi 13/06
### Objectifs : 
- Finir les classes de l'automates et les tester
- Tester les sprites
- Finir le prototypage du modèle
-  
### Travail réalisé : 
- Division du travail : 
	- Automate : Asmae, Brice, Grégory
	- Modèle : Hakim, Louane
	- Vue : Ali, Pamela
	- Gestion du git : Ali
	
-
| Team |Travail réalisé  |Conclusion 
|-------|-------|--------|---------|
|Automate  |- Fin de l'implémentation des classes des automates  <br>- Création d'un automate brute (un Bull qui fonce) <br> - Début de réflexion sur le fonctionnement du parser pour avoir les ast et aut, puis les mettre en .dot et les afficher en .svg (lecture des FAQ) <br> - Création des .gal| - Automate brute tester : les classes d'automates sont OK <br> - Suite du parser au prochain épisode <br> - .gal à tester
|Vue|- Génération d'un nouveau décor lorsque le personnage bouge et déplacement du sol <br> - Initialisation de la classe Main  |- OK <br> 
|Model|- Génération aléatoire des obstacles et ennemis <br> Implémentation des classes du modèle <br> - Merge modèle avec master candidate et vue |- Génération aléatoire à testé
|Ali | Gestion du git et des merges(quelques problèmes à résoudre) | OK

## Mercredi 14/06
### Objectifs : 
- Implémenter le parser
- Implémentation du shop et de plusieurs autres classes du modèle
- Inclusion d'un ViewPort (équivalent de l'avatar dans les FAQ)

### Travail réalisé : 
-
| Team |Travail réalisé  |Conclusion 
|-------|-------|--------|---------|
|Automate  |- Avancement du parser  <br>- Début de la finalisation des classes du controller <br> - Implémentation d'automates en .gal| - Parser à finir 
|Vue|- Affichage des 2 screens (Top et bottom ont été faits sur la même classe donc on les a séparés en 2 classes distinctes) <br> - Correction de l'affichage su sol|- OK <br> <br> - OK
|Model|- Implémentation du shop <br> - Ajout d'une classe répertoriant les constantes qui permet de répertorier toutes les constantes du modèle <br> - Implémentation de Move dans les différentes classes, de Jump, et des constructeurs <br> - Recherche de tous les sprites |- Tout est à tester

- Discussion de certains fonctionnement pour avoir tous la même idée lors de nos implémentations (exemple : quels seront les paramètres des méthodes)

## Jeudi 15/06 
### Objectifs  : 
- Finir l'implémentation du parseur (la classe visiteur)
- Implémenter un Start Menu
- Tester des méthodes du modèle

### Travail réalisé : 
-
 | Team |Travail réalisé |Conclusion
  |-------|-------|--------|---------| 
  | View | Implémentation du Start Menu + inclusion du ViewPort | Fait et testé 
  | Automate | Implémentation du visiteur (parseur AST to Automata Object) | En progression 
  | Model  | Implémentation des différentes classes du Model ajout de la classe Ground et Hole (Louane) + création de nouvelles classes/interfaces pour gérer les entités de manière plus générique (Hakim) | A tester

## Vendredi 16/06 
### Objectifs : 
-  Terminer la partie automate
-  Recherche des derniers sprites et découpages de ces derniers
-  Créer le shop et implémentation d'une documentation des touches pour le joueur
### Travail réalisé : 
-
| Team |Travail réalisé |Conclusion 
|-------|-------|--------|---------| 
| View (Ali, Pamela) | Implémentation de l'affichage du Shop + implémentation des commandes de chaque joueur dans la page d'accueil + découpage des sprites et recherche des derniers sprites manquants | OK 
| Automate (Brice, Grégory, Asmae)| Partie automate terminée (sauf la partie optionnelle avec les probabilités) | Testé et fonctionnel 
| Model (Louane, Hakim) | Revue de la génération aléatoire et nettoyage du code | A tester

## Lundi 19/06 
### Objectifs : 
- Finir le shop 
- Créer l'inventaire des joueurs
- Gestion des probabilités dans les automates
- Avancer dans le modèle
### Travail réalisé : 
- 
 | Team |Travail réalisé |Conclusion 
 |-------|-------|--------|---------| 
 | View (Ali, Pamela) |Créer le Shop et l'inventaire des deux joueurs | OK 
 | Automate (Brice, Grégory, Asmae)| Gestion des probabilités dans le parseur | Testé et fonctionnel 
 | Model (Louane, Hakim) | Ajout des méthodes restantes liées à l'automate, génération aléatoire et collision | A tester


## Mardi 20/06 
### Objectifs : 
- Réaliser un premier merge du Vue, Modèle et Automate
- Reconstituer des équipes car la team automate à terminer

### Travail réalisé : 

 - Premier merge général du code des teams Automate, View et Model, afin de partir sur une base commune avec participation de l'ensemble du groupe. Ce merge à généré énormément de conflits dans notre code, mais il en a aussi généré quelques un au sein du groupe, ce qui nous a fait perdre beaucoup de temps.
 En effet, la partie Model du projet était très brouillon et Hakim a passé la journée à la nettoyer.
 
 - 
  | Team |Travail réalisé |Conclusion
  |-------|-------|--------|---------| 
  | Hakim, Ali & Pamela| Affichage de la MiddleBar (vie communes et pièces) (Ali & Pamela), génération aléatoire terminée | A tester 
 | Louane, Asmae & Brice | Implémentation des méthodes liées aux actions et conditions des automates (Pop, Cell etc)| A tester 
 | Grégory | Réflexion sur la structure du fichier de configuration | Idée correcte


## Mercredi 21/06
### Objectifs : 
- Implémenter une évolution de nos structures de données
- Améliorer le lien entre Vue et Model
- Implémenter AutKey des automates (petit oubli)
 

### Travail réalisé : 
- Discussion avec O. Gruber concernant le choix des structures de données pour la représentation du monde en objet
- Réflexion de la team Louane, Asmae, Brice sur les méthodes des conditions Cell et Closest nécessitant ces structures de données.  

 | Team |Travail réalisé |Conclusion
  |-------|-------|--------|---------| 
  |Ali & Pamela| Travail sur le lien entre View et Model, implémentation de l'affichage des différents sprites en fonction de l'état de l'entité, ajout d'une classe qui gère les éléments visibles | A tester 
  | Louane, Asmae & Brice | Implémentation du controller liées aux conditions AutKey | A tester
   | Grégory & Hakim | Implémentation des Buckets (structure de donnée du monde) | A tester
## Jeudi 22/06
### Objectifs : 
- Revoir la génération aléatoire
- Avoir des collisions fonctionnelles
- Revoir la gravité du jump
### Travail réalisé : 
-

| Team |Travail réalisé |Conclusion 
|-------|-------|--------|---------| 
| Asmae & Brice | Reprise de la classe Collision, en cohérence avec la nouvelle structure de données | A continuer
| Grégory & Hakim | Début d'implémentation des classes de la génération aléatoire | A tester 
| Louane | Reprise de l'implémentation du Jump | OK 
| Pamela & Ali | Ajout des Holes dans Floor + améliorations de Snake dans la partie View | OK



## Vendredi 23/06
### Objectifs :
- Finir la génération  aléatoire
- Merger
- Finir les collisions

### Travail réalisé :
-

| Team |Travail réalisé |Conclusion 
|-------|-------|--------|---------| 
| Grégory & Hakim | Implémentation de la génération aléatoire des obstacles et des ennemis | Problème à résoudre 
| Pamela | Modification de l’inventaire afin de le lier avec le Modèle + affichage manuel des coins dans la View | OK 
| Ali | Gestion des merge et git tout le long de la journée | OK 
| Louane | Aide sur la partie collision et partie génération aléatoire | 
| Asmae & Brice| Fin de l'implémentation des collisions | OK
    
## Samedi 24/06
### Objectifs : 
- Finir la génération aléatoire
- Mettre à jour la liaison entre le modèle et la vue

### Travail réalisé : 
-
    
   | Team |Travail réalisé |Conclusion 
   |-------|-------|--------|---------| 
   | Asmae & Brice| Merge entre collisions et génération aléatoire + appel des méthodes dans les actions pour que la collision se fasse | Fait et testé 
   |Pamela & Ali|Séparation de l’affichage des trous dans une classe séparée, liaison de l’affichage des vies avec le modèle| Fait et testé 
   |Hakim & Grégory| Résolution du bug de la génération aléatoire avec les Buckets | A continuer 
   | Louane | Implémentation des méthodes permettant de faire mourir l'entité, et ré-organisation des classes du Modèle | OK
    
## Dimanche 25/06
### Objectifs :
- Finir la génération aléatoire 
- Tester les collisions avec la génération des entités
### Travail réalisé : 
-
    
 | Team |Travail réalisé |Conclusion 
 |-------|-------|--------|---------| 
 | Asmae & Brice| Gestion des collisions : ajustement des constantes des HitBox dans View et Model | Fait et testé 
 |Pamela & Ali| Résolution de bugs dans la partie view, merge entre la partie View et la partie Modèle | Fait et testé 
 |Hakim | Résolution du bug de la génération aléatoire qui au final de ne venait pas de la génération aléatoire | OK 
 | Louane | Implémentation des méthodes permettant de faire mourir l'entité, et ré-organisation des classes du Modèle | A continuer 
 |Grégory | Rassemblement des idées pour la vidéo | A continuer
    

    
## Lundi 26/06 
### Objectifs : 
- Finir le jeu
### Travail réalisé : 
  -
   | Team |Travail réalisé |Conclusion 
   |-------|-------|--------|---------| 
   | Asmae & Pamela | Test des méthodes Pop() et Get() et liaison entre le Shop et l'inventaire | OK 
   | Pamela | Gestion des achats et de la collection des coins, implémentation de la fenêtre GameOver montrant le score | Fait et testé 
   | Asmae & Brice | Test des méthodes Cell et Closest | OK 
   | Louane | Test de la méthode Hit | Testé mais à merger 
   | Hakim & Brice | Génération des Holes et test de la méthode Egg | OK
   | Ali | Implémentation et test des ViewPort des Coins et Looter | OK 
   | Grégory | Génération du RedPlayer et affichage des Coins et Looter | OK


## Mardi 27/06 
### Objectifs : 
- Réaliser la vidéo de présentation
- Finir le journal de bord
### Travail réalisé : 

Réalisation de la vidéo, enregistrements des voix et montage  
| Team |Travail réalisé  |
|-------|-------|--------| 
| Asmae | Finalisation du journal de bord + Collisions 
| Brice | Montage de la vidéo, ajout des voix et musique de fond 
| Louane | Méthodes actions et conditions (Move() etc) 
| Pamela | Partie View  
| Grégory | Introduction du jeu, partie automate et génération aléatoire

 Pourcentage de  contribution  : 
 14,3% pour chaque personne.
 





