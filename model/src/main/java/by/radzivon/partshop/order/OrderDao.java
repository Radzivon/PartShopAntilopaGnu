package by.radzivon.partshop.order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    ResultSet getOrderById(Long id) throws SQLException;
    ResultSet save(Order order) throws SQLException;
    void update(Order order) throws SQLException;
    ResultSet getPartsByOrderId(Long id) throws SQLException;
    void saveMapParts(Long orderId, List<PairPartQuantity> parts) throws SQLException;
    void changeOrderCondition(Long id, OrderCondition orderCondition) throws SQLException;
    void updateMapParts(Long orderId, List<PairPartQuantity> parts) throws SQLException;
    ResultSet getAll() throws SQLException;
    ResultSet getAllOrderParts() throws SQLException;
}
