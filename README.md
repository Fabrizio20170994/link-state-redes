# link-state-redes
Programa de simulación de algoritmo de estado de enlace (link-state) implementando **Dijkstra** y lecturas de datos mediante archivos en formato **.xlsx** para el cursos de Redes de Computadoras 2020-1
## Integrantes

 - **Montemayor**
 - **Sotelo**
 - **Gomez**
 - **Chiri**

## Pasos para replicar en NETBEANS

 - Una vez clonado el repositorio se deben enlazar las librerías, para esto Netbeans mostrará un mensaje de Resolución de Problemas, en el que se debe ubicar las 6 librerías en el mismo directorio del repositorio. Una vez enlazadas puede cerrar la ventana.
 - Luego cambiar la línea de código donde se menciona la ubicación del archivo **.xlsx** que contenga los datos de prueba en **pruebaD.java** : `File f=new File("Ubicación de Archivo");`
## Manipulación del Archivo .xlsx
 - Cada fila después de la cabecera representará una arista **(Nodo Inicial, Nodo Final, Peso)**
 > Si existen X número de nodos en su topología, estos se representan de 0 a X-1
 - Este programa trabaja con Grafos no dirigidos, por lo que se debe de considerar el ingreso de caminos de ida y vuelta en el archivo
