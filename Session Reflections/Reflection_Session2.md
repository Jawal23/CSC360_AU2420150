# CSC360: Computer Graphics and Image Processing
## Reflection Journal — Session 2

---

### Session Metadata
- **Course Code:** CSC360
- **Course Name:** Computer Graphics and Image Processing
- **Student ID:** AU2420150
- **Session Number:** Session 02
- **Session Date:** August 07, 2026
- **Entry Date:** August 11, 2026

---

## 1. Overview

Today's lecture moved beyond the graphics fundamentals covered in earlier sessions and introduced practical software-development concepts alongside core computer graphics topics.

The session focused on:

- **SSH (Secure Shell)** and its comparison with HTTPS
- **SSH vs. HTTPS for Git repository access**
- **Public and private key authentication**
- **SSH KeyGen and Microsoft PowerShell**
- **Static vs. interactive graphics**
- **Vector vs. raster graphics**
- The relationship between mathematical representations, secure development practices, and modern graphics workflows

---

## 2. SSH (Secure Shell) vs. HTTPS

SSH and HTTPS are both protocols that enable secure communication, but they are designed for different primary purposes.

| Aspect | SSH | HTTPS |
|---|---|---|
| Full form | Secure Shell | Hypertext Transfer Protocol Secure |
| Primary purpose | Secure remote access and command execution | Secure communication over the web |
| Common development use | Remote servers and Git repositories | Websites, APIs, and Git repositories |
| Authentication | Commonly uses key-based authentication | Commonly uses credentials or access tokens |
| Typical interaction | Command-line/remote system access | Browser or web-based communication |

### Key Distinction

**SSH** is primarily associated with securely accessing and controlling remote systems, while **HTTPS** is primarily associated with securely transferring information over the web.

Both can also be used to access Git repositories, which makes understanding their differences particularly important in a development workflow.

---

## 3. SSH and HTTPS for Git Repositories

Git repositories can commonly be accessed through either **HTTPS** or **SSH**.

### HTTPS Authentication

When using HTTPS, authentication may require credentials such as:

- Username and password
- Personal Access Token (PAT)

Depending on the Git configuration and credential manager being used, authentication details may need to be provided when access is required.

### SSH Authentication

SSH uses **key-based authentication**.

Once an SSH key pair has been generated, the public key can be added to a Git hosting service. The corresponding private key remains securely stored on the user's computer.

After configuration, SSH allows authenticated access without repeatedly entering a password or personal access token.

### SSH vs. HTTPS for Git

| Feature | HTTPS | SSH |
|---|---|---|
| Authentication | Password/token-based | Key-based |
| Initial setup | Generally simpler | Requires SSH key configuration |
| Repeated authentication | May require credentials unless cached | Usually seamless after setup |
| Private key required | No | Yes |
| Common use | Repository cloning and pushing | Repository cloning and pushing |

---

## 4. Public and Private Keys

SSH authentication is based on a **key pair** consisting of:

### Public Key

The public key can be shared with trusted services, such as a Git hosting platform.

Its purpose is to allow the service to verify that the connecting user possesses the corresponding private key.

### Private Key

The private key must remain confidential and securely stored on the user's machine.

> **Never share your private SSH key.**

### How the Key Pair Works

The basic authentication process can be understood as:

1. A user generates an SSH key pair.
2. The **public key** is added to the relevant service.
3. The **private key** remains on the user's computer.
4. When the user connects, the service verifies the user's identity using the key pair.
5. Authentication takes place without transmitting the private key or requiring the user to send a password.

This makes SSH key-based authentication both practical and secure for development workflows.

---

## 5. SSH KeyGen

**SSH KeyGen** is a utility used to generate SSH key pairs.

A typical key-generation workflow involves:

1. Opening a terminal or command-line environment.
2. Running the appropriate `ssh-keygen` command.
3. Choosing where to store the generated key.
4. Optionally protecting the private key with a passphrase.
5. Adding the generated public key to the required service.

The lecture demonstrated this process using **Microsoft PowerShell**, which is particularly useful for Windows users.

### Microsoft PowerShell

PowerShell provides a command-line environment in which SSH-related commands can be executed.

Seeing SSH commands demonstrated directly in PowerShell helped connect the theoretical concepts of authentication and key pairs to a practical development workflow.

---

## 6. Static Graphics vs. Interactive Graphics

The lecture then returned to computer graphics and introduced an important distinction between **static** and **interactive** graphics.

### Static Graphics

Static graphics are graphical elements or images that remain unchanged after they are displayed.

