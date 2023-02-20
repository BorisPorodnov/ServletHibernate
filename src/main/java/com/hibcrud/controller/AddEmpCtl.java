package com.hibcrud.controller;

import com.hibcrud.entity.Employee;
import com.hibcrud.model.EmployeeModel;

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
        List<Employee> employees = EmployeeModel.GetEmployeeList();
        int size = employees.size();
    }

}