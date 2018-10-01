import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class MainHomePage extends HttpServlet {
    public Connection cn;
    public Statement st;
    public ResultSet rs;
    public String name= null;
    public List<String> shoppingCart = new ArrayList<>();
    public MainHomePage(){
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
            HttpSession session = request.getSession();
synchronized(session) {
    name = (String)session.getAttribute("userName");
    shoppingCart = (List<String>)session.getAttribute("cart");
} 
out.println("<!DOCTYPE html>\n" +
"<html>\n" +
" <head>\n" +
"  <title>Net Pro Project</title>\n" +
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
"table, th, td {\n" +
"    border: 1px solid black;\n" +
"    border-collapse: collapse;\n" +
"}\n" +
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
"   <nav>\n");
    if (name== null){
       out.println("<a href=\"SignupPage\">Register</a>\n" +"<a href=\"LoginPage\">Login</a>\n");
    }
    else{
        
         out.println("<a href=\"Logout\">Logout</a>\n");
    }
out.println("   </nav>\n" +
"   <article>\n" +
"    <h1>Please Choose books to purchase:</h1>\n" +
"    <form method=\"get\" action=\"SecondPage\">\n" +
"	<fieldset>\n" +
"	<legend>Available Books</legend>");
out.println("<table style=\"width:100%\">\n" +
" 	<tr>\n" +
"    <th>Book Name</th>\n" +
"    <th>Price</th> \n" +
"    <th>Available</th>\n" +
"  	</tr>");
            rs = st.executeQuery("SELECT bookname,price,available FROM books");
            while (rs.next()) {
                int check = 0;
                String bookname = rs.getString("bookname");
                int price = rs.getInt("price");
                int available = rs.getInt("available");
                if (shoppingCart != null) { // cart exists?
                    for (String item : shoppingCart) {
                         if(bookname ==item){
                             check = 1;
                         }
                    }
                }
                if(check==1){
                                    out.println("  	<tr>\n" +
"    <td><input type=\"checkbox\" name=\"books\" value='"+bookname+"' checked/>"+bookname+"</td>\n" +
"    <td>"+price+"</td>\n" +
"    <td>"+available+"</td>\n" +
"    <tr>");
                }
                else{
                                    out.println("  	<tr>\n" +
"    <td>"+bookname+"</td>\n" +
"    <td>"+price+"</td>\n" +
"    <td>"+available+"</td>\n" +
"    <tr>");
                }
                
            }    
    out.println("</table");    
    out.println(
            "</fieldset>\n" +
"   </article>\n" +
"   <h2>Please Login to purchase</h2>\n" +
"   </article>\n" +
"</fieldset>\n" +
            
"   <footer>\n" );
if(name==null){
    out.println(" welcome Visitor\n"); 
}
else{
    out.println(" welcome "+name+"\n"); 
}

out.println("   </footer>\n" +
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
