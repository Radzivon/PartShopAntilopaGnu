package by.radzivon.partshop.order;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Override
    public ResultSet getOrderById(Long id) throws SQLException {
        //TODO
        return null;
    }

    @Override
    public ResultSet save(Order order) throws SQLException {
        //TODO
        return null;
    }

    @Override
    public void update(Order order) throws SQLException {
        //TODO

    }

    @Override
    public ResultSet getPartsByOrderId(Long id) throws SQLException {
        //TODO
        return null;
    }

    @Override
    public void saveMapParts(Long orderId, List<PairPartQuantity> parts) throws SQLException {
        //TODO

    }

    @Override
    public void changeOrderCondition(Long id, OrderCondition orderCondition) throws SQLException {
        //TODO

    }

    @Override
    public void updateMapParts(Long orderId, List<PairPartQuantity> parts) throws SQLException {
        //TODO

    }

    @Override
    public ResultSet getAll() throws SQLException {
        //TODO
        return null;
    }

    @Override
    public ResultSet getAllOrderParts() throws SQLException {
        //TODO
        return null;
    }
}
