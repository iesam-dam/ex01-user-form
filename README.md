# Ejercicio User - Form (ex01-user-form)

El ejercicio consiste en añadir usuarios a un fichero xml con SharedPreferences. Se podrán añadir y eliminar. Sólo se podrán mostrar 5 filas.

![Formulario](/assets/form.jpeg)

## Funcionamiento
El formulario tendrá los siguientes elementos:
- Una etiqueta **Nombre**.
- Un campo de texto para recoger el nombre.
- Una etiqueta **Apellidos**.
- Un campo de texto para recoger los apellidos.
- Un botón **Guardar** que persistirá en Local los datos introducidos por el usuario.
- Un botón **Limpiar** que borrará las cajas de texto del nombre y apellidos.
- Un botón **Mostrar** que visualizará 5 registros de local (aunque haya más, sólo mostrará 5 como máximo).
- Una tabla en la que cada fila será un registro guardado en local.
- Cada una de las filas tendrá un botón **Eliminar** que borraré la información de local (recargar los datos tras eliminar).

1. El usuario introducirá un nombre y apellidos. Pulsará en Guardar y se almacenará en local (SharedPreferences).
2. El usuario visualizará el registro que acaba de insertar.
3. El usuario borrará las cajas de texto con el botón Limpiar.
4. El usuario insertará más datos.
5. El usuario eliminará datos.

## Vídeo
Vídeo con la solución al problema  
[<img src="https://i.ytimg.com/vi/4xHTrbfa3GI/maxresdefault.jpg" width="50%">](https://www.youtube.com/watch?v=4xHTrbfa3GI "Ejercicio Formulario en Android")


## Conceptos
- Activity
- Elementos de la vista: LinearLayout, EditText, TextView, Button, include, ConstraintLayouts, RelativeLayout.
- Eventos en botónes: OnClick.
- ViewBinding.
- ViewModel (MVVM).
- Clean Architecture.
- SharedPreferences (obtener, guardar, eliminar).
- Serialización (Gson).
- Gradle (añadido de librerías).
- LiveData.
- Coroutines.
- UiModel.
- Patrón Observer.
- SOLID: Single Responsability.

## Módulos
**Programación Multimedia y Dispositivos Móviles**
- Activity: Ciclo de vida
- Elementos de la vista: LinearLayout, EditText, TextView, Button, include, ConstraintLayouts, RelativeLayout.
- Eventos en botónes: OnClick.
- ViewBinding.
- ViewModel (MVVM).
- Gradle (añadido de librerías).
- LiveData.
- UiModel.

**Programación de Servicios y Procesos**
- Coroutines.

**Acceso a Datos**
- SharedPreferences (obtener, guardar, eliminar).

**Común**
- Clean Architecture.
- Serialización (Gson).
- Patrón Observer.
- SOLID: Single Responsability.
