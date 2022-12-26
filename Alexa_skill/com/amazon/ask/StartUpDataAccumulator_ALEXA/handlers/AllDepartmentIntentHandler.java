package com.amazon.ask.startup.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.startup.dao.Database;

public class AllDepartmentIntentHandler implements RequestHandler  {

	public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AllDepartmentIntent"));
    }

    public Optional<Response> handle(HandlerInput input) {
    	System.out.println("***************** AllDepartmentIntent start********************");
        String speechText = "";
        
        Database d = new Database();
		List ls=d.getAllDepartment();
		String speech="";
		if(ls.size()>0){
			for (int i = 0; i < ls.size(); i++) {
				if(i==0){
					speech = (i+1)+". "+ls.get(0);
				}else{
					speech = speech +"\n , "+(i+1)+". "+ls.get(i);
				}
			}
			System.out.println(speech);
			
			speechText = "we have following department "+speech;
		}else{
			speechText = "we have couldn't find any record, please try again..";
		}
        
        System.out.println("***************** AllDepartmentIntent ends********************");
       return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("All Department", speechText)
                .withShouldEndSession(false)
                .build();
    }
	
	
}
