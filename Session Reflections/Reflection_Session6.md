# CSC360: Computer Graphics and Image Processing
## Reflection Journal — Session 6

---

### Session Metadata
- **Course Code:** CSC360
- **Course Name:** Computer Graphics and Image Processing
- **Student ID:** AU2420150
- **Session Number:** Session 06
- **Session Date:** August 25, 2026
- **Entry Date:** August 31, 2026

---

## 1. Overview

Session 6 provided a major synthesis of computer graphics complexity progression, software build architecture, version control hygiene, multi-threading mechanics, and JVM performance characteristics.

Key topics covered in this session include:
- **Three-Tier Roadmap for Graphics Complexity:** Evolving from basic orthogonal primitives to multi-point polygons and recursive fractal structures.
- **Git Collaboration Hygiene:** Utilizing `git pull` upstream synchronization and `git rebase` for linear commit histories.
- **Maven Build Lifecycle & Dependency Management:** Declarative project structures via `pom.xml`, dependency resolution, and build phase execution.
- **Concurrency & Event Dispatch Thread (EDT):** OS process vs. thread isolation, single-threaded Swing UI models, and asynchronous execution with `SwingUtilities.invokeLater()`.
- **JVM Execution & JIT Compilation:** Understanding cold-start overhead vs. tiered JIT optimization (C1/C2) in long-running graphics software.

---

## 2. Three-Tier Roadmap for Graphics Complexity

Rather than treating graphics exercises as isolated assignments, the course structures skill progression into three cumulative tiers:

```
+-----------------------------------------------------------------------+
| TIER 3: Recursive & Procedural Generation (Fractals, L-Systems)       |
+-----------------------------------------------------------------------+
                                   ^
                                   |
+-----------------------------------------------------------------------+
| TIER 2: Multi-Point Polygon Rendering (Triangles, Mesh Geometry)      |
+-----------------------------------------------------------------------+
                                   ^
                                   |
+-----------------------------------------------------------------------+
| TIER 1: Orthogonal Primitives & Screen-Space Math (Squares, Rectangles)|
+-----------------------------------------------------------------------+
```

### Tier 1: Basic Orthogonal Primitives (Squares & Rectangles)
- **Focus:** Master screen-space coordinate systems, origin offsets, and bounding-box mathematics.
- **Key Insight:** Because 2D graphics APIs position the origin $(0,0)$ at the top-left, centering an object requires calculating half-width and half-height offsets: $x_{\text{draw}} = x_{\text{center}} - \frac{W}{2}, \ y_{\text{draw}} = y_{\text{center}} - \frac{H}{2}$.

### Tier 2: Multi-Point Polygon Rendering (Triangles)
- **Focus:** Move from axis-aligned shapes to arbitrary planar primitives.
- **Hardware Relevance:** Triangles are the primary rendering primitive in GPU hardware because any three non-collinear points unambiguously define a flat 2D plane.
- **Connection to Session 5:** Directly extends the Triangle Inequality Theorem ($a+b>c, b+c>a, a+c>b$).
- **Mathematical Underpinnings:** Vector **cross products** and matrix **determinants** are used to test for non-collinearity and to compute **barycentric coordinates**, which enable attribute interpolation (such as colors and texture coordinates) across a triangle's surface.

### Tier 3: Recursive & Fractal Generation (Fractal Trees & L-Systems)
- **Focus:** Render complex, naturalistic geometry through recursive branching structures, L-systems, and parameterized transformation angles.
- **Real-World Applications:** Each recursive invocation applies scale and rotation transformations. This recursive subdivision principle forms the foundation for procedural terrain synthesis, vegetation modeling, and procedural assets in modern game engines.

---

## 3. Git Collaboration & Repository Hygiene

Maintaining clean version control practices is vital when working in collaborative software environments:

### Upstream Synchronization
- **Rule:** Always pull upstream changes (`git pull`) before initiating new local feature work.
- **Rationale:** Prevents diverged branch histories, resolves merge conflicts early, and avoids silently overwriting peer contributions.

### Linear History with `git rebase`
Using `git rebase` instead of standard `git merge` rewinds local commits, applies remote updates, and re-applies local work on top:

```bash
git pull --rebase origin main
```

> [!TIP]
> **Why Rebase over Merge:**  
> Rebasing avoids cluttered "Merge branch..." commits, keeping the repository log linear, clean, and easily bisectable when debugging regressions.

---

## 4. Maven Build Lifecycle & Dependency Management

### Declarative Configuration with `pom.xml`
The `pom.xml` (Project Object Model) file acts as the single source of truth for project metadata, build plugins, and external dependencies.

- **Dependency Coordinates:** External libraries are referenced using coordinates (`GroupId:ArtifactId:Version`) instead of storing binary `.jar` files in version control.
- **Transitive Dependency Resolution:** Maven automatically builds and fetches the entire transitive dependency tree and caches artifacts locally (typically under `~/.m2/repository`).

