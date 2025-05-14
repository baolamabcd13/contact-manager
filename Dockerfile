FROM openjdk:21
WORKDIR /app
COPY build/libs/*.jar contact-manager.jar
CMD ["java", "-jar", "contact-manager.jar"]