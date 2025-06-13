package com.tharindu.me.ee.bank.servlet;

import com.tharindu.me.ee.bank.ejb.Test.NewBeanB;
import com.tharindu.me.ee.bank.ejb.Test.NewBeanC;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @EJB
//    private NewBeanA beanA;
    private NewBeanC beanC;

    @EJB
    private NewBeanB beanB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        beanC.doActionC(); //txId=7
//        beanA.doActionA(); //txId=7
//        beanB.doActionB(); //txId=8
    }
}
