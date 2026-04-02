# Etapa 1: Construcción
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:21-jre
WORKDIR /app
# Buscamos cualquier archivo .war o .jar en la carpeta target y lo renombramos a app.jar
COPY --from=build /app/target/*.war /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]