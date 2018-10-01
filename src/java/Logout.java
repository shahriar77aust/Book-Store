
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Logout extends HttpServlet {
public Connection cn;
public Statement st;
int flag =0,pswe,usere;
public String name = null;
public List<String> shoppingCart = new ArrayList<>();
public Logout(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webappdatabase","root","");
        st = (Statement) cn.createStatement();
        System.out.println("Connected");

    }catch(Exception e){
        System.out.println("Connection Error");
    }
}


@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException {
// Set the response message's MIME type
response.setContentType("text/html; charset=UTF-8");
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
PrintWriter out = response.getWriter();
try {
out.println("<!DOCTYPE html>");
out.println("<html><head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
out.println("<title>Processing</title></head>");
out.println("<body>");
HttpSession session = request.getSession();
 session.setAttribute("userName",name);
 shoppingCart = null;
  session.setAttribute("cart",shoppingCart);
  out.println("<div style='float:center'>");
    out.println("<p>You are logged out</p>");
    out.println("<p>Go to homepage</p>");
    out.println("<form action='MainHomePage'>");
    out.println("<button type='submit'>Home Page</button>");
    out.println("</form>");
    out.println("</div");


out.println("</body></html>");
}   catch (Exception ex) {
        out.println(ex);
    } finally {
out.close(); 
}
}

@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException {
doGet(request, response);
}

private static String htmlFilter(String message) {
if (message == null) return null;
int len = message.length();
StringBuffer result = new StringBuffer(len + 20);
char aChar;
for (int i = 0; i < len; ++i) {
aChar = message.charAt(i);
switch (aChar) {
case '<': result.append("&lt;"); break;
case '>': result.append("&gt;"); break;
case '&': result.append("&amp;"); break;
case '"': result.append("&quot;"); break;
default: result.append(aChar);
}
}
return (result.toString());
}
}