/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package unknown;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class pg71 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Longest Word Finder</title>");
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.println("h1 { color: #333; text-align: center; }");
        out.println("form { margin-top: 20px; text-align: center; }");
        out.println("input[type=text] { padding: 10px; border-radius: 5px; border: 1px solid #ccc; width: 300px; }");
        out.println("input[type=submit] { padding: 10px 20px; border-radius: 5px; border: none; background-color: #4CAF50; color: white; font-size: 16px; cursor: pointer; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Longest Word Finder</h1>");
        out.println("<form method=\"post\">");
        out.println("Enter a sentence: <input type=\"text\" name=\"sentence\"><br>");
        out.println("<input type=\"submit\" value=\"Find Longest Word\">");
        out.println("</form>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String sentence = request.getParameter("sentence");
        String[] words = sentence.split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Longest Word Result</title>");
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.println("h1 { color: #333; text-align: center; }");
        out.println("p { margin-top: 20px; text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Longest Word Result</h1>");
        out.println("<p>Longest word in the sentence \"" + sentence + "\": <strong>" + longestWord + "</strong></p>");

        out.println("</body></html>");
    }
}


