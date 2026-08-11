# CSC360: Computer Graphics and Image Processing
## Reflection Journal — Session 2

---

### Session Metadata
- **Course Code:** CSC360
- **Course Name:** Computer Graphics and Image Processing
- **Student ID:** AU2420150
- **Session Number:** Session 02
- **Session Date:** August 07, 2026
- **Entry Date:** August 09, 2026

---

## 1. Session Overview & Summary

The second session started with a recap of the introductory lecture, reinforcing the core distinctions between computer graphics (generating visual content from model data) and image processing (manipulating pre-existing visual data), alongside a quick review of Java-based graphical frameworks. This contextual refresher provided a smooth foundation before diving into shell mechanics and development workflows.

The narrative then transitioned into the world of Secure Shell (SSH) authentication. To appreciate why SSH matters, the professor established context by contrasting classic Windows command-line environments:
- **Command Prompt (`cmd`):** The legacy Windows command interpreter with limited scripting capabilities.
- **PowerShell:** A modern, object-oriented shell and scripting environment designed for system administration.

This historical backdrop illustrated how command-line interfaces formed the backbone of computing prior to graphical user interfaces (GUIs). Understanding this environment made SSH far more intuitive—it serves as a cryptographic protocol designed to establish secure, encrypted shell sessions into remote machines over unsecured networks.

```
+-----------------------------------------------------------------------------------+
|                                SSH Authentication                                 |
+-----------------------------------------------------------------------------------+
|  Local Machine (Client)                           Remote Host (e.g., GitHub)       |
|  +---------------------+                          +----------------------------+  |
|  | Private Key         |                          | Public Key                 |  |
|  | (~/.ssh/id_ed25519) |                          | (Registered Padlock)       |  |
|  | [STAYS PRIVATE]     |                          | [SHARED FREELY]            |  |
|  +----------+----------+                          +-------------+--------------+  |
|             |                                                   |                 |
|             +----------------- Cryptographic -------------------+                 |
|                               Handshake (No Secret Sent)                          |
+-----------------------------------------------------------------------------------+
```

From authentication, the lecture shifted into fundamental graphics concepts, examining **Raster vs. Vector graphics** as the structural centerpiece of visual computing, and delineating **Static vs. Interactive graphics**:
- **Static Graphics:** Visual output rendered once onto a frame buffer, remaining immutable unless redrawn explicitly.
- **Interactive Graphics:** Dynamic visuals that continuously monitor user input events (mouse, keyboard, touch) to recalculate and update frames in real time.

---

## 2. Code & Practical Implementation

Following the theoretical portion, a hands-on practice assignment was introduced to synthesize our tooling setup with early Java graphics programming:

### Practice Task Scope: Basic 2D Java Graphics & Git Integration
- **Objective:** Construct a lightweight 2D rendering program using Java's standard graphics libraries while establishing a clean Git workflow (write code, commit changes, push to GitHub remote repository).
- **Technical Mechanism:** 
  - Subclassing a GUI component (such as `JPanel` or `JFrame`) and overriding its inherited `paint()` or `paintComponent(Graphics g)` lifecycle method.
  - Casting the `Graphics` context object to `Graphics2D` to access enhanced rendering controls.
  - Drawing fundamental 2D geometric primitives including straight lines, rectangles, ellipses, and basic paths.

This task marks our initial direct interaction with Java's low-level drawing API, serving primarily to build comfort with windowing lifecycle hooks and repository management.

---

## 3. Deep-Dive Conceptual Understanding

### Raster vs. Vector Graphics Mechanics

The conceptual core of this session centered on how visual data is represented in computer memory:

```
+------------------------------------------------------------------------------------+
|                             Visual Data Representation                             |
+------------------------------------------------------------------------------------+
|  Raster Graphics                                Vector Graphics                    |
|  - Stored as a 2D grid of discrete pixels       - Stored as parametric formulas    |
|  - Fixed spatial resolution (width x height)    - Resolution-independent primitives |
|  - Scaling stretches individual pixel blocks     - Scaling recalculates equations  |
|  - Ideal for rich photographic detail           - Ideal for typography & UI icons  |
+------------------------------------------------------------------------------------+
```

