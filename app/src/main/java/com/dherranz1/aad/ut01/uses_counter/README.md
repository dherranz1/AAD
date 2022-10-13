## Description de la tarea

<!-- Descripción sobre lo que se pide en la tarea -->
Contar el número de veces que se abre la aplicación.
Mostrar cuántas veces se ha abierto hasta el momento en un textview.
Incluir botón de reset.
Al llegar a 5 veces, notificarlo con Snackbar.


## ¿Cómo se ha implementado?

<!-- Estructura de clases, patrones: MVVM, etc.  -->

Capa presentation
    Ut01UsesCounterActivity

Capa data
    local
        OpenedLocalDataSource
    CounterRepository

La actividad de la capa de presentación interactúa con la capa de datos, mediante el patrón repository usando la clase CounterRepository.
La clase OpenedLocalDataSource se encarga de trabajar con sharedpreferences para tratar la información del número de usos.

## Keywords

<!-- Palabras relacionadas con los conceptos vistos -->
Sharedpreferences, LinearLayaout, TextView, Button, Snackbar

## Screenshots or Video

<!-- Captura de pantalla de la consola -->

## Objetivos

<!-- Buscar en el README el Resultado de Aprendizaje con el que se está trabajando -->

## Criterios de Evaluación
<!-- 
    Buscar en el README los criterios de Evaluación con los que se están trabajando.
    Marca con una [X] los conseguidos. Ejemplo:
    [ ] Criterio Evaluación 1.
    [ ] Criterio Evaluación 2.
    [X] Criterio Evaluación 3.
-->