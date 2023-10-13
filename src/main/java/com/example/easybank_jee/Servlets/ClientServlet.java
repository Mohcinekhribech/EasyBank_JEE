package com.example.easybank_jee.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.easybank_jee.DAO.ClientDao;
import com.example.easybank_jee.DTO.Client;
import com.example.easybank_jee.DTO.Employee;
import com.example.easybank_jee.Mapping.ClientMap;
import com.example.easybank_jee.Services.ClientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 *
 * @email Ramesh Fadatare
 */

@WebServlet(urlPatterns = {"/new", "/insert", "/"})
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientService clientService;
    public List<Client> listClient;
    private ClientMap clientMap;
    public String att;
    private Client client = new Client();

    public void init() {
        clientService = new ClientService(new ClientDao());
        clientMap = new ClientMap(this.client);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertClient(request, response);
                break;
            case "/delete":
                deleteClient(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateClient(request, response);
                break;
            case "/list":
                if (this.check(request))
                    listClient(request, response);
                else
                    search(request, response);
                break;
        }
    }

    private void listClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.listClient = this.clientService.getAll();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addForm.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String attribute = request.getParameter("attribut");
        this.listClient = this.clientService.searchByAttribute(attribute);
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private boolean check(HttpServletRequest request) {
        return request.getParameter("attribut") == null ;
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("id");
        Optional<Client> existingClient = clientService.searchByCode(code);
        if (existingClient.isPresent()) {
            this.client = existingClient.get();
            request.setAttribute("client", this.client);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (clientService.add(clientMap.mapping(request)).isPresent())
            response.sendRedirect("list");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.client = clientMap.mapping(request);
        if (this.clientService.update(this.client, this.client.getCode()).isPresent())
            response.sendRedirect("list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String code = request.getParameter("id");
        if (this.clientService.delete(code) > 0)
            response.sendRedirect("list");
    }
}