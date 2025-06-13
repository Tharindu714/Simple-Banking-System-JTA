package com.tharindu.me.ee.bank.servlet;

import com.tharindu.me.ee.bank.ejb.remote.LoginService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @EJB
    private LoginService loginService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean login_result = loginService.login(email, password);
        if (login_result) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            response.sendRedirect("home.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
