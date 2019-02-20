package Controller;

import Domain.Question;
import service.QuestionService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionService questionService = new QuestionService();
        String pageRequest = request.getParameter("pageRequest");

        //Request for question add page
        if (pageRequest.equalsIgnoreCase("questionare")) {
            redirectTo(request, response);
        }

        //Request for adding question
        if (pageRequest.equalsIgnoreCase("question")) {
            questionService.registerQuestions(getQuestion(request));
            request.setAttribute("message", "Question added succesfully!!");
            redirectTo(request, response);
        }

        //Request for list of question page
        if (pageRequest.equalsIgnoreCase("questionarelist")) {
            redirectToList(request, response, questionService);
        }

        //Request for question updating page
        if (pageRequest.equalsIgnoreCase("updatePage")) {
            Question question = questionService.getQuestion(request.getParameter("id"));
            request.setAttribute("questionList", question);
            RequestDispatcher rd = request.getRequestDispatcher("question/editQuestion.jsp");
            rd.forward(request, response);
        }

        //Request for deleting question page
        if (pageRequest.equalsIgnoreCase("delete")) {
            request.setAttribute("message", "Question Deleted Succesfully!!");
            questionService.delete(request.getParameter("id"));
            redirectToList(request, response, questionService);
        }

        //Request for succesfully updating question
        if (pageRequest.equalsIgnoreCase("update")) {
            request.setAttribute("message", "Question Updated Succesfully!!");
            questionService.updateQuestion(getUpdatedQuestion(request), request.getParameter("id"));
            redirectToList(request, response, questionService);
        }
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response, QuestionService questionService) throws ServletException, IOException {
        List<Question> list = questionService.viewQuestion();
        request.setAttribute("questionList", list);
        RequestDispatcher rd = request.getRequestDispatcher("question/questionList.jsp");
        rd.forward(request, response);
    }

    private void redirectTo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("question/questionnare.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public Question getQuestion(HttpServletRequest request) {
        Question question = new Question();
        question.setQuestion(request.getParameter("question"));
        question.setOption1(request.getParameter("option 1"));
        question.setOption2(request.getParameter("option 2"));
        question.setOption3(request.getParameter("option 3"));
        question.setOption4(request.getParameter("option 4"));
        question.setCategory(request.getParameter("category"));
        question.setDifficultyLevel(request.getParameter("difficultylevel"));
        question.setCorrectAnswer(request.getParameter(request.getParameter("answer")));

        return question;
    }

    public Question getUpdatedQuestion(HttpServletRequest request) {
        Question question = new Question();
        question.setQuestion(request.getParameter("question"));
        question.setOption1(request.getParameter("option 1"));
        question.setOption2(request.getParameter("option 2"));
        question.setOption3(request.getParameter("option 3"));
        question.setOption4(request.getParameter("option 4"));
        question.setCategory(request.getParameter("category"));
        question.setDifficultyLevel(request.getParameter("difficultylevel"));
        question.setCorrectAnswer(request.getParameter("answer"));
        return question;
    }


}
