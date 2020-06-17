# Servidor web concurrente
En este proyecto se resuelven el siguiente ejercicio:

* Escriba un servidor web que soporte múltiples solicitudes seguidas (concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo páginas html e imágenes.

## Getting Started

Para hacer uso del proyecto solo debe clonar el repositorio o descargarlo directamente, para ejectarlo lo hacemos por medio de la consola usando el siguiente comando, al ejecutarlo el servidor ya quedará escuchando las peticiones.

```bash
java -cp target/herokusocketprimer-1.0-SNAPSHOT.jar co.edu.escuelaing.herokusocketprimer.HttpServer
```

### Prerequisites

Para usar el proyecto se necesitan tener las siguientes versiones de java o superior:


```
java version "1.8"
javac version "1.8"
Apache Maven 3.6.3
```

### Installing

Para usar el proyecto decargamos directamente el proyecto o lo clonamos de la siguiente manera:

En la consola nos vamos al directorio donde vamos a clonar el repositorio y ponemos el siguiente comando:

```bash
git clone https://github.com/anfegoca/ARSW-lab4.git

```
![clone](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/1.png)

En el direcctorio nos quedará la carpeta del proyecto y dentro veremos las siguiente carpetas

![direc](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/2.png)

Para modificar abrimos el proyecto con cualquier editor, en este caso usamos NetBeans

![edit](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/3.png)

Y ya podemos modificar cualquier clase del proyecto

![class](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/4.png)

## Running the tests

Para probar el funcionamiento vamos a hacer crear un **HTTPServer**, vamos a hacer un pool de 100 hilos y en cada uno de los hilos vamos a crear un **HTTPClient** el cuál realizará una solicitud de la página **index.html**, con esto comprobaremos que el server es capaz de soportar multiples solicitudes de multiples clientes

![class](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/5.png)

Para correr el test usamos el siguiente comando

```bash
mvn test
```

Obtendremos los siguientes resultados

![class](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/4.png)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

El versionamiento se realizó a través de [github](https://github.com/anfegoca/ARSW-lab4.git)

## Authors

* **Andrés González** - [anfegoca](https://github.com/anfegoca)


## License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details

## Design

![class](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/5.png)

El **HttpServer** recibe las solicitud que hace el navegador, usando un pool de hilos procesa cada solicitud en un hilo nuevo,en la clase **ConsumerPeticiones** saca el nombre del archivo que se quiere de la solicitud y haciendo uso de un **Interprete**, el cual es un **singleton** que identifica la extensión del archivo y con ello usa la clase **Reader** y el método **toHtml** si se trata de un archivo con extensión **html**, **js** o **css** el cual convierte el archivo en una cadena de texto y si se trata de una imagen usa el método **readImage**, el cual dada la dirección de la imagen la transforma la imagen en un arreglo de **Bytes**, una vez convertidos los archivos en texto el Interprete los manda como respuesta al navegador, el cual solo mostrará el resultado.

## JavaDoc

La documentación del proyecto la puede encontrar [aquí](https://github.com/anfegoca/ARSW-lab3/tree/master/site/apidocs)

