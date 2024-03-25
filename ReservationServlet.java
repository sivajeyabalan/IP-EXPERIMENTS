/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package unknown;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ReservationServlet", urlPatterns = {"/ReservationServlet"})
public class ReservationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Retrieve user input
        String name = request.getParameter("name");
        String seatsStr = request.getParameter("seats");

        // Validate user input
        if (name == null || name.trim().isEmpty() || seatsStr == null || seatsStr.trim().isEmpty()) {
            response.sendRedirect("error.html");
            return;
        }

        // Parse seats to integer
        int seats;
        try {
            seats = Integer.parseInt(seatsStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("error.html");
            return;
        }

        // Get session object
        HttpSession session = request.getSession(true);

        // Retrieve reserved seats map from session
        HashMap<String, Integer> reservedSeats = (HashMap<String, Integer>) session.getAttribute("reservedSeats");

        if (reservedSeats == null) {
            reservedSeats = new HashMap<>();
        }

        // Update reserved seats map with new reservation
        reservedSeats.put(name, seats);

        // Update session attribute
        session.setAttribute("reservedSeats", reservedSeats);

        // Display available and reserved seats
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Seat Reservation Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Seat Reservation Result</h1>");
            out.println("<h2>Available Seats</h2>");
            out.println("<p>Total Seats: 100</p>");
            int totalReservedSeats = 0;
            for (String reservedName : reservedSeats.keySet()) {
                int reservedSeatCount = reservedSeats.get(reservedName);
                out.println("<p>" + reservedName + ": " + reservedSeatCount + " seats</p>");
                totalReservedSeats += reservedSeatCount;
            }
            out.println("<h2>Total Reserved Seats</h2>");
            out.println("<p>" + totalReservedSeats + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}


