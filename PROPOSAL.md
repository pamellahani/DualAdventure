INFO3
Equipe E

# Proposition de notre jeu : 

**1. But principal du jeu**

C'est un jeu se jouant à deux, en coopération, le but étant de s'entraider pour aller le plus loin possible dans l'aventure. Le challenge étant de battre son record, calculé en fonction de la distance parcourue. 
Tout le long du jeu, les deux joueurs pourront accumuler des objets, et pourront se les échanger.
La difficulté augmente au fur et à mesure du jeu (de plus en plus d'ennemis).
Les deux joueurs possèdent 5 vies en commun.

Si l'ensemble des vies sont épuisées, alors le jeu se termine.

Les coins, inventaires et scores seront affichées en haut à gauche pour chaque joueur. Les vies, étant communes, seront affichées sur le bandeau central.

**2. Décor et vue**

La fenêtre sera divisée horizontalement en deux, correspondant à la vue de chaque joueur, avec des thèmes indépendants (rouge et bleu). Le monde généré pour les deux joueurs est également indépendant. 

Les joueurs pourront se déplacer à droite ou à gauche, la partie de droite sera générée de manière aléatoire à chaque fois qu'on avance. 
Le sol est plat, mais il peut y avoir des trous. Une gravité s'applique aux joueurs.

**3. Obstacles et ennemis**

Les joueurs rencontreront tout le long du jeu des obstacles, des objets et des ennemis. 

Les pièces sont générées aléatoirement, il faut marcher dessus pour les récupérer. Il y a un compteur de coins attribué à chaque joueur, tout comme leur inventaire.

Il y aura également plusieurs types d'ennemis :

| Ennemis |  But| 
|--|--|
| Rochers | Des rochers roulent et le joueur devra sauter pour l'esquiver |
| Flèches | Des flèches seront lancées et le joueur devra se baisser |
| Chauve-souris | Les attaquer ou se baisser  |
| Serpent | Les attaquer ou sauter |
| Pilleur | Attaquer, éviter de se faire toucher au risque de se faire piller un item/pièce |



> Si un des deux joueurs est touché par les différents ennemis précédemment cités, une quantité de vie (un quart, un demi etc) est perdue.

Concernant les obstacles, des murs et des portes apparaîtront également. Ceux-ci seront générés en fonction du thème du joueur, ce qui implique qu'il faudra casser le mur avec une pioche de la bonne couleur, et ouvrir la porte avec la clé de la bonne couleur. Les joueurs pourront s'échanger les clefs et les pioches pour coopérer.

Ces clés et ces pioches seront obtenues lors de duels avec des pilleurs.
Les buissons qui apparaissent sur notre chemin permettent d'avoir des pièces (si on les brûle avec la torche), et des items si on est très chanceux.

Il y aura aussi des trous qu'il faudra éviter.

**4. Actions des personnages**

* Aller à gauche (Q/left), aller à droite (D/right)
* Sauter (Z/up) , se baisser (S/down)
* Echanger un objet (possible uniquement avec les objets colorés) (espace pour les deux joueurs)
* Faire une action spécifique (l'action dépendra de l'objet qu'il a dans sa main actuellement) (W/O)
* Choisir un objet/arme (X/P)

Définition des actions Pop, Wizz et Egg : 
* Pop : Don d'un item coloré à l'autre joueur (l'autre joueur ne doit rien avoir dans sa main pour que cette action marche)
* Egg : Clonage des boules de feu (traînée) et Shurikens.  
* Wizz : pas d'action définie

Si aucun objet/arme est choisi : le personnage attaque simplement avec ses poings.

**6. Armes (et sac)**

Chaque joueur a par défaut une torche dans son inventaire au début du jeu.
Il pourra collecter des pièces (coins) et acheter des items dans une boutique. 
 
| Items du shop| Prix en coins | Nombre d'usage | Type 
|--|--|--|--|
| Vie (1 coeur)| 20 | | 
| Torche | 3 | 10x | Brûler un buisson (pour trouver un item)
| Hache | 10 | 7x | Attaque corps à corps
| Epée| 7  | 5x | Attaque corps à corps
| Shuriken | 2 | Usage unique | Attaque à distance
| Boules de feu| 8 | Usage unique | Attaque à distance
| 4 places en plus dans l'inventaire (optionnel) | 25 |
| Echange d'un item non coloré| 1 |

Parmi les items qu'il devra collecter et qui ne seront pas vendus dans la boutique, il y aura des clefs (rouge ou bleue, utile lors de la rencontre d'une porte) et des pioches (rouge ou bleue, utile lors de la rencontre d'un mur).

**7. Options** 

1) Création de plateformes en l'air et sur le sol (donc le sol n'est pas toujours pas plat)
5) L'inventaire est limité à 5 items. : si on souhaite en ajouter un alors que l'inventaire est plein, il faudra acheter quatre places en plus
2) Augmentation des statistiques (dégâts, vie) des ennemis selon notre distance parcourue (pour augmenter la difficulté)

4) Salle avec le pilleur

Le joueur pourra parfois trouver des salles où il sera libre d'entrer ou non. Dans cette salle (vue de profil), il y aura un pilleur, et il faudra réussir à le battre pour obtenir une clé ou une pioche (rouge ou bleue). 

5) Mystery Box, dont les malus (une vie en moins, modif des statistiques du joueur) et bonus (une vie en plus, modif des statistiques du joueur)

Par exemple, une Mystery Box apparaîtra (génération aléatoire) sur son chemin : elle donne soit un malus, soit un bonus et le joueur aura le choix de la prendre ou non (mais ne saura pas de ce qu'il s'agit avant d'accepter).





