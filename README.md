# 🔤 Mystery Word — Backend

API REST Spring Boot qui alimente le jeu du pendu **[Le Mot Mystère](https://github.com/MathieuBourasseau/front-mystery-word)**. Le backend est "authoritative" : il choisit le mot mystère et le sert au frontend, qui ne fait qu'afficher l'état du jeu.

- **Stack** : Java 25, Spring Boot 4.1 (Web + Data JPA), PostgreSQL
- **Déploiement** : [Render](https://render.com) (Docker)

## Endpoints

| Méthode | Route              | Description                                    |
| ------- | ------------------ | ----------------------------------------------- |
| `GET`   | `/api/randomWord`  | Retourne un mot aléatoire parmi ceux en base    |

Exemple de réponse :

```json
{ "id": 3, "name": "JAVASCRIPT" }
```

## Prérequis

- Java 25
- Maven (ou le wrapper `./mvnw` si présent)
- Une base PostgreSQL (locale ou distante)

## Configuration

La connexion à la base de données est définie dans [`application.properties`](src/main/resources/application.properties) et attend deux variables d'environnement :

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mystery_words_db
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Avant de lancer le projet en local, exportez ces variables (ou utilisez un fichier `.env` avec votre IDE) :

```bash
export DB_USERNAME=postgres
export DB_PASSWORD=your_password
```

> `spring.jpa.hibernate.ddl-auto=update` : le schéma de la table `words` est créé/mis à jour automatiquement au démarrage, mais **la table n'est jamais peuplée automatiquement**. Il faut insérer des mots manuellement (voir plus bas).

## Lancer le projet en local

```bash
./mvnw spring-boot:run
```

L'API est disponible sur [http://localhost:8080](http://localhost:8080).

## Peupler la base de mots

Il n'existe pas encore d'endpoint pour ajouter des mots via l'API. En attendant, insère-les directement en base :

```sql
INSERT INTO words (name) VALUES
('ORDINATEUR'),
('JAVASCRIPT'),
('MONTAGNE')
ON CONFLICT (name) DO NOTHING;
```

> Les mots doivent être en majuscules, sans accents ni espaces : le frontend ne gère que les lettres `A-Z`.

## Build & Docker

```bash
# Build du jar
./mvnw clean package

# Build de l'image Docker (multi-stage : build Maven + runtime JRE léger)
docker build -t backend-mystery-word .
docker run -p 8080:8080 -e DB_USERNAME=postgres -e DB_PASSWORD=your_password backend-mystery-word
```

## Structure du projet

```
src/main/java/com/portfolio/backend_mystery_word/
├── controllers/
│   └── WordController.java     # Expose GET /api/randomWord
├── models/
│   └── Word.java                # Entité JPA mappée sur la table "words"
├── repositories/
│   └── WordRepository.java      # Accès aux données (JpaRepository)
└── BackendMysteryWordApplication.java
```

## Licence

Projet personnel à but éducatif.
