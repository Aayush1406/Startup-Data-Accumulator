package com.amazon.ask.startup.handlers;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.startup.dao.Database;

public class WhatsMinistrySchemeIntentHandler implements RequestHandler {

	public static final String MINISTRY_SLOT="Ministry";
	public static final String MINISTRY_KEY="MINISTRY";
	
	
	@Override
	public boolean canHandle(HandlerInput input) {
		
		return  input.matches(intentName("WhatsMinistrySchemeIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		
	System.out.println("***************** WhatsMinistrySchemeIntent start************");
    	
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request; // intent is mygameisintent()
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

       
        Slot ministrySlot = slots.get(MINISTRY_SLOT);
        System.out.println("(1) The name of slot is"+ ministrySlot);
        String speechText="", repromptText="";

        if(ministrySlot != null) {
            
            String ministryName = ministrySlot.getValue();
            System.out.println("(2) the value of Ministry intended is "+ministryName);
            
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(MINISTRY_KEY, ministryName));
            
            System.out.println("***************** WhatsMinistryIntent start********************");
           
            
            Database d = new Database();
    		List ls=d.getAllMinistrySchemes(ministryName);
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
    			
    			speechText = "we have following schemes "+speech;
    		}else{
 
    			speechText = "we couldn't find any record, please try again..";
    		}
        
        } else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "Please provide a valid department name, and try again !";
            repromptText= "I'm not sure what your ministry you asked about. You can start by saying tell me about xyz ministry";
        
        }
        System.out.println("***************** WhatsMinistrySchemeIntent ends********************");
        return input.getResponseBuilder()
                .withSimpleCard("Ministry Scheme", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }

		
		
	}


