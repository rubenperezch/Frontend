package com.greenfoxacademy.frontend.Controllers;

import com.greenfoxacademy.frontend.DTOs.Until;
import com.greenfoxacademy.frontend.Services.LogService;
import com.greenfoxacademy.frontend.Services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    MainService mainService;

    LogService logService;

    @Autowired
    public MainController(MainService mainService, LogService logService) {
        this.mainService = mainService;
        this.logService = logService;
    }


    @GetMapping("/")
    public String renderMainPage() {
        return "index";
    }

    @GetMapping("/doubling")
    public ResponseEntity<Object> renderDoubling(@RequestParam (required = false) Integer input) {

        if(input == null) {
            return ResponseEntity.ok(mainService.doublingError());
        }

        logService.saveLogEntry("/doubling","input="+input);
        return ResponseEntity.ok(mainService.doubling(input));
    }
        /*public ResponseEntity<Object> renderDoubling(@RequestParam (required = false) Integer input) {

                if(input == null ) {
                    JSONObject jo = new JSONObject();

                    jo.append("error","Please provide an input!");

                    return ResponseEntity.ok(jo);

                } else {
                    JSONObject jo = new JSONObject();

                    jo.append("received",input);
                    jo.append("result", input*2);

                    return ResponseEntity.ok(jo);

                }*/
                //return ResponseEntity.ok(mainService.doubling(input));


    @GetMapping("/greeter")
    public ResponseEntity<Object> renderGreeter(@RequestParam (required = false) String name, @RequestParam (required = false) String title) {

        if(name == null || title == null) {

            return ResponseEntity.status(404).body(mainService.greeter(name, title));
        }

        logService.saveLogEntry("/greeter","name="+name+"title="+title);
        return ResponseEntity.ok(mainService.greeter(name, title));
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity<Object> renderAppendA(@PathVariable (required = false) String appendable) {

        logService.saveLogEntry("/appenda","appendable="+appendable);
        return ResponseEntity.ok(mainService.appendA(appendable));
    }

    @PostMapping("/dountil/{operation}")
    public ResponseEntity<Object> returnDoUntil(@PathVariable (required = false) String operation, @RequestBody (required = false) Until until) {

        logService.saveLogEntry("/dountil","operation="+operation+"until="+until);
        return ResponseEntity.ok(mainService.doUntil(operation, until));
    }

    @GetMapping("/log")
    public ResponseEntity<Object> returnLogEntries() {
        return ResponseEntity.ok(logService.returnLogEntry());
    }
}
