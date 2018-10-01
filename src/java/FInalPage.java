
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FInalPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
" <head>\n" +
"  <title>Basic Fixed-width CSS Page Layout Example - resource-centre.net</title>\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <style type=\"text/css\">\n" +
"  	 /* over all rules */\n" +
"*{\n" +
" box-sizing:border-box;\n" +
"}\n" +
"html,body{\n" +
" margin:0;\n" +
" padding:0;\n" +
" background:#ddd;\n" +
" color:#333;\n" +
" font-family:'Open Sans','Trebuchet MS','Arial',sans-serif;\n" +
" font-size:14px;\n" +
"}\n" +
".container{\n" +
" width:1200px;\n" +
" float:left;\n" +
" position:relative;\n" +
" left:50%;\n" +
" margin-left:-600px;\n" +
" background:#fff;\n" +
" padding:10px;\n" +
"}\n" +
"a{\n" +
" text-decoration:none;\n" +
" color:#c33;\n" +
"}\n" +
"\n" +
" /* header and footer */\n" +
"header,footer,article,nav,section{\n" +
" float:left;\n" +
" padding:10px;\n" +
"}\n" +
"header,footer{\n" +
" width:100%;\n" +
"}\n" +
"header,footer{\n" +
" background-color:#333;\n" +
" color:#fff;\n" +
" text-align:right;\n" +
" height:100px;\n" +
"}\n" +
"header{\n" +
" font-size:1.8em;font-weight:bold;\n" +
"}\n" +
"header big{\n" +
" line-height:130px;\n" +
" vertical-align:bottom;\n" +
"}\n" +
"footer{\n" +
" background-color:#333;\n" +
" text-align:center;\n" +
" height:40px;\n" +
"}\n" +
"footer a{\n" +
" text-decoration:underline;\n" +
" color:#fff;\n" +
" font-weight:bold;\n" +
"}\n" +
" \n" +
"/* navigation on the left hand side */\n" +
"nav{\n" +
" text-align:center;\n" +
" width:24%;\n" +
" margin-right:1%;\n" +
" border:1px solid #ccc;\n" +
" margin:5px;\n" +
"}\n" +
"nav a{\n" +
" display:block;\n" +
" width:100%;\n" +
" background-color:#c33;\n" +
" color:#fff;\n" +
" height:30px;\n" +
" margin-bottom:10px;\n" +
" padding:10px;\n" +
" border-radius:\n" +
" 3px;\n" +
" line-height:10px;\n" +
" vertical-align:middle;\n" +
"}\n" +
"nav a:hover,nav a:active{\n" +
" background-color:#226;\n" +
"} \n" +
"\n" +
"/* <article> tag is our 'content area' */\n" +
"article{\n" +
" width:75%;\n" +
"}\n" +
"h1{\n" +
" padding:0;\n" +
" margin:0 0 20px 0;\n" +
"}\n" +
"/* section */\n" +
"article section{\n" +
" padding:0;\n" +
"}\n" +
"/* basic page column layout */\n" +
".halves,.thirds{\n" +
" width:49%;\n" +
" float:left;\n" +
" margin-right:2%;\n" +
"}\n" +
".thirds{\n" +
" width:32.66666%;\n" +
" margin-right:1%;\n" +
"}\n" +
".last{\n" +
" margin-right:0;\n" +
"}\n" +
"/*table, th, td {\n" +
"    border: 1px solid black;\n" +
"    border-collapse: collapse;\n" +
"}*/\n" +
"th, td {\n" +
"    padding: 15px;\n" +
"}\n" +
"  </style>\n" +
" </head>\n" +
" <body>\n" +
"  <div class=\"container\">\n" +
"   <header>\n" +
"    <bigExample>myBookStore</big>\n" +
"   </header>\n" +
"   <nav>\n" +
"    <a href=\"HomePage\">Back to Home</a>\n" +
"   </nav>\n" +
"      <article>\n" +
"    <h1>Thank you for staying with us your book will be delivered in 3 wordays!!!</h1>\n" +
"  </article>\n" +
"   <footer>\n" +
"    	Thank You\n" +
"   </footer>\n" +
"  </div>\n" +
" </body>\n" +
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
