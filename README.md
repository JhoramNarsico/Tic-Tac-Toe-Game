# Tic-Tac-Toe Game (Java AWT)

## Description

This is a simple, graphical Tic-Tac-Toe game implemented in Java using the Abstract Window Toolkit (AWT) library. The application follows the Model-View-Controller (MVC) design pattern to separate concerns:

*   **Model (`GameModel.java`):** Manages the game's state, rules, logic (board data, current player, win/tie checking).
*   **View (`GameView.java`):** Handles the visual presentation (the game window, grid buttons, status label, reset button).
*   **Controller (`GameController.java`):** Acts as the intermediary, handling user input (button clicks) and updating the Model and View accordingly.

Two players (X and O) take turns marking spaces on a 3x3 grid. The first player to get three of their marks in a row (horizontally, vertically, or diagonally) wins the game. If all squares are filled and no player has won, the game ends in a tie.

## Features

*   Classic 3x3 Tic-Tac-Toe gameplay.
*   Graphical User Interface (GUI) built with Java AWT.
*   Clear display of the game board.
*   Visual feedback for player moves (X and O).
*   Status messages indicating the current player's turn or the game outcome (Win/Tie).
*   Win detection for rows, columns, and diagonals.
*   Tie detection when the board is full with no winner.
*   Input validation: Prevents marking occupied cells or playing after the game ends.
*   "New Game" button to reset the board and start over.
*   Clean separation of concerns using the MVC pattern.
*   Proper GUI handling on the Event Dispatch Thread (EDT).

## Prerequisites

*   **Java Development Kit (JDK):** Version 8 or later installed and configured on your system. You need the `javac` (compiler) and `java` (runtime) commands available in your terminal or command prompt.

## How to Run

1.  **Ensure Files:** Make sure you have the following four Java source files in the same directory:
    *   `Main.java`
    *   `GameModel.java`
    *   `GameView.java`
    *   `GameController.java`

2.  **Open Terminal:** Open a terminal, command prompt, or shell window.

3.  **Navigate:** Use the `cd` command to navigate to the directory where you saved the `.java` files.
    ```bash
    cd path/to/your/tic-tac-toe/files
    ```

4.  **Compile:** Compile the Java source files. You can compile them all explicitly or just the main file:
    *   **Option A (Compile all):**
        ```bash
        javac Main.java GameModel.java GameView.java GameController.java
        ```
    *   **Option B (Compile main - usually sufficient):**
        ```bash
        javac Main.java
        ```
    This will generate `.class` files (`Main.class`, `GameModel.class`, etc.) in the same directory.

5.  **Run:** Execute the compiled application using the `java` command, specifying the main class (`Main`):
    ```bash
    java Main
    ```

6.  **Play:** The Tic-Tac-Toe game window should appear. Click on the squares to play. Player X goes first. Use the "New Game" button to restart. Close the window to exit the application.

## File Structure

*   **`Main.java`:** Contains the `main` method, the entry point of the application. Sets up the MVC components and starts the game on the EDT.
*   **`GameModel.java`:** Defines the game's data structure and logic (the Model).
*   **`GameView.java`:** Defines the AWT-based graphical user interface (the View).
*   **`GameController.java`:** Connects the View and Model, handling user interactions (the Controller).

---