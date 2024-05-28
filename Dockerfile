# Utiliser une image de base OpenJDK
FROM maven AS build
WORKDIR C:/Users/youssef/Desktop/bookstore_spring_boot_project-main
COPY . .
RUN mvn clean package
FROM openjdk:11-slim
WORKDIR /app
COPY --from=build /Users/youssef/Desktop/bookstore_spring_boot_project-main*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
