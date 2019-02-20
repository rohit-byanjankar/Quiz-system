package service;


import Domain.Question;
import utils.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    PreparedStatement preparedStatement = null;
    public void registerQuestions(Question question){
        String query="insert into questions(question,option_1,option_2,option_3,option_4,difficulty_level,category,correct_answer) values(?,?,?,?,?,?,?,?)";
        preparedStatement=new DatabaseConnection().getPreparedStatement(query);
        try {
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getOption1());
            preparedStatement.setString(3,question.getOption2());
            preparedStatement.setString(4,question.getOption3());
            preparedStatement.setString(5,question.getOption4());
            preparedStatement.setString(6,question.getDifficultyLevel());
            preparedStatement.setString(7,question.getCategory());
            preparedStatement.setString(8,question.getCorrectAnswer());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> viewQuestion(){
        List<Question> questionList=new ArrayList<>();
        ResultSet resultSet;
        String query="select * from questions";
        preparedStatement=new DatabaseConnection().getPreparedStatement(query);
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Question question=new Question();
                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
                question.setCategory(resultSet.getString("category"));
                question.setDifficultyLevel(resultSet.getString("difficulty_level"));
                question.setCorrectAnswer(resultSet.getString("correct_answer"));
                question.setOption1(resultSet.getString("option_1"));
                question.setOption2(resultSet.getString("option_2"));
                question.setOption3(resultSet.getString("option_3"));
                question.setOption4(resultSet.getString("option_4"));

                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public void delete(String id){
        String query="delete from questions where id=?";
        preparedStatement=new DatabaseConnection().getPreparedStatement(query);
        try{
        preparedStatement.setString(1,id);
        preparedStatement.execute();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Question getQuestion(String id){
        ResultSet resultSet;
        String query="select * from questions where id=?";
        Question question=new Question();
        preparedStatement=new DatabaseConnection().getPreparedStatement(query);
        try {
        preparedStatement.setString(1,id);
        resultSet =preparedStatement.executeQuery();
        while (resultSet.next()){
            question.setId(resultSet.getInt("id"));
            question.setQuestion(resultSet.getString("question"));
            question.setCategory(resultSet.getString("category"));
            question.setDifficultyLevel(resultSet.getString("difficulty_level"));
            question.setCorrectAnswer(resultSet.getString("correct_answer"));
            question.setOption1(resultSet.getString("option_1"));
            question.setOption2(resultSet.getString("option_2"));
            question.setOption3(resultSet.getString("option_3"));
            question.setOption4(resultSet.getString("option_4"));
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return question;
    }

    public void updateQuestion(Question question,String id){
        String query="update questions set question=? , option_1=? ,option_2=? ,option_3=? ,option_4=? ,correct_answer=? , difficulty_level=?, category=? where id=?";
        try {
            preparedStatement=new DatabaseConnection().getPreparedStatement(query);
            preparedStatement.setString(1,question.getQuestion());
            preparedStatement.setString(2,question.getOption1());
            preparedStatement.setString(3,question.getOption2());
            preparedStatement.setString(4,question.getOption3());
            preparedStatement.setString(5,question.getOption4());
            preparedStatement.setString(6,question.getCorrectAnswer());
            preparedStatement.setString(7,question.getDifficultyLevel());
            preparedStatement.setString(8,question.getCategory());
            preparedStatement.setString(9,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