- **Raster Graphics:** Image data is defined by a fixed rectangular matrix of color samples (pixels). Because the resolution is baked into the grid upon creation, increasing the display scale forces the rasterizer to stretch existing pixel samples—resulting in visible pixelation, aliasing artifacts, and blurriness.
- **Vector Graphics:** Image data is represented parametrically as mathematical descriptions (points, vectors, lines, curves, and filled shapes). When scaling vector content, the rendering engine simply evaluates the underlying geometric equations against the target screen coordinates. Consequently, visual elements remain crisp and razor-sharp across all output devices, from minute web favicons to massive high-density displays.

---

## 4. Technical Challenges & Areas for Growth

### Unpacking the SSH Handshake & Key Management

While the high-level concept of public-private key cryptography was clear during class, several low-level mechanics warrant deeper investigation:
1. **The Cryptographic Handshake:** Precisely how the server verifies that the client possesses the private key without the private key ever traveling across the wire (e.g., challenge-response mechanisms using asymmetric encryption).
2. **Local Identity Resolution:** How the local terminal client locates the correct key file within `~/.ssh/` and pairs it to a specific remote host definition.
3. **The Role of `ssh-agent`:** How background SSH agent daemons cache unencrypted private keys in memory so users don't need to enter passphrases repeatedly during active developer sessions.

Further self-study on asymmetric cryptographic handshakes helped clarify these points, though articulating the full protocol end-to-end remains an area for continued review.

---

## 5. Inter-Session Connections & Conceptual Continuity

### Mathematical & Architectural Progression

```
+------------------------------------------------------------------------------------+
|                               Course Progression                                   |
+------------------------------------------------------------------------------------+
|  Session 1 (Theoretical Foundation)             Session 2 (Implementation & Tools) |
|  - Geometry & Calculus fundamentals             - Parametric Vector Graphics       |
|  - Rates of change describing curves            - Hands-on Java 2D Graphics API    |
|  - Theoretical graphical frameworks             - SSH keypair setup & Git workflow |
+------------------------------------------------------------------------------------+
```

- **Calculus to Parametric Rendering:** Session 1 highlighted how curves and geometric boundaries are mathematically governed by rates of change. Session 2 translated this exact mathematical principle into vector graphics, where visual elements are rendered directly from parametric equations rather than pre-baked pixel grids.
- **From Framework Concepts to Execution:** Session 1 introduced graphical framework abstractions in passing; Session 2 demanded hands-on invocation of the Java 2D API (`Graphics2D`), linking early theoretical models directly to executable code.

---

## 6. Real-World Applications & Pragmatic Insights

- **Professional Developer Tooling:** The walkthrough of SSH demystified past setup steps from second-year projects. SSH keypairs are fundamental across modern software engineering—from authenticating git commits to establishing secure shell sessions into cloud instances (AWS EC2, digital infrastructure) and orchestrating automated CI/CD deployment pipelines.
- **Design Workflows (Adobe Photoshop Dual-Engine Model):** 
  - Imported digital photographs represent raw raster matrices; resizing them degrades quality as pixel data stretches.
  - Native text layers and vector shape tools inside Photoshop preserve perfectly crisp vector paths regardless of canvas scaling.
  - Recognizing that professional graphic software operates as a hybrid engine—simultaneously managing raster pixel arrays and vector parametric shapes—transforms how one approaches digital asset creation.

---

## 7. Key Takeaways

1. **Asymmetric SSH Authentication:** Security rests on a complementary keypair—the public key acts as an open padlock distributed to remote services like GitHub, while the local private key serves as the exclusive key. Authentication occurs cryptographically without transmitting sensitive credentials over the network.
2. **Structural Data Distinction:** The difference between raster and vector graphics is not an aesthetic choice, but a fundamental difference in memory architecture (pixel matrix vs. mathematical geometric equations).
3. **Terminal Environments:** Shells like PowerShell offer object-oriented scripting and lower-level system control essential for serious development workflows, far beyond simple command prompts.
4. **Interactivity Paradigm:** Static graphics are drawn once per frame lifecycle; interactive graphics continuously process user events to recompute visual frames dynamically.
5. **Practical Convergence:** The initial Java 2D practice task bridges development infrastructure (SSH, Git, GitHub) directly with low-level visual rendering hooks.

---


