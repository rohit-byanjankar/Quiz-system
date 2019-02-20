package service;

import Domain.User;
import utils.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    PreparedStatement preparedStatement = null;

    public void registerUser(User user) {
        String query = "insert into user(name,email,password) values(?,?,?)";
        try {
            preparedStatement = new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User loginUser(String email, String password) {
        String query = "select * from user where email=? and password=?";
        ResultSet resultSet;
        User user = null;
        try {
            preparedStatement = new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> userList(){
        String query="select * from user";
        ResultSet resultSet;
        List<User> userList = new ArrayList<>();

        try{
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                userList.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    public void delete(String id){
        String query="delete from user where id=?";
        try {
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(User user,String id){
        String query="update user set name=? , email=? , password=? where id=?";
        try {
             preparedStatement=new DatabaseConnection().getPreparedStatement(query);
             preparedStatement.setString(1,user.getName());
             preparedStatement.setString(2,user.getEmail());
             preparedStatement.setString(3,user.getPassword());
             preparedStatement.setString(4,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String id){
        String query="select * from user where id=?";
        ResultSet resultSet;
        User user=new User();
        try{
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
