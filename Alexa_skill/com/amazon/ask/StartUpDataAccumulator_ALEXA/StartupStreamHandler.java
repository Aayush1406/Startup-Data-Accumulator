/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.startup;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.startup.handlers.AllDepartmentIntentHandler;
import com.amazon.ask.startup.handlers.AllMinistryIntentHandler;
import com.amazon.ask.startup.handlers.CancelandStopIntentHandler;
import com.amazon.ask.startup.handlers.FallbackIntentHandler;
import com.amazon.ask.startup.handlers.HelpIntentHandler;
import com.amazon.ask.startup.handlers.LaunchRequestHandler;
import com.amazon.ask.startup.handlers.SessionEndedRequestHandler;
import com.amazon.ask.startup.handlers.WhatDepartmentSchemeIntentHandler;
import com.amazon.ask.startup.handlers.WhatsDepartmentIntentHandler;
import com.amazon.ask.startup.handlers.WhatsMinistryIntentHandler;
import com.amazon.ask.startup.handlers.WhatsMinistrySchemeIntentHandler;
import com.amazon.ask.startup.handlers.WhatsSchemeBenefitsIntentHandler;
import com.amazon.ask.startup.handlers.WhatsSchemeDocumentsIntentHandler;
import com.amazon.ask.startup.handlers.WhatsSchemeEligibilityIntentHandler;
import com.amazon.ask.startup.handlers.WhatsSchemeIntentHandler;
import com.amazon.ask.startup.handlers.WhatsSchemeProcedureIntentHandler;

public class StartupStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new AllMinistryIntentHandler(),
                        new AllDepartmentIntentHandler(),
                        new WhatDepartmentSchemeIntentHandler(),
                        new WhatsMinistrySchemeIntentHandler(),
                        new WhatsMinistryIntentHandler(),
                        new WhatsDepartmentIntentHandler(),
                        new WhatsSchemeIntentHandler(),
                        new WhatsSchemeEligibilityIntentHandler(),
                        new WhatsSchemeBenefitsIntentHandler(),
                        new WhatsSchemeProcedureIntentHandler(),
                        new WhatsSchemeDocumentsIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                
                // Add your skill id below
                //.withSkillId("")
                .build();
    }

    public StartupStreamHandler() {
        super(getSkill());
    }

}
