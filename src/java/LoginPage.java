/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class LoginPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<style>\n" +
"body {\n" +
"    font-family: Arial, Helvetica, sans-serif;    \n" +
"    background:#ddd\n" +
"    \n" +
"    }\n" +
"* {box-sizing: border-box}\n" +
"\n" +
"/* Full-width input fields */\n" +
"input[type=text], input[type=password] {\n" +
"    width: 100%;\n" +
"    padding: 15px;\n" +
"    margin: 5px 0 22px 0;\n" +
"    display: inline-block;\n" +
"    border: 1px solid black;\n" +
"    background: #f1f1f1;\n" +
"}\n" +
"\n" +
"input[type=text]:focus, input[type=password]:focus {\n" +
"    background-color: #ddd;\n" +
"    outline: none;\n" +
"}\n" +
"\n" +
"hr {\n" +
"    border: 1px solid #f1f1f1;\n" +
"    margin-bottom: 25px;\n" +
"}\n" +
"\n" +
"/* Set a style for all buttons */\n" +
"button {\n" +
"    background-color: #c33;\n" +
"    color: #fff;\n" +
"    padding: 14px 20px;\n" +
"    margin: 8px 0;\n" +
"    border: none;\n" +
"    cursor: pointer;\n" +
"    width: 100%;\n" +
"    opacity: 0.9;\n" +
"}\n" +
"\n" +
"button:hover {\n" +
"    background-color:#226;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"/* Float cancel and signup buttons and add an equal width */\n" +
".signupbtn {\n" +
"  float: center;\n" +
"  width: 100%;\n" +
"}\n" +
"\n" +
"/* Add padding to container elements */\n" +
".container {\n" +
"    padding: 16px;\n" +
"    width : 100%;\n" +
"    \n" +
"}\n" +
"\n" +
"/* Clear floats */\n" +
".clearfix{\n" +
"      align-items: center;\n" +
"  justify-content: center;\n" +
"}\n" +
"    \n" +
".transparent{\n" +
"height:100vh;\n" +
"    opacity: 30%;\n" +
"\n" +
"       \n" +
"}\n" +
"\n" +
"/* Change styles for cancel button and signup button on extra small screens */\n" +
"@media screen and (max-width: 300px) {\n" +
"    .signupbtn {\n" +
"       width: 100%;\n" +
"    }\n" +
"}\n" +
"</style>\n" +
"<body>\n" +
"<div class=\"transparent\">\n" +
"\n" +
"<form action=\"ProcessPage2\" style=\"border:1px solid #ccc;width:50%;margin: 0 auto;background: #f1f1f1;\">\n" +
"  <div class=\"container\">\n" +
"    <h1>Login</h1>\n" +
"    <p>Please fill in this form to create an account.</p>\n" +
"    <hr>\n" +
"    \n" +
"    <label for=\"username\"><b>Username</b></label>\n" +
"    <input type=\"text\" placeholder=\"Enter Username\" name=\"userName\" required>\n" +
"\n" +
"    <label for=\"psw\"><b>Password</b></label>\n" +
"    <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\n" +
"  \n" +

"    	<button type=\"submit\" class=\"signupbtn\">Login</button>\n" +

"  </div>\n" +
"</form>\n" +
"</div>\n" +
"</body>\n" +
"</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
