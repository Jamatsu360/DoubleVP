# DoubleVP

Este proyecto consiste en un crud para la adminstracion de tickets, usando una base de datos en Postgres y un Api desarrollada en Java Spring

- Para su correcta ejecucion y pruebas se da material adicional ubicado en la carpeta /deployment
<hr>
A continuacion se detalla el paso a paso para crear correctamente la base de datos usando una imagen docker/PostgreSQL

1. Desde el aplicativo de docker se debe descargar la imagen oficial de Postgres en su ultima version
2. Una vez se tenga la imagen se debe se debe crear el contenedor, se debe ubicar la carpeta /deployment en la raiz del proyecto y el archivo comandos.txt
3. Ejecutar el comando #1 
4. Para probar el correcto funcionamiento de la base de datos se debe usar el comando #2 desde el sistema operativo (Si solicita password usar el comando #2.1) del contenedor de Postgres y estar logueado dentro del motor de bases de datos
5. Una vez dentro del motor de postgres se debe ejecutar el comando #3 para crear la tabla que va a guardar la informacion
6. Despues de crear la tabla ejecutar el comando #4 para insertar datos semilla

- NOTA:
Debido a que es un ejercicio academico no se encriptaron las credenciales de coneccion ni se usaron variables de entorno
<hr>
Ya creada y ejecutandose la base de datos se debe proceder a ejecutar el desarrollo del proyecto hecho en java, el cual expone una serie de servicios para probar la insercion, actualizacion, busqueda y eliminacion de datos:

Se ha creado una coleccion de servicios que se pueden importar en el aplicativo Postman, esta se encuentra en la carpeta /deployment en la raiz del proyecto bajo el nombre DoubleVP.postman_collection.json

1. POST/Test => Servicio para comprobar correcto funcionamiento del aplicativo java y comunicacion Restful por protocolo http
2. POST/Crear Ticket => Servicio que crea un ticket, recibe como cuerpo un JSON con el usuario y el estado
3. POST/Actualizar Ticket => Servicio que actualiza un ticket, recibe como cuerpo un JSON con el id del ticket, el usuario y el estado
4. GET/Buscar Ticket => Servicio que busca un unico ticket, recibe en el header de la peticion el parametro id que se desea buscar
5. PUT/Eliminar Ticket => Servicio que elimina un unico ticket, recibe en el header de la peticion el parametro id que se desea eliminar
6. POST/Listar Tickets => Servicio que trae una lista de tickets paginados de acuerdo a los parametros dados (La X indica que es obligatorio):

        X pagina: Indica la pagina que se desea recuperar

        X tamanio: Indica de cuantos elementos es cada pagina

        fechaCreacionMinima: Fecha de creacion minima que se desea filtrar, debe tener el siguiente formato: "yyyy-MM-dd'T'HH:mm:ss"

        fechaCreacionMaxima: Fecha de creacion maxima que se desea filtrar, debe tener el siguiente formato: "yyyy-MM-dd'T'HH:mm:ss"

        X ticketReq:
            usuario: Caracteres que debe contener el usuario (Case sensitive)
            id: Numero de id exacto del usuario que se desea buscar (-1 indica que busca todos los id´s posibles)

<hr>