# 📚 Gestión de Biblioteca

### 📝 Descripción de la App
Esta es una aplicación móvil desarrollada para **Android** que permite gestionar y visualizar una colección de libros. Ofrece una experiencia donde el usuario puede explorar obras literarias y consultar su información detallada.

La aplicación permite al usuario:
* **Búsqueda Avanzada:** Filtrar libros por título o autor.
* **Visualización Dinámica:** Listar los resultados mediante tarjetas (CardViews) dentro de un RecyclerView.
* **Ficha de Detalle:** Acceder a la información completa de cada libro (Sinopsis, Año, Páginas y géneros).
* **Visualización de validacion:** Sistema de mensajes (Toasts) para informar si no hay resultados o si el campo de búsqueda está vacío.

---

### 👥 Integrantes del Grupo
* **Suarez, Tomas Agustin** - DNI: `44.642.586`

---

### 🏗️ Implementación de MVVM
Para este proyecto se utilizó la arquitectura **MVVM (Model-View-ViewModel)**, implementada de la siguiente forma: 

#### 1. Model (`BookModel`)
Representa la estructura de los datos de un libro (ID único, Título, Autor, Descripción, etc.). Implementa la interfaz `Serializable` para permitir el transporte del objeto completo entre pantallas.

#### 2. ViewModel (`BookViewModel`)
* Contiene la **lógica de negocio** (filtrado de la lista).
* Gestiona el **estado de los datos** usando `MutableLiveData` para separar la lista original de los resultados de búsqueda.

#### 3. View (`MainActivity` & `DetailBookActivity`)
Su única responsabilidad es la **interfaz de usuario**:
* **MainActivity:** Utiliza **View Binding** para gestionar el RecyclerView y el buscador. **Observa** los cambios en el ViewModel; cuando el usuario busca un libro, la lista se refresca automáticamente.
* **DetailBookActivity:** Recibe el objeto seleccionado y genera dinámicamente componentes visuales.
* **Eventos:** Captura los clics en la lista para navegar entre pantallas y envía las consultas del buscador al ViewModel.

---
