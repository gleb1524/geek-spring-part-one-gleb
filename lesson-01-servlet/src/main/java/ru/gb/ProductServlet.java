package ru.gb;

import ru.gb.persist.Product;
import ru.gb.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product_servlet/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        for (int i = 0; i < 10; i++) {
            productRepository.insert(new Product(String.format("Product %d", i)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInformation = req.getPathInfo();

        PrintWriter wr = resp.getWriter();
        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>Id</th>");
        wr.println("<th>Title</th>");
        wr.println("<th>Cost</th>");
        wr.println("</tr>");

        for (Product product : productRepository.findAll()) {
            if (pathInformation.equals(String.format("/%d", product.getId()))) {
                wr.println(String.format("<tr><td>%d</td><td>%s</td><td>%d</td>",
                        product.getId(), product.getName(), product.getCost()));
                break;
            }
        }

        wr.println("</table>");
    }


}
