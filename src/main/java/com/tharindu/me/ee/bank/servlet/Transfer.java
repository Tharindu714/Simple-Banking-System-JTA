package com.tharindu.me.ee.bank.servlet;

import com.tharindu.me.ee.bank.ejb.remote.TransferService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/transfer")
public class Transfer extends HttpServlet {

    @EJB
    private TransferService transferService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipientAccount = request.getParameter("recipientAccount");
        String destinationAccount = request.getParameter("destinationAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));

        try {
            transferService.transferAmount(recipientAccount, destinationAccount, amount);
            response.sendRedirect("home.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
