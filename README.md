# SmartCity

**SmartCity** es la aplicación de **back-end** de la Ciudad Inteligente. 

Su interfaz de comunicación es a través de servicios **REST** con la notación **HAL+JSON**.

Esta escrito en **Kotlin**, que es un lenguaje basado en java y que compila en bytecode, es decir, genera archivos *.class, lo cual permite que corra en la JVM, al igual que Java. Además es totalmente compatible y puede reutilizar todo el código escrito en Java e integrarse con las librerías y frameworks ya existentes.

Está montado sobre el framework **Spring Boot** para gestionar threads, conexión con base de datos, configuración general, gestión de servicios, etc.

Utiliza **Gradle** como herramienta de automatización de builds, que se engarga, entre otras cosas, de la compilación, modularización, gestión de librerías y dependencias. 


##Compilación


El compilador genera 4 archivos: 

Ubicación: %carpeta_del_proyecto%/api/build/libs

* smartcity-api-%version%.jar
* smartcity-api-%version%.jar.original
* smartcity-api-%version%.war
* smartcity-api-%version%.war.original

Los que terminan en *.original no incluyen las librerias, por lo cual no son muy utiles para utilizar.

El archivo *.jar incluye todas las librerias y un tomcat embebido, por lo cual puede ser ejecutado directamente con el comando `java -jar smartcity-api-1.0.jar`

El archivo *.war es un servlet y necesita un contenedor de servlets, como Tomcat, para funcionar. Esto es lo que se ejecuta en el servidor que usamos en clase.

**Requisito**
* Tener instalado: Java 8 JDK
* Haber clonado/bajado el proyecto


**Compilación en Unix/Linux:**

1) Abrir una terminal y navegar hasta la carpeta del proyecto
2) Ejecutar el comando: `./gradlew clean build`
3) Para correr la aplicacion ejecutar: `./gradlew run`

La aplicación correra, por defecto, en: `http://localhost:8888`

**Compilación en Windows**

... proximamente