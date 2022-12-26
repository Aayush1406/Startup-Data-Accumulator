package com.amazon.ask.startup.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.startup.dao.Database;

public class WhatsMinistryIntentHandler implements RequestHandler{

	public static final String MINISTRY_SLOT="Ministry";
	public static final String MINISTRY_KEY="MINISTRY";
	
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WhatsMinistryIntent"));
    }

    public Optional<Response> handle(HandlerInput input) {
    	System.out.println("*****************Whats Ministry start************");
    	
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
    		List ls=d.getMinistryDescription(ministryName);
    		String speech="";
    		if(ls.size()>0){
    			
    			speech = (String)ls.get(0);
    			System.out.println(speech);
    			
    			speechText = speech;
    		}else{
 
    			speechText = "we couldn't find any record, please try again..";
    		}
        
        } else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "Please provide a valid ministry name, and try again !";
            repromptText= "I'm not sure what your ministry you asked about. You can start by saying tell me about xyz ministry";
        
        }
        System.out.println("***************** MinistryNameIntent ends********************");
        return input.getResponseBuilder()
                .withSimpleCard("Ministry Description", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }

}