**Examples:**

- A photograph
- A static diagram
- A non-animated illustration
- A rendered image that does not respond to user input

### Interactive Graphics

Interactive graphics respond dynamically to:

- User input
- Mouse movement
- Keyboard input
- Touch
- Other system events

The graphical output can change in real time based on the interaction.

### Comparison

| Static Graphics | Interactive Graphics |
|---|---|
| Remain unchanged after display | Respond to input or events |
| No real-time user interaction | Supports real-time interaction |
| Primarily presents visual information | Allows users to influence visual output |
| Simpler interaction model | More dynamic system |

This distinction provides an important bridge toward the broader goal of computer graphics, where interaction becomes an essential part of many graphical applications.

---

## 7. Vector Graphics vs. Raster Graphics

The lecture concluded with a discussion of **vector graphics** and **raster graphics**.

### Vector Graphics

Vector graphics represent images mathematically using elements such as:

- Paths
- Lines
- Curves
- Geometric shapes

Because the image is described mathematically rather than as a fixed grid of pixels, vector graphics can generally be scaled to different sizes without losing visual quality.

**Examples:**

- Logos
- Icons
- Diagrams
- Mathematical illustrations

### Raster Graphics

Raster graphics are represented as a **grid of pixels**.

Each pixel contains information that contributes to the final image.

When a raster image is enlarged significantly, the individual pixels become more visible, which can result in a **pixelated or less sharp appearance**.

**Examples:**

- Photographs
- Screenshots
- Digital paintings
- Pixel-based images

### Vector vs. Raster

| Vector Graphics | Raster Graphics |
|---|---|
| Mathematically represented | Pixel-based |
| Uses paths, lines, and curves | Uses a grid of pixels |
| Scales without significant quality loss | Can become pixelated when enlarged |
| Well suited for logos and diagrams | Well suited for photographs and detailed images |
| Resolution-independent | Resolution-dependent |

---

## 8. Connection to Previous Lectures

The discussion of vector graphics connected naturally with concepts introduced in the previous lecture.

Previously, **lines and curves** were identified as fundamental geometric primitives used to construct graphical objects. Vector graphics build upon this idea by representing graphical objects mathematically through paths, curves, and other geometric elements.

This demonstrates how seemingly basic mathematical concepts can form the foundation of more advanced graphical systems.

---

## 9. Overall Understanding

Today's lecture combined **practical software-development skills** with **computer graphics fundamentals**.

The SSH section introduced an important development workflow involving:

> **SSH → Key Pair → Authentication → Git Repository Access**

Meanwhile, the graphics section expanded the conceptual foundation of the course through:

> **Static Graphics → Interactive Graphics**

and:

> **Vector Graphics → Raster Graphics**

Together, these topics demonstrate that modern computer graphics is not limited to drawing shapes or images. It also involves software tools, secure development practices, mathematical representations, system interaction, and user interaction.

---

# Key Takeaways

1. **SSH and HTTPS are both secure communication protocols, but they serve different primary purposes.**
   - SSH is mainly used for secure remote access and command execution.
   - HTTPS is mainly used for secure web communication.

2. **Git repositories can be accessed through both HTTPS and SSH.**
   - HTTPS commonly relies on credentials or personal access tokens.
   - SSH uses key-based authentication.

3. **An SSH key pair consists of a public key and a private key.**
   - The public key can be shared.
   - The private key must remain secret and secure.

4. **SSH KeyGen is used to generate SSH key pairs.**

5. **Microsoft PowerShell provides a practical environment for running SSH commands on Windows.**

6. **Static graphics remain unchanged after being displayed, while interactive graphics respond dynamically to user input or events.**

7. **Vector graphics use mathematical representations such as paths, lines, and curves.**
   - They can generally be scaled without losing quality.

8. **Raster graphics are made up of pixels.**
   - Enlarging them significantly can result in pixelation and loss of clarity.

9. **Lines and curves are fundamental geometric primitives that form an important foundation for vector graphics and computer graphics in general.**

10. **Modern computer graphics combines mathematical concepts, graphical representations, user interaction, and software-development practices.**

---

## Final Reflection

The strongest takeaway from today's session is that computer graphics exists within a much broader technical ecosystem. Mathematical representations provide the foundation for creating graphical objects, interactive systems allow users to engage with those objects dynamically, and secure development practices such as SSH authentication support the software workflows through which graphical applications are built and maintained.

Understanding these connections will provide a stronger foundation for the practical and interactive computer graphics concepts introduced in future lectures.
