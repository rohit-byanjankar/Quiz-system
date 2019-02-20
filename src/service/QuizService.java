package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Domain.Answer;
import Domain.Question;
import utils.DatabaseConnection;

public class QuizService {
    PreparedStatement preparedStatement = null;

    public List<Question> getQuizQuestion(Integer id) {
        List<Question> questionList = new ArrayList<>();
        ResultSet resultSet;
        String query = "select * from questions where id>? LIMIT 1";
        preparedStatement = new DatabaseConnection().getPreparedStatement(query);
        try {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    Question question = new Question();
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
            } else {
                questionList = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public void storeQuizResult(Answer answer) {
        String query = "insert into answer(question_id,question,correct_answer,user_answer) values(?,?,?,?)";
        preparedStatement = new DatabaseConnection().getPreparedStatement(query);
        try {
            preparedStatement.setInt(1, answer.getQuestionId());
            preparedStatement.setString(2,answer.getQuestion());
            preparedStatement.setString(3, answer.getCorrectAnswer());
            preparedStatement.setString(4, answer.getUserAnswer());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Answer> getAnswers(){
        String query="select * from answer";
        List<Answer> userAnswer=new ArrayList<>();
        ResultSet resultSet;
        preparedStatement = new DatabaseConnection().getPreparedStatement(query);
        try {
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                Answer answer=new Answer();
                answer.setUserAnswer(resultSet.getString("user_answer"));
                answer.setCorrectAnswer(resultSet.getString("correct_answer"));
                answer.setQuestion(resultSet.getString("question"));
                userAnswer.add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userAnswer;
    }
}
