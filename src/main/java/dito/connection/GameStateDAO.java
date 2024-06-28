package dito.connection;

import dito.GamePanel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameStateDAO {

    private static final int GAME_STATE_ID = 1;

    public void saveGameState(GamePanel gamePanel) {
        String sql = "UPDATE game_state SET player_level = ? WHERE id = ?";
    
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            // Set parameters based on game state
            int playerLevel = gamePanel.getPlayer().getLevel();
            pstmt.setInt(1, playerLevel);
            pstmt.setInt(2, GAME_STATE_ID);

            System.out.println("Saving game state for player level: " + playerLevel);
            System.out.println("Executing SQL query: " + pstmt.toString());
            System.out.println("Parameters - player_level: " + playerLevel + ", id: " + GAME_STATE_ID);
        
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Game state saved successfully.");
            } else {
                System.out.println("Failed to save game state: No rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to save game state: SQLException - " + e.getMessage());
            e.printStackTrace(); // Log the exception for detailed analysis
        } catch (Exception e) {
            System.out.println("Failed to save game state: Exception - " + e.getMessage());
            e.printStackTrace(); // Log the exception for detailed analysis
        }
    }
    
    public void loadGameState(GamePanel gamePanel) {
        String sql = "SELECT player_level FROM game_state WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, GAME_STATE_ID); // Set the id for WHERE clause

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                gamePanel.getPlayer().setLevel(rs.getInt("player_level"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (log, throw custom exception, etc.)
        }
    }
}
