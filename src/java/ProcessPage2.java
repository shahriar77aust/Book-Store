
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


public class ProcessPage2 extends HttpServlet {
public Connection cn;
public Statement st;
public String userName;
int flag =0,pswe,usere;
public ProcessPage2(){
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
// Allocate a output writer to write the response message into the network socket
PrintWriter out = response.getWriter();
// Write the response message, in an HTML page
try {
out.println("<!DOCTYPE html>");
out.println("<html><head>");
out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
out.println("<title>Processing</title></head>");
out.println("<body>");
userName = request.getParameter("userName");
String password = request.getParameter("psw");


ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = '"+userName+"' AND password='"+password+"'");
int t=0;
while (rs.next()) {
  t++;
}
if(t>0){
    usere = 1;
    flag=1;
    
}else{
    usere = 0;
    flag =0;
}

if(usere==1){
    flag = 1;
}

if(flag ==1){
    out.println("<div style='float:center'>");
    out.println("<p>Welcome user</p>");
    out.println("<form action='HomePage'>");
    out.println("<button type='submit'>Go to home</button>");
    out.println("</form>");
    out.println("</div");
        HttpSession session = request.getSession(true);
    synchronized (session) {
        session.setAttribute("userName", userName);
    }
}
else{
    if(usere==0){
        out.println("<p>User doesn't esists</p>");
    }
    out.println("<div style='float:center'>");
    out.println("<p>Please try again</p>");
    out.println("<form action='LoginPage'>");
    out.println("<button type='submit'>Try again</button>");
    out.println("</form>");
    out.println("</div");

}

out.println("</body></html>");
}   catch (SQLException ex) {
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