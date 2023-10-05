package ru.itis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/11-200";
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("name");
        String uemail = req.getParameter("email");
        String upwd = req.getParameter("pass");
        String umobile = req.getParameter("contact");
        RequestDispatcher dispatcher = null;
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users (uname,uemail,upwd,umobile)values (?,?,?,?) ");
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, uemail);
            preparedStatement.setString(3, upwd);
            preparedStatement.setString(4, umobile);

            int rowCount = preparedStatement.executeUpdate();
            dispatcher = req.getRequestDispatcher("Registration.jsp");
            dispatcher.forward(req,resp);

            if (rowCount > 0) {
                req.setAttribute("status", "Success");
            } else {
                req.setAttribute("status", "Failed");
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            List<User> usersList = new ArrayList<>();

            while(resultSet.next()) {
                User user = new User();

                user.setName(resultSet.getString("uname"));
                user.setEmail(resultSet.getString("uemail"));
                user.setPassword(resultSet.getString("upwd"));
                user.setMobile(resultSet.getString("umobile"));
                usersList.add(user);

            }
            req.setAttribute("usersList", usersList);
            dispatcher = req.getRequestDispatcher("indexFinal.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
        }

    }
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
