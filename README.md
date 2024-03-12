# Microservicio API Rest de Encriptación - Apicriptografia

## Descripción
Este microservicio es una API Rest, la cual se encarga de la encriptación de texto plano bajo algoritmos seguros de encriptación, según seleccione el usuario; desarrollado en Java con Framework Spring Boot.

## Consideraciones

### Prerrequisitos
- Java JDK 17
- Maven, para la gestión de dependencias del proyecto

## Instalación y Configuración del Proyecto
Se deben seguir los siguientes pasos para preparar el entorno local para ejecutar la API:
```sh
git clone https://github.com/GrayHat18/apicriptografia-encriptacion.git
cd apicriptografia-encriptacion
git fetch
git pull origin master
```
### Configuración del ambiente local para la base de datos
Solicitar al dueño del repositorio las credenciales de acceso y configuraciones de Spring Boot para esta API

## Ejecución de la API

Para ejecutar la API, ejecutar el siguiente comando:
```sh
mvn spring-boot:run
```
## Uso de endpoints
La API cuenta con endpoints disponibles para ser consumidos, ya sea mediante `curl`, mediante una aplicación frontend o directamente con  `PostMan`. El detalle de 
los endpoints se encuentra a continuación:

### Tipos de Encriptación
- `GET /typeEncryption/listTypeEncryption`: Se recupera una lista de todos los tipos de encriptación registrados en base de datos
- `POST /typeEncryption/register`: Se crea un nuevo tipo de encriptación, el cual es un algoritmo oficial de encriptación, considerando el siguiente body:
```json
{
  "descriptorName": "nombreDelTipoDeEncriptacion",
  "descriptor": "descripcionExplicativaBreveDelTipoDeEncriptacion",
  "enabled": true
}
```

### Encriptaciones
- `GET /encryptions/listEncryptions`: Se recupera una lista de todas las encriptaciones realizadas por el usuario desde la base de datos
- `POST /encryptions/register`: Se crea una nueva encriptación de un texto plano ingresado por el usuario junto al tipo de encriptación para ser encriptado, considerando el siguiente body:
```json
{
  "encryptedText": "textoPlano",
  "typeEncryption":{
    "idTypeEncryption": 1,
    "descriptorName": "TipoDeEncriptaciónSeleccionado"
  },
  "enabled": true
}
```
Nota: Se debe reemplazar los métodos HTTP y las rutas de acuerdo al entorno local.

Para utilizar estos endpoints con `curl`, a continuación se muestra un ejemplo:
```sh
# Lista de todos los tipos de encriptación
curl -X GET http://localhost:8282/typeEncryption/listTypeEncryption

# Crear un nuevo tipo de encriptación
curl -X POST http://localhost:8282/typeEncryption/register -H "Content-Type: application/json" -d '{"descriptorName": "nombreTipoEncriptacion", ... el resto de atributos}'

# Crear una nueva encriptación de texto plano
curl -X POST http://localhost:8282/encryptions/register -H "Content-Type: application/json" -d '{"encryptedText": "textoPlano", ... resto de atributos}'

# Lista de todas las encriptaciones registradsa
curl -X GET http://localhost:8282/encryptions/listEncryptions

```

## Desarrollo

Respecto al desarrollo, se considera que en el entorno local debe estar instalado el JDK de Java versión 17, si no se encuentra instalado, se puede instalar de la siguiente manera 
en un entorno linux:

### Distribuciones basadas en RPM
1. Descargar el JDK 17 desde la página oficial de Oracle o usando OpenJDK, se descargará un archivo con extensión `.rpm`
2. Abrir una terminal
3. Navegar hacia el directorio donde se haya descargado el archivo `.rpm`
4. Instalar el paquete `.rpm` con el comando `rpm` o `dnf`, por ejemplo:

```sh
sudo dnf install jdk-17.0.1_linux-x64_bin.rpm
```
o
```sh
sudo rpm -ivh jdk-17.0.1_linux-x64_bin.rpm
```
5. Configurar las variables de entorno `JAVA_HOME` y actualizar tu `$PATH`. Para hacer esto, se tiene que editar tu archivo `.bashrc` o `.bash_profile` de la siguiente
manera:
```sh
export JAVA_HOME=/usr/java/jdk-17.0.1
export PATH=$JAVA_HOME/bin:$PATH
```
6. Y finalmente verificar la instalación con el siguiente comando en la terminal:
```sh
java -version
```

### Distribuciones basadas en Debian
1. Descargar el archivo tar.gz de la página oficial de Oracle o instalar OpenJDK desde el repositorio
2. Abrir una terminal
3. Si descargaste el archivo `tar.gz` manualmente, puedes extraer el archivo en un directorio de tu elección, por ejemplo:
```sh
sudo tar -xvf jdk-17_linux-x64_bin.tar.gz -C /usr/lib/jvm
```
4. Si utilizaste OpenJDK del repositorio, instala con:
```sh
sudo apt update
sudo apt install openjdk-17-jdk
```
5. Configura la variable de entorno `JAVA_HOME` y actualiza tu `$PATH`, puedes hacer esto en tu archivo `.bashrc` o `.bash_profile`.
6. Y finalmente verifica la instalación con:
```sh
java -version
```
### Nota
Recuerda que cada distribución de linux podría tener diferentes variaciones en su gestión de paquetes y nombres de los directorios de instalación, por lo tanto se
recomienda asegurarse de adaptar los comandos mencionados anteriormente a la configuración de tu distribución especifica y las rutas en donde se instale el JDK.

### Entorno de Windows
1. Descargar desde la página oficial de Oracle el JDK 17
2. Realizar la instalación normal, doble clic en el archivo descargado, verificar las rutas donde se haga la instalación y esperar a que finalice la instalación
3. Descargar el IDE de desarrollo de tu preferencia

## Contribuir
Para contribuir con el desarrollo de esta API, se tienen las siguientes consideraciones:
1. Solamente realizar pull request al branch `develop`
2. Respetar el trabajo de otros colaboradores, considerando apoyo y/o mejoras en el código fuente mediante comentarios
3. Y por favor seguir los siguientes pasos:
- Hacer un fork del repositorio
- Clonar tu fork localmente
- Crear una nueva feature a partir del branch `develop`
- Hacer los cambios que desees colaborar
- Hacer commit de tus cambios y push a tu fork
- Crear un Pull Request desde tu fork al branch `develop`

## Contacto
Ante cualquier duda o consulta detallada respecto al desarrollo de esta API, por favor comunicarse con `GrayHat` en los siguientes canales de comunicación:
`fabian.hernan95@gmail.com` o al instagram `@grayhat18`.


