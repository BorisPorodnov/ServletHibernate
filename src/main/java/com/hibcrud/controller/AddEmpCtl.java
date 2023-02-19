package com.hibcrud.controller;

import com.hibcrud.entity.Employee;
import com.hibcrud.entity.Lot;
import com.hibcrud.model.EmployeeModel;
import com.hibcrud.model.LotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class AddEmpCtl
 */
@WebServlet("/AddEmpCtl")
public class AddEmpCtl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpCtl() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        long editid = (request.getParameter("editId") == null) ? 0 : Long.parseLong(request.getParameter("editId"));
        long delId = (request.getParameter("delId") == null ? 0 : Long.parseLong(request.getParameter("delId")));
        Employee emp = new Employee();
        if (editid > 0) {
            emp = EmployeeModel.FindById(editid);
        }

        if (delId > 0) {
            EmployeeModel.deleteEmp(delId);
        }
        request.setAttribute("bean", emp);
        List<Employee> empList = EmployeeModel.GetEmployeeList();
        request.setAttribute("empList", empList);
        request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");


        Long id = Long.parseLong(request.getParameter("id"));

        if (id > 0) {
            Employee updatedEmp = new Employee(id, username, password, name);
            List<Lot> lotsList = LotService.getLotsList();
            EmployeeModel.UpdateEmp(updatedEmp);
            System.out.println("Data is updated");
        } else {
            Employee emp = new Employee(
                    username,
                    password,
                    name
            );
            long resid = EmployeeModel.SignUp(emp);

            if (resid > 0) {
                out.print("Employee is added into database");
            } else {
                out.print("Someting went wrong");
            }
        }

        doGet(request, response);

    }

}