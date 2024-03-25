/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package unknown;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class pg2 extends HttpServlet {

    private List<City> cities;

    @Override
    public void init() throws ServletException {
      
        cities = new ArrayList<>();
        cities.add(new City("New York", 1575133));
        cities.add(new City("Los Angeles", 3792621));
        cities.add(new City("Chicago", 2795598));
        cities.add(new City("Houston", 2900263));
        cities.add(new City("Phoenix", 1645632));
        cities.add(new City("Philadelphia", 3517550));
        cities.add(new City("San Antonio", 1227407));
        cities.add(new City("San Diego", 1407402));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(HtmlTemplate.getHeader("City List"));

        out.println("<h1>City List</h1>");
        out.println("<form method=\"post\">");
        out.println("Sort by: <select name=\"sort\">");
        out.println("<option value=\"name\">Name</option>");
        out.println("<option value=\"population\">Population</option>");
        out.println("</select>");
        out.println("<input type=\"submit\" value=\"Sort\">");
        out.println("</form>");

        String sortParam = request.getParameter("sort");
        if (sortParam != null && sortParam.equals("population")) {
            Collections.sort(cities, Comparator.comparingInt(City::getPopulation).reversed());
            out.println("<h2>Sorted by Population</h2>");
        } else {
            out.println("<h2>Unsorted</h2>");
        }

        out.println("<ul>");
        for (City city : cities) {
            out.println("<li>" + city.getName() + " - Population: " + city.getPopulation() + "</li>");
        }
        out.println("</ul>");

        out.println(HtmlTemplate.getFooter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private static class City {
        private String name;
        private int population;

        public City(String name, int population) {
            this.name = name;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }
    }
}



