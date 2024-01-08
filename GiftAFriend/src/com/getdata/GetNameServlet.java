package com.getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetNameServlet
 */
@WebServlet("/GetName")
public class GetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetNameServlet() {
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
	@SuppressWarnings("restriction")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetDataServiceImpl getDataServiceImpl=new GetDataServiceImpl();
		ArrayList<SecretSanta> listGivers= getDataServiceImpl.getNamesWithNoToFriend();
	    String myName=request.getParameter("myName");
		try {			
			String toFriend=null;
			toFriend=getDataServiceImpl.getFriend(myName.toLowerCase());			
	    if(!(toFriend==null)){
	    	request.setAttribute("whosmyfriendId",toFriend);
	    	
	    }else{	    	
	    	for (int i=0;i<listGivers.size();i++ ){
	    	if(listGivers.get(i).getFromName().toLowerCase().equals(myName.toLowerCase())){
	    		if(!(getDataServiceImpl.getNamesWithNoFromFriend().isEmpty())){
	    			SecretSanta newFriend=getDataServiceImpl.getRandomElement(getDataServiceImpl.getNamesWithNoFromFriend(),listGivers.get(i).getFromName().toLowerCase());
	    		if(!(newFriend.equals(null))){
	    			Boolean updated=getDataServiceImpl.updateToName(listGivers.get(i).getFromName().toLowerCase(),newFriend.getFromName().toLowerCase());
	    			if(updated){
	    				request.setAttribute("whosmyfriendId",newFriend.getFromName().toLowerCase());
	    			}
	    	     }
	    	    }
	         }
	    	}
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("/KnowFriend.jsp");
	    rd.forward(request,response);
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
