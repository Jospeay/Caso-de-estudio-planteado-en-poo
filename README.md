#  SmartOrder - Sistema de Gestión de Pedidos

SmartOrder es un sistema desarrollado en **Java** aplicando los pilares de la **Programación Orientada a Objetos (POO)**. Permite registrar clientes, administrar productos, crear pedidos con múltiples ítems, procesar pagos y generar reportes.

---

##  Arquitectura del Sistema
El proyecto está organizado en tres capas principales:

### 1. Capa de Modelo (`src/modelo/`)
Contiene las entidades principales del negocio:
* **Cliente:** Almacena información de contacto con encapsulamiento completo.
* **Producto:** Gestiona el catálogo con control de disponibilidad.
* **Pedido:** Actúa como agregador, relacionando un cliente con múltiples productos y calculando totales automáticamente.

### 2. Capa de Pagos (`src/pago/`)
Implementa el patrón de diseño mediante la interfaz `MetodoPago`. 
* Permite procesar pagos en **Efectivo** o **Tarjeta**.
* **Extensibilidad:** El sistema está preparado para incorporar nuevos métodos (Nequi, PayPal) sin modificar código existente.

### 3. Capa de Utilidades (`src/util/`)
Funcionalidades transversales mediante clases estáticas:
* **ReporteVentas:** Mantiene un registro acumulativo de todas las ventas.
* **Utilidades:** Herramientas comunes como formateo de fechas y validaciones.

---

##  Decisiones de Diseño Clave

* **Uso de Interfaces en Pagos:** Se eligió una interfaz en lugar de una clase abstracta porque cada método tiene su propia lógica, pero todos deben cumplir el mismo "contrato".
* **Encapsulación Estricta:** Atributos privados con acceso controlado para proteger la integridad de los datos.
* **Clases Estáticas:** `ReporteVentas` es estática porque representa una única fuente de verdad para el sistema.
* **Cálculo Dinámico:** El total se calcula en tiempo real para evitar errores de consistencia.
