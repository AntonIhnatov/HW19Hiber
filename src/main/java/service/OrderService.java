package service;

import entity.Customer;
import entity.Order;
import entity.Product;
import service.impl.OrderDaoImpl;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    private final OrderDaoImpl orderDao = new OrderDaoImpl();

    public void saveOrder(Order order) {
        orderDao.save(order);
    }

    public int countOrders(int customerId) {
        int orderCount = orderDao.getOrderCountByCustomerId(customerId);
        System.out.println("Количество заказов у кастомера №" + customerId + ": ");
        return orderCount;
    }
    public static Order createOrder(String name, double totalSum, Customer customer, List<Product> products) {
        Order order = new Order();
        order.setName(name);
        order.setTotalSum(totalSum);
        order.setCustomer(customer);
        order.setProducts(products);
        return order;
    }

    public List<Order> getAllOrdersWithDetails() {
        return orderDao.getAllOrdersWithDetailsSortedByTimePlaced();
    }

    public void updateCustomerOrder(int orderId, String comment, LocalDateTime timeUpdated){
        orderDao.updateOrder(orderId, comment, timeUpdated);
    }

    public int getTotalQuantityForOrder(int id){
        return orderDao.getTotalQuantityForOrder(id);
    }

}
