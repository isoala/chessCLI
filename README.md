# CLI Chess Game
```
╔═══════════════════════════════════════════════════════════════════════════════════╗
║            88                                            ,dPYb,   88     a8b88d8a ║
║            88                                           daY'"'ba, 88        88    ║
║            88                                          a8"'    "" 88        88    ║
║  ,adPPYba, 88,dPPYba,   ,adPPYba, ,adPPYba, ,adPPYba, .a8"        88        88    ║
║ a8"     "" 88P'    "8a a8P_____88 I8[    "" I8[    "" |a8"        88        88    ║
║ 8b         88       88 8PP"""""""  `"Y8ba,   `"Y8ba,  '8b;     ,, 88        88    ║
║ "8a,   ,aa 88       88 "8b,   ,aa aa    ]8I aa    ]8I  "8a,. ,,ap 88        88    ║
║  `"Ybbd8"' 88       88  `"Ybbd8"' `"YbbdP"' `"YbbdP"'   `"YbbdP"  888888P Yb88dY  ║
╚═══════════════════════════════════════════════════════════════════════════════════╝
```

This project is a CLI chess game developed in Java. It allows users to play chess against a basic AI opponent directly in their terminal.

## Current State of The Repository
* While the game is playable, I plan on working on this regularly until all the features are working as intended.
* Future Improvements are a second priority once the features are fully developed.

## Features

* **Standard Chess Rules:** Implements standard chess movement, including pawn promotion, castling, and en passant (to be added).
* **Move Validation:** Checks for legal moves and prevents illegal actions.
* **Board Display:** Displays the chessboard with ASCII art and pieces using Unicode characters.
* **Basic AI Opponent:** Includes a simple AI opponent for single-player games.
* **Check and Checkmate:** Detects check and checkmate conditions.
* **Algebraic Notation:** Accepts moves in standard algebraic notation (e.g., "b6", "0-0").

## Prerequisites

* **Java Development Kit (JDK):** Ensure you have a JDK installed (version 8 or later).
* **Git (Optional):** If you want to clone the repository.
* **Bash:** For running the installation script (macOS/Linux).

## Installation and Execution

### On macOS and Arch-based Systems

1.  **Clone the Repository (Optional):**
    ```bash
    git clone [https://github.com/isoala/chessCLI.git](https://www.google.com/search?q=https://github.com/isoala/chessCLI.git)
    cd chessCLI/chess_project
    ```
2.  **Run the Installation Script:**
    ```bash
    ./install.sh
    ```
    * This script will compile the Java code and create an executable `chesscli` script.
    * It will then install `chesscli` to either `/usr/local/bin` (if you have root privileges) or `~/bin`.
    * If installed to `~/bin`, ensure `~/bin` is in your `PATH` environment variable. The script will remind you of this.
3.  **Run the Game:**
    ```bash
    chesscli
    ```
    * You can run this command from any directory after installation.
    

### On Windows Systems

* This program is not meant for Windows systems.

## How to Play

* The game will display the chessboard in the console.
* You will be prompted for color and difficulty.
* You will be prompted to enter your move using the current and desired location of the piece you want to me.
* **Examples:**
    * `e2e4` (move pawn from e2 to e4)
    * `c1f4` (move bishop to f4)
    * `0-0` (kingside castling) 
    * `0-0-0` (queenside castling)
    * `b8a6` (move knight from b8 to a6)
* The game will validate your move and update the board.
* The game will inform you when a player is in check or checkmate.
* Follow the command line prompts.
* 

## Uninstallation

To uninstall the game, follow these steps:

### If Installed to `/usr/local/bin` (System-Wide):

1.  Open your terminal.
2.  Run the following command:
    ```bash
    sudo rm /usr/local/bin/chesscli
    ```
3.  Enter your password when prompted.

### If Installed to `~/bin` (User-Specific):

1.  Open your terminal.
2.  Run the following command:
    ```bash
    rm ~/bin/chesscli
    ```

### If Installed to the Local Directory:

1. Open your terminal.
2. Navigate to the directory where you installed the game.
3. Remove the `chesscli` file.
    ```bash
    rm chesscli
    ```

### Remove the chess_project Directory (Optional):

1.  Navigate to the directory containing the `chess_project` directory.
2.  Remove the `chess_project` directory:
    ```bash
    rm -rf chess_project
    ```

## Future Improvements

* Implement full AI functionality using Minimax/Alpha-Beta pruning.
* Add support for en passant and pawn promotion.
* Improve the user interface and error handling.
* Implement a help command for Users unsure of how to make a move
* Implement a full PGN save/load feature.
* Refactor the input parsing to be more robust.

## Contributing

Feel free to contribute, would be much appreciated :3