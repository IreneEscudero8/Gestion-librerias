# Sistema de Gestión para Asociación de Librerías

**Autora:** Irene Escudero Cázarez  
**Fecha:** 15 de mayo de 2024  
**Curso:** Algoritmos y programas  
**Institución:** Instituto Tecnológico Autónomo de México

---

## 📚 Descripción General

Este proyecto consiste en un sistema informático desarrollado en Java con GUI (Swing) que permite gestionar una asociación de librerías. Permite registrar y consultar información de sucursales, libros, ventas y realizar operaciones de administración de inventario de forma eficiente y automatizada.

---

## 🧠 Objetivos

- Automatizar el manejo de múltiples librerías y sus inventarios.
- Facilitar la localización y gestión de libros.
- Optimizar recursos humanos y materiales.
- Implementar una GUI amigable para el usuario.

---

## 🧩 Requisitos y Restricciones

### ✅ Requisitos funcionales

- Java y Eclipse para su ejecución.
- Todas las clases deben estar en el mismo proyecto o correctamente enlazadas.
- Solo se permiten valores numéricos mayores a 0.
- Datos deben coincidir con los registrados para realizar operaciones exitosas.

### 🚫 Restricciones

- Máximo de **15 librerías** en la asociación.
- Cada librería puede almacenar un máximo de **50 libros**.
- No se pueden repetir nombres de libros o librerías.

---

## 🏗️ Diseño del Sistema

El sistema está compuesto por las siguientes clases:

| Clase    | Descripción                                                                 |
|----------|------------------------------------------------------------------------------|
| `Libro`  | Representa un libro con título, autor, año, número de páginas y editorial.   |
| `Librería` | Maneja los libros de una sucursal, su inventario y datos básicos.          |
| `AsoLib` | Gestiona el conjunto de librerías y permite operaciones cruzadas entre ellas.|
| `Vista`  | GUI que permite la interacción del usuario.                                  |
| `Controlador` | Intermediario entre la vista y la lógica de negocio.                    |
| `Main`   | Ejecutable del sistema.                                                      |

---
## UML:
+---------------------------+
|           Libro           |
+---------------------------+
| - titulo: String          |
| - autor: String           |
| - anio: int               |
| - numPaginas: int        |
| - editorial: String       |
+---------------------------+
| + Libro(...)              |
| + getTitulo(): String     |
| + getAutor(): String      |
| + getAnio(): int          |
| + getNumPaginas(): int    |
| + getEditorial(): String  |
| + equals(Libro): boolean  |
| + compareTo(Libro): int   |
| + toString(): String      |
+---------------------------+

+----------------------------------+
|            Libreria             |
+----------------------------------+
| - nombre: String                |
| - direccion: String             |
| - gerente: String               |
| - libros: Libro[]               |
| - ejemplares: Integer[]         |
| - MAX: int                      |
| - ocupados: int                 |
+----------------------------------+
| + Libreria(...)                 |
| + getNombre(): String           |
| + getDireccion(): String        |
| + getGerente(): String          |
| + getOcupados(): int            |
| + altaLibro(...): boolean       |
| + bajaLibro(titulo): boolean    |
| + registrarVentaLib(...): boolean |
| + cuantosHayTitulo(titulo): int|
| + librosAutor(autor): ArrayList|
| + agregarEjemplares(...): bool |
| + infoLibro(titulo): String     |
| + toString(): String            |
+----------------------------------+

+--------------------------------------------+
|                 AsoLib                     |
+--------------------------------------------+
| - nombre: String                          |
| - librerias: Libreria[]                   |
| - MAX: int                                |
| - ocupados: int                           |
+--------------------------------------------+
| + AsoLib(...)                             |
| + getNombre(): String                     |
| + getOcupados(): int                      |
| + altaLibreria(...): boolean              |
| + bajaLibreria(nombre): boolean           |
| + altaLibro(...): boolean                 |
| + bajaLibro(...): boolean                 |
| + registrarVenta(...): boolean            |
| + cuantosHayTituloTotal(titulo): int      |
| + cuantosHayTituloLib(...): int           |
| + donde(titulo): String                   |
| + titulosPorAutor(autor): ArrayList       |
| + cambioDeLibreria(...): boolean          |
| + agregarEjemplares(...): boolean         |
| + infoLibreria(nombre): String            |
| + infoLibro(...): String                  |
| + librerias(): String                     |
| + toString(): String                      |
+--------------------------------------------+


---

## 💻 Implementación de la GUI

La interfaz gráfica tiene 4 secciones principales:

1. **Gestión de librerías**
2. **Gestión de libros**
3. **Consultas y acciones**
4. **Área de mensajes**



---

## 🧪 Casos de Prueba y Resultados

| Prueba                            | Entrada                               | Resultado Esperado             |
|----------------------------------|----------------------------------------|--------------------------------|
| Alta librería                    | Datos correctos                        | Alta exitosa                   |
| Alta libro ya existente          | Título duplicado en la misma librería | Alta no exitosa                |
| Baja libro inexistente           | Libro no registrado                    | Baja no exitosa                |
| Venta de todos los ejemplares   | Ejemplares = inventario               | Libro se elimina automáticamente |
| Consulta total libros por título | “Título” y “Nombre” vacío              | Cantidad total entre librerías |
| Cambio de librería               | Librerías y título correctos           | Cambio exitoso                 |

---

## 📊 Análisis de Resultados

El sistema fue sometido a distintas pruebas para validar su robustez. Se detectaron errores como:

- Campos vacíos sin validación adecuada.
- Falta de verificación de datos numéricos negativos.
- Dificultad para consultar sin conocer nombres exactos.

Se corrigieron añadiendo validaciones, condiciones de error, y una funcionalidad de consulta general (“Librerías”).

---

## ✅ Conclusiones

- El proyecto cumple con los objetivos de automatizar y facilitar la gestión de librerías.
- Su diseño modular y GUI amigable permiten escalar o integrar nuevas funcionalidades fácilmente.
- Promueve el acceso más justo y eficiente a la cultura mediante una mejor administración de libros.

---

## 📎 Referencias

- Galiana, Y. (2022). [10 razones por las que son importantes las bibliotecas públicas](https://www.lecturalia.com/blog/2022/10/19/razones-por-las-que-son-importantes-las-bibliotecas-publicas/)
- Oscar, A. N., & Graciela, T. Q. (n.d.). Bibliotecas universitarias y automatización: un panorama de la Ciudad de México. [scielo.org](http://scielo.org.co/scielo.php?script=sci_arttext&pid=S0120-09762011000200002)
