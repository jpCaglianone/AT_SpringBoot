# Use a imagem base do JDK
FROM openjdk:17-jdk-alpine

# Define um argumento para o JAR do aplicativo
ARG JAR_FILE=target/*.jar

# Copie o JAR para a imagem Docker
COPY ${JAR_FILE} app.jar

# Exponha a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]
