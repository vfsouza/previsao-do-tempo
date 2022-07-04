package com.tempo.controller;

import com.google.gson.Gson;
import com.tempo.dao.TempDAO;
import com.tempo.model.LocalTemp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "TempServlet", value = "/temp")
public class TempServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");;
        LocalTemp lt = null;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        lt = TempDAO.readByString(city);

        if (stringIsValid(city) && !city.isEmpty()) {
            if (lt == null) {
                Random rd = new Random();
                int temp = rd.nextInt(46);

                lt = new LocalTemp(city, temp);
                TempDAO.insert(lt);
            }

            PrintWriter pw = response.getWriter();
            pw.print(new Gson().toJson(lt));
        } else {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.println("Digite uma cidade válida");
        }
    }

    private boolean stringIsValid(String str) {
        for(int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                return false;
            }
        }
        return true;
    }
}
