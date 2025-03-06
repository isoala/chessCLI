# CLI Chess Game

This project is a CLI chess game developed in Java. It allows users to play chess against a basic AI opponent directly in their terminal.

## Features

* **Standard Chess Rules:** Implements standard chess movement, including pawn promotion, castling, and en passant (to be added).
* **Move Validation:** Checks for legal moves and prevents illegal actions.
* **Board Display:** Displays the chessboard using Unicode characters for pieces.
* **Basic AI Opponent:** Includes a simple AI opponent (Minimax/Alpha-Beta or random move selection) for single-player games.
* **Check and Checkmate:** Detects check and checkmate conditions.
* **Algebraic Notation:** Accepts moves in standard algebraic notation (e.g., "b6", "0-0").

## Prerequisites

* **Java Development Kit (JDK):** Ensure you have a JDK installed (version 8 or later).
* **Git (Optional):** If you want to clone the repository.

## Installation and Execution

### On Arch-based Systems

1.  **Clone the Repository (Optional):**
    ```bash
    git clone [https://github.com/isoala/chessCLI](https://github.com/isoala/chessCLI)
    cd chessCLI/chess_project
    ```
2.  **Compile the Java Code:**
    ```bash
    javac main/**/*.java
    ```
3.  **Run the Game:**
    ```bash
    java main.Main
    ```

### On macOS Systems

1.  **Clone the Repository (Optional):**
    ```bash
    git clone [https://github.com/isoala/chessCLI](https://github.com/isoala/chessCLI)
    cd chessCLI/chess_project
    ```
2.  **Compile the Java Code:**
    ```bash
    javac main/**/*.java
    ```
3.  **Run the Game:**
    ```bash
    java main.Main
    ```

### On Windows Systems

1.  **Clone the Repository (Optional):**
    * Use Git Bash or another Git client to clone the repository.
2.  **Compile the Java Code:**
    * Open a command prompt or PowerShell.
    * Navigate to the `chessCLI/chess_project` directory.
    * Run the same `javac main/**/*.java` command as above.
3.  **Run the Game:**
    * Run the same `java main.Main` command.

### Unicode Character Issues on Windows

Windows command prompt and PowerShell may have issues displaying Unicode characters correctly by default. This can result in the chess pieces appearing as boxes or other symbols.

**Solutions for Windows Users:**

1.  **Change the Console Font:**
    * Right-click on the command prompt or PowerShell title bar.
    * Select "Properties."
    * Go to the "Font" tab.
    * Choose a font that supports Unicode characters, such as "Lucida Console" or "Consolas."
    * Make sure the font is not a raster font.
2.  **Use Windows Terminal:**
    * Windows Terminal is a modern terminal application that supports Unicode characters by default.
    * Download and install it from the Microsoft Store.
    * Run the game within Windows Terminal.
3.  **Change the Code Page:**
    * In a windows command prompt, type `chcp 65001`. This will change the code page to UTF-8.
    * This may not fix all issues, but it is a step in the right direction.

## How to Play

* The game will display the chessboard in the console.
* You will be prompted to enter your move using algebraic notation.
* **Examples:**
    * `e2e4` (move pawn from e2 to e4)
    * `Bf4` (move bishop to f4)
    * `0-0` (kingside castling)
    * `0-0-0` (queenside castling)
    * `b8a6` (move knight from b8 to a6)
* The game will validate your move and update the board.
* The game will inform you when a player is in check or checkmate.
* Follow the command line prompts.

## Future Improvements
s
* Implement full AI functionality using Minimax/Alpha-Beta pruning.
* Add support for en passant and pawn promotion.
* Improve the user interface and error handling.
* Implement a help command for Users unsure of how to make a move
* Implement a full PGN save/load feature.
* Implement a undo move feature.
* Refactor the input parsing to be more robust.

## Contributing

Feel free to contribute! I need the help lol.