### Maven Build Lifecycle Phases

Maven enforces a sequential build lifecycle:

$$\text{clean} \longrightarrow \text{compile} \longrightarrow \text{test} \longrightarrow \text{package} \longrightarrow \text{install}$$

> [!IMPORTANT]
> **Sequential Phase Execution:**  
> Executing any build phase automatically invokes all preceding phases. For instance, running `mvn package` implicitly executes `compile` and `test` beforehand.

---

## 5. Concurrency, Threads, & the Event Dispatch Thread (EDT)

### OS Processes vs. Threads

- **Process:** An isolated execution environment with its own dedicated memory space managed by the OS.
- **Thread:** A lightweight path of execution *within* a process that shares process memory but maintains its own private call stack.

### Swing Concurrency & Single-Threaded UI Model

Swing components are **not thread-safe**. All graphical updates, user interactions, and repaints must execute strictly on a single dedicated thread: the **Event Dispatch Thread (EDT)**.

```
                  +-----------------------------------+
                  |  Background Worker Thread         |
                  |  (Ray Tracing / Fractal Calc)     |
                  +-----------------------------------+
                                    |
                                    | SwingUtilities.invokeLater(...)
                                    v
+-------------------------------------------------------------------+
| Event Dispatch Thread (EDT)                                       |
|  ---> [ Task Queue ] ---> [ paintComponent() / UI Updates ]       |
+-------------------------------------------------------------------+
```

### Offloading Heavy Computations

Running intensive computations (e.g., fractal rendering or ray tracing) directly on the EDT freezes the UI.

- **Pattern:** Offload heavy work to background threads and dispatch UI updates back to the EDT using `SwingUtilities.invokeLater()`:

```java
new Thread(() -> {
    // 1. Heavy computation (e.g., fractal generation)
    BufferedImage fractalImage = generateFractal();

    // 2. Dispatch UI update to EDT
    SwingUtilities.invokeLater(() -> {
        drawingPanel.setImage(fractalImage);
        drawingPanel.repaint();
    });
}).start();
```

---

## 6. JVM Execution Mechanics & Tiered JIT Compilation

### JVM Startup Overhead vs. Scripting Languages

Java exhibits a slower "cold start" compared to interpreted languages like Python due to JVM bootstrapping overhead:
1. Loading core system classes
2. Bytecode verification
3. Linking symbolic references before `main()` executes

### Tiered JIT Compilation ("Slow to Start, Fast Once Warmed Up")

While initial startup takes time, Just-In-Time (JIT) compilation delivers high runtime performance through tiered optimization:

- **Tier 1 (C1 Compiler):** Quickly compiles bytecode into native machine code for fast baseline execution.
- **Tier 2 (C2 Compiler):** Analyzes hot code paths and applies aggressive optimizations (method inlining, loop unrolling, dead code elimination).

> [!NOTE]
> This architecture creates a classic engineering trade-off: Java applications take slightly longer to launch ("cold start"), but once warmed up, JIT optimization enables execution speeds rivaling native C/C++ code.

---

# Key Takeaways

1. **Three-Tier Graphics Roadmap:** Skills progress from 2D orthogonal primitives (Tier 1) to planar triangle meshes (Tier 2) and recursive fractal generation (Tier 3).
2. **Triangle Primitives & GPU Hardware:** Triangles form the fundamental building block of GPU rendering because three non-collinear points uniquely define a 2D plane.
3. **Barycentric Coordinates & Cross Products:** Determinants and cross products check vertex non-collinearity and compute barycentric coordinates for attribute interpolation across surfaces.
4. **Git Hygiene & Linear History:** Pulling upstream changes before starting work prevents diverged histories; using `git rebase` maintains a clean, linear commit log.
5. **Maven Lifecycle Cascading:** Maven's `pom.xml` manages dependencies declaratively; running a build phase (e.g., `package`) implicitly executes all prior phases (`compile`, `test`).
6. **Process vs. Thread Isolation:** Processes hold private memory spaces; threads share process memory while keeping separate call stacks.
7. **EDT Concurrency Rule:** All Swing UI operations must run on the Event Dispatch Thread; heavy computations belong on background threads coupled with `SwingUtilities.invokeLater()`.
8. **Tiered JIT Compilation:** JVM startup overhead is counterbalanced by C1/C2 JIT optimizations (inlining, loop unrolling), enabling long-running Java graphics code to achieve near-native performance.

---

## Final Reflection

Session 6 effectively unified high-level graphics theory with core systems architecture. Understanding how shape complexity scales from simple bounding-box math to recursive L-systems provides a clear learning roadmap. Simultaneously, mastering EDT concurrency, Maven build lifecycles, and JVM JIT compilation dynamics ensures that graphical applications are not only mathematically sound, but also architecturally robust and performant.
