
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondPage extends HttpServlet {
    public Connection cn;
    public Statement st;
    public ResultSet rs;
    public String name = null;
    public List<String> shoppingCart = new ArrayList<>();
    int total = 0;
    public SecondPage(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webappdatabase","root","");
        st = (Statement) cn.createStatement();
        System.out.println("Connected");

    }catch(Exception e){
        System.out.println("Connection Error");
    }
    }
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
"    <a href=\"homePage\">Back to Home</a>\n" +
"   </nav>\n" +
"   <article>\n" +
"    <h1>Your purchaselist and info:</h1>\n" +
"    <form method=\"get\" action=\"FInalPage\">\n" +
"	<fieldset>\n" +
"	<legend>Selected Books</legend>\n" +
"<table style=\"width:100%\">\n" +
" 	<tr>\n" +
"    <th align=\"center\">Book name</th>\n" +
"    <th align=\"center\">Price Per Book</th> \n" +
"  	</tr>");
    String instruction = request.getParameter("address");
    String[] books = request.getParameterValues("books");
    HttpSession session = request.getSession(true);
    
        if (books == null || books.length == 0) {
                
        } else {
         if(total>0){
             total=0;
         }
        for (String book : books) {
            rs = st.executeQuery("SELECT bookname,price FROM books WHERE bookname='"+book+"'");
                while (rs.next()) {
                    String bookname = rs.getString("bookname");
                    shoppingCart.add(bookname);
                    int price = rs.getInt("price");
                    total = total+price;
                    out.println("  	<tr>\n" +
"    <td align=\"center\">"+bookname+"</td>\n" +
"    <td align=\"center\">"+price+"</td>\n" +
"    <tr>");
                }
        }

    }
    synchronized (session) { // synchronized to prevent concurrent updates
session.setAttribute("cart", shoppingCart);
name = (String)session.getAttribute("userName");
}
    out.println("    <td align=\"center\">Total</td>\n" +
"    <td align=\"center\">"+total+"</td>");
    out.println("</table>\n" +
"  \n" +
"	</fieldset>\n" +
"  <legend>Your address:</legend>\n" +
"  <p>"+instruction+"</p>\n" +
"	<fieldset>\n" +
"	<legend>Please enter your credit card info</legend>\n" +
"	<textarea rows=\"5\" cols=\"110\" name=\"address\"></textarea>\n" +
"	</fieldset>\n" +
"<input type=\"hidden\" name=\"secret\" value=\"888\" />\n" +
"<input type=\"submit\" value=\"Finalize Purchase\" />\n" +
"<input type=\"reset\" value=\"Clear\" />\n" +
"</form>\n" +
"   </article>\n" +
"   <footer>\n"); 
if(name==null){
    out.println(" welcome Visitor\n"); 
}
else{
    out.println(" welcome "+name+"\n"); 
}
out.println("</footer>\n" +
"  </div>\n" +
" </body>\n" +
"</html>");
        }catch(Exception e){
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
