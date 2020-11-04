package com.example.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.save;
import com.example.database.RegisterDao;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
        //fetch product data from registration page
        String barcode = request.getParameter("barcode");
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String details = request.getParameter("details");
        

        
    	//create database model
        RegisterDao regDao= new RegisterDao();
        
        //create save model
        save product = new save();
        product.setBarcode(barcode);
        product.setName(name);
        product.setColor(color);
        product.setDetails(details);
        
        String result="Product is already registered";
        
        if( regDao.validate(product)){
        	
        	response.getWriter().print(result);
        }
        else {
            
        regDao.insert(product);
        
        //attributes
        request.setAttribute("barcode",request.getParameter("barcode"));
        request.setAttribute("name",request.getParameter("name"));
        request.setAttribute("color",request.getParameter("color"));
        request.setAttribute("details",request.getParameter("details"));
        
        
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        	
        }
	}

}
