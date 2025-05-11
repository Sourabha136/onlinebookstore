package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittercode.model.UserRole;
import com.bittercode.util.StoreUtil;

// Http Servlet extended class for showing the about information
public class AboutServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        // If the store is logged in as customer or seller show about info
        if (StoreUtil.isLoggedIn(UserRole.CUSTOMER, req.getSession())) {
            RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.html");
            rd.include(req, res);
            StoreUtil.setActiveTab(pw, "about");

            pw.println("<div class='about-section' style='padding: 20px; font-family: Arial, sans-serif;'>"
                    + "<h2>About Online Book Store</h2>"
                    + "<p>An online book store is a digital platform that allows users to browse, search, and purchase books over the internet. "
                    + "It typically features a wide range of books in various categories such as fiction, non-fiction, academic, and children’s literature.</p>"
                    + "<h3>Key Features:</h3>"
                    + "<ul>"
                    + "<li>User-friendly interface for searching and filtering books</li>"
                    + "<li>Shopping cart and secure checkout for purchases</li>"
                    + "<li>User registration and login functionality</li>"
                    + "<li>Book reviews and ratings from other customers</li>"
                    + "<li>Admin panel to manage inventory, orders, and user data</li>"
                    + "<li>Integration with payment gateways, delivery tracking, and support for e-books</li>"
                    + "</ul>"
                    + "</div>");

        } else if (StoreUtil.isLoggedIn(UserRole.SELLER, req.getSession())) {
            RequestDispatcher rd = req.getRequestDispatcher("SellerHome.html");
            rd.include(req, res);
            StoreUtil.setActiveTab(pw, "about");

            pw.println("<div class='about-section' style='padding: 20px; font-family: Arial, sans-serif;'>"
                    + "<h2>About Online Book Store</h2>"
                    + "<p>An online book store is a digital platform that allows users to browse, search, and purchase books over the internet. "
                    + "It typically features a wide range of books in various categories such as fiction, non-fiction, academic, and children’s literature.</p>"
                    + "<h3>Key Features:</h3>"
                    + "<ul>"
                    + "<li>User-friendly interface for searching and filtering books</li>"
                    + "<li>Shopping cart and secure checkout for purchases</li>"
                    + "<li>User registration and login functionality</li>"
                    + "<li>Book reviews and ratings from other customers</li>"
                    + "<li>Admin panel to manage inventory, orders, and user data</li>"
                    + "<li>Integration with payment gateways, delivery tracking, and support for e-books</li>"
                    + "</ul>"
                    + "</div>");

        } else {
            // If the user is not logged in, ask to login first
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
            pw.println("<table class=\"tab\"><tr><td>Please Login First to Continue!!</td></tr></table>");
        }
    }
}
