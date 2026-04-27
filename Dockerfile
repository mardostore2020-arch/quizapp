# Utiliser l'image officielle Maven pour construire
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copier les fichiers du projet
COPY pom.xml .
COPY src ./src

# Construire l'application JAR
RUN mvn clean package -DskipTests

# Étape 2: Image d'exécution légère
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copier le JAR depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port
EXPOSE 8080

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
