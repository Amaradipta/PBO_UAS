package dito;

import javax.swing.*;

public class Main {

    public static JFrame window;

    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Delicious in Dungeon");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.getConfig().loadConfig();

        if (gamePanel.isFullScreenOn()) {
            window.setUndecorated(true);
        }

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();

        // Simulate game running and user exiting the game
        // This should be replaced with actual game logic
        boolean userIsExitingGame = true;

        if (userIsExitingGame) {
            gamePanel.stopGame();
            gamePanel.saveGameState(); // Save game state before exiting
        }
    }
}
