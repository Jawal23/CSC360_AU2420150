# CSC360: Computer Graphics and Image Processing
## Reflection Journal — Session 5

---

### Session Metadata
- **Course Code:** CSC360
- **Course Name:** Computer Graphics and Image Processing
- **Student ID:** AU2420150
- **Session Number:** Session 05
- **Session Date:** August 20, 2026
- **Entry Date:** August 30, 2026

---

## 1. Overview

In Session 5, we deepened our understanding of GUI application architecture in Java Swing, exploring object-oriented design principles and geometric validation algorithms. The session bridged low-level rendering mechanics with fundamental mathematical theorems required for robust 2D and 3D graphics rendering.

Key topics covered in this session include:
- **Java Swing Component Hierarchy:** Dissecting `JFrame` vs. `JPanel`, window management, and the execution lifecycle of `paintComponent`.
- **Object-Oriented Programming (OOP) in Graphics:** Leveraging class inheritance (`extends JPanel`) and understanding anonymous inner classes for event handling.
- **Drawing Algorithms & Shape Definitions:** Formulating rules for defining rectangles and triangles.
- **The Triangle Inequality Theorem:** Applying mathematical validation to polygon mesh construction and computational geometry.
- **Conceptual Progression:** Linking earlier centroid calculations with dynamic primitive parameterization.

---

## 2. Java Swing Architecture: `JFrame` vs. `JPanel`

### Component Hierarchy & Roles

In Java Swing development, maintaining a clean distinction between window management and graphics rendering is critical:

- **`JFrame` (Top-Level Container):** Serves as the outer OS-level window shell. It manages window decorations (title bar, minimize/maximize/close buttons), menu bars, and overall container layout.
- **`JPanel` (Custom Canvas Component):** Represents a lightweight drawing surface inside the frame. Actual drawing logic and custom shape rendering belong inside a class extending `JPanel`, not inside the `JFrame` itself.

```
+---------------------------------------------------+
| JFrame (Outer Window Shell)                       |
|  +---------------------------------------------+  |
|  | JPanel (Custom Drawing Surface)             |  |
|  |                                             |  |
|  |   [ Custom paintComponent(g) Graphics ]     |  |
|  |                                             |  |
|  +---------------------------------------------+  |
+---------------------------------------------------+
```

### Correct Container Assembly

A common conceptual misstep is attempting to add a `JFrame` into a panel. The correct structural flow requires adding the panel *into* the frame:

```java
JFrame frame = new JFrame("Graphics Application");
MyDrawingPanel panel = new MyDrawingPanel();
frame.add(panel); // Correct: Adding the drawing panel to the container frame
```

Similarly, adding GUI components like buttons, sliders, or panels to a `JFrame` follows this incremental population model—the frame acts as a general-purpose container that you populate step by step.

### The Role of `super.paintComponent(g)` and the Event Dispatch Thread

When overriding `paintComponent(Graphics g)` in custom `JPanel` subclasses, calling `super.paintComponent(g)` as the first statement is essential:

```java
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); // Clears background & previous frame state
    // Custom drawing commands follow...
}
```

> [!IMPORTANT]
> **Why `super.paintComponent(g)` is mandatory for correctness:**  
> Swing relies on an asynchronous event loop—the **Event Dispatch Thread (EDT)**—which automatically triggers `paintComponent` during window resizes, focus changes, or explicit `repaint()` calls. Omitting `super.paintComponent(g)` prevents the background from being wiped, causing visual ghosting and persistent rendering artifacts from previous paint cycles.

---

## 3. OOP Concepts Reinforced: Inheritance & Anonymous Classes

### Inheritance in Graphics Frameworks: Beyond Boilerplate

Early on, writing `class CustomPanel extends JPanel` can feel like routine boilerplate. However, this session provided a key "aha moment": this declaration is **active inheritance** doing heavy structural work.

- **Class Hierarchy Analogy:** Just as an `Apple` subclass extending `Fruit` inherits standard fruit attributes (sweetness, seeds) while defining specific characteristics (red skin, specific flavor profile), a custom drawing class extending `JPanel` inherits:
  - Built-in double-buffering support
  - Layout and sizing capabilities
  - Integration into the Swing component tree and repainting pipeline

