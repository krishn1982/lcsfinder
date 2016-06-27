package com.fis.lcs.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fis.lcs.core.LcsCalculatorImpl;
import com.fis.lcs.core.LcsService;
import com.fis.lcs.core.LcsServiceImpl;
import com.fis.lcs.json.Error;
import com.fis.lcs.json.Lc;
import com.fis.lcs.json.Payload;
import com.fis.lcs.json.Result;
import com.fis.lcs.validator.Validator;
import com.fis.lcs.validator.ValidatorImpl;

/**
 * Servlet implementation class LCSServlet
 */
public class LCSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LCSServlet.class);

	private Validator validator;
	
	
	private LcsService lcsService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LCSServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException{
		validator = new ValidatorImpl();
		lcsService = new LcsServiceImpl();
		((LcsServiceImpl)lcsService).setLcsCalculator(new LcsCalculatorImpl());
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");		
		ObjectMapper objectMapper = new ObjectMapper();
		Payload body = transformValidateAndSetResponseErrorMessage(request, response, objectMapper );
		if(body == null){
			return ;
		}
		String result = lcsService.getLongestCommonSubstring(body.getSetOfStrings());		
		response.getWriter().append(convertToJsonFormat(result,objectMapper));

	}
	
	private Payload transformValidateAndSetResponseErrorMessage(HttpServletRequest request,
	          HttpServletResponse response, ObjectMapper objectMapper) throws IOException{
		
		String payload = readRequestBody(request);
		Payload body = null;
		try {
			body = objectMapper.readValue(payload, Payload.class);

		} catch (Exception jse) {			
			logger.warn("Could not parse input json");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().append(Error.INVALID_JSON_PAYLOAD.getErrorMessage());
			return null;
		}
		List<Error> errors = validator.validate(body);
		
		if(!errors.isEmpty()){
			
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			for(Error error : errors){
				logger.warn("following error found " + error.getErrorMessage() );
				response.getWriter().append(error.getErrorMessage());
			}
			
			return null;
			
		}
		
		return body;
	}
	public static String convertToJsonFormat(String input, ObjectMapper objectMapper) throws JsonProcessingException{
		List<Lc> lcList = new ArrayList<Lc>();
		Lc lc = new Lc();
		lc.setValue(input);
		lcList.add(lc);
		Result result = new Result();
		result.setLcs(lcList);
		String jsonResult = objectMapper.writeValueAsString(result);
		return jsonResult;
	}

	
	private String readRequestBody(HttpServletRequest request) {
		try {
			// Read from request
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			return buffer.toString();
		} catch (Exception e) {

		}
		return null;
	}


}
