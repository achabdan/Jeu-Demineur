**16/01/2023 Groupe 06 : Fdili, Marchal, Achabdan**

**Livrable**


Dans le cadre de notre cursus scolaire, nous avons entrepris le développement d'un jeu Java visant à concrétiser les concepts de la programmation orientée objet. Notre projet s'articule autour de la création d'une version du jeu classique « Mine Sweeper », intégrant des fonctionnalités avancées telles que la gestion des niveaux de difficulté, la sauvegarde et le chargement de parties, ainsi qu'une fonctionnalité de gestion de profils utilisateurs avec des statistiques de jeu.

La phase de conception revêt une importance cruciale dans le développement de notre application Mine Sweeper, car elle vise à établir une base solide en comprenant les besoins de l'utilisateur, en identifiant les entités clés du jeu, et en créant une architecture orientée objet cohérente.

**1. Définition des Besoins**

La phase initiale du projet implique une compréhension approfondie des besoins de l'utilisateur. Il est essentiel de collaborer étroitement avec les parties prenantes pour identifier et clarifier les fonctionnalités incontournables et facultatives de l'application. Ces besoins englobent la gestion avancée des joueurs, l'historique détaillé des parties, la création de terrains de jeu avec divers niveaux de difficulté, le placement aléatoire des mines, la sauvegarde et le référencement des terrains de jeu, ainsi que des actions de jeu intuitives. En outre, l'application doit permettre la sauvegarde et le chargement d'états de partie, tout en offrant une interaction utilisateur fluide via des commandes console. Cette conception d'interface devra également anticiper une évolution future vers d'autres types d'interfaces, garantissant ainsi une flexibilité pérenne.

**2. Analyse des Exigences**

Une fois les besoins définis, l'analyse des exigences consiste à identifier les entités principales du jeu, telles que : Board, Player, GameConstant, Game Controller et le Tile. Cette phase doit également clarifier les interactions entre ces entités pour garantir une implémentation cohérente.

**3. Diagramme de Classes UML**

La création d'un diagramme de classes UML initial est une étape clé. Ce diagramme servira de guide visuel pour définir les différentes classes, leurs relations, ainsi que les méthodes et attributs associés. Il permettra de conceptualiser l'architecture globale du système.

Voici le Diagramme de Classes UML de notre projet :
![UML du projet](./UML.png)

**4. Plan de Travail du Groupe**

Une distribution efficace des tâches est essentielle pour maximiser l'efficacité de l'équipe de développement. La définition claire des responsabilités de chaque membre, basée sur leurs compétences et spécialités, contribuera à une progression fluide du projet.
Marchal Côme est le leader technique du groupe, il sera responsable de la classe Tile et la classe Player.
Achabdan Mehdi sera responsable de la classe GameConstante et la classe Board.
Fdili Walid Saâd sera responsable de la classe GameController et tout ce qui a un rapport avec ce livrable.



**5. Plan de Tests**

Élaborer un plan de tests complet est crucial pour assurer la qualité du développement. Cela inclut des tests unitaires pour chaque composant, des tests d'intégration pour vérifier la collaboration entre les entités, et des tests de système pour garantir la jouabilité et les fonctionnalités principales.

**Conclusion**

En synthèse, la phase de conception pose les fondations du projet en définissant clairement les objectifs, en structurant les entités du jeu, et en créant un plan de travail stratégique pour l'équipe de développement. Ces éléments seront essentiels pour guider les phases ultérieures du développement de notre jeu Mine Sweeper.
