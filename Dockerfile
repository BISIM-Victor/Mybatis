# Usa una imagen base con Java 8
FROM openjdk:8-jdk-alpine

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR compilado a la imagen
COPY ./target/Mybatis-0.0.1-SNAPSHOT.jar /app.jar

# Expone el puerto por defecto de Spring Boot
EXPOSE 8081

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
