# 👮‍♂️ Sistema de Gestión de Armas del personal policial

Este proyecto Java 17 implementa un sistema para la administración del personal policial, sus escuadrones y las armas asignadas en la Policía de Tres de Febrero. El sistema permite gestionar los datos de policías, escuadrones y una variedad de armas (cortas y largas), así como consultar el estado y la disponibilidad de las mismas para el servicio.

---

## 🚀 Funcionalidades Principales

**✔** **Gestión de Policías**: Almacena información detallada de cada agente, incluyendo nombre, apellido, legajo, el escuadrón al que pertenecen y el arma que tienen asignada.

**✔** **Administración de Escuadrones**: Cada escuadrón tiene un nombre, una comisaría de pertenencia, un grupo de policías y un inventario de armas.

**✔** **Control de Armas**:
- _Armas Genéricas_: Registra la cantidad de municiones, alcance, marca, calibre y estado (nueva, en mantenimiento, en uso).
- _Armas Cortas_: Se especifica si son automáticas o no.
- _Armas Largas_: Incluye información sobre el sello del RENAR, una descripción de justificación de uso y un nivel de importancia (del 1 al 5).
- 
**✔** **Consulta de Disponibilidad**: Permite determinar si un arma está en condiciones de ser utilizada en un enfrentamiento (estado "en uso" y calibre mayor o igual a 9).

**✔** **Comparación de Armas Largas**: Posibilidad de comparar armas largas según su nivel.

**✔** **Análisis de Alcance de Armas Cortas**: Funcionalidad para saber si un arma corta puede ser disparada a más de 200 metros.

**✔** **Reportes de Escuadrones**: Ofrece la capacidad de conocer la cantidad de integrantes, las armas que poseen, a qué policía corresponde cada una y cuántas de ellas están en condiciones operativas.

---

## 🛠️ Tecnologías Utilizadas
- **Java 17**: Lenguaje de programación.
- **Programación Orientada a Objetos (POO)**: Diseño basado en clases abstractas, herencia y encapsulamiento.
- `java.util.List` y `java.util.Map`: Colecciones para manejar grupos de objetos.
- `Stream API`: Utilizada para operaciones eficientes y legibles sobre colecciones.

---

## 🏗️ Estructura del Proyecto
El proyecto está organizado en las siguientes clases principales:

- `Arma` (Clase Abstracta): Define las características comunes de todas las armas y el método para verificar su estado operativo.
- `ArmaCorta` (Extiende `Arma`): Añade la propiedad esAutomatica.
- `ArmaLarga` (Extiende `Arma`, implementa `Comparable<ArmaLarga>`): Incluye `selloRENAR`, `descripcionJustificacionUso` y `nivelArma`.
- `Policia`: Representa a un agente con sus datos personales y el arma asignada.
- `Escuadron`: Gestiona un grupo de policías y el inventario de armas del escuadrón.
- `SistemaPolicia`: Contiene el método `main` con ejemplos de uso y demostración de funcionalidades.

--- 

## 🚀 Cómo Ejecutar el Proyecto

1. **Clonar el repositorio**:

```bash
   git clone https://github.com/SonyGahan/TP2-Java2025
   cd TP2-Java2025
   ```

2. **Compilar el código**:

Asegúrate de tener el JDK 17 instalado y configurado en tu sistema.
Navega hasta el directorio raíz del proyecto y compila los archivos `.java`:

```bash
   javac -d out src/*.java src/**/*.java
   ```

(Ajusta `src/*.java src/**/*.java` si tus archivos están en subcarpetas específicas dentro de `src`)

3. **Ejecutar el programa**:

Una vez compilado, puedes ejecutar la clase principal `SistemaPolicia`:

```bash
   java -cp out SistemaPolicia
   ```

Esto imprimirá en la consola los ejemplos de uso y los reportes generados por el sistema.

---

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto o agregar nuevas funcionalidades, sigue estos pasos:

1. **Haz un Fork** del repositorio.
2. Crea una nueva rama con una descripción clara:
   ```bash
   git checkout -b nueva-funcionalidad
   ```
3. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m "Agrega nueva funcionalidad X"
   ```
4. Sube los cambios a tu repositorio remoto:
   ```bash
   git push origin nueva-funcionalidad
   ```
5. Crea un **Pull Request** en este repositorio.
---

## 📄 Licencia
Este proyecto está bajo la **Licencia MIT**. Consulta el archivo [LICENSE](LICENSE) para más detalles.

---

## 💻 Agradecimientos

🚀 Gracias por visitar mi repositorio y por tu interés en este proyecto. ¡Espero que te sea útil! 😄

⌨️ Construido con ❤️ por **Sonia Pereira** 😊
