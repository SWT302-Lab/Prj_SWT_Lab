/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Bill;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BillDAO extends DBContext {

    private static final Logger LOGGER = Logger.getLogger(BillDAO.class.getName());
    public void inserToBill(Bill bill) {
        String sql = """
                     INSERT INTO Bill (TableID, DishID, Quantity, Price)
                     VALUES 
                         (?, ?, ?, ?)
                     """;
         try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, bill.getTableId());
            st.setInt(2, bill.getDishId());
            st.setInt(3, bill.getQuantity());
            st.setInt(4, bill.getPrice());
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting bill into database", e);
        }
    }
}