Overriding `paintComponent` allows us to inject specialized drawing logic while letting `JPanel` handle all complex background rendering plumbing.

### Anonymous Inner Classes

The session also introduced **anonymous classes**—classes declared and instantiated in a single expression without an explicit identifier name.

```java
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Repaint requested.");
    }
});
```

Anonymous inner classes are typically used for short, one-off implementations such as quick event listeners, providing a natural follow-on to the inheritance discussion in GUI programming.

---

## 4. Drawing Algorithms & The Triangle Inequality Theorem

### Parametric Shape Definitions

Mathematical representations determine how shapes are constructed in code:

1. **Rectangles:** An axis-aligned rectangle is fully defined by **two opposite corner points** $(x_1, y_1)$ and $(x_2, y_2)$, from which width ($|x_2 - x_1|$) and height ($|y_2 - y_1|$) are computed.
2. **Triangles:** Defining a triangle requires **three distinct points** $P_1(x_1, y_1)$, $P_2(x_2, y_2)$, and $P_3(x_3, y_3)$.

### Triangle Inequality Theorem

Not any arbitrary set of three points or side lengths can form a closed 2D triangle. The side lengths $a$, $b$, and $c$ (calculated via the distance formula between vertex pairs) must satisfy the **Triangle Inequality Theorem**:

$$a + b > c$$
$$b + c > a$$
$$a + c > b$$

```
       P3
      /  \
  a  /    \  b
    /      \
  P1--------P2
       c
```

If any single inequality fails (e.g., $a + b = c$ or $a + b < c$), the points are **collinear** (lying along a single straight line) or degenerate, meaning they cannot form a valid triangle.

### Practical Extension: Mesh Generation & Computational Geometry

> [!NOTE]
> The Triangle Inequality Theorem is not merely a 2D geometry rule—it is foundational in **3D mesh generation**, CAD modeling, and **computational geometry** (e.g., Delaunay triangulation). Every candidate triangle in a surface mesh must pass this same check before being accepted into the rendering pipeline; otherwise, the renderer will display visual gaps, holes, or degenerate faces.

---

## 5. Connections & Takeaways Carrying Forward

### Progression from Minimal to Complex Primitives

This session's rectangle and triangle definitions build directly on an earlier session's square-centroid formula, demonstrating a deliberate progression from minimal-input shapes to more complex, multi-point parametric geometry.

### Conceptual Aha Moment

Recognizing that `extends JPanel`—something previously typed without much thought—is actually inheritance performing crucial rendering work is a major reflective milestone. It signifies a transition from writing syntax by memory to understanding how framework architectures function under the hood.

---

# Key Takeaways

1. **Window vs. Canvas Separation:** `JFrame` acts as the top-level window container, while a custom class extending `JPanel` provides the canvas surface for custom rendering.
2. **Container Assembly Flow:** Panels and components are added *into* a frame (`frame.add(panel)`), reflecting incremental container population.
3. **Repaint Lifecycle Management:** `super.paintComponent(g)` must be called at the beginning of `paintComponent` to clear prior frame artifacts managed by Swing's Event Dispatch Thread (EDT).
4. **Inheritance in Swing:** Extending `JPanel` grants built-in windowing and rendering mechanics while allowing specialized graphics overrides.
5. **Anonymous Inner Classes:** Unnamed, single-expression class instantiations enable concise, inline event listener handling.
6. **Rectangle Parameterization:** Axis-aligned rectangles are fully defined by two opposite corner points.
7. **Triangle Inequality Theorem:** Valid triangles require that the sum of any two side lengths strictly exceeds the third side ($a+b>c, b+c>a, a+c>b$).
8. **Computational Geometry Applications:** Triangle validity checks prevent degenerate faces and visual gaps in 3D mesh generation and algorithms like Delaunay triangulation.

---

## Final Reflection

Session 5 successfully connected software engineering principles with computer graphics fundamentals. Understanding how Swing's container hierarchy and event-driven repainting model operate under the hood provides a solid foundation for building responsive interactive applications. Concurrently, grounding shape definitions in geometric theorems like the Triangle Inequality highlights the importance of mathematical validation before attempting visual rendering—a principle that scales directly into complex 3D graphics pipelines.
