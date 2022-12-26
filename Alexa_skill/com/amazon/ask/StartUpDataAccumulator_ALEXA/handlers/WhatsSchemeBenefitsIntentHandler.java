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

public class WhatsSchemeBenefitsIntentHandler implements RequestHandler{

	public static final String SCHEME_SLOT="Scheme";
	public static final String SCHEME_KEY="SCHEME";
	
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WhatsSchemeBenefitsIntent"));
    }

    public Optional<Response> handle(HandlerInput input) {
    	System.out.println("*****************WhatsSchemeBenefitsIntent start************");
    	
    	Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request; // intent is mygameisintent()
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

       
        Slot schemeSlot = slots.get(SCHEME_SLOT);
        System.out.println("(1) The name of slot is"+ schemeSlot);
        String speechText="", repromptText="";

        if(schemeSlot != null) {
            
            String schemeName = schemeSlot.getValue();
            System.out.println("(2) the value of Scheme intended is "+schemeName);
            
            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(SCHEME_KEY, schemeName));
            
            System.out.println("***************** WhatsSchemeBenefitsIntent end********************");
           
            
            Database d = new Database();
    		List ls=d.getSchemeBenefits(schemeName);
    		String speech="";
    		if(ls.size()>0){
    			
    			speech = (String)ls.get(0);
    			System.out.println(speech);
    			
    			speechText = "Benefits for this scheme are, "+speech;
    		}else{
 
    			speechText = "we couldn't find any record, please try again..";
    		}
        
        } else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "Please provide a valid department name, and try again !";
            repromptText= "I'm not sure what your ministry you asked about. You can start by saying tell me about xyz ministry";
        
        }
        System.out.println("***************** Department NameIntent ends********************");
        return input.getResponseBuilder()
                .withSimpleCard("Scheme Benefits", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }
}
