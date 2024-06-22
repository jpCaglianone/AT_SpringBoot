# Usar a versão correta do JDK
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR do diretório alvo para o diretório de trabalho dentro do container
COPY target/AT_SpringBoot-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
