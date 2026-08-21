# CSC360: Computer Graphics and Image Processing
## Reflection Journal — Session 3

---

### Session Metadata
- **Course Code:** CSC360
- **Course Name:** Computer Graphics and Image Processing
- **Student ID:** AU2420150
- **Session Number:** Session 03
- **Session Date:** August 12, 2026
- **Entry Date:** August 21, 2026

---

## 1. Overview

In Session 3, we transitioned from fundamental theoretical concepts to practical, hands-on 2D computer graphics development. The primary objective of this session was to implement, render, and push a basic 2D vector graphic primitive program using Java Swing and AWT.

This session focused on:
- Setting up a **Java Swing GUI container** (`JFrame` and `JPanel`).
- Understanding the **2D graphics coordinate system** in Java AWT.
- Utilizing the **`Graphics` object context** and methods (`g.setColor` and `g.drawRect`).
- Rendering a **practice graphic**: a square with **blue borders only** (hollow/unfilled rectangle primitive).
- Committing and pushing source code (`SimpleShapes.java`) and session reflections to the GitHub repository.

---

## 2. 2D Coordinate System & Graphics Primitives

### Java 2D Screen Coordinate Space
Unlike the standard Cartesian coordinate system in mathematics (where origin $(0,0)$ is centered or bottom-left and $+y$ points upward), the 2D screen coordinate system in Java AWT defines:
- **Origin $(0,0)$:** Top-left corner of the container panel.
- **X-axis ($+x$):** Extends horizontally to the right.
- **Y-axis ($+y$):** Extends vertically downwards.

```
(0,0) -------------> +X
  |
  |   (50,50)
  |      +--------------+
  |      |              |
  |      |  150 x 150   |
  |      |              |
  v      +--------------+
 +Y
```

### Outline vs. Solid Graphics Primitives

In 2D computer graphics libraries like Java AWT:
- `g.drawRect(x, y, width, height)` draws the **outline/border only** of a rectangle without filling the interior.
- `g.fillRect(x, y, width, height)` draws a **solid, filled** rectangle.

For Session 3's practice exercise, we specifically rendered a square with **blue borders only** using `drawRect(50, 50, 150, 150)` with `Color.BLUE`.

---

## 3. Practice Graphic Implementation (`SimpleShapes.java`)

The source code created in [`Projects/SimpleShapes.java`](../Projects/SimpleShapes.java) initializes a Java Swing frame window and renders the 2D primitive shape onto a custom panel context.

### Code Listing

```java
import javax.swing.*;
import java.awt.*;

public class SimpleShapes extends JPanel {

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(50, 50, 150, 150); // rectangle

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Shapes");
        frame.setSize(400, 400);
        frame.add(new SimpleShapes());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

### Code Explanation

1. **`extends JPanel`**: Inherits component rendering capabilities from Swing's `JPanel`.
2. **`paint(Graphics g)`**: Overrides the paint lifecycle method where 2D graphic rendering commands are issued using the `Graphics` context object `g`.
3. **`g.setColor(Color.BLUE)`**: Sets the graphics context state stroke color to blue.
4. **`g.drawRect(50, 50, 150, 150)`**: Draws a 150x150 pixel square border starting at coordinate $(50, 50)$ from top-left.
5. **`JFrame` Setup**: Creates a window container of size 400x400 pixels titled `"Simple Shapes"` and displays it on screen.

---

## 4. Output Graphic Visualization

Below is the photo/image of the rendered output graphic produced by compiling and running `SimpleShapes.java`:

![SimpleShapes Output Graphic](images/simpleshapes_output.png)

*Figure 1: Output graphic canvas displaying the square shape with blue borders only (150x150 pixels at coordinate position (50, 50)).*

> [!NOTE]
> As rendered above, the shape appears with blue borders only while preserving the background fill, directly reflecting `g.drawRect()` primitive execution.

---

# Key Takeaways

1. **Java Swing/AWT 2D Graphics Canvas:** Custom 2D graphics in Java are drawn inside a GUI component by overriding its rendering lifecycle method (`paint` / `paintComponent`).
2. **Graphics Context State Machine:** Commands like `g.setColor(...)` modify the state of the `Graphics` object context, affecting subsequent primitive rendering calls.
3. **Top-Left Screen Coordinate System:** Pixel coordinates start at $(0, 0)$ at the top-left corner, increasing rightward ($+x$) and downward ($+y$).
4. **Border vs. Fill Operations:** `drawRect()` renders unfilled shape outlines (borders only), whereas `fillRect()` fills the shape interior.
5. **Hands-on Graphics Pipeline Practice:** Implementing basic 2D primitives builds essential intuition for upcoming topics such as transformation matrices, color models, and interactive graphics.

---

## Final Reflection

Session 3 provided a critical hands-on step by translating conceptual graphics knowledge into working code. Creating and pushing `SimpleShapes.java` helped solidify understanding of screen coordinates, graphic context operations, and primitive outline rendering. Adding output visual documentation closes the loop between code implementation and final rendered graphics.
