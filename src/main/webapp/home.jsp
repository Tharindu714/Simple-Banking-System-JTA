<%--
  Created by IntelliJ IDEA.
  User: tharidu
  Date: 5/31/2025
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%--%>
<%--  if (session.getAttribute("user")==null){--%>
<%--    response.sendRedirect("login.jsp");--%>
<%--  }--%>
<%--%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delta Codex Bank</title>
</head>
<body>
<h1>Your Trusted Bank</h1>
<p>Welcome to Delta Codex Bank, where your financial security is our priority.</p>
<p>We offer a range of services to help you manage your finances effectively.</p>
<p>Explore our services:</p>

<h3>Hello, ${sessionScope.user}</h3>
<ul>
    <li><a href="account.jsp">Account Management</a></li>
    <li><a href="transfer.jsp">Money Transfer</a></li>
    <li><a href="loan.jsp">Loan Services</a></li>
    <li><a href="contact.jsp">Contact Us</a></li>
</ul>

<form action="transfer" method="post">
<table>
    <tr>
        <th>Recipient Account Number</th>
        <td><input type="text" name="recipientAccount" required></td>
    </tr>
    <tr>
        <th>Destination Account Number</th>
        <td><input type="text" name="destinationAccount" required></td>
    </tr>
    <tr>
        <th>Transfer Amount</th>
        <td><input type="number" name="amount" required></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Transfer"></td>
    </tr>
</table>
</form>
</body>
</html>
