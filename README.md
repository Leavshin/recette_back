# Application Delices culinaires
## Prérequis :
* [Node 20](https://nodejs.org/)+
* [JDK 17](https://www.oracle.com/fr/java/technologies/downloads/)
* [Docker](https://www.docker.com/get-started/)
* [Git](https://git-scm.com/downloads)

## Lancement de l'application

Pour installer l'application, lancez un terminal et faites la commande ci-dessous dans le dossier en local que vous souhaitez:

```bash
git clone https://github.com/Leavshin/recette_back.git
```

Déplacez-vous dans le dossier nouvellement créé puis lancez le conteneur docker (n'oubliez pas de lancer docker desktop au préalable):
```bash
cd .\recette_back\
docker-compose up -d --build
```

* Une fois lancé, vous pouvez ouvrir votre navigateur sur l'adresse suivante pour accéder à l'application : [http://localhost:4201](http://localhost:4201)

* Vous pouvez accéder au pgadmin via l'adresse : [http://localhost:8081](http://localhost:8081) 

## Informations supplémentaires

Si vous voulez accéder au projet angular : 
```bash
git clone https://github.com/Leavshin/recette_front.git
```