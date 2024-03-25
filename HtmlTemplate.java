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

/**
 *
 * @author navee*/


public class HtmlTemplate {
    public static String getHeader(String title) {
        StringBuilder header = new StringBuilder();
        header.append("<!DOCTYPE html>");
        header.append("<html lang=\"en\">");
        header.append("<head>");
        header.append("<meta charset=\"UTF-8\">");
        header.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        header.append("<title>").append(title).append("</title>");
        header.append("<style>");
        header.append("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        header.append("h1 { color: #333; text-align: center; }");
        header.append("form { margin-top: 20px; text-align: center; }");
        header.append("input[type=text] { padding: 10px; border-radius: 5px; border: 1px solid #ccc; width: 300px; }");
        header.append("input[type=submit] { padding: 10px 20px; border-radius: 5px; border: none; background-color: #4CAF50; color: white; font-size: 16px; cursor: pointer; }");
        header.append("</style>");
        header.append("</head>");
        header.append("<body>");
        return header.toString();
    }

    public static String getFooter() {
        return "</body></html>";
    }
}

