package org.yabo.fsm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.transition.DefaultExternalTransition;
import org.springframework.statemachine.transition.Transition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Response;
import org.yabo.fsm.define.Events;
import org.yabo.fsm.define.States;

import java.util.Collection;

@RestController
public class Controller {

    @Autowired
    private StateMachine<States, Events> stateMachine;


    @RequestMapping("/test")
    public Response condition(Long id) {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
        Response response = new Response();
        response.setData("OK");
        return response;
    }

    @RequestMapping("/update")
    public Response update() {
        Collection<Transition<States, Events>> transitions = stateMachine.getTransitions();
        System.out.println(transitions);
//        Transition<States,Events> transition=new DefaultExternalTransition<>();
//        transitions.add();
        System.out.println("test");
        Response response = new Response();
        response.setData("OK");
        return response;
    }
}
