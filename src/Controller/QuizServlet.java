package Controller;

import Domain.Answer;
import Domain.Question;
import Domain.User;
import service.QuestionService;
import service.QuizService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuizService service=new QuizService();
        String pageRequest=request.getParameter("pageRequest");

        //Request for play quiz page
        if(pageRequest.equalsIgnoreCase("playQuiz")){
            RequestDispatcher rd=request.getRequestDispatcher("user/playQuiz.jsp");
            rd.forward(request,response);
        }

        //Request for quiz questions
        if (pageRequest.equalsIgnoreCase("start")) {
            Answer answer = storeQuizAnswer(request);
            if (answer != null){
                service.storeQuizResult(answer);
            }

            List<Question> list=service.getQuizQuestion(Integer.parseInt(request.getParameter("id")));
            if(list != null){
                request.setAttribute("questionList", list);
                RequestDispatcher rd = request.getRequestDispatcher("user/quizQuestions.jsp");
                rd.forward(request, response);
            }else {
                pageRequest="displayResult";
            }
        }

        //Request for result of quiz
        if (pageRequest.equalsIgnoreCase("displayResult")) {
            List<Answer> quizAnswer=service.getAnswers();
            request.setAttribute("quiz",quizAnswer);
            RequestDispatcher rd = request.getRequestDispatcher("question/resultPage.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public Answer storeQuizAnswer(HttpServletRequest request) {
        QuestionService questionService = new QuestionService();
       Question question = questionService.getQuestion(request.getParameter("id"));

        String userAnswer=request.getParameter("userAnswer");
        if (userAnswer == null){
            return null;
        }else {
            Answer answer=new Answer();
            answer.setQuestion(question.getQuestion());
            answer.setQuestionId(question.getId());
            answer.setCorrectAnswer(question.getCorrectAnswer());
            answer.setUserAnswer(userAnswer);
            return answer;
        }
    }
}
