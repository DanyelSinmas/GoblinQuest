========================
INFORMACIÓN DEL PROYECTO
========================

- Este proyecto sirvió como último proyecto de la asignaruta  de programación de primero de DAW, hace uso de MySQL para los datos y estadisticas del usuario, también guarda información de inicio de sesión con hasheo en la base de datos. El inicio de sesión tiene una doble autentificación. Se hace uso de ficheros internos para el guardado y cargado de objetos (serialización) así como un logs de errores. Este proyecto se basa en un uso avanzado de POO combinado con herramientas de manejo de ficheros y base de datos.

========================
   MANUAL DE USUARIO
========================

-Este programa necesita de una base de datos MySQL local de forma que puedas aprovechar todas sus funciones, para su correcto funcionamiento se debe crear la base de datos local. Edita el .bat ubicado en attachment/BBDD.bat con tu nombre de usuario y contraseña (-u "usuario" -p"contraseña"). Una vez editado, guarda los cambios y ejecuta el .bat.
Al iniciar el programa se pedirá el usuario y contraseña, coloca los mismos que pusiste en attachments/BBDD.bat.

ATENCIÓN!
Al ejecutar BBDD.bat se crea la base de datos del juego desde 0, si ejecutas el script de nuevo, esta se borrará y creará de nuevo, perdiendo los datos guardados anteriormente.
