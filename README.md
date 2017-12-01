# Seccion_07_Toolbar_Tabs_Lab
Laboratorio 7 Android - Tabby App.

Objetivo
--------
Crear una app llamada Tabby. Esta app, implementará 2 TABS, “Form” y “List”. Usaremos Toolbar y TabLayout con ViewPager, y crearemos un layout xml para el toolbar y
otro para el TabLayout. Intenta averiguar como usar dos <include> y posicionarlo uno debajo de otro.

En el Fragment para el Form, vamos a tener un simple formulario, compuesto por un editText para el nombre, un Spinner (lista desplegable) para los países y un botón para
crear Personas. Por lo tanto, tendremos dos modelos POJO a tener en cuenta, Country con name y countryCode, y Person, con name y country.

Country deberá tener un método llamado getFlagURL con el que a partir del código de país, nos proporcione la bandera alojada en Internet, mediante esta URL: “http://
www.geognos.com/api/en/countries/flag/{0}.png”, sustituyendo {0} por el código de país, por ejemplo “ES” de España. El enlace es un API de libre uso y gratuito, con
banderas de los países del mundo.

Person, deberá tener relación de composición con Country, lo que significa que su atributo country es del tipo Country (nuestro otro POJO).

En el Fragment para el List, vamos a tener un simple listView, donde renderizaremos nuestra lista de personas, que al principio estará vacía pero que desde el Fragment
Form podremos ir agregando. Vamos a mostrar el nombre, el país, y la bandera correspondiente al país a través del código de país y la página web indicada anteriormente.
Ayúdate de Picasso para la carga de imagen en el adaptador.

Crearemos una clase Util para proporcionarnos los valores que cargaremos en nuestro Spinner, con algunos países, puedes usar los que quieras, aquí proporciono un ejemplo:
  "España", "ES"
  "Argentina", "AR"
  "Bolivia", "BO"
  "Chile", "CL"
  "Colombia", "CO"
  "Ecuador", "EC"
  "Mexico", "MX"
  "Perú", "PE"
  "Uruguay", "UY"
  "Venezuela", "VE"
  
La interfaz para comunicarnos entre fragment-activity, será creada en un paquete diferente llamado Interfaces.

Probablemente, necesitaremos un cambio en nuestra POJO Country para ser renderizado correctamente en el Spinner, prueba con un array de storing y cuando funcione,
intenta encontrar la manera de adaptarlo con el modelo Country. No te preocupes si no lo encuentras, pero inténtalo :)

Cuando consigas crear una persona, mueve automáticamente mediante código y sin ninguna acción extra por parte del usuario, el fragment, para que sea visible el LIST
fragmento con la nueva persona añadida.

Esta app tiene que tener soporte para multilenguaje al menos 2.
