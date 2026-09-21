# Sistema de Gestión de Pedidos — Cafetería Universitaria

Proyecto de la Evaluación T1 del curso **Técnicas de Programación Orientada a Objetos**.

## Descripción

Aplicación de consola en Java que permite registrar clientes y sus pedidos,
calcular importes, buscar pedidos por código y gestionar su estado
(`PENDIENTE`, `ATENDIDO`, `CANCELADO`).

## Estructura del proyecto
CafeteriaT1/
├── ANALISIS.md # Historias de usuario, clases/responsabilidades y diagrama UML
├── README.md
└── src/
├── EstadoPedido.java # Enum de estados del pedido
├── Pedido.java # Clase Pedido
├── Cliente.java # Clase Cliente (contiene sus pedidos)
└── Main.java # Clase de demostración

## Cómo compilar y ejecutar

```bash
cd src
javac *.java -d ../out
cd ../out
java Main
```

## Clases principales

- **Cliente**: código, nombre completo, correo electrónico y su lista de pedidos.
- **Pedido**: código, descripción, precio unitario, cantidad y estado.
- **EstadoPedido**: enum con los valores PENDIENTE, ATENDIDO, CANCELADO.

## Validaciones implementadas

- El código del cliente no puede estar vacío.
- El código del pedido debe ser único dentro de cada cliente.
- El precio unitario y la cantidad deben ser mayores que cero.
- El estado de un pedido solo puede tomar uno de los tres valores del enum.

## Autor

Daniel Alejandro Ramos parimango n00436442
